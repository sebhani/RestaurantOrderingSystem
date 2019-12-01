
require('../src/main/webapp/JS/CartPageJs.js')


var expect = require('expect');
let carts = require('../src/main/webapp/JS/CartPageJs.js');
/*
let test = function(){
	return [];
}
*/
describe('My first test suite', () => {
	it('stores quantity', () => {
		expect(carts.storeIntialQTY(-10)).toBe(0)
	})
	it('increases value', () => {
		expect(carts.increaseValue("row1",8, "total1")).toBeTruthy()
	})
	
})



