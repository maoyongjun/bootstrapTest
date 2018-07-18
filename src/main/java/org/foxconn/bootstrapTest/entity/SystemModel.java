package org.foxconn.bootstrapTest.entity;

import java.util.List;

public class SystemModel {
	private String pn;
	private String sn;
	private BoardModel board;
	private CpuModel cpu;
	private HddModel hdd;
	private List<MemoryModel> memory;
	private List<NicModel> nic;
	private List<PsuModel> psu;
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
	public BoardModel getBoard() {
		return board;
	}
	public void setBoard(BoardModel board) {
		this.board = board;
	}
	public CpuModel getCpu() {
		return cpu;
	}
	public void setCpu(CpuModel cpu) {
		this.cpu = cpu;
	}
	public HddModel getHdd() {
		return hdd;
	}
	public void setHdd(HddModel hdd) {
		this.hdd = hdd;
	}
	public List<MemoryModel> getMemory() {
		return memory;
	}
	public void setMemory(List<MemoryModel> memory) {
		this.memory = memory;
	}
	public List<NicModel> getNic() {
		return nic;
	}
	public void setNic(List<NicModel> nic) {
		this.nic = nic;
	}
	public List<PsuModel> getPsu() {
		return psu;
	}
	public void setPsu(List<PsuModel> psu) {
		this.psu = psu;
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
	
}
