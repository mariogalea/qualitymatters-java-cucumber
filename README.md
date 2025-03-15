# qualitymatters-java-cucumber

## Tool Overview

A Behavior-Driven Development (BDD) Tool for Writing Acceptance Tests Using the Gherkin Language.

This tool leverages Behavior-Driven Development (BDD) principles to facilitate the writing of acceptance tests. 
It utilizes the Gherkin language, which is designed to be easily readable and understandable by both technical and non-technical stakeholders. 

By using this tool, development teams can define clear and concise acceptance tests, covering acceptance criteria that bridges the gap between business requirements and technical implementation.

### API Test Sample - Why using CRUD?

All tests are using a simple Restful API example located below:

```link
https://github.com/mariogalea/qualitymatters-springboot-restfulapi
```


This provides basic CRUD operations via Restful, which will allow a full demo of all possible scenario examples of the Gherkin Language, including: 
- Scenario 
- Scenario Outline 
- Scenarios with Data Tables.  
- Backgrounds


### Folder Structure

```bash
├── app
│   ├── css
│   │   ├── **/*.css
│   ├── favicon.ico
│   ├── images
│   ├── index.html
│   ├── js
│   │   ├── **/*.js
│   └── partials/template
├── dist (or build)
├── node_modules
├── bower_components (if using bower)
├── test
├── Gruntfile.js/gulpfile.js
├── README.md
├── package.json
├── bower.json (if using bower)
└── .gitignore
```

