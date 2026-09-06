package io.github.cbs.service.mapper;

import io.github.cbs.domain.entity.Customer;
import io.github.cbs.dto.req.CustomerReq;
import io.github.cbs.dto.res.CustomerRes;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CustomerMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "cifNumber", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "dateOfBirth", source = "dateOfBirth")
    @Mapping(target = "gender", source = "gender")
    Customer toEntity(CustomerReq request);

    CustomerRes toResponse(Customer entity);
}
