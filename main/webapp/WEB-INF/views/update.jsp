<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><fmt:message key="page.index.title" /></title>
</head>
<body>
<p>削除対象のproduct_idを入力してください</p>

<c:if test="${not empty msg}">
<p>${msg}</p>
</c:if>

  <form:form action="update" modelAttribute="update" method="post">
    <div>
      <label><fmt:message key="lbl.id" /></label><form:input path="productId" /><form:errors path="productId" cssStyle="color: red"/><br>
      <label><fmt:message key="lbl.product.name" /></label><form:input path="name" /><form:errors path="name" cssStyle="color: red"/><br>
      <label><fmt:message key="lbl.price" /></label><form:input path="price" /><form:errors path="price" cssStyle="color: red"/><br>
    </div>
    <form:button name="update"><fmt:message key="form.lbl.update" /></form:button>

  </form:form>
  
</body>
</html>