# Specialer

Author: LT 'syreal' Jones, et al.
Location: https://play.picoctf.org/events/72/challenges/challenge/378
Tags: General Skills, bash, ssh

## Problem

> Reception of Special has been cool to say the least. That's why we made an exclusive version of Special, called Secure Comprehensive Interface for Affecting Linux Empirically Rad, or just 'Specialer'. With Specialer, we really tried to remove the distractions from using a shell. Yes, we took out spell checker because of everybody's complaining. But we think you will be excited about our new, reduced feature set for keeping you focused on what needs it the most. Please start an instance to test your very own copy of Specialer.

## Solution

I launched the instance associated with this challenge (Figure 1) and was given the hint "[w]hat programs do you have access to?" I ``ssh``'d into the instance and noticed that some programmes are not present:

```
┌──(dna㉿deniers)-[/Specialer]
└─$ ssh -p 60582 ctf-player@saturn.picoctf.net
The authenticity of host '[saturn.picoctf.net]:60582 ([13.59.203.175]:60582)' can't be established.
ED25519 key fingerprint is SHA256:lMXKIC17ONzyUJx7ZYBY5VSwoxCz20uq5/Nm+IhXKew.
This key is not known by any other names
Are you sure you want to continue connecting (yes/no/[fingerprint])? yes
Warning: Permanently added '[saturn.picoctf.net]:60582' (ED25519) to the list of known hosts.
ctf-player@saturn.picoctf.net's password: 
Specialer$ ls
-bash: ls: command not found
Specialer$ cd
Specialer$ cd /bin
Specialer$ /bin/bash
Specialer$ /usr/bin/python3
bash: /usr/bin/python3: No such file or directory
Specialer$ 

[... snip ...]


Specialer$ pwd
/bin
Specialer$ cd ~
Specialer$ pwd
/home/ctf-player
Specialer$ 
```



## References


