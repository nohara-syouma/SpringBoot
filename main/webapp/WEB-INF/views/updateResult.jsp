<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>削除完了</title>
</head>
<body>
  <h2>更新完了</h2>

 	<div>
  	<p><fmt:message key="lbl.before" /></p>
    <fmt:message key="lbl.id" />:${fn:escapeXml(productList.productId)}<br>
    <fmt:message key="lbl.product.name" />:${fn:escapeXml(productList.productName)}<br>
    <fmt:message key="lbl.price" />:${fn:escapeXml(productList.price)}
  	</div>
  
  
  
  <div>
  	<p><fmt:message key="lbl.after" /></p>
    <fmt:message key="lbl.id" />:${fn:escapeXml(product.productId)}<br>
    <fmt:message key="lbl.product.name" />:${fn:escapeXml(product.productName)}<br>
    <fmt:message key="lbl.price" />:${fn:escapeXml(product.price)}
  </div>

  <a href="update"><fmt:message key="btn.back" /></a>

</body>