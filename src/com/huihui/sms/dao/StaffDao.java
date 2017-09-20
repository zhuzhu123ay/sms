package com.huihui.sms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.huihui.sms.bean.Staff;
import com.huihui.sms.jdbc.ConnectionFactory;

public class StaffDao {
	// 通过生日查询职工信息
	public List<Staff> findByBirthday(String staff_birthday) throws Exception {
		Staff staff = null;
		List<Staff> list;
		try {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				// 获取连接
				conn = ConnectionFactory.getConn();
				// 预处理sql
				String sql = "select * from tbl_staff where subString(ID_number,11,4) = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, staff_birthday);
				// 处理结果集
				rs = pstmt.executeQuery();
				list=new ArrayList<>();
				while (rs.next()) {
					String id = rs.getString("id");
					String username = rs.getString("username");
					String iD_number = rs.getString("iD_number");
					String phone_number = rs.getString("phone_number");
					String job = rs.getString("job");
					staff = new Staff(id, username,  iD_number, phone_number,  job);
					list.add(staff);
				}
			} finally {
				// 释放资源
				ConnectionFactory.close(rs, pstmt, conn);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return list;
	}
	// 通过职务查询职工信息
	public List<Staff> findByJob(String staff_job) throws Exception {
		Staff staff = null;
		List<Staff> list;
		try {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				// 获取连接
				conn = ConnectionFactory.getConn();
				// 预处理sql
				String sql = "select * from tbl_staff where job = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, staff_job);
				// 处理结果集
				rs = pstmt.executeQuery();
				list=new ArrayList<>();
				while (rs.next()) {
					String id = rs.getString("id");
					String username = rs.getString("username");
					String iD_number = rs.getString("iD_number");
					String phone_number = rs.getString("phone_number");
					String job = rs.getString("job");
					staff = new Staff(id, username,  iD_number, phone_number,  job);
					list.add(staff);
				}
			} finally {
				// 释放资源
				ConnectionFactory.close(rs, pstmt, conn);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return list;
	}
	
	//查询所有人员信息（有参数）
		public List<Staff> query(String id, String username, String iD_number, String phone_number, String job) throws Exception{
			List<Staff> list=new ArrayList<>();
			try {
				Connection conn=null;
				PreparedStatement pstmt=null;
				ResultSet rs=null;
				try {
					//1.获取连接
					conn=ConnectionFactory.getConn();
					//2.预处理
					String sql="select * from tbl_staff where 1=1";
					if(id!=null){
						sql+=" and id = "+id;
					}
					if(username!=null){
						sql+=" and username = "+username;
					}
					if(iD_number!=null){
						sql+=" and iD_number = '"+iD_number+"'";
					}
					if(phone_number!=null){
						sql+=" and phone_number = "+phone_number;
					}
					if(job!=null){
						sql+=" and age ="+job;
					}
					pstmt=conn.prepareStatement(sql);
					//3.执行sql
					rs=pstmt.executeQuery();
					//4.处理结果集
					while(rs.next()){
						String db_id=rs.getString("id");
						String db_username=rs.getString("username");
						String db_iD_number=rs.getString("iD_number");
						String db_phone_number=rs.getString("phone_number");
						String db_job=rs.getString("job");
						Staff staff=new Staff(db_id,db_username,db_iD_number,db_phone_number,db_job);
						list.add(staff);
					}
				} finally {
					//5.释放资源
					ConnectionFactory.close(rs, pstmt, conn);
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw e;
			}
			return list;
		}
	
	//查询职工信息(无参数)
	public List<Staff> findAll() throws Exception{
		List<Staff> list=new ArrayList<>();
		try {
			Connection conn=null;
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			try {
				//获取连接
				conn=ConnectionFactory.getConn();
				//预处理
				String sql="select * from tbl_staff";
				pstmt=conn.prepareStatement(sql);
				//处理结果集
				rs=pstmt.executeQuery();
				while(rs.next()){
					String id = rs.getString("id");
					String username = rs.getString("username");
					String iD_number = rs.getString("iD_number");
					String phone_number = rs.getString("phone_number");
					String job = rs.getString("job");
					Staff staff = new Staff(id, username,  iD_number, phone_number,  job);
					list.add(staff);
				}
			} finally {
				//释放资源
				ConnectionFactory.close(rs, pstmt, conn);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return list;
	}
}
