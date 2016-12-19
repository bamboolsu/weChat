<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>查询</title>
 <c:if test="${wx==null }">
   <c:redirect url="/st/initJsp"/>
</c:if>
</head>
<body>
    <table border="1px" align="center">
          <tr>
               <td>推广人名</td>
                <td>二维码参数</td>
                <td>推广类型</td>
                <td>状态</td>
                 <td>详细</td>
          </tr>
          <c:forEach items="${wx }" var="item">
          
                 <tr>
                     <td>${item.name }</td>
                     <td>${item.eventKey }</td>
                      <c:forEach items="${type }" var="type">
                           <c:if test="${item.leTypeId==type.letypeId }">
                                <td>${type.type }</td>
                           </c:if>
                      </c:forEach>
                      <c:if test="${item.state==1 }">
                          <td>可用</td>
                      </c:if>
                       <c:if test="${item.state==0 }">
                          <td>禁用</td>
                      </c:if>
             
                        <td><a href="http://192.168.220.24:8080/WeChat/st/find?eventKey=${item.eventKey }">详细</a></td>
                </tr>
          </c:forEach>
    </table>
</body>
</html>