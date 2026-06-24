
# Incomplete solution to Matter and Interactions (Chabay & Sherwood 2015, p. 42)
# ... specifically, P.69a and P.69b
# By Alexander Ahmann <alexander.ahmann@snhu.edu>

import random as pyrand
from visual import *

def render_cubedge(mag, rad):
    """
    mag (vector) = magnitude of the cube
    rad (scalar) = radius of the rendered spheres

    Note that (I think?) in reference to my Figure 2:
        vector(ax, ay, az) = E[ax, f(x), g(x, f(x))]
    
    """

    colours = (
        color.red,
        color.cyan,
        color.green
    )
    
    edge_coefficients = (
        vector(0, 0, 0), # O
        vector(+1 * mag, 0, 0), # OL
        vector(0, +1 * mag, 0), # TO
        vector(+1 * mag, +1 * mag, 0), # O-UL

        vector(0, +1 * mag, 0), # OA
        vector(+1 * mag, 0, -1 * mag), # OR
        vector(0, +1 * mag, -1 * mag), # O-AU
        vector(+1 * mag, +1 * mag, -1 * mag) # O-PP
    ) 

    for n, k in enumerate(edge_coefficients):
        sphere(pos=k, radius=rad, color=pyrand.choice(colours))

def render_arrow(mag):
    """
    mag (scalar) = magnitude of the arrow
    ax (vector) = the directon of the arrow
    
    """

    arrow(pos = vector(
            0, 0, -1 * mag
        ), axis = vector(
            +1 * mag, +1 * mag, +1 * mag
        ), color = color.blue)

render_cubedge(6, 0.5)
render_arrow(6)

# References
# Chabay, R. W. & Sherwood, B. A. (2015). Matter and Interactions
# [Fourth Edition, Hardcover]. John Wiley & Sons.
