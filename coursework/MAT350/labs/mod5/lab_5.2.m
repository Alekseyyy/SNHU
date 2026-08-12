%
% zyBooks practice problems 
% 5.2 MATLAB: Linear Transformations
%
% By Alexander Ahmann <alexander.ahmann@snhu.edu>
%   - GitHub: https://github.com/Alekseyyy
%

%Create the standard matrix A that rotates a point 60 degrees counterclockwise about the origin.

A = [
    cos(pi/3) -sin(pi/3);
    sin(pi/3) cos(pi/3)
]

%Create a matrix S containing the points of the triangle as the columns.

S = [
    0 1 3 0;
    0 1 0 0
]

%Perform matrix multiplication to transform each of the points in S.  Store this in T1.

T1 = A*S

%Plot the original triangle and the transformed triangle in a single graph.

plot(S(1,:), S(2,:), T1(1,:), T1(2,:))

%Do you run into any difficulties?  Explain what is happening as a comment in your code.
  % The "S" matrix was the hardest part, I had to experiment a bit with trial and error to
  % "get it right." Setting up the "A" matrix, and the computations, were easier.

