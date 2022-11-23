package edu.jl.gsod.pojo;

public class VisibVO {
	private String date;
	private String stn;
	private String wban;
	private String visib;
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
	public String getVisib() {
		return visib;
	}
	public void setVisib(String visib) {
		this.visib = visib;
	}
	@Override
	public String toString() {
		return "VisibVO [date=" + date + ", stn=" + stn + ", wban=" + wban + ", visib=" + visib + "]";
	}
}
