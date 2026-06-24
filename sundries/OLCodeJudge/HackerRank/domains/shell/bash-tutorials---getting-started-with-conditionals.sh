
# Domain: Linux Shell
# A solution to "Getting Started with Conditionals"
#   Submitted by A. S. "Aleksey" Ahmann <alekseyyy2@outlook.com>
#   Submitted on: [tba]
#   Link: https://www.hackerrank.com/challenges/bash-tutorials---getting-started-with-conditionals/problem
#
# Task description: Read in one character from STDIN. If the character is 'Y' or 'y' display "YES". If the character is 'N' or 'n' display "NO". No other character will be provided as input. 
#

read my_char

if [ "$my_char" = "Y" ] || [ "$my_char" = "y" ]
then
    echo "YES"

elif [ "$my_char" = "N" ] || [ "$my_char" = "n" ]
then
    echo "NO"

fi

# Endnotes:
# 1. I consulted the following resources: 
#   1a. https://stackoverflow.com/questions/39550623/how-to-do-character-comparison-in-bash-scripts
#   1b. https://kapeli.com/cheat_sheets/Bash_Test_Operators.docset/Contents/Resources/Documents/index
#

