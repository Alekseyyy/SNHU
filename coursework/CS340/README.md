
<center>

![banner](./banner.png)

</center>

<p><b>Note that some of the banner's components are from: <a href="https://www.youtube.com/watch?v=VPVnFHBdWKM" target="_blank">Lidi (2020)</b></a></p>

> "\[In this course\], \[s\]tudents will learn how to apply database systems concepts and principles to develop client/server applications that interface client-side code with databases." ---[CS-340 Syllabus](./resources/Syllabus.pdf)

_Client/Server Development (CS-340)_ is about developing client-side web applications that interact with various networked services. Specifically, this class concerns itself with the development of tools and web interfaces in the Python programming language to interact with the non-relational database management service called MongoDB. 

In this course, I have worked with with developing MongoDB queries for CRUD operations, using the Python ``pymongo`` library to interface with MongoDB instances, and then using Python's Dash framework to visualise datasets stored in the form of key/value pairs that constitute a "document" in a MongoDB "collection" of many other documents of the same kind.

## Project

The work done in this course culminated into a full-stack web application that I have called _The Animal Tracker Database_. It consists of a MongoDB database management system, a custom "Python CRUD Module," and a front-end web application written in the Python programming language, and invoking the Dash framework with its respective supporting third-party modules. 

The [Dashboard Specifications Document](./project/Dashboard%20Specifications%20Document.pdf) describes and defines the software engineering problem, and discusses its constraints.

### Acknowledgements

I don't think that I could have developed _The Animal Tracker Database_ without the (in)direct help of other people. I must thank former SNHU students Victor Udeh and Joseph Dengler, as I referenced their versions of the project when I "got stuck" on certain subtasks. I must also thank Professor Jeff H. Sanford for his guidance and helpful feedback - which formed the basis for good progress.

### Codebase

This project's codebase consists of the following key programme files:

* [``CRUD_Python_Module.py``](./project/code/CRUD_Python_Module.py): the core library that consists of the _create, read update, and delete_ (CRUD) functionality to make transactions with a MongoDB server. 
    * [``CRUD_Test_Harness.py``](./project/code/CRUD_Test_Harness.py): a custom test harness that I used to test the ``CRUD_Python_Module.py`` functionality. __PLEASE NOTE THAT:__ these tests only demonstrate the Python CRUD Module's functionality as a proof-of-concept, __not as a mature product that can be deployed "into the wild."__
* [``Project_2_WebApp.py``](./project/code/Project_2_WebApp.py): the actual web application front-end that invokes the ``CRUD_Python_Module.py`` to make transactions with the MongoDB instance, and then render information in its database into interactive "easy to interpret" charts and tables.
* [``aac_shelter_outcomes.csv``](./project/code/aac_shelter_outcomes.csv): the [Animal Shelter (2016)](https://doi.org/10.26000/025.000001) dataset which was modelled by the web application.
* [``Jupyters.zip``](./project/code/Jupyters.zip): this is a ZIP archive of the source code of the Python Dash web application in the form of a Jupyter Notebook.

Furthermore, this project's development and usage has been documented in the form of comprehensive __technical writeups__, and more condensed __"README"-style usage manuals__. They can be accessed over at:

* Project 1 _README_: \([pdf](./project/CRUD%20Module%20README%20(Project%201).pdf), [docx](./project/CRUD%20Module%20README%20(Project%201).docx)\).
    * Project 1 _Technical Writeup_: \([pdf](./project/Project%201_Writeup.pdf)\).
* Project 2 _README_: \([pdf](./project/Python%20Dash%20WebApp%20README%20(Project%202).pdf), [docx](./project/Python%20Dash%20WebApp%20README%20(Project%202).docx)\).
    * Project 2 _Technical Writeup_: \([pdf](./project/Project%202_Writeup.pdf)\).

### Screencast

I have also prepared a screencast which demonstrates a usage of the front-end web application component of _The Animal Tracker Database_, which [can be watched on YouTube](https://www.youtube.com/watch?v=73yvD0kBQGE):

<a href="https://www.youtube.com/watch?v=73yvD0kBQGE" target="_blank">
  <img src="./project/ythumb-screencast.png" width="550px" />
</a>

## Homework

Each module came with an "journaling" assignment, which existed to demonstrate competence in a particular aspect of the course, and/or to slowly develop the resulting Projects 1 and 2. 

* [Assignment 1-3](./homework/1-3) \([writeup](./homework/1-3/writeup.pdf)\): about data modelling with MongoDB.
* [Assignment 2-1](./homework/2-1) \([writeup](./homework/2-1/writeup.pdf)\): about CRUD transactions with MongoDB.
* [Assignment 3-1](./homework/3-1) \([writeup](./homework/3-1/writeup.pdf)\): about indexing and systems administration in MongoDB.
* [Assignment 4-1](./homework/4-1) \([writeup](./homework/4-1/writeup.pdf)\): about interacting with MongoDB with Python and ``pymongo``.
* [Assignment 5-2](./homework/5-2) \([writeup](./homework/5-2/writeup.pdf)\): introduction to the Python Dash framework for build web applications.
* [Assignment 6-1](./homework/6-1) \([writeup](./homework/6-1/writeup.pdf)\): adding basic interactive components in a Dash webapp.

### Prompts Regarding the 8-2 Assignment

Assignment 8-2 involves creating a ``README`` file that addresses three prompts. These are my answers to them:

<details>
<summary>Q1: Good Software Design</summary>

> "How do you write programs that are maintainable, readable, and adaptable? Especially consider your work on the CRUD Python module from Project One, which you used to connect the dashboard widgets to the database in Project Two. What were the advantages of working in this way? How else could you use this CRUD Python module in the future?"

A software product must be mature before it can be deployed into a hostile cloud service - where it will be subjected to "tall orders" from many end-users, along with malicious hackers trying to break it in order to steal confidential information or just cause general mayhem. A few things that can be done are as follows:

1. Apply good software design practices like [refactoring](https://refactoring.guru/refactoring) and code peer review from experts.
2. Apply good secure coding --- including but not limited to: [linting](https://www.perforce.com/blog/qac/what-is-linting), extensive [unit testing](https://www.dataquest.io/blog/unit-tests-python/), software [fuzzing and fault injection](https://www.fuzzingbook.org/html/Fuzzer.html), and, depending on the severity of the assets involved, [provably correct systems](https://engineering.cmu.edu/news-events/news/2024/12/23-provably-correct-software.html)
3. If deploying the product to the cloud, as opposed to a "sideloaded" desktop application, consider making use of a [content delivery network](https://www.akamai.com/glossary/what-is-a-cdn), [load balancer](https://www.f5.com/glossary/load-balancer), network firewall, [web application firewall](https://www.cloudflare.com/learning/ddos/glossary/web-application-firewall-waf/) and [web shell / server-side backdoor detection](https://redcanary.com/threat-detection-report/trends/webshells/). 

</details>

<details>
<summary>Q2: How I go about solving software engineering problems</summary>

> "How do you approach a problem as a computer scientist? Consider how you approached the database or dashboard requirements that Grazioso Salvare requested. How did your approach to this project differ from previous assignments in other courses? What techniques or strategies would you use in the future to create databases to meet other client requests?"

When approaching a computer science or software engineering problem, I first try to get a deep understanding of the problem. Such a "deep" understanding of the thing that needs to be worked out, along with the appropriate constraints, will give me an idea of what kind of software solution is needed. 

Personally, when I begin writing code, I start out by writing a "caveman" solution, where I simply want the programme to run and reliably make calculations. After this "caveman code" is worked out, I try to identify inefficiencies with what I have written, and then eliminate them. I also try to get "second opinions" from more experience coders. 

</details>

<details>
<summary>Q3: The need for computer science</summary>

> "What do computer scientists do, and why does it matter? How would your work on this type of project help a company, like Grazioso Salvare, to do their work better?"

Computer science is a "hodgepoge" of several disciplines, like mathematics, physics, and engineering. Computer scientists can work on theoretical problems, or apply computer science principles to solving applied problems. Regarding the former, theoretical computer science is important, because progress made in finding abstract, generalised and efficient solutions to computational problems will benefit societies at large. 

Regarding the latter, applied computer science can benefit individuals, organizations and even society at large (see the _Free and Open Source Software_ movement). Applied computer scientists can use their understanding of principles of computing and informatics to design and implement complex systems that can work at scale. It is indeed possible to write software without much computer science knowledge, but such solutions will be limited (and highly dependent on third-party tools developed by computer scientists).

</details>
 

## Resources

### Course Textbook

The following textbook was used as the primary reference when learning and implementing the material that is the concern of this course:

<a href="https://search.worldcat.org/title/1343909393" target="_blank"><img src="./resources/Textbook%20Cover.jpg" width="400px" /></a>

### Other Resources

* \[todo\]
