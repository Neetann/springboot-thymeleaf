FROM java:8

EXPOSE 8080

ADD target/springbootThymeleaf.jar springbootThymeleaf.jar

ENTRYPOINT ["java","-jar","springbootThymeleaf.jar"]