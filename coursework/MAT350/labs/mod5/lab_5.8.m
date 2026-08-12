%
% zyBooks practice problems 
% 5.8 MATLAB: Change of Bases
%
% By Alexander Ahmann <alexander.ahmann@snhu.edu>
%   - GitHub: https://github.com/Alekseyyy
%

%Create the augmented matrix D, whose columns are the ordered basis of C followed 
%by the image of the ordered basis of B.

C = [
    3 2;
    -1 5
] % the original "C" basis

B = [
    1 -3 5
    -2 -4 0
] % put the finishing "B" through the T transform

D = [C B]

%Row reduce the augmented matrix to get [I | T_BtoC].  Store the transformation
%matrix in T_BtoC.

temp = rref(D)
format rat

T_BtoC = temp(:,3:5)

