/* ===========================================================================
 * Solution to "Not a Wall of Text" from DM::OJ
 * - Source: https://dmoj.ca/problem/dmopc15c7p2
 * By A. S. "Aleksey" Ahmann <hackermaneia@riseup.net>
 * - GitHub: https://github.com/Alekseyyy
 * - DM::OJ profile: https://dmoj.ca/user/a_ahmann
 * ========================================================================= */

import java.io.*;
import java.util.*;

public class solution {
    public static void main(String[] args) {
        Scanner input_mechanism = new Scanner(System.in);
        String sentence = input_mechanism.nextLine();
        input_mechanism.close();
        
        String[] sentence_split = sentence.split(" ");
        System.out.format("%d", sentence_split.length);
    }
}
