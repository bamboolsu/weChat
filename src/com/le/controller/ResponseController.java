package com.le.controller;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.le.biz.INumberOfSubscriptionsBiz;
import com.le.util.DateUtil;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/res")
public class ResponseController {
     
	@Autowired
	private INumberOfSubscriptionsBiz inos;
	
	public INumberOfSubscriptionsBiz getInos() {
		return inos;
	}

	public void setInos(INumberOfSubscriptionsBiz inos) {
		this.inos = inos;
	}

	@RequestMapping("/gec")
	public void getEventCount(HttpServletRequest req,HttpServletResponse resp){
		//验证其为数字
	     String parameter = req.getParameter("day");
	     int day = Integer.parseInt(parameter);
	     String date = DateUtil.SomeTime(day);
	     int count = inos.getWxEventCount(date);
	     String jsonStr = "{'count':'','date':''}";
	     JSONObject jsonObject = JSONObject.fromObject(jsonStr);
	     jsonObject.put("count", count);
	     jsonObject.put("date", date);
	     try {
			PrintWriter writer = resp.getWriter();
			writer.write(jsonObject.toString());
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
