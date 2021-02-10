package com.bakery.management;

import com.bakery.management.graphql.datafetchers.AddressDataFetcher;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class BakeryTests {

    ///***
    // * Dumb test.
    // */
    //@Test
    //void contextLoads() {
    //    assertTrue(true);
    //}

    // todo: Add graphql java implementation unit tests.

}
