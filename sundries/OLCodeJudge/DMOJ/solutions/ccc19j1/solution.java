/* ===========================================================================
 * Solution to "Winning Score" from DM::OJ
 * - Source: https://dmoj.ca/problem/ccc19j1
 * By A. S. "Aleksey" Ahmann <hackermaneia@riseup.net>
 * - GitHub: https://github.com/Alekseyyy
 * - DM::OJ profile: https://dmoj.ca/user/a_ahmann
 * ========================================================================= */

import java.io.*;
import java.util.*;

public class solution {
    public static void main(String[] args) {
        Scanner inputMechanism = new Scanner(System.in);
        int apples = 0;
        int bananas = 0;
        for (int i = 0; i < 6; i++) {
            if (i < 3)
                apples += inputMechanism.nextInt() * (3 - i);
            else
                bananas += inputMechanism.nextInt() * (3 - (i - 3));
        }
        inputMechanism.close();
        if (apples > bananas) 
            System.out.println("A");
        else if (bananas > apples)
            System.out.println("B");
        else if (apples == bananas)
            System.out.println("T");
    }
}