
# Submitted by: A. S. "Aleksey" Ahmann <alekseyyy2@outlook.com
# Problem statement: Given two integers, X and Y, identify whether X < Y or X > Y or X = Y. 

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

# Notes:
# * I learnt that Bash is super sensitive regarding its syntax. Examples:
# ** [ "$X" -eq "$Y" ] needs to have spaces; ["$X" -eq "$Y"] DOES NOT WORK (notice te lack of spaces between the brackets)!

