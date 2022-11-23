package edu.jl.gsod.pojo;

public class FrshttVO {
	private String date;
	private String stn;
	private String wban;
	private String isFog;
	private String isRainOrDrizzle;
	private String isSnowOrIcePellets;
	private String isHail;
	private String isThunder;
	private String isTornadoOrFC;
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
	public String getIsFog() {
		return isFog;
	}
	public void setIsFog(String isFog) {
		this.isFog = isFog;
	}
	public String getIsRainOrDrizzle() {
		return isRainOrDrizzle;
	}
	public void setIsRainOrDrizzle(String isRainOrDrizzle) {
		this.isRainOrDrizzle = isRainOrDrizzle;
	}
	public String getIsSnowOrIcePellets() {
		return isSnowOrIcePellets;
	}
	public void setIsSnowOrIcePellets(String isSnowOrIcePellets) {
		this.isSnowOrIcePellets = isSnowOrIcePellets;
	}
	public String getIsHail() {
		return isHail;
	}
	public void setIsHail(String isHail) {
		this.isHail = isHail;
	}
	public String getIsThunder() {
		return isThunder;
	}
	public void setIsThunder(String isThunder) {
		this.isThunder = isThunder;
	}
	public String getIsTornadoOrFC() {
		return isTornadoOrFC;
	}
	public void setIsTornadoOrFC(String isTornadoOrFC) {
		this.isTornadoOrFC = isTornadoOrFC;
	}
	@Override
	public String toString() {
		return "FrshttVO [date=" + date + ", stn=" + stn + ", wban=" + wban + ", isFog=" + isFog + ", isRainOrDrizzle="
				+ isRainOrDrizzle + ", isSnowOrIcePellets=" + isSnowOrIcePellets + ", isHail=" + isHail + ", isThunder="
				+ isThunder + ", isTornadoOrFC=" + isTornadoOrFC + "]";
	}
}
