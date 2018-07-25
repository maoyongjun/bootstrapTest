package org.foxconn.bootstrapTest.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SeagateData1 extends BaseStringArray {
	private String sysserialno;
	private String eventname;
	private String eventpass;
	private String eventfail;
	private Date scandatetime;
	public String getSysserialno() {
		return sysserialno;
	}
	public void setSysserialno(String sysserialno) {
		this.sysserialno = sysserialno;
	}
	public String getEventname() {
		return eventname;
	}
	public void setEventname(String eventname) {
		this.eventname = eventname;
	}
	public String getEventpass() {
		return eventpass;
	}
	public void setEventpass(String eventpass) {
		this.eventpass = eventpass;
	}
	public String getEventfail() {
		return eventfail;
	}
	public void setEventfail(String eventfail) {
		this.eventfail = eventfail;
	}
	public Date getScandatetime() {
		return scandatetime;
	}
	public void setScandatetime(Date scandatetime) {
		this.scandatetime = scandatetime;
	}
	@Override
	public String[] toStringArray() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		String scandatetime = sdf.format(this.scandatetime);
		return new String[]{ sysserialno,eventname,eventpass,eventfail,sysserialno,scandatetime};
	}
	@Override
	public String[] getHeader() {
		// TODO Auto-generated method stub
		return new String[]{ "sysserialno","eventname","eventpass","eventfail","sysserialno","scandatetime"};
	}
	
}
