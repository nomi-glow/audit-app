package com.assessment.auditapp.config

import com.assessment.auditapp.query.AuditQuery
import graphql.GraphQL
import graphql.analysis.MaxQueryComplexityInstrumentation
import graphql.analysis.MaxQueryDepthInstrumentation
import graphql.execution.AsyncExecutionStrategy
import graphql.execution.instrumentation.ChainedInstrumentation
import graphql.schema.GraphQLSchema
import io.leangen.graphql.GraphQLSchemaGenerator
import io.leangen.graphql.metadata.strategy.query.AnnotatedResolverBuilder
import io.leangen.graphql.metadata.strategy.query.PublicResolverBuilder
import io.leangen.graphql.metadata.strategy.value.jackson.JacksonValueMapperFactory
import org.keycloak.adapters.springboot.KeycloakSpringBootConfigResolver
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
open class GraphQLConfig {
    @Bean
    open fun graphQL(
            auditQuery: AuditQuery
    ): GraphQL {
        val schema = prepareGraphQLSchema(auditQuery)

        return GraphQL.newGraphQL(schema)
                .queryExecutionStrategy(AsyncExecutionStrategy())
                .instrumentation(
                        ChainedInstrumentation(
                                listOf(
                                        MaxQueryComplexityInstrumentation(100),
                                        MaxQueryDepthInstrumentation(10)
                                )
                        )
                )
                .build()
    }

    private fun prepareGraphQLSchema(
            auditQuery: AuditQuery
    ): GraphQLSchema =
            GraphQLSchemaGenerator()
                    .withResolverBuilders(
                            AnnotatedResolverBuilder(),
                            PublicResolverBuilder("com.assessment.auditapp")
                    )
                    .withOperationsFromSingletons(auditQuery)
                    .withValueMapperFactory(JacksonValueMapperFactory())
                    .generate()

    @Bean
    open fun keycloakConfigResolver(): KeycloakSpringBootConfigResolver {
        return KeycloakSpringBootConfigResolver()
    }
}