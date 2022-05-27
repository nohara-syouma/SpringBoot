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

  <form:form action="result" modelAttribute="login">
    <div>
      ログインID：
      <form:input path="logid" />
    </div>
    <br>
    <div>
      パスワード：
      <form:password path="pass" />
    </div>
    <br>
    
    <form:button name="param2">送信</form:button>
   
  </form:form>
  <a href="index2">戻る</a>

</body>
</html>
