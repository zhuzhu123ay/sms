<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="getJobInf" method="post">
	<!-- <div style="background-color: gray;">
		<div style=" width: 200px; height: 150px; border:1px; line-height: 150px; text-align: center;float:left" id=" div1">布拉格公园</div> -->
		<div style="600px; height: 150px; border:1px; line-height: 120px; text-align:center;float:left" id="div_2">
			<table bordercolor="green;" border=10px; align="center">
				<tr>
					<td>
					教授<input name="checkBoxJobName" type="checkbox" value="教授">
					助教<input name="checkBoxJobName" type="checkbox" value="助教">
					处长<input name="checkBoxJobName" type="checkbox" value="处长">
					副处长<input name="checkBoxJobName" type="checkbox" value="副处长">
					副处长<input name="checkBoxJobName" type="checkbox" value="副处长">
					副处长<input name="checkBoxJobName" type="checkbox" value="副处长">
					副处长<input name="checkBoxJobName" type="checkbox" value="副处长">
					副处长<input name="checkBoxJobName" type="checkbox" value="副处长">
					</td>
				</tr>
				<tr>
					<td>
						<input type="text" name="smsInform">
						<input type="submit" value="发送">
					</td>
				</tr>
			</table>
		</div>
	</form>
	<!-- </div> -->
</body>
</html>