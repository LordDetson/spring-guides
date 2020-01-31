# Accessing Relational Data using JDBC with Spring

### Description

You will build an application that uses Spring’s **JdbcTemplate** to access data stored in a relational database.

Most JDBC code is mired in resource acquisition, connection management, exception handling, and general error checking that is wholly unrelated to what the code is meant to achieve. The **JdbcTemplate** takes care of all of that for you.

Spring Boot supports H2 (an in-memory relational database engine) and automatically creates a connection. Because we use *spring-jdbc*, Spring Boot automatically creates a **JdbcTemplate**.

First, install some DDL by using the execute method of **JdbcTemplate**.

Then install some records in your newly created table by using the `batchUpdate` method of **JdbcTemplate**. The first argument to the method call is the query string. The last argument (the array of Object instances) holds the variables to be substituted into the query where the ? characters are.

_For single insert statements, the `insert` method of **JdbcTemplate** is good. However, for multiple inserts, it is better to use batchUpdate._

Finally, use the `query` method to search your table for records that match the criteria. You again use the ? arguments to create parameters for the query, passing in the actual values when you make the call. The last argument is a Java 8 lambda that is used to convert each result row into a new `Customer` object.

Main lines:

    jdbcTemplate.execute("CREATE TABLE `customer`(`id` SERIAL, `first_name` VARCHAR(255), `last_name` VARCHAR(255))");

    jdbcTemplate.batchUpdate("INSERT INTO `customer`(`first_name`, `last_name`) VALUES (?,?)", splitUpNames);
    
    jdbcTemplate.query("SELECT `id`, `first_name`, `last_name` FROM `customer` WHERE `first_name` = ?", new Object[]{"Josh"},
                        (rs, rowNum) -> new Customer(rs.getLong("id"), rs.getString("first_name"), rs.getString("last_name")))
                        .forEach(customer -> log.info(customer.toString()));