# Spring Boot War Deployment 
Spring Boot War Deployment project created to showcase WAR file deployment in Tomcat along with environment variables

### How to run?
1. Build the project project using 
```
mvn clean package -DskipTests
```
2. Copy then WAR file from `/target` directory to Tomcat `<TOMCAT_HOME>/webapps/`
2. Go to http://localhost:8081/springdatademo/api/v1/category/create to create category
3. Go to http://localhost:8081/springdatademo/api/v1/category/list to see all categories 

## How to pass environment variables to WAR file in Apache Tomcat?
1. To pass environment variables to WAR file that is being deployed in Tomcat, create file `setenv.sh` under `<Tomcat Home>/bin/` directory and add the following values. 
    ```
    export JAVA_OPTS="$JAVA_OPTS -Dspring.profiles.active=dev"
    export JAVA_OPTS="$JAVA_OPTS -Dmysql_username=root"
    export JAVA_OPTS="$JAVA_OPTS -Dmysql_password=bcmc1234"
    ```
2. Add as many variables as you like and these variables will be available in `application.yml` and `System.getProperty("mysql_username")`
