package edu.jl.gsod.pojo;

public class PressureVO {
	private String date;
	private String stn;
	private String wban;
	private String slp;
	private String stp;
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
	@Override
	public String toString() {
		return "PressureVO [date=" + date + ", stn=" + stn + ", wban=" + wban + ", slp=" + slp + ", stp=" + stp + "]";
	}
}
