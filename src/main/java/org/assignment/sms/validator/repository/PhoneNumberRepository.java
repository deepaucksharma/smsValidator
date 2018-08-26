package org.assignment.sms.validator.repository;

import org.assignment.sms.validator.domain.PhoneNumber;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the PhoneNumber entity.
 */
@SuppressWarnings("unused")
@Repository
public interface PhoneNumberRepository extends JpaRepository<PhoneNumber, Long> {

}
