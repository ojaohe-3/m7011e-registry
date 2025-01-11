# The Homeric Odyssey - Registry Module

The Registry module is a core component of The Homeric Odyssey system, responsible for maintaining all the primary entities and their relationships.

## Overview
This registry keeps track of users and keeps supposed to keep the in sync with a keycloak integration
this however was not completed.


## Getting Started
Requirements
JDK version 21 and JAVA_HOME is set.

To run locally and to dev, requires that gradle.properties is set in the GRADLE_HOME (or GRADLE_USER_HOME)
to something like this:
```groovy
reposiliteUser=<user>
reposiliteSecret=<token>
reposiliteUrl=<repository url>
```

