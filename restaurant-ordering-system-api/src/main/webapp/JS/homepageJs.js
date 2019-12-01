var xhr = new XMLHttpRequest();
					 xhr.open('GET', "http://localhost:8080/inventory", true);
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
								console.log(prices);
								console.log(descriptions);
								console.log(names);
								data=response;
								
								for (var i=0; i<data.length; i++){

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
					                btn.onclick= function(){
										if(localStorage.getItem(id) === null){
											localStorage.setItem(id,"item with id: "+id);
										}
				   					};
				   					pTagButton.appendChild(btn);
					                
					            
					               document.getElementById("cards").appendChild(header);
					               document.getElementById("cards").appendChild(price);
					               document.getElementById("cards").appendChild(pTag);
					               document.getElementById("cards").appendChild(pTagButton);
					              }
						 	}
						 }