%
% zyBooks practice problems 
% 2.3 MATLAB: Matrix Operations
%
% By Alexander Ahmann <alexander.ahmann@snhu.edu>
%   - GitHub: https://github.com/Alekseyyy
%


%Create the matrices A, B, and C.

A = [1 2 0; -1 -2 3]
B = [-2 0 3; 1 3 1; 0 1 -1]
C = [3 1; 2 -1; -1 0]

%WARNING:  Matrix operations are only possible using matrices of the appropriate sizes.

%Find the scalar product of 2 times A.  Store this product in Ans1.
Ans1 = 2*A

%Find the product of A and B.  Store this product in Ans2.
Ans2 = A * B

%Use the appropriate identity matrix to find the sum of Ans2 and AI.  Store this product in Ans3.
Ans3 = Ans2 + A

%Use the appropriate identity matrix to find CI minus 2 times the transpose of Ans2.  Store 
%this product in Ans4.
Ans4 = C - 2*Ans2.'

