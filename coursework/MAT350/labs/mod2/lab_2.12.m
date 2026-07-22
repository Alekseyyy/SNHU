%
% zyBooks practice problems 
% 2.12 MATLAB: LU Decomposition
%
% By Alexander Ahmann <alexander.ahmann@snhu.edu>
%   - GitHub: https://github.com/Alekseyyy
%

%Create the coefficient matrix A and and the column matrix b of constants.

A = [1 2 3; 
    3 0 -1;
    2 -1 1]
b = [9; 3; 8]

%Use the lu() command to find the LU decomposition of A, storing the lower and upper matrices
%in L and U, respectively.

[L U] = lu(A)

%Solve the system of linear equations Ax=b using the LU decomposition.  Store the intermediary
%solution in y.  Store the solution for x in x1.

y = L\b
x1 = U\y

%Check that the solution x1 matches that found by directly using the backslash operator to solve
%the system Ax=b.  Use the backslash operator to solve Ax=b in one step, storing the solution in x2.

x2 = U\y

