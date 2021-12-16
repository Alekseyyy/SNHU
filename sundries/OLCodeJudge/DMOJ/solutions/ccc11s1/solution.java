/* ===========================================================================
 * Solution to "English or French?" from DM::OJ
 * - Source: https://dmoj.ca/problem/ccc11s1
 * By A. S. "Aleksey" Ahmann <hackermaneia@riseup.net>
 * - GitHub: https://github.com/Alekseyyy
 * - DM::OJ profile: https://dmoj.ca/user/a_ahmann
 * ========================================================================= */
 
import java.io.*;
import java.util.*;

public class solution {

	public static void main(String[] args) {
		Scanner input_mechanism = new Scanner(System.in);
		int lines = Integer.parseInt(input_mechanism.nextLine());
		String[] samples = new String[lines];
		for (int i = 0; i < lines; i++)
			samples[i] = input_mechanism.nextLine();
		input_mechanism.close();
        	int[] counts = {0, 0}; //t and T, or s and S
		for (int i = 0; i < lines; i++) {
			char[] explode_sample = samples[i].toCharArray();
			for (int j = 0; j < explode_sample.length; j++) {
				if (explode_sample[j] == 't')
					counts[0] += 1;
				else if (explode_sample[j] == 'T')
					counts[0] += 1;
				else if (explode_sample[j] == 's')
					counts[1] += 1;
				else if (explode_sample[j] == 'S')
					counts[1] += 1;
				else
					continue;
			}
		}
		if (counts[0] > counts[1])
			System.out.println("English");
		else if (counts[1] > counts[0])
			System.out.println("French");
		else if (counts[0] == counts[1])
			System.out.println("French");
		else
			System.out.print("");
	}
}

