# qualitymatters-java-cucumber

## Tool Overview
A Behavior-Driven Development (BDD) Tool for Writing Acceptance Tests Using the Gherkin Language.

This tool leverages Behavior-Driven Development (BDD) principles to facilitate the writing of acceptance tests. 
It utilizes the Gherkin language, which is designed to be easily readable and understandable by both technical and non-technical stakeholders. 

By using this tool, development teams can define clear and concise acceptance tests, covering acceptance criteria that bridge the gaps between business requirements and technical implementation.


### API Test Sample - Why using CRUD?
All tests are targeted against a simple Springboot application located below, with CRUD operations via Restful.  Start the application before running the tests.  

```link
https://github.com/mariogalea/qualitymatters-springboot-restfulapi
```

This provides basic CRUD operations via Restful, which will allow a full demo of all possible scenario examples of the Gherkin Language, including: 
- Scenario 
- Scenario Outline 
- Scenario Data Tables
- Backgrounds


### JAVA Package and Folder Structure
```bash
src\main\java
├── io.qualitymatters.bdd.
│   ├── booking.
│   │   ├── actions
│   │   ├── pojo
│   ├── utilities

src\test\java
├── StepDefinitions

src\test\resources\booking
```


#### Main Folder and Packages
In the sources folder, all business logic should be placed under package io.qualitymatters.bdd.

*Booking* is the root for business logic, thus, all actions are located under package io.qualitymatters.bdd.booking.actions.
Similar to actions, any responses related to booking, are to be converted into POJOs, and should be packaged here as well - io.qualitymatters.bdd.booking.pojo.

Finally, the *utilities* package are in a level higher than booking, as utilities can be used for multiple business logic and functionality.  

This makes the testing app scalable, and shippable.  Scalable since it can expand on existing logic, and new logic.  Shippable as it can be distributed between multiple teams contributing towards different business logic.  


#### Test Folder and Packages
The test folder holds the *StepDefinitions* package and the Feature Files - *Booking.feature*.  Feature files are the human readable files - the tests themselves.  Everything connects to this file, which should be located in the resources folder.  Behaviours are structured as per business logic, so all features / behaviours related to booking, should be placed in the booking folder.  



