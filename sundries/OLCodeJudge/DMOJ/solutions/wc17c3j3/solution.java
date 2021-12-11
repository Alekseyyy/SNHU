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
        Scanner input_mechanism = new Scanner(System.in);
        String password = input_mechanism.nextLine();
        input_mechanism.close();

        if (password.length() >= 8 && password.length() <= 12) {
            char[] explode_password = password.toCharArray();
            int[] criteria = {0, 0, 0}; // lower, upper, digit
            for (int i = 0; i < explode_password.length; i++) {
                if (Character.isLowerCase(explode_password[i]))
                    criteria[0] += 1;
                else if (Character.isUpperCase(explode_password[i]))
                    criteria[1] += 1;
                else if (Character.isDigit(explode_password[i]))
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

