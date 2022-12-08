package com.lgu.mysnowball.domain.snowball.repository;

import com.lgu.mysnowball.domain.snowball.entity.QSnowBall;
import com.lgu.mysnowball.domain.snowball.entity.QSnowBallContent;
import com.lgu.mysnowball.domain.snowball.entity.SnowBallContent;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SnowBallContentRepositoryCustomImpl implements SnowBallContentRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    QSnowBallContent qSnowBallContent = QSnowBallContent.snowBallContent;
    QSnowBall qSnowBall = QSnowBall.snowBall;

    @Override
    public List<SnowBallContent> findAllBySnowBallId(Long snowBallId) {

        return queryFactory
            .selectFrom(qSnowBallContent)
            .join(qSnowBallContent.snowBall, qSnowBall).fetchJoin()
            .where(qSnowBallContent.snowBall.id.eq(snowBallId))
            .fetch();
    }
}
