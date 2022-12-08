package com.lgu.mysnowball.domain.snowball.repository;

import com.lgu.mysnowball.domain.snowball.entity.SnowBallContent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SnowBallContentRepository extends JpaRepository<SnowBallContent, Long>, SnowBallContentRepositoryCustom {

}
