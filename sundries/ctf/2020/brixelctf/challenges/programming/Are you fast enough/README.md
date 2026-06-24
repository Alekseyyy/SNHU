# Are you fast enough?

```
Can you program something that is fast enough to submit the solution before the time runs out?
http://timesink.be/speedy 
```

flag: ``brixelCTF{sp33d_d3m0n}``

This was was a bit of a doozy. I originally experimented with Python's ``requests`` module, but it didn't work. So I used selenium and downloaded the geckodriver (ver [0.28.0](https://github.com/mozilla/geckodriver/releases/tag/v0.28.0)) and whipped up a solution in (in Python ofc).

It's a bit stochastic, so you're gonna have to run the script a few times to get the flag.
