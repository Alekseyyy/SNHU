
# Submitted by: A. S. "Aleksey" Ahmann <alekseyyy@outlook.com>
# Link: https://www.hackerrank.com/challenges/bash-tutorials---compute-the-average/problem
# Problem Statement: Given N integers, compute their average, rounded to three decimal places. 

read N

T=0
for n in $(seq 1 $N); do
    read x
    T=$(($T + $x))
done

printf "%.3f\n" $(echo "$T / $N" | bc -l)

# Notes:
# 1. I referenced the following articles when solving this problem:
#   1a. https://phoenixnap.com/kb/bash-printf
#   1b. https://linuxconfig.org/calculate-column-average-using-bash-shell
#   1c. https://stackoverflow.com/questions/20509541/bash-calculate-the-average-of-numbers-inputted
#   1d. https://stackoverflow.com/questions/38751037/add-two-decimal-number-in-bash-script
#   1e. https://www.cyberciti.biz/faq/howto-linux-unix-bash-append-textto-variables/
#   1f. https://opensource.com/article/18/5/you-dont-know-bash-intro-bash-arrays
#

