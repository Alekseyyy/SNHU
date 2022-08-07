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
        Scanner inputMechanism = new Scanner(System.in);
        String line1 = inputMechanism.nextLine();
        String line2 = inputMechanism.nextLine();
        inputMechanism.close();

        double[] pl1 = computeParameters(line1);
        double[] pl2 = computeParameters(line2);
        double[] fl2 = formatPoints(line2);

        if (pl1[0] == pl2[0] && pl1[1] == pl2[1])
            System.out.println("coincident");
        else if ( pl1[0] == pl2[0] && !(pl1[1] == pl2[1]) )
            System.out.println("parallel");
        else {
            if (pl1[0] == Double.POSITIVE_INFINITY || pl1[0] == Double.NEGATIVE_INFINITY ||
                pl1[0] == Double.NaN || pl1[0] == Double.NaN)
                System.out.format("%.6f %.6f\n", pl2[0], pl2[1]);
            else if (pl2[0] == Double.POSITIVE_INFINITY || pl2[0] == Double.NEGATIVE_INFINITY ||
                pl2[0] == Double.NaN || pl2[0] == Double.NaN)
                System.out.format("%.6f %.6f\n", pl1[0], pl1[1]);
            else {
                double x_1 = (pl2[0] * fl2[2] + pl2[1] - pl1[1]) / pl1[0];
                System.out.format("%.6f %.6f\n", x_1, pl1[0] * x_1 + pl2[1]);
            }
        }
    }

    public static double[] computeParameters(String input) {
        double[] inputParse = formatPoints(input);
        
        double[] params = new double[2];
        params[0] = (inputParse[3] - inputParse[1]) / (inputParse[2] - inputParse[0]); // compute slope
        params[1] = ( (params[0] * inputParse[0]) - inputParse[1] ) / -1; // compute intercept

        return params; //slope, intercept
    }

    public static double[] formatPoints(String input) {
        double[] inputParse = new double[4];
        String[] explodeInput = input.split(" ");

        for (int i = 0; i < 4; i++)
            inputParse[i] = Double.parseDouble(explodeInput[i]);
        return inputParse; // x_1, y_1, x_2, y_2
    }
}

