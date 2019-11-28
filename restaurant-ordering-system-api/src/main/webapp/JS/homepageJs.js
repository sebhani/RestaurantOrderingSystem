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
					                console.log(data[i].name);
					                g = document.createElement('div');
					                g.setAttribute("class", "card");
					                document.getElementById("cards").appendChild(g);
					                var img = document.createElement('img');
					                img.setAttribute("src", "");
					                img.setAttribute("alt", data[i].name +" Image");
					                var h = document.createElement("H1");
					                var t = document.createTextNode(data[i].name); 
					                h.appendChild(t);
					                
					                var price = document.createElement("P");
					                price.setAttribute("class", "price");
					                var amount = document.createTextNode(data[i].price + "$");
					                price.appendChild(amount);
					                
					                var p = document.createElement("P");
					                var d = document.createTextNode(data[i].description);
					                p.appendChild(d);
					                
					                var bb = document.createElement("P")
					                var btn = document.createElement("BUTTON");
					                btn.innerHTML = "Add to Cart";
					                let id = data[i].id;
					                btn.onclick= function(){
										if(localStorage.getItem(id) === null){
											localStorage.setItem(id,"item with id: "+id);
										}
				   					};
					                bb.appendChild(btn);
					                
					            
					                document.getElementById("cards").appendChild(img);
					               document.getElementById("cards").appendChild(h);
					               document.getElementById("cards").appendChild(price);
					               document.getElementById("cards").appendChild(p);
					               document.getElementById("cards").appendChild(bb);
					              }
						 	}
						 }