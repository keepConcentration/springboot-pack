package com.teamknp.elk.service;

import com.teamknp.elk.domain.HelloDto;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.stereotype.Service;

@Service
public interface ElkService {

    public HelloDto searchHello(Long id);
    public Long insertHello(HelloDto hello);
}
