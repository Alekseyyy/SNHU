/*
 * Tutorial: 30 Days of Code.
 * A solution to "Day 11: 2D Arrays"
 *   Submitted by A. S. "Aleksey" Ahmann <alekseyyy2@outlook.com>
 *   Submitted on Feb. 24, 2024
 *   Link: https://www.hackerrank.com/challenges/30-2d-arrays/problem
 * 
 * Objective: Today, we are building on our knowledge of arrays by adding another dimension.
 */

using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;

class Solution {
  
    static void Main(String[] args) {
        int[][] arr = new int[6][];
        for(int arr_i = 0; arr_i < 6; arr_i++){
           string[] arr_temp = Console.ReadLine().Split(' ');
           arr[arr_i] = Array.ConvertAll(arr_temp,Int32.Parse);
        }
        
        // Calculate The Hourglass Sums...
        List<int> hourglass_sums = new List<int>();
        
        for (int row = 1; row < 5; row++) {
            for (int column = 1; column < 5; column++) {
                int x_1 = arr[row][column]; //hourglass centre
                
                int x_2 = arr[row - 1][column]; //hourglass midtop
                int x_3 = arr[row + 1][column]; //hourglass midbottom
                
                int x_4 = arr[row - 1][column - 1]; //hourglass topleft
                int x_5 = arr[row - 1][column + 1]; //hourglass topright
                int x_6 = arr[row + 1][column - 1]; //hourglass bottomleft
                int x_7 = arr[row + 1][column + 1]; //hourglass bottomright
                
                int hourglass_sum = x_1 + x_2 + x_3 + x_4 + x_5 + x_6 + x_7;
                hourglass_sums.Add(hourglass_sum);
            }
        }
        
        // Determine the winner through a voting method...
        int theWinner = hourglass_sums[0];
        for (int i = 1; i < hourglass_sums.Count; i++) {
            if (hourglass_sums[i] > theWinner)
                theWinner = hourglass_sums[i];
        }
        Console.WriteLine("{0}", theWinner);
    }
}

