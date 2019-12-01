var ROOT = "http://localhost:8080";
var xhr = new XMLHttpRequest();
					 xhr.open('GET', ROOT+"/inventory", true);
					 xhr.send();
					 xhr.onload = processRequest;
					 var names = [];
					 var prices = [];
					 var descriptions = [];
					
					 
					 function populateArray(e){
						 for (var i = 0; i<e.length; i++){
								if (e[i].available){
									itemName = e[i].name;
									names.push(itemName);
									itemPrice = e[i].price;
									prices.push(itemPrice);
									itemDescription = e[i].description;
									descriptions.push(itemDescription);
								}
								}
					 }
					 
					 
					 function processRequest (e){
						 	if (xhr.readyState == 4){
						 		var response = JSON.parse(xhr.responseText);
								populateArray(response);
								data=response;
								
								for (var i=0; i<data.length; i++){

									//CREATING HTML ELEMENTS DYNAMICALLY
					                baseDiv = document.createElement('div');
					                baseDiv.setAttribute("class", "card");
					                document.getElementById("cards").appendChild(baseDiv);
					          
					                
					                var header = document.createElement("H1");
					                var title = document.createTextNode(data[i].name); 
					                header.appendChild(title);
					                
					                var price = document.createElement("P");
					                price.setAttribute("class", "price");
					                var amount = document.createTextNode(data[i].price + "$");
					                price.appendChild(amount);
					                
					                var pTag = document.createElement("P");
					                var descriptionText = document.createTextNode(data[i].description);
					                pTag.appendChild(descriptionText);
					                
					                var pTagButton = document.createElement("P")
					                var btn = document.createElement("BUTTON");
					                btn.innerHTML = "Add to Cart";
					                let id = data[i].id;
					                let item = data[i];
					                btn.onclick= function (){
											//POST
											var reqCart = new XMLHttpRequest();
												reqCart.open('POST', ROOT+"/cart", true);
												reqCart.setRequestHeader("Content-Type", "application/json");
												reqCart.send(JSON.stringify({
												    id: item.id,
												    name: item.name,
												    description: item.description,
												    price: item.price,
												    available: item.available
												}));	
					                }
				   					pTagButton.appendChild(btn);
					                
					            
					               document.getElementById("cards").appendChild(header);
					               document.getElementById("cards").appendChild(price);
					               document.getElementById("cards").appendChild(pTag);
					               document.getElementById("cards").appendChild(pTagButton);
					              }
						 	}
						 }

					 