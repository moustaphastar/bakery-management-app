package com.bakery.management.graphql;

import com.bakery.management.graphql.datafetchers.AddressDataFetcher;
import com.bakery.management.graphql.datafetchers.CashAccountDataFetcher;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import graphql.schema.idl.errors.SchemaProblem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static graphql.schema.idl.TypeRuntimeWiring.newTypeWiring;

/***
 * Provides methods for generating graphql schema and runtime wiring.
 * @since 1.0
 * @author Moustapha Star
 */
@Component
public class GraphQLProvider {

    /***
     * Provides GraphQL object.
     */
    private GraphQL graphQL;

    /***
     * Injection for GraphQLDataFetchers class.
     */
    @Autowired
    private GraphQLDataFetchers graphQLDataFetchers;

    /***
     * Injection for AddressDataFetcher class.
     */
    @Autowired
    private AddressDataFetcher addressDataFetcher;

    /***
     * Injection for CashAccountDataFetcher class.
     */
    @Autowired
    private CashAccountDataFetcher cashAccountDataFetcher;

    /***
     * Reads a schema file in given charset and builds an executable schema.
     */
    @PostConstruct
    public void init() {
        final Resource resource = new ClassPathResource("schema.graphqls");

        try {
            final InputStream is = resource.getInputStream();
            byte[] byteArray = FileCopyUtils.copyToByteArray(is);
            String sdl = new String(byteArray, StandardCharsets.UTF_8);
            GraphQLSchema graphQLSchema = buildSchema(sdl);
            this.graphQL = GraphQL.newGraphQL(graphQLSchema).build();
            //LOGGER.info(data);
        } catch (IOException | SchemaProblem e) {
            //LOGGER.error("IOException", e);
        }
    }

    /***
     * Parses a schema definitions string and generates an executable schema.
     * @param sdl schema in string format
     * @return schema as an executable by graphql-java
     * @throws SchemaProblem if there are problems in assembling a schema
     */
    private GraphQLSchema buildSchema(final String sdl) throws SchemaProblem {
        TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(sdl);
        RuntimeWiring runtimeWiring = buildWiring();
        SchemaGenerator schemaGenerator = new SchemaGenerator();
        return schemaGenerator
                .makeExecutableSchema(typeRegistry, runtimeWiring);
    }

    /***
     * Builds the runtime wiring.
     * @return runtime wiring for graphql-java
     */
    private RuntimeWiring buildWiring() {
        return RuntimeWiring.newRuntimeWiring()
                .type(newTypeWiring("GraphQLQuery")
                        .dataFetcher("address",
                                addressDataFetcher.fetchAddress())
                        .dataFetcher("cashAccount",
                                cashAccountDataFetcher.fetchCashAccount())
                        .dataFetcher("cashTransaction",
                                graphQLDataFetchers.cashTransactionFetcher())
                        .dataFetcher("cashTransactions",
                                graphQLDataFetchers.cashTransactionsFetcher())
                        .dataFetcher("merchant",
                                graphQLDataFetchers.merchantFetcher())
                        .dataFetcher("countries",
                                addressDataFetcher.fetchCountries())
                        .dataFetcher("cities",
                                addressDataFetcher.fetchCityByCountry())
                        .dataFetcher("customerAddress",
                                addressDataFetcher.getCustomerAddress())
                )
                .type(newTypeWiring("GraphQLMutation")
                        .dataFetcher("addCashAccount",
                                cashAccountDataFetcher.addCashAccount())
                )
                .build();
    }

    /***
     * Getter for GraphQL object.
     * @return GraphQl object
     */
    @Bean
    public GraphQL graphQL() {
        return graphQL;
    }
}
