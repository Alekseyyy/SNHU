# findme

* Author: Geoffrey Njogu
* Location: https://play.picoctf.org/practice/challenge/349
* Tags: Web Exploitation

## Problem

> Help us test the form by submiting the username as ``test`` and password as ``test!``. Additional details will be available after launching your challenge instance.

The challenge also came with a hint that simply asked "any redirections?"

## Solution

This is another challenge that consists of an "instance," which I launched (Figure 1). After launching the instance, a link to some introductionary articles came up. I visited the link and my browser returned a login form (Figure 2). I type in ``test`` into both the username and password forms, and my browser returned a page that simply said "try username:test and password:test!" (Figure 3). 

I tried again with the username ``test`` and the password ``test!`` (with an exclamination point), and got some kind of search page (Figure 4). I searched for "picoCTF" in the search input form, clicked on "go," and was presented with the same page, but noticed a ``?`` appended to my browser's address bar:

Before searching: ``http://saturn.picoctf.net:65258/home``

After searching: ``http://saturn.picoctf.net:65258/home?``

From experience, I know that there is a class of vulnerabilities called "open redirect." I decided to research it more and found some articles discussing it [1][2][3]. I replayed the attack of searching for ``picoCTF`` but having by browser's "Inspector" open (Figure 5). Unfortunately, this method did not work either. 

I proceeded by using Burp Suite and its respective proxy (Figure 6) to inspect the open redirects. I visited the website this time with Burp's proxy intercepting the connection. I repeated the process of searching for ``picoCTF`` and then inspected the HTTP History (Figure 7). The ``Referer`` looks pretty interesting:

``http://saturn.picoctf.net:61000/next-page/id=bF90aGVfd2F5XzNkOWUzNjk3fQ==`` 

and its respective ID looks like it's base64 encoded. I attempted to decode it like so:

```
┌──(dna㉿deniers)-[~]
└─$ echo "bF90aGVfd2F5XzNkOWUzNjk3fQ==" | base64 --decode
l_the_way_3d9e3697}                                                                                                                                                                
┌──(dna㉿deniers)-[~]
└─$ 
```

I also noticed a couple of GET requests in (Figure 7) with ``/next-page`` in them. I decoded both of them, and ...

```
┌──(dna㉿deniers)-[~]
└─$ echo "cGljb0NURntwcm94aWVzX2Fs" | base64 --decode    
picoCTF{proxies_al                                                                                                                                                                
┌──(dna㉿deniers)-[~]
└─$ echo "bF90aGVfd2F5XzNkOWUzNjk3fQ==" | base64 --decode
l_the_way_3d9e3697}                                                                                                                                                                
┌──(dna㉿deniers)-[~]
└─$ 
```

I reconstructed the flag as: ``picoCTF{proxies_all_the_way_3d9e3697}``

## References

1. https://learn.snyk.io/lessons/open-redirect/javascript/
2. https://portswigger.net/kb/issues/00500100_open-redirection-reflected
3. https://cheatsheetseries.owasp.org/cheatsheets/Unvalidated_Redirects_and_Forwards_Cheat_Sheet.html
