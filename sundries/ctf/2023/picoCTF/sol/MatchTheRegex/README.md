# MatchTheRegex

Author: Sunday Jacob Nwanyim
Location: https://play.picoctf.org/events/72/challenges/challenge/356
Tags: Web Exploitation

## Problem

> How about trying to match a regular expression? Additional details will be available after launching your challenge instance.

The problem also came with a hint that recommended to "[a]ccess the webpage and try to match the regular expression associated with the text field."

## Solution

I started by launching an instance of this challenge (Figure 1) and a website was started up. I then proceeded to visit the website with a browser and Burp Suite Pro's proxy intercepting its requests (Figure 2). I decided to type in "dna deniers" in the text form and click on submit (Figure 3) and I got a message that said "wrong match! Try again!" (Figure 4). 

I decided to look at the page's HTML source and found an interesting javascript snippet:

```javascript
<script>
	function send_request() {
		let val = document.getElementById("name").value;
		// ^p.....F!?
		fetch(`/flag?input=${val}`)
			.then(res => res.text())
			.then(res => {
				const res_json = JSON.parse(res);
				alert(res_json.flag)
				return false;
			})
		return false;
	}

</script>
```

The regular expression appears to be: ``^p.....F!?``. I don't know much about regular expressions to be honest, but I tried the input ``picoCTF`` and got the flag. The flag is ``picoCTF{succ3ssfully_matchtheregex_c64c9546}``.

## References
