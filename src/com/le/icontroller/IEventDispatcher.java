package com.le.icontroller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public interface IEventDispatcher {
	public String processEvent(Map<String, String> map,HttpServletRequest request,HttpServletResponse response);
}
