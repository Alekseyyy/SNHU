#!/bin/python3

# Tutorial: 30 Days of Code
# A solution to "Day 20: Sorting"
#   Submitted by A. S. "Aleksey" Ahmann <alekseyyy2@outlook.com>
#   Submitted on Mar. 1, 2024
#   Link: https://www.hackerrank.com/challenges/30-sorting/problem
#
# Task description:
#
# Given an array, a, of size n distinct elements, sort the array in ascending order using the Bubble Sort algorithm above. 
# Once sorted, print the following lines:
#   1. "Array is sorted in numSwaps swaps."
#       where "numSwaps" is the number of swaps that took place.
#   2. "First Element: firstElement"
#       where "firstElement" is the first element in the sorted array.
#   3. "Last Element: lastElement"
#       where "lastElement" is the last element in the sorted array.
#

import math
import os
import random
import re
import sys

def swap(arr, x_i, y_i):
    rep_x = arr[y_i]
    rep_y = arr[x_i]
    
    arr[x_i] = rep_x
    arr[y_i] = rep_y
    
    return arr

def bubble_sort(arr):
    number_of_swaps = 0
    
    for i in range(len(arr)):
        for j in range(len(arr) - 1):
            if arr[j] > arr[j + 1]:
                swap(arr, j, j + 1)
                number_of_swaps += 1
    
    return number_of_swaps, arr

if __name__ == '__main__':
    n = int(input().strip())

    a = list(map(int, input().rstrip().split()))

    # Write your code here
    number_of_swaps, sorted_array = bubble_sort(a)
    print("Array is sorted in {0} swaps.".format(number_of_swaps))
    print("First Element: {0}".format(sorted_array[0]))
    print("Last Element: {0}".format(sorted_array[len(sorted_array) - 1]))

# Endnotes
# 1. Normally, I like to solve the coding problems in C++, but this one
#   gave a solution for the Bubble Sort algorithm in a C/C++-like pseudocode
#   so I wanted to challenge myself by porting it into Python
#

