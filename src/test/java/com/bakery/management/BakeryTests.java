package com.bakery.management;

import com.bakery.management.graphql.datafetchers.AddressDataFetcher;
import graphql.cachecontrol.CacheControl;
import graphql.execution.ExecutionId;
import graphql.execution.ExecutionStepInfo;
import graphql.execution.MergedField;
import graphql.language.Document;
import graphql.language.Field;
import graphql.language.FragmentDefinition;
import graphql.language.OperationDefinition;
import graphql.schema.*;
import org.dataloader.DataLoader;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class BakeryTests {
    @Autowired
    private AddressDataFetcher addressDataFetcher;

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

    @Test
    @ParameterizedTest(name = "Address for Id {0} is not existing or inactive.")
    @ValueSource(ints = {2016, 2020, 2048})
    public void fetchAddress_ReturnsNullForNotExistOrInactiveAddress(int id) {
        DataFetchingEnvironment env = new DataFetchingEnvironment() {
            @Override
            public <T> T getSource() {
                return null;
            }

            @Override
            public Map<String, Object> getArguments() {
                return null;
            }

            @Override
            public boolean containsArgument(String name) {
                return false;
            }

            @Override
            public <T> T getArgument(String name) {
                return null;
            }

            @Override
            public <T> T getContext() {
                return null;
            }

            @Override
            public <T> T getLocalContext() {
                return null;
            }

            @Override
            public <T> T getRoot() {
                return null;
            }

            @Override
            public GraphQLFieldDefinition getFieldDefinition() {
                return null;
            }

            @Override
            public List<Field> getFields() {
                return null;
            }

            @Override
            public MergedField getMergedField() {
                return null;
            }

            @Override
            public Field getField() {
                return null;
            }

            @Override
            public GraphQLOutputType getFieldType() {
                return null;
            }

            @Override
            public ExecutionStepInfo getExecutionStepInfo() {
                return null;
            }

            @Override
            public GraphQLType getParentType() {
                return null;
            }

            @Override
            public GraphQLSchema getGraphQLSchema() {
                return null;
            }

            @Override
            public Map<String, FragmentDefinition> getFragmentsByName() {
                return null;
            }

            @Override
            public ExecutionId getExecutionId() {
                return null;
            }

            @Override
            public DataFetchingFieldSelectionSet getSelectionSet() {
                return null;
            }

            @Override
            public <K, V> DataLoader<K, V> getDataLoader(String dataLoaderName) {
                return null;
            }

            @Override
            public CacheControl getCacheControl() {
                return null;
            }

            @Override
            public OperationDefinition getOperationDefinition() {
                return null;
            }

            @Override
            public Document getDocument() {
                return null;
            }

            @Override
            public Map<String, Object> getVariables() {
                return null;
            }
        };

        var address = addressDataFetcher.fetchAddress();
        assertNotNull(address);
    }

    // TODO: Add graphql java implementation unit tests.

}
