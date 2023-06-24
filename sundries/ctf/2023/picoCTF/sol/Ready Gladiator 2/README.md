# Ready Gladiator 2

* Author: LT 'syreal' Jones
* Location: https://play.picoctf.org/practice/challenge/370
* Tags: Reverse Engineering, CoreWars

## Problem

> __Due to Instance Launching maintenance, you may access the challenge download file to work offline:__ Your opponent is the Imp. The source is available [here](https://artifacts.picoctf.net/c/284/imp.red). If you wanted to pit the Imp against himself, you could download the Imp and run your own core wars server. Can you make a CoreWars warrior that wins every single round? Additional details will be available after launching your challenge instance.

## Solution

I started the instance associated with this room (Figure 1) and was given the hint "[i]f your warrior is close, try again, it may work on subsequent tries... why is that?" So, based on the website of past CoreWars solutions, [1] I decided to try various "imps" and see which ones came close to the instance's imp. Here are my results:

|__Imp's Name__|__Imp's Source__|__Imp's Average Score__|
|-|-|
| Classic Imp | ``classic.red`` | |
| Mirrored Imp | ``mirror.red`` | |
| Imp Ring | ``ring.red`` | |
| Vector Launch | | |
| Binary Launch | | |
| JMP/ADD Launch | | |
| Impfinity Launch | | |
| Vortex Launch | | |
| Amber Launch | | |
| A-Field vs B-Field | | |

None of the above solutions worked, so I looked to another source for a solution, and found another [2][3] that works 100/100 times.

## References

1. https://corewar.co.uk/imp.htm
2. https://www.reddit.com/r/programminggames/comments/11vaxk8/beat_classic_imp_100_of_the_time_in_corewars/
3. https://web.archive.org/web/20230325030148/https://old.reddit.com/r/programminggames/comments/11vaxk8/beat_classic_imp_100_of_the_time_in_corewars/
