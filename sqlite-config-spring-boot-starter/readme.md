About
===
- sqlite-based read only db for configurations
- with sample db 
- created at build time with flyway migrations
- with sample plain jdbc repository class
- use via spring boot starter dependency 

Quickstart
===
- include spring starter dependency in pom
    ```xml
    <dependency>
        <groupId>com.example</groupId>
        <artifactId>sqlite-config-starter</artifactId>
        <version>0.0.1-SNAPSHOT</version>
    </dependency>
    ```
- use the optional property `sqliteconfig.location` to override db location
  - don't
- default location is: `jdbc:sqlite::resource:conf.db`

Modules
===
Project is separated into Maven Modules

sqlite-config-lib
---
- repository base class for config resolver
- plain java

sqlite-config-db
---
- sqlite database 
- generated at buildtime via flyway migrations
- adds db to classpath as resource with default name

sqlite-config-autoconfigure
---
- spring configuration for plain java repository with defaults

sqlite-config-starter
---
- convenience class to include in spring boot project dependencies
- bundles library, database, configuration

