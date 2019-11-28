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
				<div>
						<table id="menu"> <%-- replace by loop to fetch all inventory items --%>
								<tr>
										<th>Item</th>
										<th>Price (CAD)</th>
								</tr>
		<script>
					 var xhr = new XMLHttpRequest();
					 xhr.open('GET', "http://localhost:8080/inventory", true);
					 xhr.send();
					 xhr.onreadystatechange = processRequest;
					 xhr.addEventListener("readystatechange", processRequest, false);
					 
					 function processRequest (e){
					 	if (xhr.readyState == 4){
					 		var response = JSON.parse(xhr.responseText);
					 		console.log(response[0].name)
							drawMenu(response);
					 	}
					 }
					 function drawMenu(e){
					 	var menu = document.getElementById('menu');
							 for (var i = 0; i<e.length; i++){
									if (e[i].available){
											itemName = e[i].name;
											var cellName= document.createElement("td");
											var cellNameText= document.createTextNode(itemName)
					 						cellName.appendChild(cellNameText);
											itemPrice = e[i].price;
											var cellPrice= document.createElement("td");
					 						var cellPriceText= document.createTextNode(itemPrice);
					 						cellPrice.appendChild(cellPriceText);
					 						var row= document.createElement("tr");
					 						row.appendChild(cellName);
					 						row.appendChild(cellPrice);
							   				menu.appendChild(row);
									}
					 		 }
					 }
		</script>
						</table>
				</div>
		</body>
</html>


