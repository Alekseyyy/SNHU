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
		Scanner inputMechanism = new Scanner(System.in);
		int lines = Integer.parseInt(inputMechanism.nextLine());
		String[] samples = new String[lines];
		for (int i = 0; i < lines; i++)
			samples[i] = inputMechanism.nextLine();
		inputMechanism.close();
        	int[] counts = {0, 0}; //t and T, or s and S
		for (int i = 0; i < lines; i++) {
			char[] explodeSample = samples[i].toCharArray();
			for (int j = 0; j < explodeSample.length; j++) {
				if (explodeSample[j] == 't')
					counts[0] += 1;
				else if (explodeSample[j] == 'T')
					counts[0] += 1;
				else if (explodeSample[j] == 's')
					counts[1] += 1;
				else if (explodeSample[j] == 'S')
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

