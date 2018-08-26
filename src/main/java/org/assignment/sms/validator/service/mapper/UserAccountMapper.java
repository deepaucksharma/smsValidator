package org.assignment.sms.validator.service.mapper;

import org.assignment.sms.validator.domain.*;
import org.assignment.sms.validator.service.dto.UserAccountDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity UserAccount and its DTO UserAccountDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface UserAccountMapper extends EntityMapper<UserAccountDTO, UserAccount> {



    default UserAccount fromId(Long id) {
        if (id == null) {
            return null;
        }
        UserAccount userAccount = new UserAccount();
        userAccount.setId(id);
        return userAccount;
    }
}
