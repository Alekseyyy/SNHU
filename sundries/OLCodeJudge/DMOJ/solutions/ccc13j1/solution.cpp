/* ===========================================================================
 * Solution to "Next in line" from DM::OJ
 * - Source: https://dmoj.ca/problem/ccc13j1
 * By A. S. "Aleksey" Ahmann <hackermaneia@riseup.net>
 * - GitHub: https://github.com/Alekseyyy
 * - DM::OJ profile: https://dmoj.ca/user/a_ahmann
 * ========================================================================= */

#include <iostream>
using namespace std;

int main() {
    int S_1, S_2;
    cin >> S_1;
    cin >> S_2;
    
    cout << S_2 + (S_2 - S_1) << endl;
    return 0;
}
