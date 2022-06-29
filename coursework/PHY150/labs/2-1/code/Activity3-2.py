# Graph for data analysis of a hypothetical kinematics dataset
# By Alexander Ahmann <alexander.ahmann@snhu.edu>

import csv
import pandas as pd
import matplotlib.pyplot as plt

fig, ax = plt.subplots()

table = pd.read_csv("table4.csv")

plt.scatter(table["m"], table["s_sq"], color="grey")
plt.plot(table["m"], table["s_sq"], color="black")

plt.title("Displacement (in metres \"m\")", fontsize=14)
plt.ylabel("Time (in seconds-squared \"s^2\")", fontsize=14)

ax.xaxis.tick_top()
plt.show()
