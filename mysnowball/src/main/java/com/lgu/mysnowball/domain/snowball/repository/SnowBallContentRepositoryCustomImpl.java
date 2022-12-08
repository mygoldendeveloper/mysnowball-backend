package com.lgu.mysnowball.domain.snowball.repository;

import com.lgu.mysnowball.domain.snowball.entity.SnowBallContent;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SnowBallContentRepositoryCustomImpl implements SnowBallContentRepositoryCustom {

    private final JPAQueryFactory queryFactory;


    @Override
    public List<SnowBallContent> findAllBySnowBallId(Long snowBallId) {
        return null;
    }
}
