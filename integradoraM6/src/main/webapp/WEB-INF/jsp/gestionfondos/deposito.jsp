<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Depósitos</title>
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
						<h1>Realizar Depósito</h1>
						<div class="row">
							<div class="col-md-6">
								<c:if test="${creado}">
									<div class="alert alert-success alert-dismissible fade show" role="alert">
									 	Depósito realizado exitosamente
									 	<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
									</div>
								</c:if>
							</div>
						</div>



<!-- 			<td> -->
<!-- 				<select name="categoriaServicio" id="categoriaServicio" class="form-control"> -->
<!-- 					<option value="0">Seleccione una categoría</option> -->
<%-- 					<c:forEach var="productos" items="${listaCatSer}"> --%>
<%-- 						<option value="${productos.id}">${productos.nombre}</option> --%>
<%-- 					</c:forEach> --%>
<!-- 				</select> -->
<!-- 			</td> -->


						<form action="#" method="post">
<!-- 						  <div class="mb-3">
						    <label for="nombre" class="form-label">Nombre</label>
						    <input type="text" name="nombre" class="form-control" id="nombre">
						  </div> -->
						  <div class="mb-3">
						    <label for="monto" class="form-label">Monto depósito</label>
						    <input type="text" name="monto" class="form-control" id="monto">
						  </div>
						  <button type="submit" class="btn btn-primary">Depositar</button>
						</form>
					</div>
				</div>
			</div>
           
          </div>
        </div>
      </div>
    </div>
  </div>
</section>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
