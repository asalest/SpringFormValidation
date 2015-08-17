<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form"
    prefix="springForm"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<html>
<head>
<style type="text/css"> <%@include file="../styles/style.css" %> </style>



<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Providers Save Page</title>

</head>
<body>
 	<div id="capcelera">
		<h2>FormValidation <br>
			<small>Create providers</small>
		</h2>
	</div>
	
	<div id="menuV">
		<div class="btn-group-vertical" role="group" aria-label="...">
			<form action="../">
    			<input class="btn btn-default" id="redo"  type="submit" value="Home">
			</form>
	
	  		<div class="btn-group" role="group">
	    		<button id="redo" type="button"  class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
	      			<fmt:message key="Customers"/>
	      			<span class="caret"></span>
	    		</button>
	    		<ul class="dropdown-menu">
	      		<li><a id="submenu" href="../cust/save">Create</a></li>
	      		<li><a id="submenu" href="../cust/custList?page=1">List</a></li>
			    </ul>
			</div>
	  		<div class="btn-group" role="group">
	    		<button id="redo" type="button"  class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
	      			<fmt:message key="Employees"/>
	      			<span class="caret"></span>
	    		</button>
	    		<ul class="dropdown-menu">
	      		<li><a id="submenu" href="../emp/save">Create</a></li>
	      		<li><a id="submenu" href="../emp/empList?page=1">List</a></li>
			    </ul>
	  		</div>
	  		<div class="btn-group" role="group">
	    		<button id="redo" type="button"  class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
	      			<fmt:message key="Providers"/>
	      			<span class="caret"></span>
	    		</button>
	    		<ul class="dropdown-menu">
	      		<li><a id="submenu" href="save">Create</a></li>
	      		<li><a id="submenu" href="provList?page=1">List</a></li>
	    		</ul>
	  		</div>
	  		<div class="btn-group" role="group">
	    		<button id="redo" type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
	      			<fmt:message key="Search"/>
	      			<span class="caret"></span>
	    		</button>
	    		<ul class="dropdown-menu">
	      		<li><a id="submenu" href="../search?page=1">Search Customers</a></li>
	    		</ul>
	  		</div>
		</div>
	</div>
	<!--<button class="btn btn-default" id="boton">Modal</button> -->

	
	<div id="cos">
		<springForm:form method="POST" commandName="provider" action="save.do">
         <div class="crearTabla">
	        <table class="table table-hover">
	            <tr>
	                <td><fmt:message key="Name"/></td>
	                <td><springForm:input path="name" /></td>
	                <td><springForm:errors path="name" cssClass="error" /></td>
	            </tr>
	            <tr>
	                <td><fmt:message key="Email"/></td>
	                <td><springForm:input path="email" /></td>
	                <td><springForm:errors path="email" cssClass="error" /></td>
	            </tr>
	            <tr>
	                <td><fmt:message key="Place"/></td>
	                <td><springForm:select path="place">
	                        <springForm:option value="" label="Select Place" />
	                        <springForm:option value="BARCELONA" label="Barcelona" />
	                        <springForm:option value="LLEIDA" label="Lleida" />
	                    </springForm:select></td>
	                <td><springForm:errors path="place" cssClass="error" /></td>
	            </tr>
	            <tr>
	                <td><fmt:message key="Phone"/></td>
	                <td><springForm:input path="phone" /></td>
	                <td><springForm:errors path="phone" cssClass="error" /></td>
	            </tr>
	            <tr>
	                <td><fmt:message key="Comentario"/></td>
	                <td><springForm:input path="comentario" /></td>
	                <td><springForm:errors path="comentario" cssClass="error" /></td>
	            </tr>
	             <!-- USER -->
	            <tr>
	                <td><fmt:message key="User"/></td>
	                <td><springForm:input path="user" /></td>
	                <td><springForm:errors path="user" cssClass="error" /></td>
	            </tr>
	            <tr>
	                <td><fmt:message key="Password"/></td>
	                <td><springForm:input  type="password" path="password" /></td>
	                <td><springForm:errors path="password" cssClass="error" /></td>
	            </tr>
       		</table>
	        
	        
	        <input type="submit" value="Save Provider">
	        
	        
	        <p class="home"><a href="/spring"><input type="submit" value="<--Home" /></a></p>
	           
        </div>
        

    </springForm:form>
	</div>
	
	<!-- <div id="peu">
		<p>Ariadne Sales</p>
	</div>-->

</body>
 
</body>
</html>