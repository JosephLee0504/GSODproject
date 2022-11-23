package edu.jl.gsod.pojo;

public class RainfallVO {
	private String date;
	private String stn;
	private String wban;
	private String prcp;
	private String sndp;
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
	@Override
	public String toString() {
		return "RainfallVO [date=" + date + ", stn=" + stn + ", wban=" + wban + ", prcp=" + prcp + ", sndp=" + sndp
				+ "]";
	}
}
