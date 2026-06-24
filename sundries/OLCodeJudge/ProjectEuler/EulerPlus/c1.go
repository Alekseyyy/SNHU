/*
 * By A. S. "Aleksey" Ahmann <hackermaneia@riseup.net>
 * - GitHub: https://github.com/Alekseyyy
 * - HackerRank: https://hackerrank.com/hackermaneia
 * Doesn't pass test cases where "n" is too big :-(
*/

package main
import "fmt"

func summit(n int) int {
    var ret int = 0
    for i := 1; i < n; i++ {
        if (i % 3 == 0 || i % 5 == 0) {
            ret += i
        }
    }
    return ret
}

func main() {
 //Enter your code here. Read input from STDIN. Print output to STDOUT
 var t int
 fmt.Scan(&t)
 for i := 0; i < t; i++ {
     var c int
     fmt.Scan(&c)
     var s int = summit(c)
     fmt.Println(s)
 }
}

