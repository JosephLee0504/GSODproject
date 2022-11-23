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
 * 数据持久层：和HBase交互，获取其中的数据并且封装到HBaseDataDO
 * @author tarena
 * 逻辑：连接上HBase，读取其中的数据
 */
public class HBaseDao {

//	1、	声明HBase的配置对象
	private static Configuration conf = null;
//		声明表名和列族：
	private String tabName =GsodUtil.TABLE_NAME;
	private byte [][] familyNames = GsodUtil.COLUMN_FAMILYS;
//		创建一个用于存储数据的list集合
	List<HBaseDataDO> dataList = new ArrayList<HBaseDataDO>();
	
//	2、初始化配置对象
	static{
		conf = HBaseConfiguration.create();
		conf.set("hbase.zookeeper.quorum", "hadoop01");
	}

//	3、定义获取数据的方法
	/*
	 * 根据前台传递而来的站点编号stationID：实际上是根据stn+wban查询数据
	 * 返回值为保存HBaseDataDO的List集合
	 */
	public List<HBaseDataDO> queryAllData(String stationId) throws Exception{
//		创建表连接
		@SuppressWarnings("resource")
		HTable table = new HTable(conf, tabName);
//		HBase忠诚哈讯是通过行键来查询，之前hbase中设置的行键是：stn+wban+date
//		其中stn+wban编号是前台传值，date需要手动指定起始时间和终止时间为20160101&20161231
//		创建扫描器：按照行键的起始和结束查询
		Scan scan = new Scan(
				(stationId+"2016-01-01").getBytes(), (stationId+"2016-12-31").getBytes());
//		执行查询并且遍历结果集
		ResultScanner rs = table.getScanner(scan);
		for (Result result : rs) {
			System.out.println(Bytes.toString((result.getRow())));
//			需要将根据行键查询到的数据结果封装到HBaseDataDO对象中
			HBaseDataDO hdo = new HBaseDataDO();
//			列族为INFO的数据封装
			hdo.setStn(Bytes.toString(result.getValue(familyNames[0], GsodUtil.INFO_STN)));
			hdo.setWban(Bytes.toString(result.getValue(familyNames[0], GsodUtil.INFO_WBAN)));
//			日期类型的数据需要先转换为字符串：20160101
			String dateStr = Bytes.toString(result.getValue(familyNames[0], GsodUtil.INFO_DATE));
//			然后字符串通过截取子串再拼接的方式，处理成Date的格式：yyyy-MM-dd
//			String date = dateStr.substring(0, 4)+"-"+dateStr.substring(4, 6)+"-"+dateStr.substring(6);
			hdo.setDate(Date.valueOf(dateStr));
//			列族为DATA的数据封装
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
			
//			最后将hdo对象存储到list集合中
			dataList.add(hdo);
		}
		return dataList;
	}
	
//	测试
	public static void main(String [] args) throws Exception{
		String str= "45032099999";
		System.out.println(new HBaseDao().queryAllData(str).size());
	}
}
