package com.awei.cloud.service;

import com.awei.cloud.entity.Title;
import com.awei.cloud.request.InsertTitleRequest;
import com.awei.cloud.request.UpdateRequest;
import io.lettuce.core.dynamic.annotation.Param;

public interface TitleService {

    void insert(InsertTitleRequest  request);

    void delete(String tid);

    Title listTitle(@Param("id") String id);

    void update(UpdateRequest request);
}
