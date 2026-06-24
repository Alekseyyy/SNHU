
# Domain: Linux Shell
# A solution to "Compariing Numbers"
#   Submitted by A. S. "Aleksey" Ahmann <alekseyyy2@outlook.com>
#   Submitted on: [tba]
#   Link: https://www.hackerrank.com/challenges/bash-tutorials---comparing-numbers/problem
#
# Task description: Given two integers, X and Y, identify whether:
#   1. X < Y, 
#   2. or X > Y,
#   3. or X = Y. 
#

read X
read Y

if [ "$X" -eq "$Y" ] 
then
    echo "X is equal to Y";

elif [ "$X" -gt "$Y" ]
then
    echo "X is greater than Y";

elif [ "$X" -lt "$Y" ]
then
    echo "X is less than Y";

fi

#
# Endnotes:
# 1. I learnt that Bash is super sensitive regarding its syntax. Examples:
# 2. [ "$X" -eq "$Y" ] needs to have spaces; ["$X" -eq "$Y"] DOES NOT WORK!!!1 (notice te lack of spaces between the brackets)
#

