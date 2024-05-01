package org.example.Helpers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CardMapper {

    CardMapper mapper = Mappers.getMapper(CardMapper.class);

    @Mapping()


}
