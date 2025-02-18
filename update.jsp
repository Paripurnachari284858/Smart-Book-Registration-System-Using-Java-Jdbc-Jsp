<%@page import="com.bookshopproject.Entity.BookData"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book Registration</title>
<link rel="stylesheet" href="css/bootstrap.css">
<link
	href="https://fonts.googleapis.com/css2?family=Quicksand:wght@400;600&family=Lobster&display=swap"
	rel="stylesheet">
<style>
body {
	background: linear-gradient(to right, #ffafbd, #ffc3a0);
	/* Soft pink gradient background */
	font-family: 'Quicksand', sans-serif; /* Stylish modern font */
}

.container {
	margin-top: 50px;
	max-width: 42rem;
}

.card {
	background: #ffffff;
	border-radius: 20px;
	box-shadow: 0 10px 25px rgba(0, 0, 0, 0.15);
	padding: 20px;
}

.form-header {
	background: #ff6f61; /* Vibrant coral color */
	color: #fff;
	padding: 15px;
	text-align: center;
	font-family: 'Lobster', cursive; /* Decorative font */
	font-size: 2rem;
	border-radius: 20px 20px 0 0;
	letter-spacing: 1px;
}

.form-control {
	border: 2px solid #ff6f61;
	border-radius: 10px;
	padding: 10px;
}

.form-control:focus {
	border-color: #ffafbd;
	box-shadow: 0 0 8px rgba(255, 175, 189, 0.5);
}

.btn {
	padding: 10px 20px;
	border-radius: 10px;
	font-weight: bold;
}

.btn-primary {
	background: #ff6f61;
	border: none;
	color: white;
}

.btn-primary:hover {
	background: #ffafbd;
	color: #fff;
}

.btn-secondary {
	background: #6c757d;
	border: none;
	color: white;
}

.btn-secondary:hover {
	background: #adb5bd;
	color: white;
}

.table {
	border-collapse: separate;
	border-spacing: 0 10px; /* Add space between rows */
}

.table-hover tbody tr:hover {
	background: #fff0f3; /* Light coral hover */
	transform: scale(1.02); /* Slightly enlarge on hover */
	transition: all 0.2s ease-in-out;
}

.table td {
	font-family: 'Quicksand', sans-serif;
	font-size: 1rem;
	padding: 15px;
	vertical-align: middle;
}

.success-message {
	font-family: 'Quicksand', sans-serif;
	font-size: 1.1rem;
	color: #28a745;
	font-weight: 600;
}
</style>
</head>
<body>
	<div align="center">
		<div class="container">
			<div class="card">
				<div class="form-header">Update BookData</div>
				<% ArrayList<BookData> al=(ArrayList<BookData>)request.getAttribute("bookrecord"); %>
				<%if(!(al.equals(null))){ %>
				<%for(BookData bd:al){ %>
				<form action="updatedata" method="post" class="p-4">
				 <input type="hidden" name="bid" value="<%= bd.getBid()%>">
					<table class="table table-hover" align="center">
						<tr>
							<td>Book Name</td>
							<td><input type="text" name="bookname" class="form-control"
								value="<%= bd.getBname()%>"></td>
						</tr>
						<tr>
							<td>Book Edition</td>
							<td><input type="text" name="bookedition"
								class="form-control" value="<%= bd.getBedition()%>"></td>
						</tr>
						<tr>
							<td>Book Author</td>
							<td><input type="text" name="bookauthor"
								class="form-control"value="<%= bd.getBauthor()%>"></td>
						</tr>
						<tr>
							<td>Book Genre</td>
							<td><input type="text" name="bookgenre" class="form-control"
								value="<%= bd.getBgenre()%>"></td>
						</tr>
						<tr>
							<td>Book Price</td>
							<td><input type="number" name="bookprice"
								class="form-control" value="<%= bd.getBprice()%>"></td>
						</tr>
						<tr>
							<td colspan="2">
								<input type="submit" style="width: 400px; height: 50px;"
									class="btn btn-primary"value="Update Data">
							</td>
						</tr>

					</table>
				</form>
				<%} %>
				<%} %>
				
			</div>
		</div>
	</div>
</body>
</html>
