<%@page import="java.util.ArrayList"%>
<%@page import="com.bookshopproject.Entity.BookData"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registered Books</title>
<link rel="stylesheet" href="css/bootstrap.css">
<link
	href="https://fonts.googleapis.com/css2?family=Quicksand:wght@400;600&family=Lobster&display=swap"
	rel="stylesheet">
<style>
body {
	background: linear-gradient(to right, #ffafbd, #ffc3a0);
	/* Soft pink gradient */
	font-family: 'Quicksand', sans-serif; /* Modern font */
	margin: 0;
	padding: 0;
}

.container {
	margin-top: 50px;
	max-width: 800px;
	margin-left: auto;
	margin-right: auto;
	padding: 20px;
}

.table {
	border-collapse: collapse;
	width: 100%;
	background: #ffffff;
	border-radius: 10px;
	overflow: hidden;
	box-shadow: 0 10px 25px rgba(0, 0, 0, 0.15);
}

.table thead {
	background: #ff6f61;
	color: white;
	text-align: center;
}

.table th, .table td {
	padding: 10px;
	text-align: center;
}

.table tbody tr {
	transition: background 0.3s, transform 0.2s;
}

.table tbody tr:hover {
	background: #fff0f3;
	transform: scale(1.02);
}

h1 {
	font-family: 'Lobster', cursive;
	font-size: 2.5rem;
	color: #ff6f61;
}

p {
	font-family: 'Quicksand', sans-serif;
	font-size: 1rem;
	margin-top: 10px;
}

.error-message {
	color: red;
	font-weight: bold;
}

input[type="submit"] {
	background-color: black; /* Black background */
	color: white; /* White text for contrast */
	border: none; /* Remove borders */
	border-radius: 5px; /* Rounded corners */
	width: 100%; /* Make the button width align with the table column */
	padding: 10px 0; /* Vertical padding for height */
	font-size: 1rem; /* Adjust font size */
	cursor: pointer; /* Pointer cursor for better UX */
	transition: all 0.3s ease; /* Smooth transition effect */
}

input[type="submit"]:hover {
	background-color: #333; /* Slightly lighter black on hover */
	box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2); /* Subtle shadow effect */
	transform: translateY(-2px); /* Slight upward movement on hover */
}
</style>
</head>
<body>
	<div align="center" class="container">
		<h1>Registered Books</h1>
		<% if (request.getAttribute("regdata") != null && request.getAttribute("regdata").equals("No Records is Found")) { %>
		<p class="error-message"><%= request.getAttribute("regdata") %></p>
		<% }%>
		<%  if (request.getAttribute("regdata") != null) { %>
		<table class="table">
			<thead>
				<tr>
					<th>BId</th>
					<th>BName</th>
					<th>BEdition</th>
					<th>BAuthor</th>
					<th>BGenre</th>
					<th>BPrice</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<% 
                ArrayList<BookData> al = (ArrayList<BookData>) request.getAttribute("regdata");
                for(BookData bd : al) { 
                %>
				<tr>
					<td><%= bd.getBid() %></td>
					<td><%= bd.getBname() %></td>
					<td><%= bd.getBedition() %></td>
					<td><%= bd.getBauthor() %></td>
					<td><%= bd.getBgenre() %></td>
					<td><%= bd.getBprice() %></td>
					<td><a href="fetchdata?bid=<%= bd.getBid()%>">Edit </a> / <a
						href="deletedata?bid=<%= bd.getBid() %>">Delete</a></td>
				</tr>
				<% } %>
				<tr>
					<td colspan="7">
						<form action="Home.jsp">
							<input type="submit" value="Home">
						</form>
					</td>
				</tr>

			</tbody>
		</table>
		<% } %>


	</div>
</body>
</html>















