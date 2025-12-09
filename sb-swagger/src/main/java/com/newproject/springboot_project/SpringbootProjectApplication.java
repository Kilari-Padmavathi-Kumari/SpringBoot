package com.newproject.springboot_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootProjectApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootProjectApplication.class, args);
    }
}


/*<dependency>
    <groupId>org.springdoc</groupId>
    <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
    <version>2.5.0</version>
</dependency>

swagger dependencies add  type it on chrome and see the output
http://localhost:8080/swagger-ui/index.html

springdoc.swagger-ui.path=/my-ui.html  using this
http://localhost:8080/my-ui.html

#configure custom path for api docs  dow load yaml file and extract
#springdoc.api-doc.path=/my-api-docs
http://localhost:8080/my-api-docs.yaml
*/