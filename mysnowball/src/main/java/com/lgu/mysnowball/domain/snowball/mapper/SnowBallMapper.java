package com.lgu.mysnowball.domain.snowball.mapper;

import com.lgu.mysnowball.domain.snowball.dto.SnowBallContentResponse;
import com.lgu.mysnowball.domain.snowball.dto.SnowBallResponse;
import com.lgu.mysnowball.domain.snowball.entity.SnowBall;
import com.lgu.mysnowball.domain.snowball.entity.SnowBallContent;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface SnowBallMapper {

    SnowBallMapper instance = Mappers.getMapper(SnowBallMapper.class);

    SnowBallContentResponse toSnowBallContentResponse(SnowBallContent snowBallContent);

    SnowBallResponse toSnowBallResponse(SnowBall snowBall);

}
