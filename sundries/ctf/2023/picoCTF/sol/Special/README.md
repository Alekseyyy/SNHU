# Special

* Author: LT 'syreal' Jones
* Link: https://play.picoctf.org/events/72/challenges/challenge/377
* Tags: General Skills, bash, ssh

## Problem

> Don't power users get tired of making spelling mistakes in the shell? Not anymore! Enter Special, the Spell Checked Interface for Affecting Linux. Now, every word is properly spelled and capitalized... automatically and behind-the-scenes! Be the first to test Special in beta, and feel free to tell us all about how Special streamlines every development process that you face. When your co-workers see your amazing shell interface, just tell them: That's Special (TM) Start your instance to see connection details. Additional details will be available after launching your challenge instance.

This challenge also came with the hint "Experiment with different shell syntax."

## Solution

I started the instance associated with the challenge and got a means to connect to a virtual machine associated with said challenge.

Some console output:

```
lambdacalculus-picoctf@webshell:~$ ssh -p 54332 ctf-player@saturn.picoctf.net
The authenticity of host '[saturn.picoctf.net]' can't be established.
ED25519 key fingerprint is SHA256:tJ0wuU5yBvNO/FrkHmR9iY36VJClMhKV+Hq2sxqKFmg.
This key is not known by any other names
Are you sure you want to continue connecting (yes/no/[fingerprint])? yes
Warning: Permanently added '[saturn.picoctf.net]:54332' (ED25519) to the list of known hosts.
ctf-player@saturn.picoctf.net's password: 
Welcome to Ubuntu 20.04.3 LTS (GNU/Linux 5.15.0-1031-aws x86_64)

 * Documentation:  https://help.ubuntu.com
 * Management:     https://landscape.canonical.com
 * Support:        https://ubuntu.com/advantage

This system has been minimized by removing packages and content that are
not required on a system that users do not log into.

To restore this content, you can run the 'unminimize' command.

The programs included with the Ubuntu system are free software;
the exact distribution terms for each program are described in the
individual files in /usr/share/doc/*/copyright.

Ubuntu comes with ABSOLUTELY NO WARRANTY, to the extent permitted by
applicable law.

Special$ ls -la
Is la 
sh: 1: Is: not found
Special$ ls
Is 
sh: 1: Is: not found
Special$ /bin/bash
Why go back to an inferior shell?
Special$ /bin/bash -p
Why go back to an inferior shell?
Special$ python -c 'import pty; pty.spawn("/bin/bash")'
Why go back to an inferior shell?
Special$ python3
Python 
sh: 1: Python: not found
Special$ python
Python 
sh: 1: Python: not found
Special$ Python
Python 
sh: 1: Python: not found
Special$ /usr/bin/python
Absolutely not paths like that, please!
Special$ cat
Cat 
sh: 1: Cat: not found
Special$ 
```

This will require some "thinking outside the box," and I noticed the following hint after starting the instance: "Experiment with different shell syntax." I eventually devised a method for tricking the bad shell into giving me a Python shell:

```
Special$ id\&&python3
Id\&&python3 
sh: 1: Id&: not found
Python 3.8.10 (default, Nov 14 2022, 12:59:47) 
[GCC 9.4.0] on linux
Type "help", "copyright", "credits" or "license" for more information.
>>> import os
>>> os.system("pwd")
/home/ctf-player
0
>>> os.system("ls -l")
total 0
drwxr-xr-x 2 ctf-player ctf-player 22 Mar 16 02:10 blargh
0
>>> os.system("ls -l blargh")
total 4
-rw-r--r-- 1 root root 41 Mar 16 02:10 flag.txt
0
>>> os.system("cat blargh/flag.txt")
picoCTF{5p311ch3ck_15_7h3_w0r57_f906e25a}0
>>> Connection to saturn.picoctf.net closed by remote host.
Connection to saturn.picoctf.net closed.
```

## References

1. https://www.gnu.org/software/bash/manual/html_node/Shell-Syntax.html
