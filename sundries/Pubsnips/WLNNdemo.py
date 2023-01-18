
import random
import streamlit as st
import matplotlib.pyplot as plt

st.title = "A demonstration of the weak interpretation of the law of large numbers"
st.markdown("""

## The (weak) law of large numbers demonstration
### By A. S. Ahmann

This is a small streamlit app to demonstrate the weak law of large numbers (WLLN) by simulating a game of craps involving one (1) six-faced fair dice. The WLNN states that as the number of trials in a probability experiment incrases, the expected value of its results will converge to the true expected value of the random process being studied.

In the case of the hypothetical game of craps, the expected value is: 

$$ \mathbb{E}[X] = \sum_{x = 1}^{6} (1/6) x = 3.5$$

To see this theorem "in action," move the slider below to increase or decrease the number of runs in the craps experiment. Everytime the slider is moved to a different value, it will rerun the experiment at the number of trials that it is set to.

""")

def plot_wlln(trials):
    fig, ax = plt.subplots()
    ax.xaxis.tick_top()
    
    ax.axhline(y = 3.5, color="black", label=r'$\mathbb{E}[X] = 3.5$')
    results, averages = [], []
    
    x_range = range(1, trials + 1)
    for k in x_range:
        results.append(random.randint(1, 6))
        averages.append(sum(results) / float(len(results)))
    plt.plot(x_range, averages, label="Empirical Average")
    ax.set_title("Number of trials", fontsize=14)
    ax.set_ylabel("Expected value", fontsize=14)
    ax.legend()
    return fig

trials = st.slider("Number of dice rolls", 10, 25000)
st.pyplot(plot_wlln(trials))

st.markdown("As you can see, the empirical average becomes much, much closer to the expected value of the single die as the number of trials increases. These computer simulations can be useful in determining a minimum sample size for statistical experiments.")

