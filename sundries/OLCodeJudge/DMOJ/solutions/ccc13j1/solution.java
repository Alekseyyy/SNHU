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
        Scanner inputMechanism = new Scanner(System.in);
        int S1 = inputMechanism.nextInt();
        int S2 = inputMechanism.nextInt();
        inputMechanism.close();
        
        System.out.format("%d", S2 + (S2 - S1));
    }
}

