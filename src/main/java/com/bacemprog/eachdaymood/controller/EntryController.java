package com.bacemprog.eachdaymood.controller;

import com.bacemprog.eachdaymood.dto.entry.EntryDtoForUpdate;
import com.bacemprog.eachdaymood.dto.entry.EntryMapper;
import com.bacemprog.eachdaymood.dto.entrypage.EntryPageDtoForUpdate;
import com.bacemprog.eachdaymood.entity.Entry;
import com.bacemprog.eachdaymood.service.EntryService;
import com.bacemprog.eachdaymood.util.DebugUtil;
import org.jsondoc.core.annotation.Api;
import org.jsondoc.core.annotation.ApiMethod;
import org.jsondoc.core.annotation.ApiPathParam;
import org.jsondoc.core.pojo.ApiStage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/entry")
@CrossOrigin
@Api(
        name = "Entry API",
        description = "Provides a list of methods that manage entries",
        stage = ApiStage.RC)
public class EntryController {

    private EntryService entryService ;
    private EntryMapper entryMapper;

    public EntryController(EntryService entryService, EntryMapper entryMapper) {
        this.entryService = entryService;
        this.entryMapper = entryMapper;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    @ApiMethod(description = "Update entry with provided id")
    public void update(@RequestBody EntryDtoForUpdate entryDto,
                       @ApiPathParam(name = "id") @PathVariable int id){
        Entry entry = entryMapper.convertToEntity(entryDto);
        Entry updatedEntry = entryService.update(id,entry);
        if ( updatedEntry == null)
            DebugUtil.logError("Provided id doesn't link to any entry");
    }
}
