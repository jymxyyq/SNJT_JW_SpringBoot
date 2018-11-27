package com.yonyou.ny.yht.yhttest.endpoint;

import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.yonyou.yht.sdk.UserCenter;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/user")
@Slf4j
public class AddController {
	
	@RequestMapping(value = "/add")
	public String addUser(Map<String,String> params) {
		//http://uc.snjt.com/cas/login?sysid=yht-demo&service=http%3A%2F%2Flocalhost%3A8080%2F
		//tenantId,userCode,userName,userMobile
		//"jymtest02,9092,JUGG01" pwd= 9b8081848f4a44871e3cb214ba98565fa3485c63
		String tenantId = "9093";
		String userCode = "jymtest03";
		String userName = "JUGG02";
		String userMobile = "15971389033";
		String userPassword = "jw123456";
		params.put("tenantId", tenantId);
		params.put("userCode", userCode);
		params.put("userName", userName);
		params.put("userMobile", userMobile);
		params.put("userPassword", userPassword);
		String result = UserCenter.addUser(params);
		System.out.println(result);
		return result;
	}
	
	@RequestMapping(value = "/update")
	public String updatePwd() {
		// "sysId": "yht-demo","sid": 0,"userId": "56c324df-91d6-4173-a3d0-76e5abc5bff3"
		String userId = "56c324df-91d6-4173-a3d0-76e5abc5bff3";
		String shaPassword = "OAiJOkHeUb3q88P29VpwUEtGYM4=";
		String md5Password = "9.ivvXi.$p3LejZR8aJt5hCiJpFO5R.";
		String shaNewPassword = "+dcI50TScrwQAJfDyj3pmEcG2iU=";
		String md5NewPassword = "YWpUzUUG$Yn/zhF4wknqAQafNVS5YN0";
		String sid = "0";
		UserCenter.modifyPassword(userId, shaPassword, md5Password, shaNewPassword, md5NewPassword, sid);
		//return UserCenter.updateUserProperties("jymtest03", "userPassword", "jw654321");
		//UserCenter.updateUserMultiProperties(userid, properties)
		return "Welcome to RouNmi";
	}
	
}
