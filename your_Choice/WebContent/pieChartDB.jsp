<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<% String url = application.getContextPath() + "/"; %>


<c:set var = "vHuman" value = "0" />
<c:set var = "vAi" value = "0" />

<c:forEach items="${sessionScope.getAllChart}" var="dataAll">
<c:set var= "vHuman" value="${vHuman + dataAll.VHuman}"/>
<c:set var= "vAi" value="${vAi + dataAll.VAi}"/>
</c:forEach>  
    
[['Task', 'Hours per Day'], ['vHuman', ${vHuman}], ['vAi', ${vAi}]]