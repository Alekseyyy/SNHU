/* ===========================================================================
 * Solution to "Who is in the Middle?" from DM::OJ
 * - Source: https://dmoj.ca/problem/ccc07j1
 * By A. S. "Aleksey" Ahmann <hackermaneia@riseup.net>
 * - GitHub: https://github.com/Alekseyyy
 * - DM::OJ profile: https://dmoj.ca/user/a_ahmann
 * ========================================================================= */
 
import java.io.*;
import java.util.*;

public class solution {
    public static void main(String[] args) {
        Scanner input_mechanism = new Scanner(System.in);
        int[] bowls = new int[3];
        for (int i = 0; i < 3; i++)
            bowls[i] = input_mechanism.nextInt();
        input_mechanism.close();
        Arrays.sort(bowls);
        System.out.format("%d", bowls[1]);
    }
}

