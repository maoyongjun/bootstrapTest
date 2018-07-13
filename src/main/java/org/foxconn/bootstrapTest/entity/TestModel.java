package org.foxconn.bootstrapTest.entity;

public class TestModel {
	private String name;
	private String category;
	private String partno;
	private String workoderno;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getPartno() {
		return partno;
	}
	public void setPartno(String partno) {
		this.partno = partno;
	}
	public String getWorkoderno() {
		return workoderno;
	}
	public void setWorkoderno(String workoderno) {
		this.workoderno = workoderno;
	}
	@Override
	public String toString() {
		return "TestModel [name=" + name + ", category=" + category + ", partno=" + partno + ", workoderno="
				+ workoderno + "]";
	}
	
}
