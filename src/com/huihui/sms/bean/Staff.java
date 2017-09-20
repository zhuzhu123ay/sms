package com.huihui.sms.bean;

public class Staff {

	//私有属性
	private String id;//工号
	private String username;//姓名
	private String ID_number;//身份证号
	private String Phone_number;//手机号
	private String job;//职务
	
	//构造
	public Staff(){
		
	}

	public Staff(String id, String username, String iD_number, String phone_number, String job) {
		super();
		this.id = id;
		this.username = username;
		ID_number = iD_number;
		Phone_number = phone_number;
		this.job = job;
	}


	//公共的setter,getter
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getID_number() {
		return ID_number;
	}

	public void setID_number(String iD_number) {
		ID_number = iD_number;
	}

	public String getPhone_number() {
		return Phone_number;
	}

	public void setPhone_number(String phone_number) {
		Phone_number = phone_number;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	@Override
	public String toString() {
		return "Staff [id=" + id + ", username=" + username + ", ID_number=" + ID_number + ", Phone_number="
				+ Phone_number + ", job=" + job + "]";
	}
}
