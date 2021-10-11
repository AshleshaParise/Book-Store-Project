<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>
<head>
<title>
Book List
</title>

<link type="text/css"
	rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css"/>


</head>
<body>
	<div id="wrapper">
		<div id="header">
		 <h2> Book Store</h2>
		</div>
	</div>
	
	<div id="container">
		<div id="content">
		<!--put new button adding book  -->
		<input type="button" value="Add Book"
			onclick="window.location.href='showFormForAdd'; return false;"
			 class="add-button"/>
			 
		<table>
			<tr>
			<th>Book Name</th>
			<th>Author of Book</th>
			<th>Number of Book</th>
			<th>Price</th>
			<th>Description</th>	
			<th>Operation</th>	
			</tr>
			
			<c:forEach var="tempBook" items="${bookstores}">
			
			
			<c:url var="updatelink" value="/book/showFormForUpdate">
				<c:param name="bookid" value="${tempBook.bid}" />
			</c:url>
			
			<c:url var="deletelink" value="/book/delete">
				<c:param name="bookid" value="${tempBook.bid}" />
			</c:url>
			
			<tr>
			<td>${tempBook.bookname}</td>
			<td>${tempBook.author}</td>
			<td>${tempBook.no_of_book}</td>
			<td>${tempBook.price_book}</td>		
			<td>${tempBook.desc_of_book}</td>	
			<td>
			<a href="${updatelink}">Update</a>	
			|
			<a href="${deletelink}"
			onClick="if (!(confirm('Do you want to delete this book details?'))) return false">Delete</a>	
			</td>
			</tr>
			</c:forEach>
		</table>
		
		</div>
	</div>
	