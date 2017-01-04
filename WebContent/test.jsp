<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name=”viewport” content=”width=device-width, initial-scale=1″ />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
function GetQueryString(name)
{
     var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
     var r = window.location.search.substr(1).match(reg);
     if(r!=null)return  unescape(r[2]); return null;
}

function get() {
	//调用方法
	alert("openid     is "+GetQueryString("openid"));
}
</script>
</head>
<body>
   <a href="https://www.baidu.com">去百度</a>
    <a href="http://ouyangwenting.com/">欧阳文霆的博客</a>
    <table border="1px" align="center">
        <tr>
           <td>openid</td>
           <td>access_token</td>
           <td>refresh_token</td>
        </tr>
         <tr>
           <td>${openid }</td>
           <td><input type="button" onclick="get();" value="点我获取openId"></td>
           <td>${refresh_token}</td>
           <td></td>
        </tr>
    </table>
</body>
</html>