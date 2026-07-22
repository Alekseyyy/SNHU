%
% zyBooks practice problems 
% 2.3 MATLAB: Matrix Operations
%
% By Alexander Ahmann <alexander.ahmann@snhu.edu>
%   - GitHub: https://github.com/Alekseyyy
%

%Create the square matrix A.

A = [1 0 -1;
    2 1 -5;
    1 -1 0]

%Use the format command view values as rational numbers rather than decimals.
format rat

%Create the augmetned matrix [A | I] using the apprpopriately sized identity matrix.  Store this
%matrix in AugA.
AugA = [A eye(3)]

%Use the rref() command to reduce the augmented matrix.  Store the reduced matrix in rowreducedAugA.
%Store the pivot variables in rowreducedAugA.
[rowreducedAugA, pivotvarsAugA] = rref(AugA)

%Retrieve the inverse of matrix A from the reduced augmented matrix [I | Ainv]. Store the inverse
%matrix in Ainv1.

Ainv1 = rowreducedAugA(:,4:6)

%Use the inv() command to find the inverse of matrix A.  Store the inverse matrix in Ainv2.
Ainv2 = inv(A)

