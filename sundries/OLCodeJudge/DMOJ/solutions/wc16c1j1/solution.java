/* ===========================================================================
 * Solution to "A Spooky Season" from DM::OJ
 * - Source: https://dmoj.ca/problem/wc16c1j1
 * By A. S. "Aleksey" Ahmann <hackermaneia@riseup.net>
 * - GitHub: https://github.com/Alekseyyy
 * - DM::OJ profile: https://dmoj.ca/user/a_ahmann
 * ========================================================================= */

import java.io.*;
import java.util.*;

public class solution {
    public static void main(String[] args) {
        Scanner inputMechanism = new Scanner(System.in);
        int S = inputMechanism.nextInt();
        inputMechanism.close();
        
        String orec = "";
        while (S > 0) {
            orec += "o";
            S--;
        }
        
        System.out.format("sp%sky", orec);
    }
}
