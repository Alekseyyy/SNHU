
## Lab 2-1: Kinematics

This was the first lab that I did. It consisted of five (5) activities, which are:

1. The graphing and interpretation of a given data table.
2. The measurement and data analysis of a toy car.
3. A replication of Galileo's classical ramp kinematics experiment.
4. "Extending" from Activity 3, a scientific analysis of the ramp experiment.
5. "Extending" from Activities 3 and 4, a demonstration that acceleration is constant.

### Activity 1

This task just tested the student's ability to make a line chart from a given table. In this case, we are given the following table for a locomotive and its displacement given the time elapsed:

|__Time (t) in seconds__|__Position p(t) in metres__|
|-----------------------|---------------------------|
|0|0|
|5|20|
|10|40|
|15|50|
|20|55|
|30|60|
|35|70|
|40|70|
|45|70|
|50|55|

My method for creating line charts is to use the Python programming language, and the ``csv``, ``pandas`` and ``matplotlib`` modules to create the line chart. I came up with the following basic skeleton for creating line graphs:

```python
import csv
import pandas as pd
import matplotlib.pyplot as plt

fig, ax = plt.subplots()

table = pd.read_csv("{table}")

plt.scatter(table["{abscissa}"], table["{ordinate}"], color="grey")
plt.plot(table["{abscissa}"], table["{ordinate}"], color="black")

plt.title("{abscissa label}", fontsize=14)
plt.ylabel("{ordinate label})", fontsize=14)

ax.xaxis.tick_top()
plt.show()
```

### Activity 2

### Activity 3

### Activity 4

### Activity 5

