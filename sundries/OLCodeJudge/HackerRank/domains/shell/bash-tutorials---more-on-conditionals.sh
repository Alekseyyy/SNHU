
# Submitted by: A. S. "Aleksey" Ahmann <alekseyyy2@outlook.com>
# Problem statement: Given three integers (X, Y, and Z) representing the three sides of a triangle, identify whether the triangle is scalene, isosceles, or equilateral. If all three sides are equal, output EQUILATERAL. Otherwise, if any two sides are equal, output ISOSCELES. Otherwise, output SCALENE.

read X
read Y
read Z

if [ "$X" -eq "$Y" ] && [ "$Y" -eq "$Z" ] && [ "$X" -eq "$Z" ]
then
    echo "EQUILATERAL"
    
elif [ "$X" -ne "$Y" ] && [ "$Y" -ne "$Z" ] && [ "$X" -ne "$Z" ]
then
    echo "SCALENE"

else
    echo "ISOSCELES"
fi

