/* ===========================================================================
 * Solution to "A New Hope" from DM::OJ
 * - Source: https://dmoj.ca/problem/wc15c2j1
 * By A. S. "Aleksey" Ahmann <hackermaneia@riseup.net>
 * - GitHub: https://github.com/Alekseyyy
 * - DM::OJ profile: https://dmoj.ca/user/a_ahmann
 * ========================================================================= */

#include <iostream>
using namespace std;

int main() {
    int S;
    cin >> S;
    
    string fars = "";
    for (int i = 0; i < S; i++) {
        if (i == S - 1)
            fars += "far";
        else
            fars += "far, ";
    }
    cout << "A long time ago in a galaxy " << fars << " away..." << endl;
    return 0;
}
