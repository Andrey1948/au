package com.example.andreuapp.mapper;


import com.example.andreuapp.dto.StudentReadDto;
import com.example.andreuapp.dto.StudentUpdateGroupDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    org.openapitools.model.StudentReadDto toApi(StudentReadDto dto);

    StudentReadDto toReadDto(org.openapitools.model.StudentReadDto dto);

    StudentUpdateGroupDto toUpdateGroupDto (org.openapitools.model.StudentUpdateGroupDto dto);

}
