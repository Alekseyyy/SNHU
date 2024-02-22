
# Submitted by: A. S. "Aleksey" Ahmann <alekseyyy@outlook.com>
# Problem Statement: Write a Bash script which accepts name as input and displays the greeting "Welcome (name)"

# This one uses tilde expansion to pass the results to printf
method1() {
    read x 
    printf "%.3f\n" `echo $x | bc -l`
}

# This one uses the "$(command)" bashism to pass the results to printf
method2 () {
    read x
    printf "%.3f\n" $(echo $x | bc -l)
}

method1
method2

# Notes
# 1. I referenced the following solution when doing this problem: https://github.com/mminer/hackerrank/blob/master/bash-tutorials---arithmetic-operations.sh
# 2. I learnt about tilde expansion in the process: https://www.gnu.org/software/bash/manual/html_node/Tilde-Expansion.html
# 3. I came across some interesting *Overflow threads discussing bashisms while researching this:
#   * https://stackoverflow.com/questions/27472540/difference-between-and-in-bash
#   * https://askubuntu.com/questions/833833/what-does-command-do
#   * https://tecadmin.net/difference-between-parameter-expansion-and-command-substitution-in-bash/
