
## Artemis Financial: Project 2
### Spring Web Application Code Review and Cryptography

This project is my work in the code assessment, refactoring and cryptography, and my documentation of the procedure.<sup>[1,2]</sup> This project involves myself employed by a hypothetical software engineering company called _Global Rain_, where I was tasked to secure a web application by _Artemis Financial_. 

Artemis Financial is, like its name implies, a company that assists its clients in selecting the optimal financial instruments for long term investments.<sup>[3]</sup> Their line of work further implies that the confidentality and integrity of client data is of the upmost importance.<sup>[5]</sup> I was tasked with documenting vulnerable dependencies, refactoring the code and implementing cryptographic schemes.<sup>[3]</sup>

I felt that I did a decent job in identifying vulnerable dependencies<sup>[4]</sup> and configuring the web application SSL/TLS certificate, and making use of the SHA-512/256 hashing procedure.<sup>[5]</sup> I think that I may have done poorly in the manual identification of software vulnerabilities in code--- something that can be worked on with experience.<sup>[6]</sup> To get around my limitations, I advised _Artemis Financial_ to consult other security engineers to inspect the code.

I was able to increase the security of the system by introducing a function that hashes data structres and integrating SSL/TLS into the web application for data in transit.<sup>[7]</sup> I used _Apache Maven_ and ``keytool`` to solve the security problems posed to myself. I may have introduced new vulnerabilities into the system through my implenentations and sadly did not further assess them.<sup>[8]</sup> I recommend that other security engineers assess the project and my refactoring for any possible "software iatrogenics." <sup>[10]</sup>

Security engineering and secure coding are important in deploying software applications. I think that while this college assignment may be a toy problem in secure coding, it can be good stuff in demonstrating competence in secure coding. I will need experience with more toy problems and "real life" ecological problems involving secure coding and cybersecurity in general. But this coding project is a good start.<sup>[9]</sup>

## Endnotes

1. Due to technical issues and time constraints, this project may not have been my best work.
2. Specifically, this is assignment 7-1.
3. This answers bullet point 1 in the 8-1 guidelines.
4. To be fair, that was _Apache Maven_ doing all the hard work. I was just configuring and setting it up ;-)
5. This answers bullet point 2 in the 8-1 guidelines.
6. This answers bullet point 3 in the 8-1 guidelines.
7. This answers bullet point 4 in the 8-1 guidelines.
8. This answers bullet point 5 in the 8-1 guidelines.
9. This answers bullet point 6 in the 8-1 guidelines.
10. Not in my original report, but in this ``README.md`` document.
