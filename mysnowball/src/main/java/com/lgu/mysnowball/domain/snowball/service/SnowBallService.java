package com.lgu.mysnowball.domain.snowball.service;

import com.lgu.mysnowball.domain.snowball.dto.SnowBallContentResponse;
import com.lgu.mysnowball.domain.snowball.dto.SnowBallCreateRequest;
import com.lgu.mysnowball.domain.snowball.entity.SnowBall;
import com.lgu.mysnowball.domain.snowball.mapper.SnowBallMapper;
import com.lgu.mysnowball.domain.snowball.repository.SnowBallContentRepository;
import com.lgu.mysnowball.domain.snowball.repository.SnowBallRepository;
import java.util.List;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class SnowBallService {

    private final SnowBallRepository snowBallRepository;
    private final SnowBallContentRepository snowBallContentRepository;

    public void createSnowball(SnowBallCreateRequest snowBallCreateRequest) {

        SnowBall snowBall = SnowBall.builder()
            .nickName(snowBallCreateRequest.getNickName())
            .build();

        snowBallRepository.save(snowBall);
    }

    public List<SnowBallContentResponse> getSnowBallContents(Long id) {
        return snowBallContentRepository.findAllBySnowBallId(id).stream()
            .map(SnowBallMapper.instance::toSnowBallContentResponse)
            .collect(Collectors.toList());
    }

}
