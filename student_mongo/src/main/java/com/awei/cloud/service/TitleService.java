package com.awei.cloud.service;

import com.awei.cloud.entity.TitleEntity;
import io.lettuce.core.dynamic.annotation.Param;

public interface TitleService {

    void insert(TitleEntity entity);

    void delete(String tid);

    TitleEntity listTitle(@Param("id") String id);
}
