/*
 * Dive into Algorithms: A Pythonic Adventure for the Intrepid Beginner
 * - ISBN: 978-1-7185-0068-6
 * Ported by A. S. "Aleksey" Ahmann <hackermaneia@riseup.net>
 * - https://github.com/Alekseyyy
 * - https://keybase.io/epsiloncalculus
 *
 * This is a port of Euclid's algorithm that the author presented
 * in p. 21
 *
 */

package main

import (
	"fmt"
	"math"
)

func main() {
	fmt.Print("Enter a number: ")
	var x float64
	fmt.Scanln(&x)

	fmt.Print("Enter another number: ")
	var y float64
	fmt.Scanln(&y)

	fmt.Printf("The greatest common denomintor of these two numbers is %g\n", gcd(x, y))
}

func gcd(x, y float64) float64 {
	var larger float64 = max(x, y)
	var smaller float64 = min(x, y)

	remainder := math.Mod(larger, smaller)

	if remainder == 0 {
		return smaller
	}
	return gcd(smaller, remainder)

}

func max(x, y float64) float64 {
	if x > y {
		return x
	}
	return y
}

func min(x, y float64) float64 {
	if x < y {
		return x
	}
	return y
}
