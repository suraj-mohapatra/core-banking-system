package io.github.cbs.service.mapper;

import io.github.cbs.domain.entity.CustomerKyc;
import io.github.cbs.dto.req.CustomerKycReq;
import io.github.cbs.dto.res.CustomerKycRes;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CustomerKycMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "customerId", ignore = true)
    @Mapping(target = "kycStatus", ignore = true)
    @Mapping(target = "submittedAt", ignore = true)
    @Mapping(target = "verifiedAt", ignore = true)
    @Mapping(target = "verifiedBy", ignore = true)
    @Mapping(target = "verificationMode", ignore = true)
    @Mapping(target = "rejectionReason", ignore = true)
    @Mapping(target = "expiryDate", ignore = true)
    @Mapping(target = "reKycRequired", ignore = true)
    @Mapping(target = "reKycDueDate", ignore = true)
    @Mapping(target = "isActive", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "documents", ignore = true)
    @Mapping(target = "documentCount", ignore = true)
    CustomerKyc toEntity(CustomerKycReq request);

    @Mapping(target = "cifNumber", ignore = true)
    CustomerKycRes toResponse(CustomerKyc entity);
}
