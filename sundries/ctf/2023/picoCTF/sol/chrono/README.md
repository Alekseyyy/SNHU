# chrono

Author: Mubarak Mikail
Location: https://play.picoctf.org/events/72/challenges/challenge/347
Tags: General Skills, linux

## Problem

> How to automate tasks to run at intervals on linux servers? Additional details will be available after launching your challenge instance.

## Solution

I proceeded to start an instance (Figures 1, 2) and gives credentials to log into it. I logged in like so:

```
lambdacalculus-picoctf@webshell:~$ ssh picoplayer@saturn.picoctf.net -p 52512
The authenticity of host '[saturn.picoctf.net]:52512' can't be established.
ED25519 key fingerprint is SHA256:p/PvzCEZdcZTX+VPBLVApO7dmZmo7L7qwjpiIdTTHao.
This key is not known by any other names
Are you sure you want to continue connecting (yes/no/[fingerprint])? yes
Warning: Permanently added '[saturn.picoctf.net]:52512' (ED25519) to the list of known hosts.
picoplayer@saturn.picoctf.net's password: *password*

Welcome to Ubuntu 20.04.5 LTS (GNU/Linux 5.15.0-1031-aws x86_64)

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

picoplayer@challenge:~$ 

```

Based on the name, I looked up Linux Cronjobs and got some articles discussing them [1][2][3]. I first tried:

```
picoplayer@challenge:~$ crontab -l
no crontab for picoplayer
picoplayer@challenge:~$ 
```

I then tried:

```
picoplayer@challenge:~$ cat /etc/crontab
# picoCTF{Sch3DUL7NG_T45K3_L1NUX_5b7059d0}
picoplayer@challenge:~$ 
```

And found the flag!

## References

1. https://www.geeksforgeeks.org/crontab-in-linux-with-examples/
2. https://www.guru99.com/crontab-in-linux-with-examples.html
3. https://webdock.io/en/docs/how-guides/system-maintenance/how-configure-crontab-linux
