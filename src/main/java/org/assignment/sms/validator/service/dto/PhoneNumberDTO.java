package org.assignment.sms.validator.service.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the PhoneNumber entity.
 */
public class PhoneNumberDTO implements Serializable {

    private Long id;

    private Long number;

    private Long accountId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long userAccountId) {
        this.accountId = userAccountId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        PhoneNumberDTO phoneNumberDTO = (PhoneNumberDTO) o;
        if (phoneNumberDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), phoneNumberDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "PhoneNumberDTO{" +
            "id=" + getId() +
            ", number=" + getNumber() +
            ", account=" + getAccountId() +
            "}";
    }
}
