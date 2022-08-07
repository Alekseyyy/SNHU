/* ===========================================================================
 * Solution to "Special Day" from DM::OJ
 * - Source: "https://dmoj.ca/problem/ccc15j1"
 * By A. S. "Aleksey" Ahmann <hackermaneia@riseup.net>
 * - GitHub: https://github.com/Alekseyyy
 * - DM::OJ profile: https://dmoj.ca/user/a_ahmann
 * ========================================================================= */
 
import java.io.*;
import java.util.*;

public class solution {
    public static void main(String[] args) {
        Scanner inputMechanism = new Scanner(System.in);
        int month = inputMechanism.nextInt();
        int day = inputMechanism.nextInt();
        inputMechanism.close();
        
        if (month < 2) 
            System.out.println("Before");
        else if (month > 2)
            System.out.println("After");
        else {
            if (day < 18)
                System.out.println("Before");
            else if (day > 18)
                System.out.println("After");
            else {
                System.out.println("Special");
            }
        }
    }
}

