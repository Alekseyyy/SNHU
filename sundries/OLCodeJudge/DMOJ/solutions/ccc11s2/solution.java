/* ===========================================================================
 * Solution to "Multiple Choice" from DM::OJ
 * - Source: https://dmoj.ca/problem/ccc11s2
 * By A. S. "Aleksey" Ahmann <hackermaneia@riseup.net>
 * - GitHub: https://github.com/Alekseyyy
 * - DM::OJ profile: https://dmoj.ca/user/a_ahmann
 * ========================================================================= */
 
import java.io.*;
import java.util.*;

public class solution {
    public static void main(String[] args) {
        Scanner input_mechanism = new Scanner(System.in);
        int buf_size = Integer.parseInt(input_mechanism.nextLine());
        
	char[] raw_input = new char[2 * buf_size];
	for (int i = 0; i < 2 * buf_size; i++)
		raw_input[i] = input_mechanism.nextLine().charAt(0);
        input_mechanism.close();
		
	int correct_answers = 0;
	for (int i = 0; i < buf_size; i++) {
		if (raw_input[i] == raw_input[i + buf_size])
			correct_answers += 1;
	}

        System.out.println(correct_answers);
    }
}

