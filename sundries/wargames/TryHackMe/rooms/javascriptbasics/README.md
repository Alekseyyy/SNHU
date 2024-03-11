
<a href="https://tryhackme.com/room/javascriptbasics" target="_blank"><img src="./banner.png" width="700px" /></a>

## Background

This is a room that, like its title suggests, introduces JavaScript to the user. Topics covered includes:

* Programming constructs such as: 
    * _Conditional logic_ 
    * _Functions_ 
    * _Objects and arrays_
    * _Loops_
* The [Document Object Model (DOM)](https://developer.mozilla.org/en-US/docs/Web/API/Document_Object_Model)
* [Cross-site scripting (XSS)](https://owasp.org/www-community/attacks/xss/)

### Materials

* [js-sort.htm](./materials/js-sort.htm): implementation of an inefficient sorting algorithm.
* __CodePen Submission:__ https://codepen.io/EpsilonCalculus/full/ZEXMxYr

## Discussion of the ``bad_sort``

The last task of the room challenges its users to write an JavaScript program to sort an array of numbers from least to greatest. I wrote a function called ``bad_sort`` that attempts to solve this problem:

```javascript
const bad_sort = (x) => {
	y = [];
	do {
		winner = x[0];
		for (let k = 0; k < x.length; k++) {
			if (x[k] < winner) {
				winner = x[k];
			}
		}
		y.push(winner);
		x.splice(x.indexOf(winner), 1);
		
	} while (x.length > 0);
	return y;
};

input = [1,10,5,15,2,7,28,900,45,18,27]; // the solution is: [1,2,5,7,10,15,18,27,28,45,900]
document.write("<p>Given an array of [" + input + "] ... <br><br> ... it is sorted from smallest to biggest as [" + bad_sort(input) + "].</p>");
```

