package edu.jl.gsod.pojo;
/**
 * �¶������ݵĽ��ʵ���ࣺ
 * @author tarena
 *
 */
public class TempVO {
	
//	��Ϊǰ̨�ڽ���Date��������ʱ�����long���ͣ�����ΪString����ʱ���ʽ����
	private String date;
	private String stn;
	private String wban;
	private String temp;
	private String dwep;
	private String max;
	private String min;
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
	public String getTemp() {
		return temp;
	}
	public void setTemp(String temp) {
		this.temp = temp;
	}
	public String getDwep() {
		return dwep;
	}
	public void setDwep(String dwep) {
		this.dwep = dwep;
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
	@Override
	public String toString() {
		return "TempVO [date=" + date + ", stn=" + stn + ", wban=" + wban + ", temp=" + temp + ", dwep=" + dwep
				+ ", max=" + max + ", min=" + min + "]";
	}
}
