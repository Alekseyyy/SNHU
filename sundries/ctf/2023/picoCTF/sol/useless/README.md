# useless

* Author: Loic Shema
* Location: https://play.picoctf.org/events/72/challenges/challenge/384
* Tags: General Skills, man

## Problem

> There's an interesting script in the user's home directory. Additional details will be available after launching your challenge instance.

## Solution

I began by launching the instance (Figure 1) and got the following credentials

```
Hostname: saturn.picoctf.net
Port:     49818
Username: picoplayer
Password: [redacted]
```

I logged into the system with the webshell:

```
lambdacalculus-picoctf@webshell:~$ ssh -p 49818 picoplayer@saturn.picoctf.net
The authenticity of host '[saturn.picoctf.net]:49818 ([13.59.203.175]:49818)' can't be established.
ED25519 key fingerprint is SHA256:ves7M6DhshpiJSsScBWo3n34oOFTUXvLZqPyqLWeTHk.
This key is not known by any other names
Are you sure you want to continue connecting (yes/no/[fingerprint])? yes
Warning: Permanently added '[saturn.picoctf.net]:49818' (ED25519) to the list of known hosts.
picoplayer@saturn.picoctf.net's password: 
Welcome to Ubuntu 20.04.6 LTS (GNU/Linux 5.15.0-1031-aws x86_64)

 * Documentation:  https://help.ubuntu.com
 * Management:     https://landscape.canonical.com
 * Support:        https://ubuntu.com/advantage

The programs included with the Ubuntu system are free software;
the exact distribution terms for each program are described in the
individual files in /usr/share/doc/*/copyright.

Ubuntu comes with ABSOLUTELY NO WARRANTY, to the extent permitted by
applicable law.

picoplayer@challenge:~$
```

The challenge mentioned a "script in the user's home directory", so I decided to list the contents of it:

```
picoplayer@challenge:~$ ls -la
total 16
drwxr-xr-x 1 picoplayer picoplayer   20 Mar 16 20:59 .
drwxr-xr-x 1 root       root         24 Mar 16 02:30 ..
-rw-r--r-- 1 picoplayer picoplayer  220 Feb 25  2020 .bash_logout
-rw-r--r-- 1 picoplayer picoplayer 3771 Feb 25  2020 .bashrc
drwx------ 2 picoplayer picoplayer   34 Mar 16 20:59 .cache
-rw-r--r-- 1 picoplayer picoplayer  807 Feb 25  2020 .profile
-rwxr-xr-x 1 root       root        517 Mar 16 01:30 useless
picoplayer@challenge:~$ 
```

I suspect that ``useless`` is a script. I decided to ``cat`` out its contents:

```
picoplayer@challenge:~$ cat useless
#!/bin/bash
# Basic mathematical operations via command-line arguments

if [ $# != 3 ]
then
  echo "Read the code first"
else
        if [[ "$1" == "add" ]]
        then 
          sum=$(( $2 + $3 ))
          echo "The Sum is: $sum"  

        elif [[ "$1" == "sub" ]]
        then 
          sub=$(( $2 - $3 ))
          echo "The Substract is: $sub" 

        elif [[ "$1" == "div" ]]
        then 
          div=$(( $2 / $3 ))
          echo "The quotient is: $div" 

        elif [[ "$1" == "mul" ]]
        then
          mul=$(( $2 * $3 ))
          echo "The product is: $mul" 

        else
          echo "Read the manual"
         
        fi
fi
picoplayer@challenge:~$ 
```

I am not a bash programmer, but it seems like this is a basic calculator that take in three inputs: the first being the arithmetical operation to perform, and the second and third being the binary inputs for the operation.

I started out by playing with it a little:

```
picoplayer@challenge:~$ ./useless add 2 2 
The Sum is: 4
picoplayer@challenge:~$ ./useless sub 2 2 
The Substract is: 0
picoplayer@challenge:~$ ./useless div 2 2
The quotient is: 1
picoplayer@challenge:~$ ./useless mul 2 2
The product is: 4
picoplayer@challenge:~$ 
```

Given that the tag and clues in the source code is demanding that I use the ``man`` command, I tried ``man useless``:

```
picoplayer@challenge:~$ man useless

useless
     useless, -- This is a simple calculator script

SYNOPSIS
     useless, [add sub mul div] number1 number2

DESCRIPTION
     Use the useless, macro to make simple calulations like addition,subtrac-
     tion, multiplication and division.

Examples
     ./useless add 1 2
       This will add 1 and 2 and return 3

     ./useless mul 2 3
       This will return 6 as a product of 2 and 3

     ./useless div 6 3
       This will return 2 as a quotient of 6 and 3

     ./useless sub 6 5
       This will return 1 as a remainder of substraction of 5 from 6

Authors
     This script was designed and developed by Cylab Africa

     picoCTF{us3l3ss_ch4ll3ng3_3xpl0it3d_1888}

picoplayer@challenge:~$ 
```

This is how I got the flag.

