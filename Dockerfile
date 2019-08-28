FROM openjdk:11
COPY . /tmp
WORKDIR /tmp
RUN apt-get update -y && apt-get install maven -y
RUN mvn clean package -DskipTests
RUN pwd && ls -lah
COPY target/springdatademo-*.jar /tmp/app.jar
CMD ["java","-jar", "/tmp/app.jar"]
EXPOSE 8081
