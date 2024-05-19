package com.ueg.cooperagro.generic.mapper;

import com.ueg.cooperagro.generic.model.GenericModel;
import org.mapstruct.IterableMapping;
import org.mapstruct.Named;

import java.util.List;


public interface GenericMapper<
        DTO,
        DTOCreate,
        DTOUpdate,
        DTOList,
        MODEL extends GenericModel<TYPE_PK>,
        TYPE_PK
        > extends GenericUpdateMapper<MODEL, TYPE_PK> {
    MODEL toModel(DTO dto);
    MODEL fromModelCreatedToModel(DTOCreate dtoCreate);

    MODEL fromModelUpdatedToModel(DTOUpdate dtoUpdate);



    DTO toDTO(MODEL model);

    @Named(value = "toDTOList")
    DTOList toDTOList(MODEL model);

    @IterableMapping(qualifiedByName = "toDTOList")
    List<DTOList> fromModelToDTOList(List<MODEL> modelList);
}