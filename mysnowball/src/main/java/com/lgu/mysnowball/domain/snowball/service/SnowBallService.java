package com.lgu.mysnowball.domain.snowball.service;

import com.lgu.mysnowball.domain.snowball.dto.SnowBallCreateRequest;
import com.lgu.mysnowball.domain.snowball.entity.SnowBall;
import com.lgu.mysnowball.domain.snowball.repository.SnowBallContentRepository;
import com.lgu.mysnowball.domain.snowball.repository.SnowBallRepository;
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
            .name(snowBallCreateRequest.getName())
            .build();

        snowBallRepository.save(snowBall);
    }

//    public SnowBallContentResponse getSnowBallContents(Long id) {
//
//
//    }

}
