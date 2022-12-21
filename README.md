# Check Runner
***
The project is a console application that implements the functionality of generating
a receipt in a store. The application accepts products and a discount card as 
parameters and then generates and prints a check.
## Technologies
***
* Java 17
* Gradle 7.5
## Installation and execution
***
Installation:
* Clone project from repository.
* Build it with gradle.

Execution:

To execute project you need to navigate to folder `<project path>/build/libs` and run command 
`java -jar CheckRunner-1.0-SNAPSHOT.jar <your params>`. Param pattern is "id-amount" for products
and "card-card number" for cards.