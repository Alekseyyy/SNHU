/* ===========================================================================
 * Solution to "An Honest Day's Work" from DM::OJ
 * - Source: https://dmoj.ca/problem/wc18c3j1
 * By A. S. "Aleksey" Ahmann <hackermaneia@riseup.net>
 * - GitHub: https://github.com/Alekseyyy
 * - DM::OJ profile: https://dmoj.ca/user/a_ahmann
 * ========================================================================= */

#include <iostream>
using namespace std;

int main() {
    int P, B, D;
    cin >> P;
    cin >> B;
    cin >> D;
    
    int badges = (P / B) * D;
    int leftovers = P % B;
    
    cout << badges + leftovers << endl;
    
    return 0;
}
