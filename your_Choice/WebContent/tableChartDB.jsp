<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<% String url = application.getContextPath() + "/"; %>

<c:forEach items="${sessionScope.getAllChart}" var="dataAll">
   ${dataAll.userNum},'${dataAll.nickName}', ${dataAll.VHuman}, ${dataAll.VAi};
</c:forEach> 