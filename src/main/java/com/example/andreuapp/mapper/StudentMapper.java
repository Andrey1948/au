package com.example.andreuapp.mapper;


import com.example.andreuapp.dto.StudentReadDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    org.openapitools.model.StudentReadDto toApi(StudentReadDto dto);

    StudentReadDto toReadDto(org.openapitools.model.StudentReadDto dto);
}
