package com.awei.cloud.dao;

import com.awei.cloud.entity.UserRankEntity;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRankDao {


    void insertRank(UserRankEntity entity);

    UserRankEntity  getRank(@Param("userId")  String userId);
    void updateRank(@Param("userId")  String userId,@Param("rank") Integer rank);
}
