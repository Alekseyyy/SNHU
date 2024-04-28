
<img src="./banner.png" width="750px;" />

> "Students will apply software engineering testing strategies and practices as part of the software development lifecycle, including requirements analysis, verification and validation, and quality management. The creation of unit tests and analysis of various testing approaches will also be covered." - Course Description of [CS-320: Software Testing, Automation, and Quality Assurance](https://archive.today/rcw2t)

## Projects

* The [Case Study](./case-study): is the project that I developed throughout the course. It is a Java library that implements an in-memory database where information is stored with a unique ``String`` ID and a corresponding abstract data type as its value. The intresting stuff comes in where I use the [JUnit 5 Unit Testing Framework](https://junit.org/junit5/) to demonstrate that the library did its computations correctly. 
* The [final paper](./7-2_Final.pdf) is where I document my experiences programming the in-memory database and writing ``public class`` that take the place of a C/C++ ``struct`` to store properties of a "kind" of thing. ``Strings`` (and a ``java.util.Date`` object) define what makes for an abstract type, storing information that is in accordance with constraints supplied by design documentation in the form of project requirements.

## Reflection

I want to address prompts asked by the portfolio project:

<details>
<summary>How can I ensure that my code, program, or software is functional and secure?</summary>

The main way to ensure that software is correct is to demonstrate it with software testing. In the case of Java programming, I used the _JUnit Framework_ to demonstrate that the software behaved in the way that it is expected to. There are more sophisticated methods, like [provably correct systems](https://www.infoq.com/news/2015/05/provably-correct-software/), that can be employed to give a final proof that software is correctly implemented.

</details>

<details>
<summary>How do I interpret user needs and incorporate them into a program?</summary>

To incorporate a user's needs into a computer program, I need to borrow ideas from social science. I will start by conducting market research which will lead to me to identify a problem. I would then formalise that problem, and then  define project requirements and constraints.

</details>

<details>
<summary>How do I approach designing software?</summary>

After interpreting a user's needs into a program, or rather project requirements and constraints, I like to come up with a "caveman" intuitive approach with a procedure "built in" _ex post_ without a general solution. I would use tools like flowcharts and UML diagrams to help develop a general solution. I would then implement the solution while employing a number of software engineering strategies \(discussed in chapter 3 of [Filho 2017](https://www.amazon.com/Computer-Science-Distilled-Computational-Problems/dp/0997316020)\). I would then develop the software and test it with automation software testing frameworks. The process would repeat itself until the software is mature enough, as defined by project requirements and constraints, to be deployed to the end user.

</details>

## Coursework

* [CS-330\*: Assignment 1-3: Module 1 Journal](./journals/1-3.pdf)
* [CS-330\*: Assignment 2-2: Module 2 Journal](./journals/2-2.pdf)
* [CS-320: Assignment 4-2: Module 4 Journal](./journals/4-2.pdf)
* [CS-320: Assignment 5-2: Module 5 Journal](./journals/5-2.pdf)

\* Note that: I accidently wrote "CS-330" where I should have written "CS-320."

## References

* Filho, W. F. (2017). _Computer Science Distilled: Learn the Art of Solving Computational Problems_. Code Energy.


