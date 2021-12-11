/* ===========================================================================
 * Solution to "Trik" from DM::OJ
 * - Source: https://dmoj.ca/problem/coci06c5p1
 * By A. S. "Aleksey" Ahmann <hackermaneia@riseup.net>
 * - GitHub: https://github.com/Alekseyyy
 * - DM::OJ profile: https://dmoj.ca/user/a_ahmann
 * ========================================================================= */

import java.io.*;
import java.util.*;

public class solution {
    public static void main(String[] args) {
        Scanner input_mechanism = new Scanner(System.in);
        char[] moves = input_mechanism.nextLine().toCharArray();
        input_mechanism.close();

        int position = 1;
        for (int k = 0; k < moves.length; k++) {
            if (moves[k] == 'A') {
                if (position == 1)
                    position = 2;
                else if (position == 2)
                    position = 1;
            }
            else if (moves[k] == 'B') {
                if (position == 2)
                    position = 3;
                else if (position == 3)
                    position = 2;
            }
            else if (moves[k] == 'C') {
                if (position == 1)
                    position = 3;
                else if (position == 3)
                    position = 1;
            }
        }

        System.out.format("%d", position);
    }
}