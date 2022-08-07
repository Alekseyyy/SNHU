/* ===========================================================================
 * Solution to "Uncrackable" from DM::OJ
 * - Source: https://dmoj.ca/problem/wc17c3j3
 * By A. S. "Aleksey" Ahmann <hackermaneia@riseup.net>
 * - GitHub: https://github.com/Alekseyyy
 * - DM::OJ profile: https://dmoj.ca/user/a_ahmann
 * ========================================================================= */
 
import java.io.*;
import java.util.*;

public class solution {
    public static void main(String[] args) {
        Scanner inputMechanism = new Scanner(System.in);
        String password = inputMechanism.nextLine();
        inputMechanism.close();

        if (password.length() >= 8 && password.length() <= 12) {
            char[] explodePassword = password.toCharArray();
            int[] criteria = {0, 0, 0}; // lower, upper, digit
            for (int i = 0; i < explodePassword.length; i++) {
                if (Character.isLowerCase(explodePassword[i]))
                    criteria[0] += 1;
                else if (Character.isUpperCase(explodePassword[i]))
                    criteria[1] += 1;
                else if (Character.isDigit(explodePassword[i]))
                    criteria[2] += 1;
            }
            if (
                criteria[0] >= 3 &&
                criteria[1] >= 2 &&
                criteria[2] >= 1
            )
                System.out.println("Valid");
            else
                System.out.println("Invalid");
        }
        else 
            System.out.println("Invalid");
    }
}

