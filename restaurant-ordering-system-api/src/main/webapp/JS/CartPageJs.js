var ROOT = "http://localhost:8080";
var idsInStorage = [];
var itemObjects = [];
var xhr = new XMLHttpRequest();
var TOTALPRICE = 0;
var QTYInitial = 0;
for(var key in window.localStorage){
	if(parseInt(key) != NaN && parseInt(key) > 0 && /^\d+$/.test(key)){
		idsInStorage.push(parseInt(key));
	}
}

	 xhr.open('GET', `${ROOT}/cart/`, true);
	 xhr.send();
	 xhr.onload = processRequest;

function processRequest (e){
	if (xhr.readyState == 4){
		itemObjects = JSON.parse(xhr.responseText);
		getTotalPrice(itemObjects);
}}

function getTotalPrice(e){
	document.getElementById("numCart").innerHTML = itemObjects.length;
	for (var j=0; j<itemObjects.length; j++){
		UpdateTable(new Array(itemObjects[j].name,itemObjects[j].price));
		TOTALPRICE+=itemObjects[j].price;
		document.getElementById("totalPrice").innerHTML = TOTALPRICE +"$";
	}
}

function storeIntialQTY(initialQTY){//helper method used to store the initial number of QTY
	if(initialQTY != (-10))
		QTYInitial = initialQTY;
	return QTYInitial;
}


//handle updating quantity
function increaseValue(elementID, price, totalID) {
  var value = parseInt(document.getElementById(elementID).value, 10);
  value = isNaN(value) ? 0 : value;
  storeIntialQTY(value);
  value++;
  document.getElementById(elementID).value = value;
  var total = priceCompute(elementID, price, "increaseValue");
  document.getElementById("totalPrice").innerHTML = parseFloat(TOTALPRICE).toFixed(2) +"$";
  document.getElementById(totalID).innerHTML = parseFloat(total).toFixed(2)+"$";
}

function decreaseValue(elementID, price, totalID) {
  var value = parseInt(document.getElementById(elementID).value, 10);
  value = isNaN(value) ? 0 : value;
  storeIntialQTY(value);
  if(value != 0)
 	 value--;
  document.getElementById(elementID).value = value;
  var total = priceCompute(elementID, price, "decreaseValue");
  document.getElementById(totalID).innerHTML = total.toFixed(2) +"$";//Total price for a specific item the cart table
  document.getElementById("totalPrice").innerHTML = parseInt(TOTALPRICE) +"$";//Total price for all items in cart
  document.getElementById(totalID).innerHTML = parseInt(total)+"$";//Total price for a specific item the cart table
}

function priceCompute(elementID, price, method){
	var val = document.getElementById(elementID).value;
	if(method === "increaseValue" )
		TOTALPRICE+=price;
	else if((storeIntialQTY(-10)-val)!=0)//prevent negative total price
		TOTALPRICE-=price;
	return parseInt(val)*parseFloat(price).toFixed(2);
}

//update the cart table dynamically
function UpdateTable(rowInfo){
	var table = document.getElementById("cartTable");
	var lastRowIndex = table.rows.length -1;
	//console.log(lastRowIndex);
	var row = table.insertRow(lastRowIndex+1);

	var cell1 = row.insertCell(0);
	var cell2 = row.insertCell(1);
	var cell3 = row.insertCell(2);
	var cell4 = row.insertCell(3);

	cell1.innerHTML = rowInfo[0];
	cell2.innerHTML = rowInfo[1] +"$";
	cell3.innerHTML = "<form class='center' >"+
`<div class='value-button' id='decrease' onclick='decreaseValue("row${lastRowIndex+1}", ${rowInfo[1]}, "total${lastRowIndex+1}")' value='Decrease Value'>-</div>`+
`<input class="number" id='row${lastRowIndex+1}' value='1' />`+
`<div class='value-button' id='increase' onclick='increaseValue("row${lastRowIndex+1}", ${rowInfo[1]}, "total${lastRowIndex+1}")' value='Increase Value'>+</div>`+
"</form>"
	cell4.innerHTML = `<p class="number" id='total${lastRowIndex+1}'>${rowInfo[1]}$</p>`

}
