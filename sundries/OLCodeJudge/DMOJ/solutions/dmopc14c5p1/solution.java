/* ===========================================================================
 * Solution to "Core Drill" from DM::OJ
 * - Source: https://dmoj.ca/problem/dmopc14c5p1
 * By A. S. "Aleksey" Ahmann <hackermaneia@riseup.net>
 * - GitHub: https://github.com/Alekseyyy
 * - DM::OJ profile: https://dmoj.ca/user/a_ahmann
 * ========================================================================= */

import java.io.*;
import java.util.*;

import java.lang.Math.*;

public class solution {
    public static void main(String[] args) {
        Scanner inputMechanism = new Scanner(System.in);
        double r = inputMechanism.nextDouble();
        double h = inputMechanism.nextDouble();
        inputMechanism.close();
        
        double V = (Math.PI * Math.pow(r, 2) * h) / 3.0;
        System.out.format("%f", V);
    }
}
