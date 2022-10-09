package com.teamknp.elk.repository;

import lombok.RequiredArgsConstructor;
import org.elasticsearch.client.RestClient;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HelloRepository extends ElasticsearchRepository<Hello, String> {

}
