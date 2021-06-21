### Document application related issues faced and solutions here

#### Issues faced

- Error running spring boot application: To resolve add spring-boot application plugin.
  ```groovy
    plugins {
    id 'org.springframework.boot' version '2.5.0'
    id 'io.spring.dependency-management' version '1.0.11.RELEASE'
    }
