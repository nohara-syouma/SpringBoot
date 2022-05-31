<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index</title>
</head>
<body>
<p>検索条件を入力してください。</p>

<c:if test="${not empty msg}">
<p>${msg}</p>
</c:if>
  
  <form:form action="searchResult" modelAttribute="top" method="post">
    <div>
      <label>product_name</label> <form:input path="name" /><br>
      <label>price</label> <form:input path="price" />
    </div>
    <form:button name="search">検索</form:button>
    <form:button name="insert">登録</form:button>
  </form:form>
  
</body>
</html>