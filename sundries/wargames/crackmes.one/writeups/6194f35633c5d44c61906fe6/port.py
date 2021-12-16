
# High-level, albeit erronous, representation of the
# f-crackme puzzle hosted on the crackmes.one website

# By A. S. "Aleksey" Ahmann <hackermaneia@riseup.net>
# - GitHubs: github.com/Alekseyyy
# - Crackmes profile: crackmes.one/user/RelationalAlgebra

import sys

class f_crackme:
    
    def main(self):
        input_user = raw_input("Type your username: ") #local_28
        input_pass = raw_input("Type your password: ") #local_48
        local_c = self.checkUsername(input_user)

        local_68 = None
        local_60 = None

        if local_c == 0:
            local_68 = "\x74\x65\x69\x63\x6f\x73\x66\x40"[::-1] + \
                input_user # or, 0x746569636f736640 + input_user
            local_60 = 0x79
        else:
            if local_c != 1:
                sys.exit(0)
            local_68 = input_user + "\x2e\x72\x4d"[::-1]

        if local_68 == input_pass:
            print("Cracked")
        else:
            print("Not Cracked")

    def checkUsername(self, x):
        x_len = len(x)

        if (x_len < 2) or (x_len > 7):
            if (x_len < 8):
                return 2
            return 1
        return 0

if __name__ == "__main__":
    main_logic = f_crackme()
    main_logic.main()
