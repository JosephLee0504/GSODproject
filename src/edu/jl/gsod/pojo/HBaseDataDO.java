package edu.jl.gsod.pojo;

import java.util.Date;
/**
 * 实体类：与HBase中的列名映射
 * @author tarena
 *
 */
public class HBaseDataDO {
	
	private String stn;
	private String wban;
	private Date date;
	private String temp;
	private String dewp;
	private String slp;
	private String stp;
	private String visib;
	private String wdsp;
	private String mxspd;
	private String gust;
	private String max;
	private String min;
	private String prcp;
	private String sndp;
	private String fog;
	private String rod;
	private String soip;
	private String hail;
	private String thunder;
	private String tofc;
	
//	getter&setter
	public String getStn() {
		return stn;
	}
	public void setStn(String stn) {
		this.stn = stn;
	}
	public String getWban() {
		return wban;
	}
	public void setWban(String wban) {
		this.wban = wban;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getTemp() {
		return temp;
	}
	public void setTemp(String temp) {
		this.temp = temp;
	}
	public String getDewp() {
		return dewp;
	}
	public void setDewp(String dewp) {
		this.dewp = dewp;
	}
	public String getSlp() {
		return slp;
	}
	public void setSlp(String slp) {
		this.slp = slp;
	}
	public String getStp() {
		return stp;
	}
	public void setStp(String stp) {
		this.stp = stp;
	}
	public String getVisib() {
		return visib;
	}
	public void setVisib(String visib) {
		this.visib = visib;
	}
	public String getWdsp() {
		return wdsp;
	}
	public void setWdsp(String wdsp) {
		this.wdsp = wdsp;
	}
	public String getMxspd() {
		return mxspd;
	}
	public void setMxspd(String mxspd) {
		this.mxspd = mxspd;
	}
	public String getGust() {
		return gust;
	}
	public void setGust(String gust) {
		this.gust = gust;
	}
	public String getMax() {
		return max;
	}
	public void setMax(String max) {
		this.max = max;
	}
	public String getMin() {
		return min;
	}
	public void setMin(String min) {
		this.min = min;
	}
	public String getPrcp() {
		return prcp;
	}
	public void setPrcp(String prcp) {
		this.prcp = prcp;
	}
	public String getSndp() {
		return sndp;
	}
	public void setSndp(String sndp) {
		this.sndp = sndp;
	}
	public String getFog() {
		return fog;
	}
	public void setFog(String fog) {
		this.fog = fog;
	}
	public String getRod() {
		return rod;
	}
	public void setRod(String rod) {
		this.rod = rod;
	}
	public String getSoip() {
		return soip;
	}
	public void setSoip(String soip) {
		this.soip = soip;
	}
	public String getHail() {
		return hail;
	}
	public void setHail(String hail) {
		this.hail = hail;
	}
	public String getThunder() {
		return thunder;
	}
	public void setThunder(String thunder) {
		this.thunder = thunder;
	}
	
	public String getTofc() {
		return tofc;
	}
	public void setTofc(String tofc) {
		this.tofc = tofc;
	}
	
//	toString
	@Override
	public String toString() {
		return "HBaseDataDO [stn=" + stn + ", wban=" + wban + ", date=" + date + ", temp=" + temp + ", dewp=" + dewp
				+ ", slp=" + slp + ", stp=" + stp + ", visib=" + visib + ", wdsp=" + wdsp + ", mxspd=" + mxspd
				+ ", gust=" + gust + ", max=" + max + ", min=" + min + ", prcp=" + prcp + ", sndp=" + sndp + ", fog="
				+ fog + ", rod=" + rod + ", soip=" + soip + ", hail=" + hail + ", thunder=" + thunder + ", tofc=" + tofc
				+ "]";
	}
}
