%
% zyBooks practice problems 
% 1.3 MATLAB: Defining Matrices
%
% By Alexander Ahmann <alexander.ahmann@snhu.edu>
%   - GitHub: https://github.com/Alekseyyy
%


%Define the 3x3 matrix A with all 1's in the first row, all 2's in the second row, 
%and all 3's in the 3rd row.

A = [1 1 1; 2 2 2; 3 3 3]

%Use the size() function to compute the number of rows and columns of matrix A.
%Store these quantities as variables numRows and numCols.

[numRows, numCols] = size(A)

%Use the eye() function to create the 4x4 identity matrix.  Store this matrix as I.

I = eye(4)

%Compute the transpose of the matrix A.  Store this transposed matrix as the matrix D.

D = A.'
