FROM java:8

EXPOSE 8080

ADD target/springboot-thymeleaf-crud-web-app.jar springboot-thymeleaf-crud-web-app.jar

ENTRYPOINT ["java","-jar","springboot-thymeleaf-crud-web-app.jar"]