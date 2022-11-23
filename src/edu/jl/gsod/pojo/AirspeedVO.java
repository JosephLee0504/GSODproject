package edu.jl.gsod.pojo;

public class AirspeedVO {
	private String date;
	private String stn;
	private String wban;
	private String wdsp;
	private String gust;
	private String mxspd;
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
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
	public String getWdsp() {
		return wdsp;
	}
	public void setWdsp(String wdsp) {
		this.wdsp = wdsp;
	}
	public String getGust() {
		return gust;
	}
	public void setGust(String gust) {
		this.gust = gust;
	}
	public String getMxspd() {
		return mxspd;
	}
	public void setMxspd(String mxspd) {
		this.mxspd = mxspd;
	}
	@Override
	public String toString() {
		return "AirspeedVO [date=" + date + ", stn=" + stn + ", wban=" + wban + ", wdsp=" + wdsp + ", gust=" + gust
				+ ", mxspd=" + mxspd + "]";
	}
}
