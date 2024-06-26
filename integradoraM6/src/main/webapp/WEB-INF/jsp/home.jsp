<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib  prefix="sec" uri="http://www.springframework.org/security/tags" %>    
<%@ taglib prefix="c" uri="jakarta.tags.core" %>    
    
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org"
	  xmlns:sec="http://www.springframework.org/extras/spring-security">
<head>
<meta charset="UTF-8">
	<title>Home</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
 	<link rel="icon" href="/EnglisAlways.ico">
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
	      <div class="col-lg-4">
	        <div class="card mb-12" style="background-color: #bbb475e5;">
	          <div class="card-body text-center">
	            <h3>Situación Cuenta</h3>
	            <h3>${user.nombre} ${user.apellido}</h3>
	            <h4>Saldo: $ ${user.saldo}</h4>
	          </div>
	          	<ul>
	            	<li> <a href ="<c:url value ="/public"/>" > Novedades</a></li>
	            	<li> <a href ="<c:url value ="profile"/>" > Perfil</a></li>
					<li> <a href ="<c:url value ="/logout"/>" > Salir</a></li>
	            </ul>
	        </div>    
	      </div>
	    </div>
	    <div class="row " >
	    	<div class="col-lg-4">
	    		<div class="card mb-12" style="background-color: #a0ba76cc;">
					<div class="card-body text-center">
						<h3>Gestión de Fondos</h3>            
					</div>
		            <div class="d-flex justify-content-center mb-2">
						<form action="/deposito" method="GET">
			            	<div style="text-align: center;">
			            		<button type="submit" data-mdb-button-init data-mdb-ripple-init class="btn btn-primary btn-rounded"><span class="bi bi-piggy-bank-fill"></span> Depositar</button>
			            	</div>	            	
			            </form>
			            <form action="/retiro" method="GET">
			            	<div style="text-align: center;">
				            	<button type="submit" data-mdb-button-init data-mdb-ripple-init class="btn btn-primary btn-rounded ms-3"><span class="bi bi-cash-stack"></span> Retirar</button>
				            </div>
			            </form>
        		    </div>
				</div>
			</div>
	    	<div class="col-lg-4">
	    		<div class="card mb-12" style="background-color: #a0ba76cc;">
					<div class="card-body text-center">
						<h3>Envio de Fondos</h3>            
					</div>
					<form action="/transferencia" method="GET">
		            	<div style="text-align: center;">
		            		<button type="submit" class="btn btn-primary btn-rounded"><span class="bi bi-arrow-right-square"></span> Transferir</button>
		            	</div>
		            </form>
				</div>
			</div>
	    	<div class="col-lg-4">
	    		<div class="card mb-12" style="background-color: #a0ba76cc;">
					<div class="card-body text-center">
						<h3>Transacciones</h3>            
					</div>
					<form action="/transacciones" method="GET">
		            	<div style="text-align: center;">
		            		<button type="submit" class="btn btn-primary btn-rounded"><span class="bi bi-arrow-left-right"></span> Ver Historial</button>
		            	</div>
		            </form>
				</div>
			</div>
			<sec:authorize access="hasRole('ROLE_ADMIN')">
	    	<div class="col-lg-4">
	    		<div class="card mb-12" style="background-color: #a0ba76cc;">
					<div class="card-body text-center">
						<h3>Gestión de Usuarios</h3>            
					</div>
					<div class="d-flex justify-content-center mb-2">
						<form action="/usuario/form" method="GET">
			            	<div style="text-align: center;">
			            		<button type="submit" data-mdb-button-init data-mdb-ripple-init class="btn btn-primary btn-rounded"><span class="bi bi-kanban"></span> Crear</button>
			            	</div>
			            </form>
						<form action="/usuario/listado" method="GET">
			            	<div style="text-align: center;">
			            		<button type="submit" data-mdb-button-init data-mdb-ripple-init class="btn btn-primary btn-rounded ms-3"><span class="bi bi-kanban"></span> Listar / Editar</button>
			            	</div>
			            </form>
			        </div> 
				</div>
			</div>
			</sec:authorize>
		</div>
	  </div>
	</section>
</body>
</html>
