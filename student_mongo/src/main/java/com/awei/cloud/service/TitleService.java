package com.awei.cloud.service;

import com.awei.cloud.entity.TitleEntity;
import com.awei.cloud.request.InsertTitleRequest;
import com.awei.cloud.request.UpdateRequest;
import io.lettuce.core.dynamic.annotation.Param;

public interface TitleService {

    void insert(InsertTitleRequest  request);

    void delete(String tid);

    TitleEntity listTitle(@Param("id") String id);

    void update(UpdateRequest request);
}
