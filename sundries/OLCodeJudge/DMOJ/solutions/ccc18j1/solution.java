/* ===========================================================================
 * Solution to "Telemarketer or not?" from DM::OJ
 * - Source: https://dmoj.ca/problem/ccc18j1
 * By A. S. "Aleksey" Ahmann <hackermaneia@riseup.net>
 * - GitHub: https://github.com/Alekseyyy
 * - DM::OJ profile: https://dmoj.ca/user/a_ahmann
 * ========================================================================= */

import java.io.*;
import java.util.*;

public class solution {
    public static void main(String[] args) {
        Scanner inputMechanism = new Scanner(System.in);
        int[] w = new int[4];
        for (int i = 0; i < 4; i++)
            w[i] = inputMechanism.nextInt();
        if ( (w[0] == 8 || w[0] == 9) && 
            (w[3] == 8 || w[3] == 9) && w[1] == w[2] )
            System.out.println("ignore");
        else
            System.out.println("answer");
    }
}
