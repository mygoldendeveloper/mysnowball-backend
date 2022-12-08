package com.lgu.mysnowball.domain.snowball.repository;

import com.lgu.mysnowball.domain.snowball.entity.SnowBall;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SnowBallRepository extends JpaRepository<SnowBall, Long> {


}
