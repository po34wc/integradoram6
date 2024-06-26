<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="jakarta.tags.core" %>
    <%@ taglib prefix="sec"  uri="http://www.springframework.org/security/tags"  %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Profile</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
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
    <div class="row">
      <div class="col-lg-12">
        <div class="card mb-4">
          <div class="card-body">
          	<div class="row">
              <div class="col-sm-3">
                <p class="mb-0">Name</p>
              </div>
              
              <div class="col-sm-9">
                <p class="text-muted mb-0">${user.nombre} </p>
              </div>
            </div>
            <hr>
            <div class="row">
              <div class="col-sm-3">
                <p class="mb-0">Last Name</p>
              </div>
              <div class="col-sm-9">
                <p class="text-muted mb-0">${user.apellido}</p>
              </div>
            </div>
            <hr>
            <div class="row">
              <div class="col-sm-3">
                <p class="mb-0">Email</p>
              </div>
              <div class="col-sm-9">
                <p class="text-muted mb-0">${user.email}</p>
              </div>
            </div>
            <hr>
            <div class="row">
              <div class="col-sm-3">
                <p class="mb-0">Rol</p>
              </div>
              <div class="col-sm-9">
                <p class="text-muted mb-0">${user.rol}</p>
              </div>
            </div>
            <hr>
            <div class="row">
              <div class="col-sm-3">
                <p class="mb-0">username</p>
              </div>
              <div class="col-sm-9">
                <p class="text-muted mb-0">${user.username}</p>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  	<sec:authorize access="hasRole('ROLE_ADMIN')">
		<a href="<c:url value = "/usuario/${user.id}/edit"/>" class="btn btn-primary col-sm-3">Habilitar Edicion</a>
	</sec:authorize>
  </div>
</section>
</body>
</html>
