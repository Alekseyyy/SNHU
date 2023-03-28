// baby-go reconstruction
// by Aleksey
// - https://alekseyyy.github.io
// - @EpsilonCalculus / @EntropyThot

package main

import (
  "fmt"
  "os"
  "strconv"
)

func main() {
  // Good luck!
  
  if (len(os.Args) > 1) {
    input, err := strconv.Atoi(os.Args[1])
    if err == nil {
      if (input % 3 == 0 && input % 5 == 0) {
        fmt.Println("Green")
      } else if (input % 3 == 0) {
        fmt.Println("Yellow")
      } else if (input % 5 == 0) {
        fmt.Println("Blue")
      } else {
        fmt.Println(input)
      }
    }
  }
}
