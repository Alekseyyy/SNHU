# Graph for data analysis of a hypothetical kinematics dataset
# By Alexander Ahmann <alexander.ahmann@snhu.edu>

import csv
import pandas as pd
import matplotlib.pyplot as plt

fig, ax = plt.subplots()

table = pd.read_csv("table2.csv")

plt.scatter(table["s"], table["m"], color="grey")
plt.plot(table["s"], table["m"], color="black")

plt.title("Time (in seconds \"s\")", fontsize=14)
plt.ylabel("Position (in metres \"m\")", fontsize=14)

ax.xaxis.tick_top()
plt.show()

