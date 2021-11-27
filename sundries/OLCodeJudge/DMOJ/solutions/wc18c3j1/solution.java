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
        Scanner input_mechanism = new Scanner(System.in);
        int P = input_mechanism.nextInt();
        int B = input_mechanism.nextInt();
        int D = input_mechanism.nextInt();
        input_mechanism.close();
        
        int badges = (P / B) * D;
        int leftovers = P % B;
        
        System.out.format("%d", badges + leftovers);
    }
}
