package com.bacemprog.eachdaymood.dto.entrypage;

import com.bacemprog.eachdaymood.entity.EntryPage;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EntryPageMapper {

    private ModelMapper modelMapper;

    @Autowired
    public EntryPageMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    //********* DTO ===> ENTITY
    public EntryPage convertToEntity (EntryPageDtoForUpdate entryPageDto){
        return modelMapper.map(entryPageDto, EntryPage.class);
    }

    public EntryPage convertToEntity (EntryPageDtoForCreate entryPageDto){
        return modelMapper.map(entryPageDto, EntryPage.class);
    }


    //********* ENTITY ===> DTO
    public EntryPageDtoForRead convertToEntryPageDtoForRead(EntryPage entryPage) {
        return modelMapper.map(entryPage, EntryPageDtoForRead.class);
    }

    public EntryPageDtoForReadWithoutEntries convertToEntryPageDtoForReadWithoutEntries(EntryPage entryPage) {
        return modelMapper.map(entryPage, EntryPageDtoForReadWithoutEntries.class);
    }
}
