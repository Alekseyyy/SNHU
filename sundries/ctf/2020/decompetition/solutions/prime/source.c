/*
 * prime reconstruction
 * by Aleksey (mostly with help from Ghidra's recompiler :P)
 * - https://alekseyyy.github.io
 * - @EpsilonCalculus / @EntropyThot
*/

#include <stdio.h>
#include <stdlib.h>

int is_prime(long n) {
  // TODO...
  
  int prime, local_c;
  
  if ((int) n < 2)
    prime = 0;
  else {
    if ((n == 2) || (n == 3))
      prime = 1;
    else {
      if (((n & 1) == 0) || ((int)n % 3 == 0))
        prime = 0;
      else {
        local_c = 5;
        while (local_c * local_c < (int)n) {
          if (((int)n % local_c == 0) || ((int)n % (local_c + 2) == 0))
            return 0;
          local_c = local_c + 6;
        }
        prime = 1;
      }
    }
  }
  return prime;
}

int main(int argc, char** argv) {
  // IS PRIME?
  
  int x, y;
  
  if (argc != 2) {
    fprintf(stderr, "USAGE: %s <num>\n", *argv);
    exit(1);
  }
  
  x = atoi((char*) argv[1]);
  y = is_prime((long)x);
  
  printf("is_prime(%d) = %d\n", x, y);
  
  return 0;
}
