# CodeSignal Company Challenges
#
# A solution to SpaceX's "launchSequenceChecker" challenge
# By A. S. "Aleksey" Ahmann, <alexander.ahmann@outlook.com>
#

def launchSequenceChecker(systemNames, stepNumbers):
    sn = {}
    for n, k in enumerate(systemNames):
        if k not in sn:
            sn[k] = []
            sn[k].append(stepNumbers[n])
        else:
            sn[k].append(stepNumbers[n])
    for k, v in sn.items():
        if len(v) == 1:
            continue
        else:
            i = 1
            while i < len(v):
                if v[i] <= v[i - 1]:
                    return False
                i += 1
    return True
