package org.assignment.sms.validator.service;

import org.assignment.sms.validator.service.dto.PhoneNumberDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing PhoneNumber.
 */
public interface PhoneNumberService {

    /**
     * Save a phoneNumber.
     *
     * @param phoneNumberDTO the entity to save
     * @return the persisted entity
     */
    PhoneNumberDTO save(PhoneNumberDTO phoneNumberDTO);

    /**
     * Get all the phoneNumbers.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    Page<PhoneNumberDTO> findAll(Pageable pageable);


    /**
     * Get the "id" phoneNumber.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<PhoneNumberDTO> findOne(Long id);

    /**
     * Delete the "id" phoneNumber.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
