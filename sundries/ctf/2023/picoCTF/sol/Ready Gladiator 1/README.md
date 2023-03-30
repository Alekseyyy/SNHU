# Ready Gladiator 1

* Author: LT 'syreal' Jones
* Location: https://play.picoctf.org/events/72/challenges/challenge/369
* Tags: Reverse Engineering, CoreWars

## Problem

> __Due to Instance Launching maintenance, you may access the challenge download file to work offline:__ Your opponent is the Imp. The source is available [here](https://artifacts.picoctf.net/c/408/imp.red). If you wanted to pit the Imp against himself, you could download the Imp and run your own core wars server. Can you make a CoreWars warrior that wins? Additional details will be available after launching your challenge instance.

## Solution

I proceeded by first downloading and reviewing the source code used by this CoreWars challenge:

```
┌──(dna㉿deniers)-[/Ready Gladiator 1]
└─$ cat imp.red                       
;redcode
;name Imp Ex
;assert 1
mov 0, 1
end
                                                                                                                                              
┌──(dna㉿deniers)-[/Ready Gladiator 1]
└─$ 
```

I then tried to make an "Imp" that did less work by copying ``imp.red`` to ``imp2.red`` and using the following code:

```
;redcode
;name Imp Ex
;assert 1
end
```

Like with the previous "Ready Gladiator" challenge, my version removes the ``mov 0, 1`` bit of the code and simply does nothing. I started up the instance and was given a means to transmit my version of the "Imp" and the following hint: "You may be able to find a viable warrior in beginner docs." I tried to submit my version to see if it can beat the instance:

```
┌──(dna㉿deniers)-[/Ready Gladiator 1]
└─$ nc saturn.picoctf.net 57192 < imp2.red
Submit your warrior: (enter 'end' when done)

;redcode
;name Imp Ex
;assert 1
end
Warrior1:
;redcode
;name Imp Ex
;assert 1
end

Warning:
        No instructions
Number of warnings: 1

Rounds: 100
Warrior 1 wins: 0
Warrior 2 wins: 100
Ties: 0
Try again. Your warrior (warrior 1) must win at least once.
                                                                                                                                              
┌──(dna㉿deniers)-[/Ready Gladiator 1]
└─$ 

```

It did not win. So, I tried to pit the original Imp against itself:

```
┌──(dna㉿deniers)-[/Ready Gladiator 1]
└─$ nc saturn.picoctf.net 57192 < imp.red 
Submit your warrior: (enter 'end' when done)

;redcode
;name Imp Ex
;assert 1
mov 0, 1
end
Warrior1:
;redcode
;name Imp Ex
;assert 1
mov 0, 1
end

Rounds: 100
Warrior 1 wins: 0
Warrior 2 wins: 0
Ties: 100
Try again. Your warrior (warrior 1) must win at least once.
                                                                                                                                              
┌──(dna㉿deniers)-[/Ready Gladiator 1]
└─$ 
```

That did not work either. I did some research as per the advice of the hint, and found a page with some "warrior imps" that I can try against the system [1]. I used the "Mirrored Imp" to beat the system's warrior:

```
        dist   equ 4000           ; CORESIZE/2
        istep  equ 4001           ; CORESIZE/2+1

launch  mov    imp,        imp+dist
        spl    imp+dist
imp     mov.i  #0,         istep
end
```

I transmitted it to the system, and ...

```
┌──(dna㉿deniers)-[/Ready Gladiator 1]
└─$ nc saturn.picoctf.net 57192 < imp2.red
Submit your warrior: (enter 'end' when done)

        dist   equ 4000           ; CORESIZE/2
        istep  equ 4001           ; CORESIZE/2+1

launch  mov    imp,        imp+dist
        spl    imp+dist
imp     mov.i  #0,         istep
end
Warrior1:
        dist   equ 4000           ; CORESIZE/2
        istep  equ 4001           ; CORESIZE/2+1

launch  mov    imp,        imp+dist
        spl    imp+dist
imp     mov.i  #0,         istep
end

Warning:
        Missing ';assert'. Warrior may not work with the current setting
Number of warnings: 1

Rounds: 100
Warrior 1 wins: 48
Warrior 2 wins: 0
Ties: 52
You did it!
picoCTF{1mp_1n_7h3_cr055h41r5_f2ba3220}
                                                                                                                                              
┌──(dna㉿deniers)-[/Ready Gladiator 1]
└─$
```

I have no idea what I did, but I know that I got the flag: ``picoCTF{1mp_1n_7h3_cr055h41r5_f2ba3220}``

## References

1. https://corewar.co.uk/imp.htm

