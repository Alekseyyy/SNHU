%
% zyBooks practice problems 
% 7.9 MATLAB: Singular Value Decomposition
%
% By Alexander Ahmann <alexander.ahmann@snhu.edu>
%   - GitHub: https://github.com/Alekseyyy
%

%Enter the matrix B.

B = [
    -6 8 6 9;
    3 2 4 -8;
    5 -4 -7 -3
]

%Use the command svd() to find three matrices, namely the mxm orthogonal matrix U, the mxn 
%diagonal matrix S, and the nxn orthogonal matrix V, of the singular value decomposition of B.

[U, S, V] = svd(B)

%Verify that the appropriate product of the matrices found using the svd() command
%results in the matrix B.  Store this product in checkB. 

checkB = U*S*V.'

