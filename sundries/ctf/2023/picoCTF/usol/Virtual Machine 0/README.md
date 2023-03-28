# Virtual Machine 0

Author: LT 'syreal' Jones
Location: https://play.picoctf.org/events/72/challenges/challenge/385
Tags: Reverse Engineering, Analog

## Problem

> Can you crack this black box? We grabbed this design doc from enemy servers: [Download](https://artifacts.picoctf.net/c/360/Virtual-Machine-0.zip). We know that the rotation of the red axle is input and the rotation of the blue axle is output. The following input gives the flag as output: [Download](https://artifacts.picoctf.net/c/360/input.txt).

This challenge came with a .zip archive called ``input.txt`` ([download it here](./input.txt)) and a text file called ``Virtual-Machine-0.zip`` ([download it here](./Virtual-Machine-0.zip)). This challenge also came with a hint stating: "Rotating the axle that number of times is obviously not feasible. Can you model the mathematical relationship between red and blue?"

## Solution

I downloaded the .zip archive and text file, and then proceeded to extract the .zip archive. It contained a file called ``Virtual-Machine-0.dae``, and I tried to identify what kind of file format it is. I worked out that it is an Adobe COLLADA format [1] used mainly for 3D designs. 

I tried to find a ``.dae`` file reader for the Windows VM and decided to go with FreeCAD [2]. 

## References

1. https://www.adobe.com/creativecloud/file-types/image/vector/collada-file.html
2. https://www.freecad.org/downloads.php