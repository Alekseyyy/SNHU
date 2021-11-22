/* ===========================================================================
 * Solution to "A New Hope" from DM::OJ
 * - Source: https://dmoj.ca/problem/wc15c2j1
 * By A. S. "Aleksey" Ahmann <hackermaneia@riseup.net>
 * - GitHub: https://github.com/Alekseyyy
 * - DM::OJ profile: https://dmoj.ca/user/a_ahmann
 * ========================================================================= */
 
import java.io.*;
import java.util.*;

public class solution {
    public static void main(String[] args) {
        Scanner input_mechanism = new Scanner(System.in);
        int S = input_mechanism.nextInt();
        input_mechanism.close();
        
        String fars = "";
        for (int i = 0; i < S; i++) {
            if (i == S - 1)
                fars += "far";
            else
                fars += "far, ";
        }
        
        System.out.format("A long time ago in a galaxy %s away...", fars);
    }
}

