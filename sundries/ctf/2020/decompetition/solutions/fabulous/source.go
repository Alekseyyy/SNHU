// fabulous reconstruction
// by Aleksey
// - https://alekseyyy.github.io
// - @EpsilonCalculus / @EntropyThot

// I stole some of my code from here...
// ... (like how brett keane stole that poem about his mum): 
// https://www.thepolyglotdeveloper.com/2016/12/fibonacci-sequence-printed-golang/

package main

import (
  "fmt"
  "os"
  "strconv"
)

func fib(k int) int {
  if k <= 1 {
      return k
  }
  return fib(k - 1) + fib(k - 2)
}

func main() {
  
  if (len(os.Args ) > 1) {
    input, err := strconv.Atoi(os.Args[1])
    if err == nil {
      fmt.Println(fib(input + 1))
    } else {
      fmt.Println("1")
    }
  }
}
