package com.cayirozu.accounting;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

@SpringBootTest
class FinancialAccountingSpringbootApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void TestSQLServerConnection() {
        String connectionString = "jdbc:sqlserver://localhost:1433;" +
                "databaseName=onlineaccounting;integratedSecurity=true";
        boolean didConnect = false;

        try (
                Connection connection = DriverManager.getConnection(connectionString);
                Statement statement = connection.createStatement()) {

            didConnect = statement.execute("Select getdate()");
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }

        assert didConnect = true;
    }
}
