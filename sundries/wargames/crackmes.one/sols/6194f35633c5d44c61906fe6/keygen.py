
# Keygen script for f-crackme (crackmes.one puzzle)

# By A. S. "Aleksey" Ahmann <hackermaneia@riseup.net>
# - GitHubs: github.com/Alekseyyy
# - Crackmes profile: crackmes.one/user/RelationalAlgebra

import string
import random

def message():
    print("Aleksey's Keygen for f-crackme!")
    print("Here's what I came up with :D\n")

def main():
    message()
    user = "".join([random.choice(list(string.ascii_lowercase)) \
        for k in range(2, random.randint(4, 10))])
    print("Username: " + user)
    print("Password: " + user + "@fsociety\n")

if __name__ == "__main__":
    main()
