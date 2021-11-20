/* ===========================================================================
 * Solution to "A Spooky Season" from DM::OJ
 * - Source: https://dmoj.ca/problem/wc16c1j1
 * By A. S. "Aleksey" Ahmann <hackermaneia@riseup.net>
 * - GitHub: https://github.com/Alekseyyy
 * - Keybase: https://keybase.io/epsiloncalculus
 * ========================================================================= */

#include <iostream>
using namespace std;

int main() {
    int S;
    cin >> S;
    
    string orec;
    while (S > 0) {
        orec += "o";
        S--;
    }
    
    cout << "sp" << orec << "ky" << endl;
    return 0;
}
