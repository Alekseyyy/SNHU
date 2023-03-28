# two-sum

Author: Mubarak Mikail
Location: https://play.picoctf.org/events/72/challenges/challenge/382
Tags: Binary Exploitation, C, make

## Problem

> __Due to Instance Launching maintenance, you may access the challenge download file to work offline:__ What two positive numbers can make this possible: ``n1 > n1 + n2 OR n2 > n1 + n2``? [Source](https://artifacts.picoctf.net/c/454/flag.c). Can you solve this? Additional details will be available after launching your challenge instance.

## Solution

I began by launching the instance associated with this challenge (Figure 1) and was presented with a means to communicate with said instance --- ``nc saturn.picoctf.net 49205`` --- and two hints:

1. Integer overflow.
2. Not necessarily a math problem.

There are two approaches that I can use to go about exploiting this bug: exploiting the integer overflow bug, or trying to find a solution to the expression. I will start with the integer overflow method first, and the maybe exploit it through a maths problem. I downloaded the ``flag.c`` file and began looking for integer overflow bugs. I started by "winging it" a little:

```
dna@deniers:~/two-sum$ nc saturn.picoctf.net 55064
n1 > n1 + n2 OR n2 > n1 + n2 
What two positive numbers can make this possible: 
2 2
You entered 2 and 2
No overflow
222222222222222222222222222 2
dna@deniers:~/two-sum$ nc saturn.picoctf.net 55064

```

I did some research into integer overflows and found a couple of explainations. [1][2] My technique was to find what kind of integers were being accepted by the vulnerable appplication through its source code. The following is the relevant bits of the ``main()`` function:

```c++
int main() {
    int num1, num2, sum;
    FILE *flag;
    char c;

    printf("n1 > n1 + n2 OR n2 > n1 + n2 \n");
    fflush(stdout);
    printf("What two positive numbers can make this possible: \n");
    fflush(stdout);
    
    if (scanf("%d", &num1) && scanf("%d", &num2)) {
        printf("You entered %d and %d\n", num1, num2);
        fflush(stdout);
        sum = num1 + num2;
        if (addIntOvf(sum, num1, num2) == 0) {
            printf("No overflow\n");
            fflush(stdout);
            exit(0);
        } else if (addIntOvf(sum, num1, num2) == -1) {
            printf("You have an integer overflow\n");
            fflush(stdout);
        }

[... snip ...]
```

The sum of the inputs are sent to a function called ``addIntOvf()``:

```c++ 
static int addIntOvf(int result, int a, int b) {
    result = a + b;
    if(a > 0 && b > 0 && result < 0)
        return -1;
    if(a < 0 && b < 0 && result > 0)
        return -1;
    return 0;
}
```

The maximum of the ``signed int`` variable is ``2147483647``, and an integer overflow with signed integers can be exploited with really basic arithmetic. I want to create a situation where the first input is greater than the second input _plus_ the first input. This initially seems impossible to do through mathematics, but can be done through a rather clever technique shown below:

```
dna@deniers:~/two-sum$ nc saturn.picoctf.net 55064
n1 > n1 + n2 OR n2 > n1 + n2 
What two positive numbers can make this possible: 
2147483647 1
You entered 2147483647 and 1
You have an integer overflow
YOUR FLAG IS: picoCTF{Tw0_Sum_Integer_Bu773R_0v3rfl0w_f6ed8057}

^C
dna@deniers:~/two-sum$ 
```

## References

1. https://www.acunetix.com/blog/web-security-zone/what-is-integer-overflow/
2. https://users.cs.utah.edu/~regehr/papers/overflow12.pdf
3. https://learn.microsoft.com/en-us/cpp/c-language/cpp-integer-limits
