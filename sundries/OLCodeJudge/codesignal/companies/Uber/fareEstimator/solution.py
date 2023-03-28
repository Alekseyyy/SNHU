# CodeSignal Company Challenges
#
# A solution to Uber's "fareEstimator" challenge
# By A. S. "Aleksey" Ahmann, hackermaneia@riseup.net
#

def fareEstimator(ride_time, ride_distance, cost_per_minute, cost_per_mile):
    y, f = [], lambda w, x, y, z: (w * x) + (y * z)
    for a, b in zip(cost_per_minute, cost_per_mile):
        y.append(f(a, ride_time, b, ride_distance))
    return y
