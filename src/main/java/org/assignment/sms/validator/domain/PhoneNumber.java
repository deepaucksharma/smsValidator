package org.assignment.sms.validator.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * A PhoneNumber.
 */
@Entity
@Table(name = "phone_number")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class PhoneNumber implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "jhi_number")
    private Long number;

    @OneToOne
    @JoinColumn(unique = true)
    private UserAccount account;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNumber() {
        return number;
    }

    public PhoneNumber number(Long number) {
        this.number = number;
        return this;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public UserAccount getAccount() {
        return account;
    }

    public PhoneNumber account(UserAccount userAccount) {
        this.account = userAccount;
        return this;
    }

    public void setAccount(UserAccount userAccount) {
        this.account = userAccount;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PhoneNumber phoneNumber = (PhoneNumber) o;
        if (phoneNumber.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), phoneNumber.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "PhoneNumber{" +
            "id=" + getId() +
            ", number=" + getNumber() +
            "}";
    }
}
