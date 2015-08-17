<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=utf8" pageEncoding="utf8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ page trimDirectiveWhitespaces="true" %>
<html>
<head>
<!--  <style type="text/css"> <--%@include file="style.css" %> </style>-->
<style type="text/css"> <%@include file="../styles/style.css" %> </style>
<link rel="stylesheet" href="/resources/themes/master.css" type="text/css" />
<link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css"
 rel="stylesheet" type="text/css" />
 
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>


<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Customer Save Page</title>


<script
 src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.js"
 type="text/javascript"></script>
<script
 src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"
 type="text/javascript"></script>
<script
 src="http://ajax.microsoft.com/ajax/jquery.validate/1.7/jquery.validate.js"
 type="text/javascript"></script>
<script src="/resources/scripts/mysamplecode.js" type="text/javascript"></script>

	<style>
	$(document).ready(function() {
		$.datepicker.regional['es'] = {
				 closeText: 'Cerrar',
				 prevText: '<Ant',
				 nextText: 'Sig>',
				 currentText: 'Hoy',
				 monthNames: ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio', 'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre'],
				 monthNamesShort: ['Ene','Feb','Mar','Abr', 'May','Jun','Jul','Ago','Sep', 'Oct','Nov','Dic'],
				 dayNames: ['Domingo', 'Lunes', 'Martes', 'Miércoles', 'Jueves', 'Viernes', 'Sábado'],
				 dayNamesShort: ['Dom','Lun','Mar','Mié','Juv','Vie','Sáb'],
				 dayNamesMin: ['Do','Lu','Ma','Mi','Ju','Vi','Sá'],
				 weekHeader: 'Sm',
				 dateFormat: 'dd/mm/yy',
				 firstDay: 1,
				 isRTL: false,
				 showMonthAfterYear: false,
				 yearSuffix: ''
		};
		$.datepicker.setDefaults($.datepicker.regional['es']);
				 
		$(".myDate").datepicker();
	});
	</style>

</head>
<body>

	<div id="capcelera">
		<h2>FormValidation <br>
			<small>Search</small>
		</h2>
	</div>
	
	
		<form:form modelAttribute="Searchfields" class="form-horizontal" method="post"> 
			<div>
				<div class="form-inline" id="searchcss">
					<div id="searchcssCas" >
				    	<input type="checkbox" name="checkname" aria-label="..." onClick="byname.disabled = !this.checked" >
				    	<label>Search by name:</label> 
				    	<p></p>                
						<form:input name="byname" type="text" class="formlarge form-control" path="byname" placeholder="Introduce your customer's name" disabled="true"/> 
				    </div>
				    <div id="searchcssCas" class="serachBorder">
				    	<input type="checkbox" name="checkage" aria-label="..." onClick="byagehigh.disabled = !this.checked ; byagelow.disabled = !this.checked">
				    	<label>Search by age (X between X):</label>    
				    	<p></p>         
						<form:input name="byagelow" type="number" class="form-size form-control" path="byagelow" placeholder="Introduce your customer's age" disabled="true"/>
				    	<form:input name="byagehigh" type="number" class="form-size form-control" path="byagehigh" placeholder="Introduce your customer's age" disabled="true"/>
				    </div>
				    <div id="searchcssCas" class="serachBorder">
				    	<input type="checkbox" name="checkdate" aria-label="..." onClick="bydatehigh.disabled = !this.checked ; bydatelow.disabled = !this.checked">
				    	<label>Search by insert date:</label>    
				    	<p></p>       
						<form:input name="bydatelow" type="text" class="form-size form-control" path="bydatelow" placeholder="dd/mm/yyyy" disabled = "true"/>
				    	<form:input name="bydatehigh" type="text" class="form-size form-control" path="bydatehigh" placeholder="dd/mm/yyyy" disabled = "true"/>
				    </div>
				    
				    <div id="searchButton" class="serachBorder">
		    			<input type="submit" value="Search" id="searchbut"/>
					</div>
					
			    </div>
			   
			</div>
		</form:form>
			<!-- Table -->
		
			<table class="table table-bordered table-hover table-condensed" id="tabla">
				<tr>
					<th><fmt:message key="Name"/></th>
				 	<th><fmt:message key="Email"/></th>
				 	<th><fmt:message key="Age"/></th>
				 	<th><fmt:message key="Gender"/></th>
				 	<th><fmt:message key="Birthday"/></th>
				 	<th><fmt:message key="Phone"/></th>
				 	<th><fmt:message key="User"/></th>
				</tr>
				<c:forEach items="${listing}" var="listing">
					<tr>
						<td>${listing.name}</td>
					  	<td>${listing.email}</td>
					  	<td>${listing.age}</td>
					  	<td>${listing.gender}</td>
					  	<td><fmt:formatDate value="${listing.birthday}" type="date" /></td>
					 	<td>${listing.phone}</td>
					  	<td>${listing.user}</td>
					</tr>
				</c:forEach>
			</table>
		
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
			
		<p class="home"><a href="/spring"><input type="submit" value="<--Home" /></a></p>
			
			
			
	
		
	<!-- <div id="peu">
		<p>Ariadne Sales</p>
	</div>-->

</body>
</html>