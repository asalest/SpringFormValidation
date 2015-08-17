<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 
<%@ page session="false"  import="com.journaldev.spring.form.controllers.CustomerController"
						 import="com.journaldev.spring.form.model.Customer"
						 import="java.util.List"%>
<html>
<head>
<!--  <style type="text/css"> <--%@include file="style.css" %> </style>-->
<style type="text/css"> <%@include file="../styles/style.css" %> </style>


<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
<!-- Latest compiled and minified JavaScript -->
<script type="text/javascript" src="<c:url value="/resources/jquery.tablesorter.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/functionsE.js"/>"></script>
  
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="<c:url value="/resources/blue/style.css"/>" type="text/css" media="print, projection, screen" />
  

<style>
body{
	font-family:helvetica;
	color:#6a7841;
}
</style>

    <title>Customer Saved Successfully</title>
    
</head>
<body>
	<div id="capcelera">
		<h2>FormValidation <br>
			<small>Create customers</small>
		</h2>
	</div>
	
	<div id="menuV">
		<div class="btn-group-vertical" role="group" aria-label="...">
			
			<form action="../">
    			<input class="btn btn-default" id="redo"  type="submit" value="Home">
			</form>
			
	
	  		<div class="btn-group" role="group">
	    		<button id="redo" type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
	      			<fmt:message key="Customers"/>
	      			<span class="caret"></span>
	    		</button>
	    		<ul class="dropdown-menu">
	      		<li><a id="submenu" href="../cust/save">Create</a></li>
	      		<li><a id="submenu" href="../cust/custList?page=1">List</a></li>
			    </ul>
			</div>
	  		<div class="btn-group" role="group">
	    		<button id="redo" type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
	      			<fmt:message key="Employees"/>
	      			<span class="caret"></span>
	    		</button>
	    		<ul class="dropdown-menu">
	      		<li><a id="submenu" href="emp/save">Create</a></li>
	      		<li><a id="submenu" href="empList?page=1">List</a></li>
			    </ul>
	  		</div>
	  		<div class="btn-group" role="group">
	    		<button id="redo" type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
	      			<fmt:message key="Providers"/>
	      			<span class="caret"></span>
	    		</button>
	    		<ul class="dropdown-menu">
	      		<li><a id="submenu" href="../prov/save">Create</a></li>
	      		<li><a id="submenu" href="../prov/provList?page=1">List</a></li>
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
	
		<form:form modelAttribute="ArrayID" name="form" action="delete" method="post">
	  		<form:input type="hidden" path="employees" />
	  	</form:form>
	  	<form:form modelAttribute="ArrayID" name="formM" action="modify" method="get">
	  		<form:input type="hidden" path="employee" />
	  	</form:form>
	  	
		<div>
					
		<table class="table table-bordered" id="tabla">
				<tr id="color">
					<th><input type="checkbox" id="SelectAll" aria-label="..." onclick="AllCheck()"></th>
					<th><fmt:message key="Name"/></th>
					<th><fmt:message key="Role"/></th>
					<th><fmt:message key="Comentario"/></th>
			 		<th><fmt:message key="User"/></th>
			 		<th><fmt:message key="Password"/></th>
				</tr>
				<c:forEach items="${listingE}" var="listingE">
					<tr>
						<td><input type="checkbox" value="${listingE.id}" name="checkbox" onclick="showblocked()"></td>
						<td>${listingE.name}</td>
						<td>${listingE.role}</td>
						<td>${listingE.comentario}</td>
					  	<td>${listingE.user}</td>
					  	<td>${listingE.password}</td>
					</tr>
				</c:forEach>
			</table>
			</div>
			
			<div class="panel-footer">
				<div class="rows row">
					<div class="col-md-4">
		  				<button class="trashbut btn btn-danger glyphicon glyphicon-trash" id="deleteEmployee" style="display:none"></button>
		  				<button class="modifybut btn btn-info glyphicon glyphicon-user" id="modifyEmployee" style="display:none" onClick="check(2)"></button>
		  			</div>
					<div class="col-md-4"></div>
					<!-- Paginador aquí -->
					<div class="col-md-4" align="right">
					</div>
				</div>
			</div>
				
			<ul class="pagination pagination-default">
			<li>
				<a href="?page=1" aria-label="Fisrt">
					<span aria-hidden="true">&laquo;</span>
				</a>
			</li>
			<c:choose>
				<c:when test="${npages==1}">
					<li class="active"><a href="?page=${firstpage}">${firstpage}</a></li>
				</c:when>
				<c:when test="${npages==2}">
					<c:choose>
						<c:when test="${firstpage == 1}">
							<li class="active"><a href="?page=${firstpage}">${firstpage}</a></li>
							<li class="inactive"><a href="?page=${firstpage+1}">${firstpage+1}</a></li>
						</c:when>
						<c:otherwise>
							<li class="inactive"><a href="?page=${firstpage-1}">${firstpage-1}</a></li>
							<li class="active"><a href="?page=${firstpage}">${firstpage}</a></li>
						</c:otherwise>
					</c:choose>
				</c:when>
				<c:when test="${npages>=3}">
					<c:choose>
						<c:when test="${firstpage == 1}">
							<li class="active"><a href="?page=${firstpage}">${firstpage}</a></li>
							<li class="inactive"><a href="?page=${firstpage+1}">${firstpage+1}</a></li>
							<li class="inactive"><a href="?page=${firstpage+2}">${firstpage+2}</a></li>
						</c:when>
						<c:when test="${firstpage == npages}">
							<li class="inactive"><a href="?page=${firstpage-2}">${firstpage-2}</a></li>
							<li class="inactive"><a href="?page=${firstpage-1}">${firstpage-1}</a></li>
							<li class="active"><a href="?page=${firstpage}">${firstpage}</a></li>
						</c:when>
						<c:otherwise>
							<li class="inactive"><a href="?page=${firstpage-1}">${firstpage-1}</a></li>
							<li class="active"><a href="?page=${firstpage}">${firstpage}</a></li>
							<li class="inactive"><a href="?page=${firstpage+1}">${firstpage+1}</a></li>
						</c:otherwise>
					</c:choose>
				</c:when>
			</c:choose>
			<li>
				<a href="?page=${npages}" aria-label="Last">
					<span aria-hidden="true">&raquo;</span>
				</a>
			</li>
		</ul>
		
		<!-- Modal HTML -->
		<div id="myModal" class="modal fade">
		    <div class="modal-dialog">
		        <div class="modal-content">
		            <div class="modal-header">
		                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
		                <h4 class="modal-title">Delete confirmation</h4>
		            </div>
		            <div class="modal-body">
		                <p>Delete <span id="modalEmployeesNumber"></span> employees?</p>
		            </div>
		            <div class="modal-footer">
		                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
		                <button type="button" class="btn btn-danger" onClick="check(1)">Delete Employees</button>
		            </div>
		        </div>
		    </div>
		</div>
		</div>
	
	<!-- <div id="peu">
		<p>Ariadne Sales</p>
	</div>-->
</body>
</html>
