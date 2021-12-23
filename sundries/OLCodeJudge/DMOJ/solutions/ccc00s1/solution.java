/* ===========================================================================
 * Solution to "Slot Machines" from DM::OJ
 * - Source: https://dmoj.ca/problem/ccc00s1
 * By A. S. "Aleksey" Ahmann <hackermaneia@riseup.net>
 * - GitHub: https://github.com/Alekseyyy
 * - DM::OJ profile: https://dmoj.ca/user/a_ahmann
 * ========================================================================= */
 
import java.io.*;
import java.util.*;

public class Main {

    private static int quarters;
    private static int[] machines;
    private static int rounds;

    public static void play_machine(int machine_id, 
        int winning_position, int payoff) {
        quarters -= 1;
        machines[machine_id] += 1;
        if (machines[machine_id] % winning_position == 0)
            quarters += payoff;
        rounds += 1;
    }
    public static void main(String[] args) {
        Scanner input_mechanism = new Scanner(System.in);
        quarters = Integer.parseInt(input_mechanism.nextLine());
        machines = new int[3];
        for (int i = 0; i < 3; i++)
            machines[i] = Integer.parseInt(input_mechanism.nextLine());
        input_mechanism.close();

        boolean broke = false;
        rounds = 0;
        while (!broke) {
            play_machine(0, 35, 30); //play machine 1
            play_machine(1, 100, 60); //play machine 2
            play_machine(2, 10, 9); //play machine 3

            if (!(quarters > 0))
                broke = true;
        }
        System.out.format("Martha plays %d times before going broke.\n", rounds);
    }
}

