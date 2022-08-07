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
        Scanner inputMechanism = new Scanner(System.in);
        int bufSize = Integer.parseInt(inputMechanism.nextLine());
        
	char[] rawInput = new char[2 * bufSize];
	for (int i = 0; i < 2 * bufSize; i++)
		rawInput[i] = inputMechanism.nextLine().charAt(0);
        inputMechanism.close();
		
	int correctAnswers = 0;
	for (int i = 0; i < bufSize; i++) {
		if (rawInput[i] == rawInput[i + bufSize])
			correctAnswers += 1;
	}

        System.out.println(correctAnswers);
    }
}

