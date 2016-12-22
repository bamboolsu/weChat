package com.le.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.le.biz.IWxParticularBiz;
import com.le.bizimpl.NumberOfSubscriptionsBizImpl;
import com.le.entity.LeType;
import com.le.entity.WxParticular;
import com.le.util.DateUtil;
import com.le.util.WXUserUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * ��WxParticular
 * @author ouyangwenting
 *
 */

@Controller
@RequestMapping("/st")
public class Statistics {
     
	@Autowired
	private IWxParticularBiz iwp;
	
	private Logger log=Logger.getLogger(Statistics.class) ;
	
	public IWxParticularBiz getIwp() {
		return iwp;
	}
	public void setIwp(IWxParticularBiz iwp) {
		this.iwp = iwp;
	}
	
	
	
	@RequestMapping("/init")
	public void init(HttpServletRequest req,HttpServletResponse resp,Integer startPage,Integer pageCount,String callback){
		if(startPage==null){
			startPage=1;
		}
		
		if(pageCount==null){
			pageCount=10;
		}
		JSONArray jsonArr=new JSONArray();
		List<WxParticular> initWxParticulars = iwp.init(startPage, pageCount);
		for (WxParticular wxParticular : initWxParticulars) {
			LeType leType = wxParticular.getLeType();
			wxParticular.setLeType(null);
			JSONObject jsonObj=JSONObject.fromObject(wxParticular);
			jsonObj.put("leTypeName", leType.getType());
			jsonArr.add(jsonObj);
		}
		Long sumPage = iwp.getSumPage(pageCount);
		JSONObject initWxParticularJson=new JSONObject();
		initWxParticularJson.put("wpList", jsonArr.toString());
		initWxParticularJson.put("sumPage", sumPage);
		initWxParticularJson.put("result", 1);
		System.out.println(initWxParticularJson);
		PrintWriter out=null;
		try {
			out = resp.getWriter();
			//������������
			String crossDomain = WXUserUtil.crossDomain(callback, initWxParticularJson);
			out.write(crossDomain);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			out.close();
		}
		
	}
	
	
	
	/**
	 * ����ѡ��ʱ���첽��������
	 * @param resp
	 * @param eventKey
	 * @param date
	 */
	@RequestMapping("/findJosn")
	public void  findByEventKey(HttpServletResponse resp,Integer eventKey,Integer date,String callback){
		if(date==null){
			date=0;
		}
		Long count = iwp.getCount(eventKey, date, 1);
		JSONObject jsonObj=new JSONObject();
		jsonObj.put("count" , count);
		jsonObj.put("date", DateUtil.SomeTime(date));
		PrintWriter out=null;
		try {
			out = resp.getWriter();
			//������������
			String crossDomain = WXUserUtil.crossDomain(callback, jsonObj);
			out.write(crossDomain);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			out.close();
		}
		
	}
	
	
	@RequestMapping("initJsp")
	/**
	 * ��jspҳ���õ���ҳ����
	 * @param req
	 * @param resp
	 * @param startPage
	 * @param pageCount
	 * @param callback
	 * @return
	 */
	public String initJsp(HttpServletRequest req,HttpServletResponse resp,Integer startPage,Integer pageCount,String callback){
		if(startPage==null){
			startPage=1;
		}
		
		if(pageCount==null){
			pageCount=10;
		}
		iwp.init(startPage, pageCount);
		List<WxParticular> initWxParticulars = iwp.init(startPage, pageCount);
		req.setAttribute("wx", initWxParticulars);
		Long sumPage = iwp.getSumPage(pageCount);
		req.setAttribute("sumPage", sumPage);
		List<LeType> types = iwp.getAllType();
		req.setAttribute("type", types);
		return "index";
	}
	
	/**
	 * ����Id��ѯWxParticular����
	 * @param resp
	 * @param id
	 */
	@RequestMapping("findWxParticularById")
	public void findWxParticularById(HttpServletResponse resp,Integer id,String callback){
		WxParticular wxParticular = iwp.findWxParticularById(id);
		JSONObject jsonObj=new JSONObject();
		if(wxParticular==null){
			jsonObj.put("result", -1);
		}else{
			jsonObj.put("result", 1);
			LeType leType = wxParticular.getLeType();
			wxParticular.setLeType(null);
			jsonObj.put("wxParticular", wxParticular);
			jsonObj.put("leTypeName", leType.getType());
		}
		PrintWriter out =null;
		try {
			out = resp.getWriter();
			//������������
			String crossDomain = WXUserUtil.crossDomain(callback, jsonObj);
			out.write(crossDomain);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			out.close();
		}
	}
	
	@RequestMapping("/getLeType")
	public void getAllLeType(HttpServletResponse resp,String callback){
		List<LeType> leTypes = iwp.getAllType();
		JSONObject jsonObj=new JSONObject();
		jsonObj.put("leType", leTypes);
		jsonObj.put("result", 1);
		PrintWriter out=null;
		try {
			 out = resp.getWriter();
			 out.write(jsonObj.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			out.close();
		}
	}
	
	@RequestMapping("/add")
	public void addWxParticular(HttpServletResponse resp,WxParticular wp,String callback){
		//��֤�������ݵ������ԣ��Ϸ���
		int id = iwp.add(wp);
		System.out.println(wp);
		String imageUrl=WXUserUtil.getImageUrl(wp.getEventKey());//��ά��ͼƬurl��ַ
		boolean setImageUrlResult = iwp.setImageUrl(imageUrl, id);
		PrintWriter out=null;
		JSONObject resultJson=new JSONObject();
		if(setImageUrlResult){
			resultJson.put("result", true);
		}else{
			resultJson.put("result", 40001);//��ά��ͼƬ��ȡʧ��
		}
		System.out.println(resultJson.toString());
		try {
			out = resp.getWriter();
			//������������
			String crossDomain = WXUserUtil.crossDomain(callback, resultJson);
			out.write(crossDomain);
		   
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			out.close();
		}
		
	}
	
	/**
	 *����id ɾ��WxParticular����
	 * @param resp
	 * @param id
	 */
	@RequestMapping("/del")
	public void deleteWxParticularById(HttpServletResponse resp,Integer id,String callback){
		System.out.println("id"+id);
		boolean result = iwp.deleteWxParticularById(id);
		resp.setContentType("text/json");
		PrintWriter out=null;
		JSONObject resultJson=new JSONObject();
		resultJson.put("result", result);
		try {
			out = resp.getWriter();
			String crossDomain = WXUserUtil.crossDomain(callback, resultJson);
			System.out.println(crossDomain);
		    out.write(crossDomain);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			out.close();
		}
	}
	
	@RequestMapping("/test")
	public void test(String id){
		int i=0;
		log.info("id   "+id);
		log.info("i   "+i);
		try {
			int a=5/i;
		} catch (ArithmeticException e) {
			log.error("运算错误",e);
			// TODO: handle exception
		}
	}
	
	@RequestMapping("/find")
	public String  findByEventKey(HttpServletRequest req,Integer eventKey,Integer date){
		if(date==null){
			date=0;
		}
		Long count = iwp.getCount(eventKey, date, 1);
		req.setAttribute("count", count);
		req.setAttribute("date", DateUtil.SomeTime(date));
		req.setAttribute("eventKey", eventKey);
		return "Query";
	}
	
	/**
	 * ��ѯ����ͳ����Ϣ��ص�����
	 * @param req
	 * @return
	 */
	@RequestMapping("/getAll")
	public void getAll(HttpServletResponse resp,String callback){
		List<Object[]> list = iwp.getAll();
		
		JSONArray jsonArr=new JSONArray();
         for (Object[] objects : list) {
			jsonArr.add(objects);
		}
		JSONObject json=new JSONObject();
		json.put("allMess", jsonArr);
		json.put("result", 1);
		System.out.println(json);
		//�����������
		String crossDomain = WXUserUtil.crossDomain(callback, json);
		PrintWriter out=null;
		try {
			 out = resp.getWriter();
			 out.write(crossDomain);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			out.close();
		}
	}
}
