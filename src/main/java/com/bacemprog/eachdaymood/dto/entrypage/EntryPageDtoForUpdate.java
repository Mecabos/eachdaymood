package com.bacemprog.eachdaymood.dto.entrypage;

import org.jsondoc.core.annotation.ApiObject;

@ApiObject
public class EntryPageDtoForUpdate {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
