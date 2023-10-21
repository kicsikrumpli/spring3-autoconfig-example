impl. notes
---

For autoconfiguration: 
- Spring 2 uses META-INF/spring.factories
  - `org.springframework.boot.autoconfigure.EnableAutoConfiguration=<list autoconfig classes>` 
- Spring 3 uses META-INF/spring/org.springframework.boot.autoconfigure.AutoConfiguration.imports
  - autoconfig classes by FQN, one per line

see: 
- https://stackoverflow.com/questions/75313425/unable-to-create-custom-spring-boot-starter-autoconfiguration/75314073#75314073
- https://docs.spring.io/spring-boot/docs/current/reference/html/features.html#features.developing-auto-configuration
