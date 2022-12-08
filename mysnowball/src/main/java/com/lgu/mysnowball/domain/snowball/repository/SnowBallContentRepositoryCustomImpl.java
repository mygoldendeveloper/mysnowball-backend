package com.lgu.mysnowball.domain.snowball.repository;

import com.lgu.mysnowball.domain.snowball.entity.QSnowBall;
import com.lgu.mysnowball.domain.snowball.entity.QSnowBallContent;
import com.lgu.mysnowball.domain.snowball.entity.SnowBall;
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
            .orderBy(qSnowBallContent.id.asc())
            .fetch();
    }

    @Override
    public int findOrderOfSnowBallContent(Long snowBallContentId, SnowBall snowBall) {

        List<SnowBallContent> snowBallContentList = findAllBySnowBallId(snowBall.getId());

        SnowBallContent snowBallContent = queryFactory.selectFrom(qSnowBallContent)
            .where(qSnowBallContent.id.eq(snowBallContentId))
            .join(qSnowBallContent.snowBall, qSnowBall).fetchJoin()
            .fetchOne();

        return snowBallContentList.indexOf(snowBallContent) + 1;
    }
}
