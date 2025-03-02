<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Gestion des Formations</title>
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
</head>
<body>
<%@include file="header.jsp" %>
<p></p>
<div class="container">
<div class="card">
  <div class="card-header">
    Recherche des Formations
  </div>
  <div class="card-body">
      <form action="chercher.do" method="get">
        <label>Mot Clé</label>
        <input type="text" name="motCle" value="${model.motCle}" />
        <button type="submit" class="btn btn-primary">Chercher</button>
      </form>      
      <table class="table table-striped">
        <tr>
          <th>ID</th>
          <th>Nom Formation</th>
          <th>Prix</th>
          <th>Mode Formation</th>
          <th>Actions</th>
        </tr>
        <c:forEach items="${model.formations}" var="f">
          <tr>
            <td>${f.idFormation}</td>
            <td>${f.nomFormation}</td>
            <td>${f.prixFormation}</td>
            <td>${f.modeFormation}</td>
            <td>
              <a href="editer.do?id=${f.idFormation}" class="btn btn-warning">Editer</a>
              <a href="supprimer.do?id=${f.idFormation}" class="btn btn-danger">Supprimer</a>
            </td>
          </tr>
        </c:forEach>         
      </table>
      <a href="saisie.do" class="btn btn-success">Ajouter une Formation</a>
  </div>
</div>
</div>
</body>
</html>