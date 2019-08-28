FROM openjdk:11
COPY target/springdatademo-*.jar app.jar
CMD ["java","-jar", "app.jar"]
EXPOSE 8081
