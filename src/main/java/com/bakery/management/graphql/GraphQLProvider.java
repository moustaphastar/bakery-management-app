package com.bakery.management.graphql;

import com.bakery.management.graphql.datafetchers.AddressDataFetcher;
import com.bakery.management.graphql.datafetchers.CashAccountDataFetcher;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.URL;

import static graphql.schema.idl.TypeRuntimeWiring.newTypeWiring;

@Component
public class GraphQLProvider {

    private GraphQL graphQL;

    @Autowired
    GraphQLDataFetchers graphQLDataFetchers;
    @Autowired
    AddressDataFetcher addressDataFetcher;
    @Autowired
    CashAccountDataFetcher cashAccountDataFetcher;

    @PostConstruct
    public void init() throws IOException {
        URL url = Resources.getResource("schema.graphqls");
        String sdl = Resources.toString(url, Charsets.UTF_8);
        GraphQLSchema graphQLSchema = buildSchema(sdl);
        this.graphQL = GraphQL.newGraphQL(graphQLSchema).build();
    }

    private GraphQLSchema buildSchema(String sdl) {
        TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(sdl);
        RuntimeWiring runtimeWiring = buildWiring();
        SchemaGenerator schemaGenerator = new SchemaGenerator();
        return schemaGenerator.makeExecutableSchema(typeRegistry, runtimeWiring);
    }

    private RuntimeWiring buildWiring() {
        return RuntimeWiring.newRuntimeWiring()
                .type(newTypeWiring("GraphQLQuery")
                        .dataFetcher("address", addressDataFetcher.fetchAddress())
                        .dataFetcher("cashAccount", cashAccountDataFetcher.fetchCashAccount())
                        .dataFetcher("cashTransaction", graphQLDataFetchers.CashTransactionFetcher())
                        .dataFetcher("cashTransactions", graphQLDataFetchers.CashTransactionsFetcher())
                        .dataFetcher("merchant", graphQLDataFetchers.MerchantFetcher())
                        .dataFetcher("cities", addressDataFetcher.fetchCityByCountry())
                        .dataFetcher("customerAddress", addressDataFetcher.getCustomerAddress())
                )
                .type(newTypeWiring("GraphQLMutation")
                        .dataFetcher("addCashAccount", cashAccountDataFetcher.addCashAccount())
                )
                .build();
    }

    @Bean
    public GraphQL graphQL() {
        return graphQL;
    }
}
