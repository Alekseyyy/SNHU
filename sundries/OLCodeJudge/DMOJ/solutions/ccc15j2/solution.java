/* ===========================================================================
 * Solution to "Happy or Sad" from DM::OJ
 * - Source: https://dmoj.ca/problem/ccc15j2
 * By A. S. "Aleksey" Ahmann <hackermaneia@riseup.net>
 * - GitHub: https://github.com/Alekseyyy
 * - DM::OJ profile: https://dmoj.ca/user/a_ahmann
 * ========================================================================= */
 
import java.io.*;
import java.util.*;

public class solution {
    public static void main(String[] args) {
        Scanner inputMechanism = new Scanner(System.in);
        String message = inputMechanism.nextLine();
        inputMechanism.close();
        
        int[] scores = {
            message.split("\\Q:-)\\E").length - 1,
            message.split("\\Q:-(\\E").length - 1
        };
        
        if (scores[0] == 0 && scores[1] == 0)
            System.out.println("none");
        else if (scores[0] < scores[1])
            System.out.println("sad");
        else if (scores[0] > scores[1])
            System.out.println("happy");
        else
            System.out.println("unsure");
    }
}

