<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>
<head>
	<title> Add New Book</title>
	
	<link type="text/css"
	rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css">
	
	<link type="text/css"
	rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/add-book-style.css">
</head>
<body>
    <div id="wrapper">
		<div id="header">
		 <h2> Book Store</h2>
		</div>
	</div>
	
	<div id="container">
	  <h3>Save Book</h3>
	  <form:form action="saveBook" modelAttribute="addbookstore" method="POST">
	  <form:hidden path="bid"/>
	  	<table>
	  		<tbody>
	  		<tr>
	  			<td><label>Book name: </label></td>
	  		    <td><form:input path="bookname"/></td>
	  		</tr>
	  		<tr>
	  			<td><label>Author name: </label></td>
	  		    <td><form:input path="author"/></td>
	  		</tr>
	  		<tr>
	  			<td><label>Number of Book: </label></td>
	  		    <td><form:input path="no_of_book"/></td>
	  		</tr>
	  		<tr>
	  			<td><label>Price of book: </label></td>
	  		    <td><form:input path="price_book"/></td>
	  		</tr>
	  		<tr>
	  			<td><label>Description of book: </label></td>
	  		    <td><form:input path="desc_of_book"/></td>
	  		</tr>
	  		<tr>
	  			<td><label></label></td>
	  		    <td><input type="submit" value="save" class="save"/></td>
	  		</tr>
	  		</tbody>
	  	</table>
	  
	  </form:form>
	  
	  <div style="clear; both;"></div>
	  <p>
	  <a href="${pageContext.request.contextPath}/book/listbook">Back to main page</a>
	  </p>
	</div>
</body>
</html>
	  
	  