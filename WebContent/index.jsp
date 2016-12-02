<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
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
</script>
</head>
<body>
      欢迎，这是微信测试的首页
      <a href="wechat/security">点我测试</a>
      <input type="button" value="测试" onclick="sendPost()"/>
</body>
</html>