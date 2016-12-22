package com.le.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.le.icontroller.IEventDispatcher;
import com.le.icontroller.IMessageDispatcher;
import com.le.util.DateUtil;
import com.le.util.MessageUtil;
import com.le.util.Signature;

@Controller
@RequestMapping("/wechat")
public class WechatSecurity {
	@Autowired
	private IEventDispatcher ed;
	@Autowired
	private IMessageDispatcher md;
	

	

	public IMessageDispatcher getMd() {
		return md;
	}

	public void setMd(IMessageDispatcher md) {
		this.md = md;
	}

	public IEventDispatcher getEd() {
		return ed;
	}

	public void setEd(IEventDispatcher ed) {
		this.ed = ed;
	}

	/**
	 * 验证微信服务器
	 * @param request
	 * @param response
	 * @param signature
	 * @param timestamp
	 * @param nonce
	 * @param echostr
	 */
	@RequestMapping(value="security",method=RequestMethod.GET)
	public void securityCheck(
			HttpServletRequest request,
			HttpServletResponse response,
			String signature,
			String timestamp,
			String nonce,
			String echostr
			)
	{
		System.out.println("enter");
			try {
				if(Signature.checkSignature(signature, timestamp, nonce)){
							PrintWriter out = response.getWriter();
							out.write(echostr);
							out.close();
				}else{
					System.out.println("请求非法");	
							}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	@RequestMapping(value="security",method=RequestMethod.POST)
	public void doPost(HttpServletRequest request,HttpServletResponse response){

		try {
			Map<String, String> parseXml = MessageUtil.parseXml(request);
			response.setCharacterEncoding("utf-8");
			String msgType = parseXml.get("MsgType");
			String  event=parseXml.get("Event");
			 
			if(MessageUtil.REQ_MESSAGE_TYPE_EVENT.equals(msgType)){
				PrintWriter out = response.getWriter();
				String resp=ed.processEvent(parseXml);
				
				//String xml = DateUtil.c(resp);
				System.out.println("服务端处理     "+resp);
				if("unsubscribe".equals(event)){//取消关注事件则返回空串给微信服务器
					out.write("");
					out.close();
				}else{
					out.write(resp);
					out.close();
				}
				
			}else{
				PrintWriter out = response.getWriter();
				String resp = md.processMessage(parseXml);
				System.out.println("服务端处理     "+resp);
				out.write(resp);
				out.close();
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
		}
	}


}
