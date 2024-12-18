package ru.practicum.dto.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import ru.practicum.dto.compilation.CompilationDtoResponse;
import ru.practicum.dto.compilation.NewCompilationDto;
import ru.practicum.model.Compilation;

@Mapper(componentModel = "spring")
public interface CompilationMapper {

    Compilation toCompilation(NewCompilationDto compilationDto);

    @Mapping(target = "events", ignore = true)
    CompilationDtoResponse toCompilationDtoResponse(Compilation compilation);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
            nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
    void updateCompilationFromUpdateCompilationDto(NewCompilationDto compilationDto, @MappingTarget Compilation compilation);
}