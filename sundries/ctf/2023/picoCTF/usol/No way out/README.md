# No way out

Author: Kris
Location: https://play.picoctf.org/events/72/challenges/challenge/361
Tags: Reverse Engineering

## Problem

> Put this flag in standard picoCTF format before submitting. If the flag was h1_1m_7h3_f14g submit picoCTF{h1_1m_7h3_f14g} to the platform. [Windows game](https://artifacts.picoctf.net/c/285/win.zip), [Mac game](https://artifacts.picoctf.net/c/285/mac.app.zip).

## Solution

I have downloaded both the windows and mac version of the game (even though I don't have an macintosh computer equipped to analyse binaries, but it may show itself to be useful). I then proceeded to extract ``win.zip`` to a folder called ``game``. I listed the contents of ``game``, and came up with the following:

```
dna@deniers:~/No way out/game/win$ ls -l
total 30128
drwxrwxrwx 4 dna dna     4096 Jan 31 19:47 MonoBleedingEdge
drwxrwxrwx 5 dna dna     4096 Jan 31 19:47 pico_Data
-rw-rw-rw- 1 dna dna   654336 Jan 31 19:47 pico.exe
-rw-rw-rw- 1 dna dna  1123864 Jan 31 19:47 UnityCrashHandler64.exe
-rw-rw-rw- 1 dna dna 29060632 Jan 31 19:47 UnityPlayer.dll
dna@deniers:~/No way out/game/win$ 
```

There are some interesting things about this project: the first is that I can probably launch it through ``pico.exe`` and the second is that it is written in Unity --- making it much easier (in my opinion) to reverse engineer. I launched the game (Figure 1), and after a short while playing it, I figured that I should just try to reverse engineer it. 

I tried to open ``pico.exe`` with ``dnSpy`` (Figure 2) and it seems like that this is not a .NET executable, but a native executable. I decided to decompile the game with Ghidra; starting by making a new project and import the ``pico.exe`` executable into Ghidra (Figure 3) and it had errors.

## References
