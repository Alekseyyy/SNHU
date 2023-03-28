# babygame01

Author: Palash Oswal
Location: https://play.picoctf.org/events/72/challenges/challenge/345
Tags: Web Exploitation, game

## Problem 

> Due to Instance Launching maintenance, you may access the challenge download file to work offline: The game is available to download [here](https://artifacts.picoctf.net/c/225/game). There is no source available, so you'll have to figure your way around the map. Get the flag and reach the exit. Additional details will be available after launching your challenge instance.

## Solution 

I started the instance associated with this challenge (Figure 1) and was presented with the following means of communicating with it: ``nc saturn.picoctf.net 56652``

New hints were also revealed:

1. Use 'w','a','s','d' to move around.
2. There may be secret commands to make your life easy.

So, I decided to use netcat to get into the network service:

```
┌──(dna㉿deniers)-[~/babygame01]
└─$ nc saturn.picoctf.net 56652

Player position: 4 4
End tile position: 29 89
Player has flag: 0
..........................................................................................
..........................................................................................
..........................................................................................
..........................................................................................
....@.....................................................................................
..........................................................................................
..........................................................................................
..........................................................................................
..........................................................................................
..........................................................................................
..........................................................................................
..........................................................................................
..........................................................................................
..........................................................................................
..........................................................................................
..........................................................................................
..........................................................................................
..........................................................................................
..........................................................................................
..........................................................................................
..........................................................................................
..........................................................................................
..........................................................................................
..........................................................................................
..........................................................................................
..........................................................................................
..........................................................................................
..........................................................................................
..........................................................................................
.........................................................................................X

```

I think that I need to develop of sequences of "w", "a", "s" and "d" characters to get from the "player position" of "4 4" to "29 89". I did end up sending the right number of "s" and "d" characters to "win" the game, but without a flag:

```
Player position: 29 89
Player has flag: 0
..........................................................................................
..........................................................................................
..........................................................................................

[... snip ...]

.........................................................................................@
You win!
                                                                                                   
┌──(dna㉿deniers)-[~/babygame01]
└─$ 
```

I decided to decompile the ``game`` executable. In the ``main`` function, I found the following snippet:

```c++
[... snip ...]

  puts("You win!");
  if (local_aa4 != '\0') {
    puts("flage");
    win();
    fflush(stdout);
  }
  
[... snip ...]
```

I decided to look at the ``win`` function:

```c++
void win(void)

{
  FILE *__stream;
  int in_GS_OFFSET;
  char local_4c [60];
  int local_10;
  
  local_10 = *(int *)(in_GS_OFFSET + 0x14);
  __stream = fopen("flag.txt","r");
  if (__stream == (FILE *)0x0) {
    puts("flag.txt not found in current directory");
                    /* WARNING: Subroutine does not return */
    exit(0);
  }
  fgets(local_4c,0x3c,__stream);
  printf(local_4c);
  if (local_10 != *(int *)(in_GS_OFFSET + 0x14)) {
    __stack_chk_fail_local();
  }
  return;
}

```

It looks like that the win function will output the flag if I can get it to execute, and if I can send an input that is not null. I reconnected to the service and tried the following input to try to redirect the programme's logic to ``win``:

```
ssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddsssssssssssssssssssssssssssssssssssssssssssssddddddddddddddddddddddddddddddddddddddddddddddddddddd
```

It didn't seem to work. So I decided to look up this problem and found some interesting references [1][2]. I also decided to use the ``angr`` framework [3][4]

## References

1. https://ctf101.org/
2. https://lnwatson.co.uk/posts/pwn-challenges/
3. https://angr.io/
4. https://stackoverflow.com/questions/66456759/python-3-9-why-i-cant-import-angr

