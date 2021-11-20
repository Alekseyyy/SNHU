/* ===========================================================================
 * Solution to "A Spooky Season" from DM::OJ
 * - Source: https://dmoj.ca/problem/wc16c1j1
 * By A. S. "Aleksey" Ahmann <hackermaneia@riseup.net>
 * - GitHub: https://github.com/Alekseyyy
 * - Keybase: https://keybase.io/epsiloncalculus
 * ========================================================================= */

import java.io.*;
import java.util.*;

public class solution {
    public static void main(String[] args) {
        Scanner input_mechanism = new Scanner(System.in);
        int S = input_mechanism.nextInt();
        input_mechanism.close();
        
        String orec = "";
        while (S > 0) {
            orec += "o";
            S--;
        }
        
        System.out.format("sp%sky", orec);
    }
}
