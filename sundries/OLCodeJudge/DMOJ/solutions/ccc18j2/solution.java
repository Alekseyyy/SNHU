/* ===========================================================================
 * Solution to "Occupy parking" from DM::OJ
 * - Source: https://dmoj.ca/problem/ccc18j2
 * By A. S. "Aleksey" Ahmann <hackermaneia@riseup.net>
 * - GitHub: https://github.com/Alekseyyy
 * - DM::OJ profile: https://dmoj.ca/user/a_ahmann
 * ========================================================================= */

import java.io.*;
import java.util.*;

public class solution {
    public static void main(String[] args) {
        Scanner input_mechanism = new Scanner(System.in);
        int[] slots = new int[Integer.parseInt(input_mechanism.nextLine())];
        char[] lot_yest = input_mechanism.nextLine().toCharArray();
        char[] lot_toda = input_mechanism.nextLine().toCharArray();
        input_mechanism.close();

        // Fill the slots
        for (int i = 0; i < slots.length; i++) {
            if (lot_yest[i] == 'C' && lot_toda[i] == 'C')
                slots[i] = 1;
            else
                slots[i] = 0;
        }

        System.out.format("%d", Arrays.stream(slots).sum());
    }
}
