package com.teamknp.elk.service.impl;

import com.teamknp.elk.domain.HelloDto;
import com.teamknp.elk.repository.Hello;
import com.teamknp.elk.repository.HelloRepository;
import com.teamknp.elk.service.ElkService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class ElkServiceImpl implements ElkService {

    private final ElasticsearchRestTemplate elasticsearchRestTemplate;

    private final HelloRepository helloRepository;

    @Override
    public HelloDto searchHello(Long id) {
        QueryBuilder nameSearchQuery = QueryBuilders.matchQuery("id", id);
        Query searchQueryName = new NativeSearchQueryBuilder().withQuery(nameSearchQuery).build();
        final Hello hello = elasticsearchRestTemplate.searchOne(searchQueryName, Hello.class).getContent();
        return HelloDto.builder()
                .id(hello.getId())
                .name(hello.getName())
                .build();
    }

    @Transactional
    @Override
    public Long insertHello(HelloDto helloDto) {
        final Hello hello = Hello.builder()
                .name(helloDto.getName())
                .build();
        helloRepository.save(hello);
        return hello.getId();
    }
}
