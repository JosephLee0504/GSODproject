package edu.jl.gsod.util;

/**
 * �������ж���hbase�ı�����������������
 * �������壬�ο�GSOD�ֶ�˵�����GSOD˵���ĵ�.xlsx
 * @author tarena
 *
 */
public class GsodUtil {
	
//	����gsod������ԣ�ʹ�ó�������
//	����
	public static final String TABLE_NAME = "gsod_2016";
//	���壺�������壬�ֱ��ǻ�����Ϣ�Լ�������Ϣ
	public static final byte[][] COLUMN_FAMILYS={"INFO".getBytes(),"DATA".getBytes()};
//	�У�INFO
	public static final byte[] INFO_STN = "STN".getBytes();
	public static final byte[] INFO_WBAN = "WBAN".getBytes();
	public static final byte[] INFO_DATE = "DATE".getBytes();
//	�У�DATA
	public static final byte[] DATA_TEMP = "TEMP".getBytes();
	public static final byte[] DATA_DEWP = "DEWP".getBytes();
	public static final byte[] DATA_SLP = "SLP".getBytes();
	public static final byte[] DATA_STP = "STP".getBytes();
	public static final byte[] DATA_VISIB = "VISIB".getBytes();
	public static final byte[] DATA_WDSP = "WDSP".getBytes();
	public static final byte[] DATA_MXSPD = "MXSPD".getBytes();
	public static final byte[] DATA_GUST = "GUST".getBytes();
	public static final byte[] DATA_MAX = "MAX".getBytes();
	public static final byte[] DATA_MIN = "MIN".getBytes();
	public static final byte[] DATA_PRCP = "PRCP".getBytes();
	public static final byte[] DATA_SNDP = "SNDP".getBytes();
//	FRSHTT:Fog��'F' - ��1λ���ķ������ڡ����ϸ�꣨'R' - �ڶ�λ����ѩ�����'S' - ��3λ����������'H' - ��4λ����������'T' - ��5λ����������©���ƣ�'T' - ��6λ��
	public static final byte[] DATA_FOG = "FOG".getBytes();
	public static final byte[] DATA_ROD = "ROD".getBytes();
	public static final byte[] DATA_SOIP = "SOIP".getBytes();
	public static final byte[] DATA_HAIL = "HAIL".getBytes();
	public static final byte[] DATA_THUNDER = "THUNDER".getBytes();
	public static final byte[] DATA_TOFC = "TOCF".getBytes();
}
