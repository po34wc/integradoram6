<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Historial Transacciones</title>
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
						<h1>Historial Transacciones</h1>
						<table class="table">
						  <thead>
						    <tr>
						      <th scope="col">#</th>
						      <th scope="col">Fecha</th>
						      <th scope="col">Origen</th>
						      <th scope="col">Destino</th>
						      <th scope="col">Tipo</th>
						      <th scope="col">Monto</th>
						    </tr>
						  </thead>
						  <tbody>
							  <c:forEach var="usu" items="${historial}"> 
							    <tr>
							      <th scope="row">${usu.id}</th>
							      <td>${usu.fecha}</td>
							      <td>${usu.nombreOri} ${usu.apellidoOri}</td>
							      <td>${usu.nombreDes} ${usu.apellidoDes}</td>
							      <td>${usu.tipo}</td>
							      <td>${usu.monto}</td>
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

