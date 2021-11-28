/* ===========================================================================
 * Solution to "Canadian Calorie Counting" from DM::OJ
 * - Source: https://dmoj.ca/problem/ccc06j1
 * By A. S. "Aleksey" Ahmann <hackermaneia@riseup.net>
 * - GitHub: https://github.com/Alekseyyy
 * - DM::OJ profile: https://dmoj.ca/user/a_ahmann
 * ========================================================================= */

import java.io.*;
import java.util.*;

public class solution {
    public static void main(String[] args) {
        int[][] calories = {
          {461, 431, 420, 0}, //burgers: cheeseburger, fish burger, veggie burger, no burger
          {100, 57, 70, 0}, //side orders: fries, baked potato, chef salad, no side
          {130, 160, 118, 0}, //drinks: soft drink, orange juice, milk, no drink
          {167, 266, 75, 0} // desert: apple pie, sundae, fruit cup, no desert
        };
        int total_calories = 0;
        
        Scanner input_mechanism = new Scanner(System.in);
        for (int i = 0; i < 4; i++)
            total_calories += calories[i][input_mechanism.nextInt() - 1];
        input_mechanism.close();
        
        System.out.format("Your total Calorie count is %d.", total_calories);
    }
}

