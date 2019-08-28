FROM openjdk:11
COPY . /tmp
WORKDIR /tmp
RUN apt-get update -y && apt-get install maven -y
RUN mvn clean package -DskipTests
RUN pwd && ls -lah
RUN cp /tmp/target/springdatademo-0.0.1-SNAPSHOT.jar /tmp/app.jar
CMD ["java","-jar", "/tmp/app.jar"]
EXPOSE 8081
