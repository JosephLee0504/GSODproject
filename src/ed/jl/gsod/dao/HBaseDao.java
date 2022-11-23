package ed.jl.gsod.dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.util.Bytes;

import edu.jl.gsod.pojo.HBaseDataDO;
import edu.jl.gsod.util.GsodUtil;

/**
 * ���ݳ־ò㣺��HBase��������ȡ���е����ݲ��ҷ�װ��HBaseDataDO
 * @author tarena
 * �߼���������HBase����ȡ���е�����
 */
public class HBaseDao {

//	1��	����HBase�����ö���
	private static Configuration conf = null;
//		�������������壺
	private String tabName =GsodUtil.TABLE_NAME;
	private byte [][] familyNames = GsodUtil.COLUMN_FAMILYS;
//		����һ�����ڴ洢���ݵ�list����
	List<HBaseDataDO> dataList = new ArrayList<HBaseDataDO>();
	
//	2����ʼ�����ö���
	static{
		conf = HBaseConfiguration.create();
		conf.set("hbase.zookeeper.quorum", "hadoop01");
	}

//	3�������ȡ���ݵķ���
	/*
	 * ����ǰ̨���ݶ�����վ����stationID��ʵ�����Ǹ���stn+wban��ѯ����
	 * ����ֵΪ����HBaseDataDO��List����
	 */
	public List<HBaseDataDO> queryAllData(String stationId) throws Exception{
//		����������
		@SuppressWarnings("resource")
		HTable table = new HTable(conf, tabName);
//		HBase�ҳϹ�Ѷ��ͨ���м�����ѯ��֮ǰhbase�����õ��м��ǣ�stn+wban+date
//		����stn+wban�����ǰ̨��ֵ��date��Ҫ�ֶ�ָ����ʼʱ�����ֹʱ��Ϊ20160101&20161231
//		����ɨ�����������м�����ʼ�ͽ�����ѯ
		Scan scan = new Scan(
				(stationId+"2016-01-01").getBytes(), (stationId+"2016-12-31").getBytes());
//		ִ�в�ѯ���ұ��������
		ResultScanner rs = table.getScanner(scan);
		for (Result result : rs) {
			System.out.println(Bytes.toString((result.getRow())));
//			��Ҫ�������м���ѯ�������ݽ����װ��HBaseDataDO������
			HBaseDataDO hdo = new HBaseDataDO();
//			����ΪINFO�����ݷ�װ
			hdo.setStn(Bytes.toString(result.getValue(familyNames[0], GsodUtil.INFO_STN)));
			hdo.setWban(Bytes.toString(result.getValue(familyNames[0], GsodUtil.INFO_WBAN)));
//			�������͵�������Ҫ��ת��Ϊ�ַ�����20160101
			String dateStr = Bytes.toString(result.getValue(familyNames[0], GsodUtil.INFO_DATE));
//			Ȼ���ַ���ͨ����ȡ�Ӵ���ƴ�ӵķ�ʽ�������Date�ĸ�ʽ��yyyy-MM-dd
//			String date = dateStr.substring(0, 4)+"-"+dateStr.substring(4, 6)+"-"+dateStr.substring(6);
			hdo.setDate(Date.valueOf(dateStr));
//			����ΪDATA�����ݷ�װ
			hdo.setTemp(Bytes.toString(result.getValue(familyNames[1], GsodUtil.DATA_TEMP)));
			hdo.setDewp(Bytes.toString(result.getValue(familyNames[1], GsodUtil.DATA_DEWP)));
			hdo.setSlp(Bytes.toString(result.getValue(familyNames[1], GsodUtil.DATA_SLP)));
			hdo.setStp(Bytes.toString(result.getValue(familyNames[1], GsodUtil.DATA_STP)));
			hdo.setVisib(Bytes.toString(result.getValue(familyNames[1], GsodUtil.DATA_VISIB)));
			hdo.setWdsp(Bytes.toString(result.getValue(familyNames[1], GsodUtil.DATA_WDSP)));
			hdo.setMxspd(Bytes.toString(result.getValue(familyNames[1], GsodUtil.DATA_MXSPD)));
			hdo.setGust(Bytes.toString(result.getValue(familyNames[1], GsodUtil.DATA_GUST)));
			hdo.setMax(Bytes.toString(result.getValue(familyNames[1], GsodUtil.DATA_MAX)));
			hdo.setMin(Bytes.toString(result.getValue(familyNames[1], GsodUtil.DATA_MIN)));
			hdo.setPrcp(Bytes.toString(result.getValue(familyNames[1], GsodUtil.DATA_PRCP)));
			hdo.setSndp(Bytes.toString(result.getValue(familyNames[1], GsodUtil.DATA_SNDP)));
			hdo.setFog(Bytes.toString(result.getValue(familyNames[1], GsodUtil.DATA_FOG)));
			hdo.setRod(Bytes.toString(result.getValue(familyNames[1], GsodUtil.DATA_ROD)));
			hdo.setSoip(Bytes.toString(result.getValue(familyNames[1], GsodUtil.DATA_SOIP)));
			hdo.setHail(Bytes.toString(result.getValue(familyNames[1], GsodUtil.DATA_HAIL)));
			hdo.setThunder(Bytes.toString(result.getValue(familyNames[1], GsodUtil.DATA_THUNDER)));
			hdo.setTofc(Bytes.toString(result.getValue(familyNames[1], GsodUtil.DATA_TOFC)));
			
//			���hdo����洢��list������
			dataList.add(hdo);
		}
		return dataList;
	}
	
//	����
	public static void main(String [] args) throws Exception{
		String str= "45032099999";
		System.out.println(new HBaseDao().queryAllData(str).size());
	}
}
