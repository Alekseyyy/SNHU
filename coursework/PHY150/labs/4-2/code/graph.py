# Graph for data analysis of a hypothetical kinematics dataset
# By Alexander Ahmann <alexander.ahmann@snhu.edu>

import csv
import pandas as pd
import matplotlib.pyplot as plt

fig, ax = plt.subplots()

table = pd.read_csv("weight-vs-newtons.csv")

plt.scatter(table["weight"], table["acceleration"], color="grey")
plt.plot(table["weight"], table["acceleration"], color="black")

plt.title("Acceleration (in/s²)", fontsize=14)
plt.ylabel("Weight (g • 385.827 in/s²)", fontsize=14)

ax.xaxis.tick_top()
plt.show()

