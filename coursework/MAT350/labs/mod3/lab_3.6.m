%
% zyBooks practice problems 
% 3.6 MATLAB: Cross Product
%
% By Alexander Ahmann <alexander.ahmann@snhu.edu>
%   - GitHub: https://github.com/Alekseyyy
%

%Define the three vectors u=[1, 0, -4], v=[3, -3, 1], and w=[0, 2, 1].

u = [1 0 -4]
v = [3 -3 1]
w = [0 2 1]

%Find the cross product of u and w.  Store it in a1.

a1 = cross(u, w)

%Find the cross product of w and u.  Store it in a2.  Reversing the order of the cross product
%results in a vector of the same length but opposite direction.  Note that a2 = -1(a1).

a2 = -1 * cross(u, w)

%Find the volume of the parallelepiped determined by vectors u, v, and w.  Store this value in z.

z = abs(dot(u, cross(v, w)))

