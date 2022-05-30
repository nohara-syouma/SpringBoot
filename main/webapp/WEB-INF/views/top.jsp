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

<c:if test="${not empty productList}">
<p>${productList}</p>
</c:if>
  
  <form:form action="searchResult" modelAttribute="top" method="post">
    <div>
      <label>product_id</label> <form:input path="id" />
    </div>
    <form:button>検索</form:button>
  </form:form>
  
</body>
</html>