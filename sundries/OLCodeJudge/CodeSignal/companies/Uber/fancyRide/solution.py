# CodeSignal Company Challenges
#
# A solution to Uber's "fancyRide" challenge
# By A. S. "Aleksey" Ahmann, hackermaneia@riseup.net
#

def fancyRide(l, fares):
    winner = None
    for x, y in zip([l * fare for fare in fares], ["UberX", "UberXL", "UberPlus", "UberBlack", "UberSUV"]):
        if x > 20:
            return winner
        else:
            winner = y
    return winner
