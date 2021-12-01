# Background of CI/CD

## History

With the dawn of Agile Software development the build, deploy and test must be executed way more often, it must be automated. This lead to Continuous Development/Contiuous Deployment ("CI/CD") pipelines [(_[1] Arachchi & Perera, 2018_)](#1).
These pipelines are deeply integrated with source control systems, today that translates to a git integration. Git is a distributed source control system for large projects, created for coordinating the Linux developments. As such it supports everything needed in large projects. Its main concept is to clone repositories, each developer works on his copy and when checking in the changed files, the code is merged [(_[2] Loeliger & McCullough, 2012_)](#2).

Today, building professional software is done in the following steps:

1. The developer commits and pushes his changes into a central git repository
2. If the push succeeds (no conflicts) a set of actions is triggered automatically
3. One action is the compilition (build) of the software
4. Another action is running the unit testing
5. Often there are additional tests like Linting, completeness of class and method documentation, typical security related tests.
6. If all tests passed the branch is merged with the main branch by an administrator
7. This triggers some of the same actions plus larger integration tests

This works very well for software libraries but gets more difficult the more dependencies exist and the more abstract the test is.
For example testing a graphical user interface in an automated way requires the software to move the mouse and type text. But in addition the UI has many states. Pressing on the same button causes different effects, e.g. clicking on Save the first time opens a dialog to type in the file name and location, all subsequent clicks just update the file.
Therefore a test must start at the same initial state and go through the entire sequence of user interactions in the correct order.
For database applications that would translate to an empty database or a database with a well defined data set in the tables.
If the database application is small and independent this might be doable. Expensive, but doable. 
But for a large Enterprise Resource Planning application like SAP R/3 or SAP S/4Hana, the numbers of tables go into the 100'000 and the dependencies are very high. A sales order has impact on other sales related data like shipment planning, but also production planning, material management, purchasing of raw materials, financials, HR,...





## References

<a id="1">[1]</a> S. A. I. B. S. Arachchi and I. Perera, "Continuous Integration and Continuous Delivery Pipeline Automation for Agile Software Project Management", "2018 Moratuwa Engineering Research Conference (MERCon)", 2018, pp. 156-161, doi: 10.1109/MERCon.2018.8421965.

<a id="2">[2]</a> Loeliger, J., & McCullough, M. (2012). "Version Control with Git: Powerful tools and techniques for collaborative software development.", "O'Reilly Media, Inc.", [link](http://appcursosdegraca.s3.amazonaws.com/apostilas-en/information-technology/it-tools/version-control-with-git-by-jon-loeliger.pdf).
