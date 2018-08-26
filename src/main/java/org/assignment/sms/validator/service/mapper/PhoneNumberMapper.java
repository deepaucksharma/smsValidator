package org.assignment.sms.validator.service.mapper;

import org.assignment.sms.validator.domain.*;
import org.assignment.sms.validator.service.dto.PhoneNumberDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity PhoneNumber and its DTO PhoneNumberDTO.
 */
@Mapper(componentModel = "spring", uses = {UserAccountMapper.class})
public interface PhoneNumberMapper extends EntityMapper<PhoneNumberDTO, PhoneNumber> {

    @Mapping(source = "account.id", target = "accountId")
    PhoneNumberDTO toDto(PhoneNumber phoneNumber);

    @Mapping(source = "accountId", target = "account")
    PhoneNumber toEntity(PhoneNumberDTO phoneNumberDTO);

    default PhoneNumber fromId(Long id) {
        if (id == null) {
            return null;
        }
        PhoneNumber phoneNumber = new PhoneNumber();
        phoneNumber.setId(id);
        return phoneNumber;
    }
}
