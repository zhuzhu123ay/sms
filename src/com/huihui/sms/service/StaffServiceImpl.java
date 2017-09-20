package com.huihui.sms.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.huihui.sms.bean.Staff;
import com.huihui.sms.dao.StaffDao;
import com.huihui.sms.tool.JavaSmsApi;
import com.huihui.sms.tool.Lunar;
import com.huihui.sms.tool.TimeUtils;


public class StaffServiceImpl{

	/*
	 * 节假日自动发送祝福短信
	 */
	JavaSmsApi jsa=new JavaSmsApi();
	TimeUtils tu=new TimeUtils();
	public void sendFestival(String text) throws Exception{
		if(tu.isFestival()){
			
			jsa.batchSend(JavaSmsApi.apikey, JavaSmsApi.text, TimeUtils.getFestivalAllPhone());
		}
	}
	/*
	 * 生日自动发送祝福短信
	 */
	
	public void sendBirthday() throws Exception{
		if(tu.isBirthday()){
			jsa.batchSend(JavaSmsApi.apikey, JavaSmsApi.text,TimeUtils.getBirthdayAllPhone() );
		}
	}
	/*
	 * 根据职务发送通知类短信
	 */
	public void sendJob(String staff_job,String smsInform) throws Exception{
		if(tu.isJob(staff_job)){
			jsa.batchSend(JavaSmsApi.apikey, smsInform,TimeUtils.getJobAllPhone(staff_job) );
		}
	}
	public static void main(String[] args) throws Exception{
		StaffServiceImpl ssi=new StaffServiceImpl();
		//ssi.sendBirthday();
		//ssi.sendFestival();
	}


}
