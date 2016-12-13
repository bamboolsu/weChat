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
          <select id="day" onchange="getCount()">
            <option value="-1">请选择</option>
             <option value="0">今天</option>
             <option value="-3">近三天</option>
             <option value="-7">一周</option>
             <option value="-30">一个月</option>
          </select>
          
          <h3 align="center"><a href="http://localhost:8080/WeChat/st/toadd">添加</a></h3>
          <table border="1px" align="center">
               <tr align="center">
                    <td>id</td>
                    <td>名称</td>
                    <td>二维码参数</td>
                    <td>联系人</td>
                    <td>联系人电话</td>
                    <td>类型</td>
                    <td>状态</td>
                    <td>生成二维码</td>
                    <td>修改</td>
               </tr>
               
               <c:forEach items="${wps }" var="item" >
               <tr align="center">
                    <td>${item.id }</td>
                      <td>${item.name }</td>
                       <td>${item.eventKey }</td>
                         <td>${item.contacts }</td>
                           <td>${item.mobile }</td>
                       <td>${item.leType.type }</td>
                       <td>
                        <c:if test="${item.state==0 }">禁用</c:if>
                        <c:if test="${item.state==1 }">可用</c:if>
                     </td>
                     <td> <a href="${item.imageUrl }">生成二维码</a> </td>
                      <td> <a href="${item.id }">修改</a> </td>
               </tr>  
               </c:forEach>
          </table>
     
</body>
<script type="text/javascript">
for(var i=0;i<$("tr").length;i++){
	var c=i%2;
	if(c==0){
		$("tr").eq(i).css({"backgroundColor":"#ddd"})
	}else{
		$("tr").eq(i).css({"backgroundColor":"#fff"})
		}
}
</script>
</html>