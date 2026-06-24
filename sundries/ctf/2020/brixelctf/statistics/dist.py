# Script to generate distribution of Brixel winter CTF (2020) scores
# By Aleksey
#  https://github.com/Alekseyyy

import pandas as pd
import seaborn as sns
import matplotlib.pyplot as plt

df = pd.read_csv('scoreboard.csv', delimiter=',', engine='python')

plt.axvline(x=75)
sns.distplot(df["Score"], bins=25)

plt.title("Score", fontsize=14)
plt.ylabel("Density", fontsize=14)
plt.xlabel("", fontsize=10)
plt.xlim(0, 655)

plt.show()
