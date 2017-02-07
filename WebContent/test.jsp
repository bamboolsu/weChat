<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="Cache-Control" content="no-transform" /> 
<meta http-equiv="Cache-Control" content="no-siteapp" />
<meta name="viewport" content="width=device-width,initial-scale=1.0,user-scalable=yes" />
<style type="text/css"> 
@media(max-width:960px)
{
  
}
</style>
<style type="text/css"> 
@media(max-width:960px)
{
     /* 网页全屏显示 */
    body {width:100%;} 

    /* 正文全屏显示 */
    #divMain{width:100%} 

    /* 为了避免正文图片超出屏幕宽度 */
    /* 正文图片宽度最多是屏幕宽度的90% */
    #divMain img{max-width:90%} 

    /* 隐藏头部、导航、侧栏、页脚 */
    #divHead{display:none}
    #divNav{display:none}
    #divSide{display:none}
    #divBottom{display:none}
}
</style>
<style type="text/css"> 
/* 默认隐藏手机版头部、导航和页脚 */
#divHead_mobile{display:none}
#divNav_mobile{display:none}
#divBottom_mobile{display:none}
@media(max-width:960px)
{
     /* 网页全屏显示 */
    body {width:100%;} 

    /* 正文全屏显示 */
    #divMain{width:100%} 

    /* 为了避免正文图片超出屏幕宽度 */
    /* 正文图片宽度最多是屏幕宽度的90% */
    #divMain img{max-width:90%} 

    /* 隐藏头部、导航、侧栏、页脚 */
    #divHead{display:none}
    #divNav{display:none}
    #divSide{display:none}
    #divBottom{display:none}

    /* 显示手机版头部、导航和页脚 */
    #divHead_mobile{display:block}
    #divNav_mobile{display:block}
    #divBottom_mobile{display:block}
}
</style>
<title>自适应页面测试</title>
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
    <a href="fansindex.jsp">去fansindex.html</a>
</body>
</html>