FROM openjdk:11
#FROM openjdk:11-slim
COPY . /app
WORKDIR /app
RUN apt-get update -y && apt-get install maven -y
RUN mvn clean package -DskipTests
RUN cp /app/target/springdatademo-*.jar /app/springdatademo.jar
CMD ["java","-jar", "/app/springdatademo.jar"]
EXPOSE 8090
