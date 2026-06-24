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
        Scanner inputMechanism = new Scanner(System.in);
        int[] slots = new int[Integer.parseInt(inputMechanism.nextLine())];
        char[] lotYest = inputMechanism.nextLine().toCharArray();
        char[] lotToda = inputMechanism.nextLine().toCharArray();
        inputMechanism.close();

        // Fill the slots
        for (int i = 0; i < slots.length; i++) {
            if (lotYest[i] == 'C' && lotToda[i] == 'C')
                slots[i] = 1;
            else
                slots[i] = 0;
        }

        System.out.format("%d", Arrays.stream(slots).sum());
    }
}
