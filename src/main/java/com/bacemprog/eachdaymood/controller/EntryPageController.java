package com.bacemprog.eachdaymood.controller;

import com.bacemprog.eachdaymood.dto.entrypage.*;
import com.bacemprog.eachdaymood.entity.Entry;
import com.bacemprog.eachdaymood.entity.EntryPage;
import com.bacemprog.eachdaymood.service.EntryPageService;
import com.bacemprog.eachdaymood.util.DebugUtil;
import org.jsondoc.core.annotation.Api;
import org.jsondoc.core.annotation.ApiBodyObject;
import org.jsondoc.core.annotation.ApiMethod;
import org.jsondoc.core.annotation.ApiPathParam;
import org.jsondoc.core.pojo.ApiStage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/entrypage")
@CrossOrigin
@Api(
        name = "Entry Page API",
        description = "Provides a list of methods that manage entry pages",
        stage = ApiStage.RC)
public class EntryPageController {

    private EntryPageService entryPageService;
    private EntryPageMapper entryPageMapper;

    public EntryPageController(EntryPageService entryPageService, EntryPageMapper entryPageMapper) {
        this.entryPageService = entryPageService;
        this.entryPageMapper = entryPageMapper;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ApiMethod(description = "Get entry page with provided id")
    public EntryPageDtoForRead get(@ApiPathParam(name = "id") @PathVariable int id){
        return entryPageMapper.convertToEntryPageDtoForRead(entryPageService.get(id));
    }

    @RequestMapping(value = "/current", method = RequestMethod.GET)
    @ApiMethod(description = "Get this year's entry page")
    public EntryPageDtoForRead getCurrent(){
        return entryPageMapper.convertToEntryPageDtoForRead(entryPageService.getCurrent());
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ApiMethod(description = "Get all entry pages without associated entries")
    public List<EntryPageDtoForReadWithoutEntries> getAll(){
        return entryPageService.getAll().stream()
                .map(entryPage -> entryPageMapper.convertToEntryPageDtoForReadWithoutEntries(entryPage))
                .collect(Collectors.toList());
    }

    @RequestMapping(value = "/all/entries", method = RequestMethod.GET)
    @ApiMethod(description = "Get all entry pages with associated entries")
    public List<EntryPageDtoForRead> getAllWithEntries(){
        return entryPageService.getAll().stream()
                .map(entryPage -> entryPageMapper.convertToEntryPageDtoForRead(entryPage))
                .collect(Collectors.toList());
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ApiMethod(description = "Create a new entry page")
    public EntryPageDtoForReadWithoutEntries create(@ApiBodyObject @RequestBody EntryPageDtoForCreate entryPageDto) {
        EntryPage entryPage = entryPageMapper.convertToEntity(entryPageDto);
        EntryPage newEntryPage = entryPageService.saveNewWithEntries(entryPage);
        return entryPageMapper.convertToEntryPageDtoForReadWithoutEntries(newEntryPage);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    @ApiMethod(description = "Update entry page with provided id")
    public void update(@RequestBody EntryPageDtoForUpdate entryPageDto,
                       @ApiPathParam(name = "id") @PathVariable int id){
        EntryPage entryPage = entryPageMapper.convertToEntity(entryPageDto);
        EntryPage updatedEntryPage = entryPageService.update(id,entryPage);
        if ( updatedEntryPage == null)
            DebugUtil.logError("Provided id doesn't link to any entry page");
    }
}
