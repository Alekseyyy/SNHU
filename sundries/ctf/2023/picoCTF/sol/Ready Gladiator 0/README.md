# Ready Gladiator 0

* Author: LT 'syreal' Jones
* Location: https://play.picoctf.org/events/72/challenges/challenge/368
* Tags: Reverse Engineering, CoreWars

## Problem

> __Due to Instance Launching maintenance, you may access the challenge download file to work offline:__ Your opponent is the Imp. The source is available [here](https://artifacts.picoctf.net/c/309/imp.red). If you wanted to pit the Imp against himself, you could download the Imp and start your own corewars server. Can you make a CoreWars warrior that always loses, no ties? Additional details will be available after launching your challenge instance.

This problem comes with a file called ``imp.red`` ([download it here](./imp.red)).

## Solution

Because of picoCTF's servers that are overloaded with instances started by its other users, I tried to solve this problem on my local machine. On my local machine, I decided to output the contents of ``imp.red``:

```
dna@deniers:~/Ready Gladiator 0$ cat imp.red
;redcode
;name Imp Ex
;assert 1
mov 0, 1
end
dna@deniers:~/Ready Gladiator 0$ 
```

In case that I need to launch an instance, I will do so by clicking on the button (Figure 1). From the source code, I decided to look up "redcode" and "red code assembly" on search engines, and I came up with an "esoteric language" called Redcode [1][2]. 

It seems to be an assembly language part of a programming game called "Core Wars," where hackers and programmers would try to write programmes in an assembly language to "destroy" other programmes written in an assembly language for the challenge of optimisation. 

I eventually launched the instance and two hints came up before me:

1. CoreWars is a well-established game with a lot of docs and strategy.
2. Experiment with input to the CoreWars handler or create a self-defeating bot.

I also got the following connection details: ``nc saturn.picoctf.net 61036 < imp.red``; this specifically to "pit" the Imp against itself. I tried that strategy:

```
dna@deniers:~/Ready Gladiator 0$ nc saturn.picoctf.net 61036 < imp.red
;redcode
;name Imp Ex
;assert 1
mov 0, 1
end
Submit your warrior: (enter 'end' when done)

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
Try again. Your warrior (warrior 1) must lose all rounds, no ties.
dna@deniers:~/Ready Gladiator 0$ 
```

That did not seem to work. So, I modified ``imp.red`` into ``imp2.red``:

```
;redcode
;name Imp Ex
;assert 1
end
```

I literally just removed the ``mov`` instruction and tried to connect to the service with my version of ``imp``:

```
dna@deniers:~/Ready Gladiator 0$ nc saturn.picoctf.net 61036 < imp2.red
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
You did it!
picoCTF{h3r0_t0_z3r0_4m1r1gh7_f1e207c4}
dna@deniers:~/Ready Gladiator 0$ 
```

## References

1. https://esolangs.org/wiki/Redcode
2. https://corewar.co.uk/karonen/guide.htm
