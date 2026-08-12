%
% zyBooks practice problems 
% 6.2 MATLAB: Eigenvalues and Eigenvectors
%
% By Alexander Ahmann <alexander.ahmann@snhu.edu>
%   - GitHub: https://github.com/Alekseyyy
%

%Enter the matrix C.

C = [6 3 -8;
    0 -2 0;
    1 0 -3
]

%Find the coefficients of the characteristic polynomial.  Store them in PolyCoeffs.

PolyCoeffs = poly(C)

%Use the command roots() to find the eigenvalues.  Store them in evals.

evals = roots(PolyCoeffs)

%Use the eig() command.  Store the eigenvalues in matrix eigDiag.  Store the associated
%eigenvectors in eigV.

[eigV eigDiag] = eig(C)


