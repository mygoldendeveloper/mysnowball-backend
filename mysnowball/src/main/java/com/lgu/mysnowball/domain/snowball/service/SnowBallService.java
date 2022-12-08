package com.lgu.mysnowball.domain.snowball.service;

import com.lgu.mysnowball.domain.snowball.dto.SnowBallContentRequest;
import com.lgu.mysnowball.domain.snowball.dto.SnowBallContentResponse;
import com.lgu.mysnowball.domain.snowball.dto.SnowBallCreateRequest;
import com.lgu.mysnowball.domain.snowball.dto.SnowBallResponse;
import com.lgu.mysnowball.domain.snowball.entity.SnowBall;
import com.lgu.mysnowball.domain.snowball.entity.SnowBallContent;
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

    public SnowBallResponse createSnowball(SnowBallCreateRequest snowBallCreateRequest) {

        SnowBall snowBall = SnowBall.builder()
            .id(snowBallCreateRequest.getId())
            .nickName(snowBallCreateRequest.getNickName())
            .phoneNumber(snowBallCreateRequest.getPhoneNumber())
            .accessToken(snowBallCreateRequest.getAccessToken())
            .refreshToken(snowBallCreateRequest.getRefreshToken())
            .build();

        return SnowBallMapper.instance.toSnowBallResponse(snowBallRepository.save(snowBall));
    }

    public List<SnowBallContentResponse> getSnowBallContents(Long id) {
        return snowBallContentRepository.findAllBySnowBallId(id).stream()
            .map(SnowBallMapper.instance::toSnowBallContentResponse)
            .collect(Collectors.toList());
    }

    public SnowBallContentResponse createSnowBallContent(SnowBallContentRequest snowBallContentRequest, String accessToken) {

        SnowBall snowBall = snowBallRepository.findById(snowBallContentRequest.getReceiverId())
            .orElseThrow(() -> {
                throw new RuntimeException("해당 스노우볼이 존재하지 않습니다.");
            });

        SnowBallContent snowBallContent = SnowBallContent.builder()
            .snowBall(snowBall)
            .uuid(getUUIDOfReceiver(snowBallContentRequest.getReceiverId()))
            .accessToken(accessToken)
            .content(snowBallContentRequest.getContent())
            .build();

        return SnowBallMapper.instance.toSnowBallContentResponse(snowBallContentRepository.save(snowBallContent));
    }

    private String getUUIDOfReceiver(Long receiverId) {

        /* receiverId( 메시지 받는 사람의 카카오 아이디로 uuid 찾기)
        없으면 Exception!
         */

        return "uuid";

    }

}
