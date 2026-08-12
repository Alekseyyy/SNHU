%
% zyBooks practice problems 
% 6.5 MATLAB: Diagonalization
%
% By Alexander Ahmann <alexander.ahmann@snhu.edu>
%   - GitHub: https://github.com/Alekseyyy
%

%Enter matrix C.

C = [
    1 2 2
    2 1 2
    2 2 1
]

%Use the eig() command to find the matrix P that diagonalizes C and the resulting diagonal 
%matrix D.  Store these in P and D, respectively.

[P D] = eig(C)

%Indirectly find C^4, using P and D, and using the power() command on D.  Store the result in C4.

C4 = P * power(D, 4) * inv(P) % indirect method
C4directly = C^4 %direct method

