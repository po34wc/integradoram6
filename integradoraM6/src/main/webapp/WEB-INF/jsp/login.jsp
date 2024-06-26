<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Login</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<section class="vh-100" style="background-color: #508bfc;">
	  <div class="container py-5 h-100">
	    <div class="row d-flex justify-content-center align-items-center h-100">
	      <div class="col-12 col-md-8 col-lg-6 col-xl-5">
	        <div class="card shadow-2-strong" style="border-radius: 1rem;">
	          <div class="card-body p-5 text-center">
	
	            <h3 class="mb-5">Login</h3>
				<form  action="/login" method="post">
		            <div data-mdb-input-init class="form-outline mb-4">
		              <input type="text" name="username" id="typeEmailX-2" class="form-control form-control-lg" />
		              <label class="form-label" for="typeEmailX-2">Usuario</label>
		            </div>
		            <div data-mdb-input-init class="form-outline mb-4">
		              <input type="password"name="password" id="typePasswordX-2" class="form-control form-control-lg" />
		              <label class="form-label" for="typePasswordX-2">Clave</label>
		            </div>

		            <button data-mdb-button-init data-mdb-ripple-init class="btn btn-primary btn-lg btn-block" type="submit">Ingresar</button>
				</form>
	          </div>
	        </div>
	      </div>
	    </div>
	  </div>
	</section>
</body>
</html>
