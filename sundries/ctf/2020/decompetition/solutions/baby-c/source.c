/*
 * baby-c reconstruction
 * by Aleksey (mostly with help from Ghidra's recompiler :P)
 * - https://alekseyyy.github.io
 * - @EpsilonCalculus / @EntropyThot
*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

long foo(int a, int b) {

  int x, y;
  x = b;
  y = a;
  
  while (x != y) {
    if (x < y)
      y = y - x;
    else {
      if (y < x)
        x = x - y;
    }
  }
  
  return y;
}

int main(int argc, char** argv) {
  
  int x1, x2, y;
  
  if (argc != 3) {
    fprintf(stderr, "USAGE: %s <num1> <num2>\n", *argv);
    exit(1);
  }
  
  x1 = atoi((char*)argv[1]);
  x2 = atoi((char*)argv[2]);
  y = foo(x1, x2);
  printf("foo(%d, %d) = %d\n", x1, x2, y);
  return 0;
}
