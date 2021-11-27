/* ===========================================================================
 * Solution to "How's the Weather?" from DM::OJ
 * - Source: https://dmoj.ca/problem/wc17c1j2
 * By A. S. "Aleksey" Ahmann <hackermaneia@riseup.net>
 * - GitHub: https://github.com/Alekseyyy
 * - DM::OJ profile: https://dmoj.ca/user/a_ahmann
 * ========================================================================= */

#include <iostream>
using namespace std;

int main() {
    float C;
    cin >> C;
    
    cout << ((9.0 * C) / 5.0) + 32.0 << endl;
    
    return 0;
}
