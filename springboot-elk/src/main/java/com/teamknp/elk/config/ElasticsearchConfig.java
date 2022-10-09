package com.teamknp.elk.config;

import lombok.RequiredArgsConstructor;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchConfiguration;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.convert.ElasticsearchConverter;

@Configuration
@RequiredArgsConstructor
public class ElasticsearchConfig extends AbstractElasticsearchConfiguration {

    private final ClientConfiguration clientConfiguration;

    @Bean
    public ClientConfiguration clientConfiguration() {
        return ClientConfiguration.builder()
                .connectedTo("localhost:9200")
                .build();
    }

    @Scope()
    @Bean
    @Override
    public RestHighLevelClient elasticsearchClient() {
        return RestClients.create(clientConfiguration).rest();
    }
}
