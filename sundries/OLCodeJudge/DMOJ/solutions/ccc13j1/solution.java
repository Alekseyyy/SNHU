/* ===========================================================================
 * Solution to "Next in line" from DM::OJ
 * - Source: https://dmoj.ca/problem/ccc13j1
 * By A. S. "Aleksey" Ahmann <hackermaneia@riseup.net>
 * - GitHub: https://github.com/Alekseyyy
 * - DM::OJ profile: https://dmoj.ca/user/a_ahmann
 * ========================================================================= */
 
import java.io.*;
import java.util.*;

public class solution {
    public static void main(String[] args) {
        Scanner input_mechanism = new Scanner(System.in);
        int S_1 = input_mechanism.nextInt();
        int S_2 = input_mechanism.nextInt();
        input_mechanism.close();
        
        System.out.format("%d", S_2 + (S_2 - S_1));
    }
}

