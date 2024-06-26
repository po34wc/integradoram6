<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  prefix="sec"  uri="http://www.springframework.org/security/tags"  %>    
    
    
<!DOCTYPE html>
<html  xmlns:th="http://www.thymeleaf.org"
		xmlns:sec="http://www.springframework.org/extras/spring-security">
<head>
<meta charset="UTF-8">
<title>Novedades</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>	
	<!-- Hero -->
<div class="p-5 text-center bg-image rounded-3" style="
    background-image: url('https://mdbcdn.b-cdn.net/img/new/slides/041.webp');
    height: 400px;
  ">
  <div class="mask" style="background-color: rgba(0, 0, 0, 0.6);">
    <div class="d-flex justify-content-center align-items-center h-100">
      <div class="text-white">
	
        <h1 class="mb-3">Novedades</h1>
        <h4 class="mb-3">muestra de pagina</h4>
        <p>
        	<sec:authorize access="isAuthenticated()">
				Solo Usuarios Logueados pueden verme
			</sec:authorize>
			
			<sec:authorize access="isAuthenticated() and principal.username=='joseperez'">
				<br/> Solo José Pérez puede verme
			</sec:authorize>
        
        </p>
      </div>
    </div>
  </div>
</div>

</body>
</html>
