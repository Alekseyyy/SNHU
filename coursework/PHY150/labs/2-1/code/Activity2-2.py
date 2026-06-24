# Graph for data analysis of a hypothetical kinematics dataset
# By Alexander Ahmann <alexander.ahmann@snhu.edu>

import csv
import pandas as pd
import matplotlib.pyplot as plt

fig, ax = plt.subplots()

table = pd.read_csv("table3.csv")

plt.scatter(table["s"], table["v"], color="grey")
plt.plot(table["s"], table["v"], color="black")

plt.title("Time (in seconds \"s\")", fontsize=14)
plt.ylabel("Velocity (in metres per second \"m/s\")", fontsize=14)

ax.xaxis.tick_top()
plt.show()

