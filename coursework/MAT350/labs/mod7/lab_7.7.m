%
% zyBooks practice problems 
% 7.7 MATLAB: QR Factorization
%
% By Alexander Ahmann <alexander.ahmann@snhu.edu>
%   - GitHub: https://github.com/Alekseyyy
%

%Enter the matrix B.  Then use the qr() command to find the QR factorization of B, storing
%the orthogonal matrix in QB and the upper triangular matrix in RB.  Note that while the focus
%of the last section of the zyBook was on square matrices, QR factorization can be done for
%any size matrix.

B = [
    1 0 3 -1;
    -2 1 0 5;
    0 0 1 7
]

[QB, RB] = qr(B)

%Verify the result.  Find the product of QB and RB, storing it in checkB.  This matrix should
%equal the original matrix B.

checkB = QB * RB

