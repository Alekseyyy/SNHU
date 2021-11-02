/*
 * Dive into Algorithms: A Pythonic Adventure for the Intrepid Beginner
 * - ISBN: 978-1-7185-0068-6
 * Ported by A. S. "Aleksey" Ahmann <hackermaneia@riseup.net>
 * - https://github.com/Alekseyyy
 * - https://keybase.io/epsiloncalculus
 *
 * This describes an analytic approach to physics, where a second-
 * order polynomial is used to work out the vertical distance of
 * a ball given its horizontal distance (p. 3)
 *
 */

package main

import (
	"math"

	"github.com/Arafatk/glot"
)

func ball_trajectory(x float64) float64 {
	return 10*x - 5*math.Pow(x, 2)
}

func main() {

	plot, _ := glot.NewPlot(2, false, false)

	var x []float64
	var y []float64
	for i := 0; i <= 200; i++ {
		x = append(x, float64(i)/100.0)
		y = append(y, ball_trajectory(float64(i)/100.0))
	}

	plot.AddPointGroup("Parabola", "lines", [][]float64{x, y})

	plot.SetTitle("The trajectory of a thrown ball")
	plot.SetXLabel("Horizontal position of ball")
	plot.SetYLabel("Vertical position of ball")
	plot.SavePlot("output.png")
}
