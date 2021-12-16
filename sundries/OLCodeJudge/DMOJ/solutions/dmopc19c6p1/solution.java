/* ===========================================================================
 * Solution to "Grade 9 Math" from DM::OJ
 * - Source: https://dmoj.ca/problem/dmopc19c6p1
 * By A. S. "Aleksey" Ahmann <hackermaneia@riseup.net>
 * - GitHub: https://github.com/Alekseyyy
 * - DM::OJ profile: https://dmoj.ca/user/a_ahmann
 *
 * PLEASE NOTE that this code _DID NOT_ pass all test cases; still needs to
 * be worked on!
 * ========================================================================= */
 
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner input_mechanism = new Scanner(System.in);
        String line1 = input_mechanism.nextLine();
        String line2 = input_mechanism.nextLine();
        input_mechanism.close();

        double[] p_l1 = compute_parameters(line1);
        double[] p_l2 = compute_parameters(line2);
        double[] f_l2 = format_points(line2);

        if (p_l1[0] == p_l2[0] && p_l1[1] == p_l2[1])
            System.out.println("coincident");
        else if ( p_l1[0] == p_l2[0] && !(p_l1[1] == p_l2[1]) )
            System.out.println("parallel");
        else {
            if (p_l1[0] == Double.POSITIVE_INFINITY || p_l1[0] == Double.NEGATIVE_INFINITY ||
                p_l1[0] == Double.NaN || p_l1[0] == Double.NaN)
                System.out.format("%.6f %.6f\n", p_l2[0], p_l2[1]);
            else if (p_l2[0] == Double.POSITIVE_INFINITY || p_l2[0] == Double.NEGATIVE_INFINITY ||
                p_l2[0] == Double.NaN || p_l2[0] == Double.NaN)
                System.out.format("%.6f %.6f\n", p_l1[0], p_l1[1]);
            else {
                double x_1 = (p_l2[0] * f_l2[2] + p_l2[1] - p_l1[1]) / p_l1[0];
                System.out.format("%.6f %.6f\n", x_1, p_l1[0] * x_1 + p_l2[1]);
            }
        }
    }

    public static double[] compute_parameters(String input) {
        double[] input_parse = format_points(input);
        
        double[] params = new double[2];
        params[0] = (input_parse[3] - input_parse[1]) / (input_parse[2] - input_parse[0]); // compute slope
        params[1] = ( (params[0] * input_parse[0]) - input_parse[1] ) / -1; // compute intercept

        return params; //slope, intercept
    }

    public static double[] format_points(String input) {
        double[] input_parse = new double[4];
        String[] explode_input = input.split(" ");

        for (int i = 0; i < 4; i++)
            input_parse[i] = Double.parseDouble(explode_input[i]);
        return input_parse; // x_1, y_1, x_2, y_2
    }
}

