<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>查询</title>
<script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
<script type="text/javascript">
 $(document).ready(function(){ 
	 var indexURL='http://localhost:8080/WeChat/st/getAll';
	 $.ajax(
		{
			type:'GET',
			url:indexURL,
			dataType:'jsonp',
			success:function(data){
				//alert(data.allMess);
                if(data.result==1){
                	var result='';
                	for(var i=0;i<data.allMess.length;i++){
                		var mess='<tr>';
                		for (var j = 0; j < data.allMess[i].length; j++) {
                			
							mess+="<td>"+data.allMess[i][j]+"</td>"
						  };
								mess+='</tr>'
								
						result+=mess;
                	}
                	 $("#table tbody").append(result);
				}
			}
		}	 
	 )
	 
}); 
 </script>
</head>
<body>
	<table border="1px" align="center" id="table">
		<tr>
			<td>二维码参数</td>
			<td>推广人名</td>
			<td>今天内关注的人数</td>
			<td>三天内关注的人数</td>
			<td>一个星期内关注的人数</td>
			<td>一个月内关注的人数</td>
			<td>推广类型</td>
		</tr>
		<c:forEach items="${allMess }" var="item">

			<tr>

				<td>${item[i] }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>