FROM alpine:edge
COPY target/springdatademo-*.jar app.jar
ENTRYPOINT ["/usr/bin/java"]
CMD ["-jar", "app.jar"]
EXPOSE 8081
