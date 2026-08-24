%
% zyBooks practice problems 
% 8.5 MATLAB: Least Squares Approximation
%
% By Alexander Ahmann <alexander.ahmann@snhu.edu>
%   - GitHub: https://github.com/Alekseyyy
%

%The same data is used for the activity.  These are provided for you.
X = [-2 -1 1 2].'
Y = [3 1 0 1].'

%Use the length() command to determine the size of the column vector X.  Store this value in m.

m = length(X)

%Set up the appropriate matrix A to find the best-fit parabola of the form y=C+Dx+Ex^2.  The 
%first column of A will contain all 1's, using the ones() command.  The second column of A 
%contains x values that are stored in X.  The third column of A contains the squared x values
%that are stored in X.  Elementwise multiplication of X by itself, using .* operator, will 
%produce the desired values for the third column.

A = [ones(m,1) X X.* X]

%Calculate the matrix products.  These are provided for you.
A_transposeA = A.' * A
A_transposeY = A.' * Y

%Use the backslash operation to solve the overdetermined system.  Store this in Soln2.

Soln2 = A_transposeA \ A_transposeY

%Define the x values to use for plotting the best-fit parabola.  This creates a vector x.
%This is provided for you.
x=-4: 0.1 :4

%Define the best-fit parabola, storing it in yquadratic.  Elementwise multiplication of the
%x values times themselves to square them is achieved by using .* operator (because x is a vector).

yquadratic = Soln2(1) + Soln2(2) * x + Soln2(3)*x.^2

%The following sequence of commands plots the data and the best-fit parabola.  The command is 
%provided for you.
plot(x, yquadratic, X, Y, 'k*');grid;shg

