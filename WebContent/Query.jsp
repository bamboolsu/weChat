<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="../js/jquery-1.11.3.min.js">
</script>
<script type="text/javascript">
function getCount(){
	var url="http://localhost:8080/WeChat/st/findJosn";
	var day=$('#day option:selected').val();
	if("-1"==day){
		alert("请选择时间");
		return ;
	}
	var date={"date":day,"eventKey":$('#key').val()}
	 $.ajax({
			url:'http://localhost:8080/WeChat/st/findJosn',
			type:'GET',
			data:date,
			dataType:'jsonp',
			success:function(data){
				//alert(data.date);
				//alert(data.count);
				 $('#date').html(data.date+"至今关注人数");
				 $('#count').html($('#day option:selected').html);
				}
		})

	//data.count
}

</script>
<title>查询</title>
</head>
<body>
      <form action="">
         <input type="hidden" id="key" name="eventKey" value="${eventKey }">
      <select name="date" id="day" onchange="getCount()">
          <option value="-1">请选择查询范围</option>
           <option value=0>今天</option>
          <option value=-3>3天内</option>
          <option value=-7>一个星期内</option>
          <option value=-30>一个月内</option>
      </select>
     </form> 
      <table border="1px">
      <tr align="center">
          
          <td>二维码参数</td>
          <td>日期</td>
          <td>关注人数</td>
      </tr>
            <tr align="center">
               <td>${eventKey }</td>
               <td id="date">${date }至今关注人数</td>
                <td id="count">${count }</td>
            </tr>
      
      </table>
</body>
</html>