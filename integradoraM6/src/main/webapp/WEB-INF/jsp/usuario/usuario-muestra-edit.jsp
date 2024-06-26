<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Profile</title>
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
    <form action="/usuario/edit" method="post">
	    <div class="row">
	      <div class="col-lg-12">
	        <div class="card mb-4">
	          <div class="card-body">
	          	<div class="row">
	              <div class="col-sm-3">
	              <input type="hidden" name="id" value="${user.id}">
	                <p class="mb-0">Name</p>
	              </div>
	              <div class="col-sm-9">
	                <p class="text-muted mb-0"><input class="form-control" name="nombre" value="${user.nombre}" ></p>
	              </div>
	            </div>
	            <hr>
	            <div class="row">
	              <div class="col-sm-3">
	                <p class="mb-0">Last Name</p>
	              </div>
	              <div class="col-sm-9">
	                <p class="text-muted mb-0"><input class="form-control" name="apellido" value="${user.apellido}" ></p>
	              </div>
	            </div>
	            <hr>
	            <div class="row">
	              <div class="col-sm-3">
	                <p class="mb-0">Email</p>
	              </div>
	              <div class="col-sm-9">
	                <p class="text-muted mb-0"><input class="form-control" name="email" value="${user.email}" > </p>
	              </div>
	            </div>
	            <hr>
	            <div class="row">
	              <div class="col-sm-3">
	                <p class="mb-0">Rol</p>
	              </div>
	              <div class="col-sm-9">
	                <p class="text-muted mb-0"><select class="form-control" name="rol" id="rol">
											    	<option value="ADMIN" <c:if test="${user.rol=='ADMIN'}"> selected</c:if> >ADMIN</option>
											    	<option value="MANAGER" <c:if test="${user.rol=='MANAGER'}"> selected</c:if>>MANAGER</option>
											    	<option value="USER" <c:if test="${user.rol=='USER'}"> selected</c:if>>USER</option>
											    </select></p>
	              </div>
	            </div>
	            <hr>
	            <div class="row">
	              <div class="col-sm-3">
	                <p class="mb-0">username</p>
	              </div>
	              <div class="col-sm-9">
	                <p class="text-muted mb-0"><input class="form-control" name="username" value="${user.username}" ></p>
	              </div>	              
	            </div>
	          </div>
	        </div>
	      </div>
	    </div>
  		<button type="submit" class="btn btn-primary col-sm-3">Grabar</button>
  	</form>
  </div>
</section>
</body>
</html>
