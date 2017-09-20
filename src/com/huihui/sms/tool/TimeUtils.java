package com.huihui.sms.tool;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.huihui.sms.bean.Staff;
import com.huihui.sms.dao.StaffDao;

public class TimeUtils {
	private static StaffDao staffDao=new StaffDao();
	public static List<Staff> listAll() throws Exception {
		List<Staff> list=staffDao.findAll();
		return list;
	}
	private static Map<String,String> festivalMap;
	{
		festivalMap=new HashMap<>();
		festivalMap.put("101", "春节");
		festivalMap.put("115", "元宵节");
		festivalMap.put("505", "端午节");
		festivalMap.put("707", "乞巧节");
		festivalMap.put("815", "中秋节");
		festivalMap.put("909", "重阳节");
		festivalMap.put("1208", "腊八");
		festivalMap.put("727", "腊八");
	}
	private static Lunar lunar=new Lunar();
	//根据农历节日日期和Map中的日期是否匹配，从而判断今天是否是某一节日
	public static boolean isFestival(){
    	String lunarmd=lunar.changeLunar();
    	if(festivalMap.containsKey(lunarmd)){
    		return true;
    	}
		return false;
	}
	/**
	 * 根据农历节日日期获取“节日”
	 * @return
	 */
	public static String getFestivalName(){
		if(isFestival()){
	    	String lunarmd=lunar.changeLunar();
	    	return festivalMap.get(lunarmd);
		}
		return null;
	}
	/*
	 * 如果今天是节日，群发祝福所有老师快乐的节日短信
	 */
	public static String getFestivalAllPhone() throws Exception{
		if(isFestival()){
			 StaffDao staffDao=new StaffDao();
			    String allTeacherPhoneNumber="";
			    List<Staff> allStaffList=staffDao.findAll();
			    for(Staff staff:allStaffList){
			    	allTeacherPhoneNumber+=staff.getPhone_number()+",";
			    }
				return allTeacherPhoneNumber.substring(0,allTeacherPhoneNumber.length()-1);
		}
		return null;
	}
	//判断今天是否是某人生日
	public static boolean isBirthday() throws Exception{
		SimpleDateFormat dateFormat = new SimpleDateFormat("MMdd");
	    Date date = new Date();
			//18位的第二代身份证,出生日期是从7位到14位是出生日期
	    for (Staff staff : listAll()) {
			if(staff.getID_number().substring(10, 14).equals(dateFormat.format(date))){
				return true;
			}
		}	       
		return false;
	}
	
	
	/**
	 * 如果这些老师在这一天过生日，获取他们的电话号码
	 * @return
	 * @throws Exception
	 */
	public static String getBirthdayAllPhone() throws Exception{
		if(isBirthday()){
			SimpleDateFormat dateFormat = new SimpleDateFormat("MMdd");
		    Date date = new Date();
		    StaffDao staffDao=new StaffDao();
		    String phonenumber="";
		    List<Staff> staffList=staffDao.findByBirthday(dateFormat.format(date));
		    for(Staff staff:staffList){
		    	phonenumber+=staff.getPhone_number()+",";
		    	System.out.println(phonenumber);
		    }
			return phonenumber.substring(0,phonenumber.length()-1);	
		}
		return null;
	}
	
	public static boolean isJob(String staff_job) throws Exception {
		List<Staff> jobPhoneStaff=staffDao.findByJob(staff_job);
		for (Staff staff : jobPhoneStaff) {
			if(staff.getPhone_number()!=null){
				return true;
			}
		}	  
		return false;
	}
	
	/**
	 * 像拥有特定职务的老师发送通知类短信息
	 * @throws Exception 
	 */
	public static String getJobAllPhone(String staff_job) throws Exception{
		if(isJob(staff_job)){
			List<Staff> staffList=staffDao.findByJob(staff_job);
			String phonenumber="";
		    for(Staff staff:staffList){
		    	phonenumber+=staff.getPhone_number()+",";
		    	System.out.println(phonenumber);
		    }
		    return phonenumber.substring(0,phonenumber.length()-1);	
		}
		return null;
	}
	
}
