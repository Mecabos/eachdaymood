package com.bacemprog.eachdaymood.dto.entry;

import com.bacemprog.eachdaymood.dto.entrypage.EntryPageDtoForCreate;
import com.bacemprog.eachdaymood.dto.entrypage.EntryPageDtoForRead;
import com.bacemprog.eachdaymood.dto.entrypage.EntryPageDtoForReadWithoutEntries;
import com.bacemprog.eachdaymood.dto.entrypage.EntryPageDtoForUpdate;
import com.bacemprog.eachdaymood.entity.Entry;
import com.bacemprog.eachdaymood.entity.EntryPage;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EntryMapper {

    private ModelMapper modelMapper;

    @Autowired
    public EntryMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    //********* DTO ===> ENTITY
    public Entry convertToEntity (EntryDtoForUpdate entryDto){
        return modelMapper.map(entryDto, Entry.class);
    }

    //********* ENTITY ===> DTO
    /*public EntryPageDtoForRead convertToEntryPageDtoForRead(EntryPage entryPage) {
        return modelMapper.map(entryPage, EntryPageDtoForRead.class);
    }*/
}
