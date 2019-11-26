<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
	<!DOCTYPE html>
<html lang="en">
		<head>
				<title>Your POS!</title>
				<meta charset="UTF-8">
				<meta name="viewport" content="width=device-width, initial-scale=1">
				<link rel="stylesheet" type="text/css" href="../CSS/homepage.css">
				<style>
						@import url('https://fonts.googleapis.com/css?family=Amatic+SC|Josefin+Slab&display=swap');
				</style>

		</head>
		<body>
				<div id="header">
						<h1>Restaurant Name</h1>
				</div>
				<nav>
					<ul>
							<li><a href=#>Menu</a></li>
							<li><a href="#">Address</a></li>
							<li><a href="#">Contact</a></li>
							<li><a href="#">Log In</a></li>
							<li style="margin-left: auto;"><a href="#">Cart</a></li>
					</ul>
				</nav>
				<div id="menu">
						<h3>Sort Items</h3>
						<table> <%-- replace by loop to fetch all inventory items --%>
								<tr>
										<th>Item</th>
										<th>Price (CAD)</th>
										<th>Qtity</th>
								</tr>
								</tr>
										<td>Lorem Ipsum</td>
										<td>$$.$$</td>
										<td> <form>
														<button>+</button>
														<button>-</button>
												</form>
								</tr>
								<tr>
										<td>Lorem Ipsum2</td>
										<td>$$.$$</td>
								</tr>
						</table>
				</div>
		</body>
</html>


