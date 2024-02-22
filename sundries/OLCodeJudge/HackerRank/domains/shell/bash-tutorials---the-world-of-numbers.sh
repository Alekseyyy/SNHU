
# Submitted by: A. S. "Aleksey" Ahmann <alekseyyy2@outlook.com>
# Problem statement: Given two integers, X and Y, find their sum, difference, product, and quotient.

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

