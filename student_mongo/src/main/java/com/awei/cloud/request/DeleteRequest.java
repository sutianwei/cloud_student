package com.awei.cloud.request;

import javax.validation.constraints.NotNull;
import java.util.HashMap;

public class DeleteRequest {
    @NotNull
    String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}