package com.example.andreuapp.mapper;

import com.example.andreuapp.dto.GroupReadDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface GroupMapper {

    org.openapitools.model.GroupReadDto toApi(GroupReadDto dto);


    @Mapping(target = "id", source = "id")
    @Mapping(target = "number", source = "number")
    org.openapitools.model.GroupEditDto toApiFromEdit(
            com.example.andreuapp.dto.GroupEditDto dto
    );
    com.example.andreuapp.dto.GroupEditDto toGroupEditFromApi(
            org.openapitools.model.GroupEditDto dto
    );

}