package com.lgu.mysnowball.domain.snowball.repository;

import com.lgu.mysnowball.domain.snowball.entity.SnowBall;
import com.lgu.mysnowball.domain.snowball.entity.SnowBallContent;
import java.util.List;

public interface SnowBallContentRepositoryCustom {

    List<SnowBallContent> findAllBySnowBallId(Long snowBallId);

    int findOrderOfSnowBallContent(Long snowBallContentId, SnowBall snowBall);

}
