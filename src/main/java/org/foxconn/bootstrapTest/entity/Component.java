package org.foxconn.bootstrapTest.entity;

public class Component extends BaseStringArray{
	private String pn;
	private String sn;
	private String fw;

	
	public String getFw() {
		return fw;
	}
	public void setFw(String fw) {
		if(null==fw || "null".equalsIgnoreCase(fw)){
			fw="";
		}
		this.fw = fw;
	}
	public String getPn() {
		return pn;
	}
	public void setPn(String pn) {
		this.pn = pn;
	}
	public String getSn() {
		return sn;
	}
	public void setSn(String sn) {
		this.sn = sn;
	}
	@Override
	public String toString() {
		return "Component [pn=" + pn + ", sn=" + sn + ", fw=" + fw + "]";
	}
	@Override
	public String[] toStringArray() {
		// TODO Auto-generated method stub
		return new String[]{pn,sn,fw};
	}
	@Override
	public String[] getHeader() {
		// TODO Auto-generated method stub
		return new String[]{"pn","sn","fw"};
	}
	
	
}
