%
% zyBooks practice problems 
% 3.16.1: MATLAB: Cramer's Rule
%
% By Alexander Ahmann <alexander.ahmann@snhu.edu>
%   - GitHub: https://github.com/Alekseyyy
%

%Create the coefficient matrix A and column matrix of constants b.

A = [1 1 -1;
    3 -2 1;
    1 3 -2]
b = [6; -5; 14]

%Initialize the matrices A1, A2, and A3 as matrix A.

A1 = A
A2 = A
A3 = A

%Replace the appropriate columns in A1, A2, and A3 with the column vector of constants b. 

A1(:,1) = b
A2(:,2) = b
A3(:,3) = b

%Find the solution for x1, x2, and x3 using ratios of determinants.

x1 = det(A1) / det(A)
x2 = det(A2) / det(A)
x3 = det(A3) / det(A)


