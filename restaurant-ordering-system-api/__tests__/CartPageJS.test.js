
require('../src/main/webapp/JS/CartPageJs.js')


var expect = require('expect');
let carts = require('../src/main/webapp/JS/CartPageJs.js');
localStorage.name1="falafel";
localStorage.price1 = "8";

const sum = (a, b) => a + b
const mul = (a, b) => a * b
const div = (a, b) => a / b

describe('My first test suite', () => {
	it('stores quantity', () => {
		expect(carts.storeIntialQTY(-10)).toBe(0)
	})
	it('increases value', () => {
		expect(carts.increaseValue("row1",8, "total1")).toBe(document.getElementById("totalPrice"))
	})
	
	it('decreases value', () => {
		expect(carts.increaseValue("row1",8, "total1")).toBe(document.getElementById("totalPrice"))
	})
	
	
	
})



