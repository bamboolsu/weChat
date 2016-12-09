<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.11.3.min.js">
     
</script>
<script type="text/javascript">
function sendPost(){
	 var url="https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=weixin";
	 var data={"expire_seconds": 604800, "action_name": "QR_SCENE", "action_info": "Test"};
	 $.post(url,data,function (d){
		 
	 })
}

function getCount(){
	var url="http://localhost:8080/WeChat/res/gec";
	var day=$('#day option:selected').val();
	if("-1"==day){
		alert("请选择时间");
		return ;
	}
	var data={"day":day}
	$.post(url,data,function (d){
		 alert(d);
	 })
	
}
</script>
</head>
<c:if test="${wps==null }">
   <jsp:forward page="/st/init"></jsp:forward>
</c:if>
<body>
      欢迎，这是微信测试的首页
      <a href="wechat/security">点我测试</a>
      
      <input type="button" value="测试" onclick="sendPost()"/>
     
          <select id="day" onchange="getCount()">
            <option value="-1">请选择</option>
             <option value="0">今天</option>
             <option value="-3">近三天</option>
             <option value="-7">一周</option>
             <option value="-30">一个月</option>
          </select>
          
          <table>
               <tr>
                    <td>id</td>
                    <td>姓名</td>
                    <td>二维码参数</td>
                    <td>类型</td>
                    <td>状态</td>
               </tr>
               
               <c:forEach items="${wps }" var="item" >
                      <tr>${item.id }</tr>
                      <tr>${item.name }</tr>
                       <tr>${item.eventKey }</tr>
                       <tr>${item.Le.type }</tr>
                       <tr>
                        <c:if test="${item.state==0 }">禁用</c:if>
                        <c:if test="${item.state==1 }">可用</c:if>
                       </tr>
                      
               </c:forEach>
          </table>
     
</body>
</html>