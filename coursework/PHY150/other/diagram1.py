import matplotlib.pyplot as plt

ax = plt.gca()

def makeAircraft(x, y, message=False):
    plane = plt.Rectangle((x, y), 10, 150)
    ax.add_patch(plane)
    if message != False:
        plt.text(-98, 2500, message)
    
def makePayload(x, y, message=False):
    pass

# Plot the free-body diagram
# plt.plot(-100, 2650, "ro") # plot a dot

makeAircraft(-100, 2650, r'Aircraft ($x_i$)')
# plt.plot(0, 2650, "ro")
plt.text(2, 2500, r'Aircraft ($x_f$)')

# Finalise the plot
## Add an axis
plt.axhline(y=0, color="black")
plt.axvline(x=0, color="black")

## Title the thing
plt.title("Plane trajectory (x-axis)", fontsize=14)
plt.ylabel("Height from drop zone (h-axis)", fontsize=14)

## Adjust the x-axis scale and its ticker
plt.xlim(-120,50)
plt.ylim(-500, 3000)
ax.xaxis.tick_top()

plt.show()

