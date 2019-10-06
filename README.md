# Spring Boot War Deployment 
Spring Boot War Deployment project created to showcase WAR file deployment in Tomcat along with environment variables

### How to run?
1. Create `springdatademo` database in MySql database
2. Run the project and it will create **Category** table and also inserts data using following commands
```
INSERT INTO `springdatademo`.`category` (`id`, `description`, `name`) VALUES ('1001', 'Books', 'Books');
INSERT INTO `springdatademo`.`category` (`id`, `description`, `name`) VALUES ('1002', 'Electronics', 'Electronics');

```
3.Create stored procedure named `get_all_categories` in database
   ```
   DELIMITER $$
   CREATE DEFINER=`root`@`localhost` PROCEDURE `get_all_categories`()
   BEGIN
   	select * from category;
   END$$
   DELIMITER ;
   
   ``` 

4.Go to http://localhost:8081/api/v1/category/list to see all categories 

## How to pass environment variables to WAR file in Apache Tomcat?
1. To pass environment variables to WAR file that is being deployed in Tomcat, create file `setenv.sh` under `<Tomcat Home>/bin/` directory and add the following values. 
    ```
    export JAVA_OPTS="$JAVA_OPTS -Dspring.profiles.active=dev"
    export JAVA_OPTS="$JAVA_OPTS -Dmysql_username=root"
    export JAVA_OPTS="$JAVA_OPTS -Dmysql_password=bcmc1234"
    ```
2. Add as many variables as you like and these variables will be available in `application.yml` and `System.getProperty("mysql_username")`
