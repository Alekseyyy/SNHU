/* ===========================================================================
 * Solution to "How's the Weather?" from DM::OJ
 * - Source: https://dmoj.ca/problem/wc17c1j2
 * By A. S. "Aleksey" Ahmann <hackermaneia@riseup.net>
 * - GitHub: https://github.com/Alekseyyy
 * - DM::OJ profile: https://dmoj.ca/user/a_ahmann
 * ========================================================================= */

import java.io.*;
import java.util.*;

public class solution {
    public static void main(String[] args) {
        Scanner inputMechanism = new Scanner(System.in);
        float C = inputMechanism.nextFloat();
        inputMechanism.close();
        
        System.out.format("%f", ((9.0 * C) / 5.0) + 32.0);
    }
}
