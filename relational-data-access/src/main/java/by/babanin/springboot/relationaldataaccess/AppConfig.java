package by.babanin.springboot.relationaldataaccess;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Configuration
public class AppConfig {
    private static final Logger log = LoggerFactory.getLogger(AppConfig.class);
    private final JdbcTemplate jdbcTemplate;

    public AppConfig(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {
            log.info("Creating tables");

            jdbcTemplate.execute("DROP TABLE `customer` IF EXISTS");
            jdbcTemplate.execute("CREATE TABLE `customer`(`id` SERIAL, `first_name` VARCHAR(255), `last_name` VARCHAR(255))");

            List<Object[]> splitUpNames  = Stream.of("John Woo", "Jeff Dean", "Josh Bloch", "Josh Long")
                    .map(name -> name.split(" "))
                    .collect(Collectors.toList());

            splitUpNames.forEach(names -> log.info("Inserting customer record for {} {}", names[0], names[1]));

            jdbcTemplate.batchUpdate("INSERT INTO `customer`(`first_name`, `last_name`) VALUES (?,?)", splitUpNames);

            log.info("Querying for customer records where first_name = 'Josh':");

            jdbcTemplate.query("SELECT `id`, `first_name`, `last_name` FROM `customer` WHERE `first_name` = ?", new Object[]{"Josh"},
                    (rs, rowNum) -> new Customer(rs.getLong("id"), rs.getString("first_name"), rs.getString("last_name")))
                    .forEach(customer -> log.info(customer.toString()));
        };
    }
}
