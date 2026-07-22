
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% Applied Linear Algebra (MAT-350): Project 1 Solution  %
% By Alexander Ahmann <alexander.ahmann@snhu.edu>       %
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

% Q2: Use MATLAB to construct the augmented matrix [A b] 
  % and then perform row reduction using the rref() function.
  % Write out your reduced matrix and identify the free and 
  % basic variables of the system.

A = [
    1 2 0 0 0;
    1 1 -1 0 -1;
    0 1 -1 0 -1;
    0 -1 0 1 1;
    0 1 1 -1 1
] % The coefficient matrix

b = [
    100;
    0;
    -50;
    120;
    0
] % The column vector

augAb = [A b] % Augmented matrix of the coefficient 
[rrAugAb, prAugAb] = rref(augAb) % Automatic procedure
  %  by which to reduce the [A b] matrix into an 
  % echelon form. 

% Q3: Use MATLAB to compute the LU  decomposition of 
  % A, i.e., find A = LU. For this decomposition,
  % find the transformed set of equations Ly = b,
  % where y = Ux. Solve the system of equations 
  % Ly = b for the unknown vector y.

[A_L A_U] = lu(A) % Lower-Upper decomposition 
  %of coefficient matrix.
y = A_L\b % Solving for the "response variable" 
  % in terms of the coefficient matrix's lower
  % triangulation matrix "divided" by the coef-
  % -ficient vector "b".

% Q4: Use MATLAB to compute the inverse of U 
  % using the inv() function.

AU_inv = inv(A_U) % Automatic inverse of the coefficient
  % matrix's "upper"  triangulation matrix, or its 
  % "U"-matrix.

% Q5: Compute the solution to the original system of 
  % equations by transforming y into x, i.e., computing 
  % x = U^-1 * y

x = AU_inv * y % Solving for the "unknowns-vector" by 
  % multiplying the inverse of A_U (AU_inv) and the 
  % previously discovered "y"-vector

% Q6: Check your answer for x_1 using Cramer’s Rule.

A_x1 = A % create a copy of the coefficient matrix "A"
A_x1(:, 1) = b % replace the first column with the 
  % constants vector "b"
cr_x1 = det(A_x1) / det(A) % Solve with Cramer's Rule

  % For good measure, check the other variables x_2, 
    % x_3, ... x_5 with Cramer's rule.
    
A_x2 = A % create a copy of the coefficient matrix "A"
A_x2(:, 2) = b % replace the second column with the 
  % constants vector "b"
cr_x2 = det(A_x2) / det(A) % Solve with Cramer's Rule

A_x3 = A % create a copy of the coefficient matrix "A"
A_x3(:, 3) = b % replace the third column with the 
  % constants vector "b"
cr_x3 = det(A_x3) / det(A) % Solve with Cramer's Rule

A_x4 = A % create a copy of the coefficient matrix "A"
A_x4(:, 4) = b % replace the fourth column with the 
  % constants vector "b"
cr_x4 = det(A_x4) / det(A) % Solve with Cramer's Rule

A_x5 = A % create a copy of the coefficient matrix "A"
A_x5(:, 5) = b % replace the fifth column with the 
  % constants vector "b"
cr_x5 = det(A_x5) / det(A) % Solve with Cramer's Rule





