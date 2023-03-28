import sys
import angr

target = angr.Project("game")
init_st = target.factory.entry_state()
sim = target.factory.simgr(init_st)

def is_successful(state):
    std_output = state.posix.dumps(sys.stdout.fileno())
    return "picoCTF{th1s_1s_a_t3st_flag}" in std_output.decode("utf-8")

sim.explore(find=is_successful)
if sim.found:
    sol_state = sim.found[0]
    print("Found solution:", sol_state.posix.dumps(sys.stdin.fileno()))
