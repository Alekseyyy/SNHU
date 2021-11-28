/* ===========================================================================
 * Solution to "C.C. and Cheese-kun" from DM::OJ
 * - Source: "https://dmoj.ca/problem/dmopc16c1p0"
 * By A. S. "Aleksey" Ahmann <hackermaneia@riseup.net>
 * - GitHub: https://github.com/Alekseyyy
 * - DM::OJ profile: https://dmoj.ca/user/a_ahmann
 * ========================================================================= */
 
import java.io.*;
import java.util.*;

public class solution {
    public static void main(String[] args) {
        Scanner input_mechanism = new Scanner(System.in);
        int W = input_mechanism.nextInt();
        int C = input_mechanism.nextInt();
        input_mechanism.close();
        
        if (W == 3 && C >= 95)
            System.out.format("C.C. is absolutely satisfied with her pizza.\n");
        else if (W == 1 && C <= 50)
            System.out.format("C.C. is fairly satisfied with her pizza.\n");
        else
            System.out.format("C.C. is very satisfied with her pizza.\n");
    }
}

