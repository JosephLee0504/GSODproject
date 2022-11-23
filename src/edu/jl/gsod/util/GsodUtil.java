package edu.jl.gsod.util;

/**
 * 工具类中定义hbase的表名、列族名、列名
 * 具体释义，参考GSOD字段说明表格：GSOD说明文档.xlsx
 * @author tarena
 *
 */
public class GsodUtil {
	
//	创建gsod表的属性：使用常量定义
//	表名
	public static final String TABLE_NAME = "gsod_2016";
//	列族：两个列族，分别是基础信息以及数据信息
	public static final byte[][] COLUMN_FAMILYS={"INFO".getBytes(),"DATA".getBytes()};
//	列：INFO
	public static final byte[] INFO_STN = "STN".getBytes();
	public static final byte[] INFO_WBAN = "WBAN".getBytes();
	public static final byte[] INFO_DATE = "DATE".getBytes();
//	列：DATA
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
//	FRSHTT:Fog（'F' - 第1位）的发生日期。雨或细雨（'R' - 第二位）。雪或冰球（'S' - 第3位）。冰雹（'H' - 第4位）。雷霆（'T' - 第5位）。龙卷风或漏斗云（'T' - 第6位）
	public static final byte[] DATA_FOG = "FOG".getBytes();
	public static final byte[] DATA_ROD = "ROD".getBytes();
	public static final byte[] DATA_SOIP = "SOIP".getBytes();
	public static final byte[] DATA_HAIL = "HAIL".getBytes();
	public static final byte[] DATA_THUNDER = "THUNDER".getBytes();
	public static final byte[] DATA_TOFC = "TOCF".getBytes();
}
