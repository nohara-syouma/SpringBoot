<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring Web MVC Test</title>
</head>
<body>

  <form:form action="result" modelAttribute="index">
    <div>
      名前：
      <form:input path="input" />
    </div>
    <br>
    <!--<div>
      商品：
      <form:input path="id" />
    </div>
    <br>-->
     <div>
      <label>商品：</label>
      <form:select path="id">
        <form:options items="${userList}" itemLabel="product_name" itemValue="product_id" />
      </form:select>
    </div>
    <form:button name="param1">送信</form:button>
   
  </form:form>

</body>
</html>
