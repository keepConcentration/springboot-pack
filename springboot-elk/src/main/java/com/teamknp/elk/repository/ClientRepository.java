package com.teamknp.elk.repository;

import lombok.RequiredArgsConstructor;
import org.elasticsearch.client.RestClient;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ClientRepository {

    private final RestClient restClient;
}
