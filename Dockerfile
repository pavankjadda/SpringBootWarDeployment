#FROM openjdk:11
FROM openjdk:11.0.4-jdk-slim-buster
COPY . /app
WORKDIR /app
#RUN mkdir -p /usr/share/man/man1
RUN apt-get update -y && apt-get install maven -y
RUN mvn clean package -DskipTests
RUN cp /app/target/springdatademo-*.jar /app/springdatademo.jar
CMD ["java","-Dspring.profile.active=test","-jar", "/app/springdatademo.jar"]
EXPOSE 8090
