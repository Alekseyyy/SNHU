
# Submitted by: A. S. "Aleksey" Ahmann <alekseyyy@outlook.com>
# Problem Statement: Given N lines of input, print the 3rd character from each line as a new line of output. It is guaranteed that each of the n lines of input will have a 3rd character.

while read LINE
do
    cut -c 3 <<< $LINE
done < "${1:-/dev/stdin}"

# Endnotes
# 1. I referenced the following articles when writing this script:
#   * https://www.unix.com/unix-for-dummies-questions-and-answers/28542-how-do-i-get-nth-character-string.html
#   * https://stackoverflow.com/questions/6980090/how-to-read-from-a-file-or-standard-input-in-bash
#   * https://www.baeldung.com/linux/bash-substring

