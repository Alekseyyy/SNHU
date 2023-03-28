/*
 * bitesize reconstruction
 * by Aleksey (mostly with help from Ghidra's recompiler :P)
 * - https://alekseyyy.github.io
 * - @EpsilonCalculus / @EntropyThot
*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef unsigned char byte;

void win(int x, int y) {
  puts("How did you get here??");
  exit(42);
}

void register_tm_clones(void) {
  return;
}

void sum(int x, long int y) {
  int var_i;
  char memptr[255];
  byte var_b;
  
  var_i = atoi(*(char**)(y + 8));
  var_b = (byte)var_i;
  printf("SIZE: %d\n", (long)var_b);
  
  if (var_b < 0xf8) {
    memset(memptr, 0, 0xf7);
    var_i = atoi(*(char**)(y + 0x10));
    memcpy(memptr, *(void**)(y+0x10), (long)var_i);
    printf("Got: %s\n", memptr);
  }
  
  else {
    puts("Too long!");
  }
  
  return;
}

void frame_dummy(void) {
  
  register_tm_clones();
  return;
}

int main(int argc, int argv[]) {
  if (argc > 2)
    sum((long)argc, argv);
    
  return 0;
}
