/* ===========================================================================
 * Solution to "An Honest Day's Work" from DM::OJ
 * - Source: https://dmoj.ca/problem/wc18c3j1
 * By A. S. "Aleksey" Ahmann <hackermaneia@riseup.net>
 * - GitHub: https://github.com/Alekseyyy
 * - DM::OJ profile: https://dmoj.ca/user/a_ahmann
 * ========================================================================= */

import java.io.*;
import java.util.*;

public class solution {
    public static void main(String[] args) {
        Scanner inputMechanism = new Scanner(System.in);
        int P = inputMechanism.nextInt();
        int B = inputMechanism.nextInt();
        int D = inputMechanism.nextInt();
        inputMechanism.close();
        
        int badges = (P / B) * D;
        int leftovers = P % B;
        
        System.out.format("%d", badges + leftovers);
    }
}
