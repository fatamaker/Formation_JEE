<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Confirmation Ajout Formation</title>
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
</head>
<body>
<%@include file="header.jsp" %>
<p></p>
<div class="container">
<div class="card">
  <div class="card-header">
    Confirmation Ajout Formation
  </div>
  <div class="card-body">
    <div class="form-group">
      <label class="control-label">ID :</label>
      <input type="text" name="idFormation" class="form-control" value="${formation.idFormation}" readonly/>
    </div>
    <div class="form-group">
      <label class="control-label">Nom Formation :</label>
      <input type="text" name="nomFormation" class="form-control" value="${formation.nomFormation}" readonly/>
    </div>
    <div class="form-group">
      <label class="control-label">Prix Formation :</label>
      <input type="text" name="prixFormation" class="form-control" value="${formation.prixFormation}" readonly/>
    </div>
    <div class="form-group">
      <label class="control-label">Mode Formation :</label>
      <input type="text" name="modeFormation" class="form-control" value="${formation.modeFormation}" readonly/>
    </div>
  </div>
</div>
</div>
</body>
</html>