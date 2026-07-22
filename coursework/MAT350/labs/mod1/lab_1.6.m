%
% zyBooks practice problems 
% Lab 1.6: MATLAB: Reduce Matrices
%
% By Alexander Ahmann <alexander.ahmann@snhu.edu>
%   - GitHub: https://github.com/Alekseyyy
%

%Create the matrix C.

C = [2 1 3 1; 1 2 0 3; -2 2 3 7]

%Use the rref() command to reduce the matrix C.  Store the reduced matrix in rowreducedC, and 
%store the pivot variables in pivotvarsC.

[rowreducedC, pivotvarsC] = rref(C)

%Use the "format rat" option to express elements as ratios.

format rat
[rowreducedC, pivotvarsC] = rref(C)

