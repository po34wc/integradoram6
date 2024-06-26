<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listado</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body style="background-color: #eee;">


<section style="background-color: #eee;">
  <div class="container py-5">
    <div class="row">
      <div class="col">
        <nav aria-label="breadcrumb" class="bg-body-tertiary rounded-3 p-3 mb-4">
          <ol class="breadcrumb mb-0">
            <li class="breadcrumb-item"><a href="/home">Home</a></li>
          </ol>
        </nav>
      </div>
    </div>

    <div class="row " >
      <div class="col-lg-12">
        <div class="card mb-12">
          <div class="card-body">
            <div class ="container">
				<div class="row">
					<div class="col-md-12">
						<h1>Usuarios</h1>
						<table class="table">
						  <thead>
						    <tr>
						      <th scope="col">#</th>
						      <th scope="col">Nombre</th>
						      <th scope="col">Apellido</th>
						      <th scope="col">Email</th>
						    </tr>
						  </thead>
						  <tbody>
						  <c:forEach var="usu" items="${list}"> 
						    <tr>
						      <th scope="row">
						      <a href="<c:url value = "/usuario/${usu.id}"/>">${usu.id}</a>				      
						      
						      </th>
						      <td>${usu.nombre}</td>
						      <td>${usu.apellido}</td>
						      <td>${usu.email}</td>
						    </tr>
						    </c:forEach>
						  </tbody>
						</table>
			
					</div>
				</div>
			</div>
           
          </div>
        </div>
      </div>
    </div>
  </div>
</section>
</body>
</html>
