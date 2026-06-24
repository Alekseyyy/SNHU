
# Domain: Linux Shell
# A solution to "The World of Numbers"
#   Submitted by A. S. "Aleksey" Ahmann <alekseyyy2@outlook.com>
#   Submitted on: [tba]
#   Link: https://www.hackerrank.com/challenges/bash-tutorials---the-world-of-numbers/problem
#
# Task description: Given two integers, X and Y, find their sum, difference, product, and quotient.
#

read X
read Y

a=$(($X + $Y))
echo $a

b=$(($X - $Y))
echo $b

c=$(($X * $Y))
echo $c

d=$(($X / $Y))
echo $d

