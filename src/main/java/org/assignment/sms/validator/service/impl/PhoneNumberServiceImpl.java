package org.assignment.sms.validator.service.impl;

import org.assignment.sms.validator.service.PhoneNumberService;
import org.assignment.sms.validator.domain.PhoneNumber;
import org.assignment.sms.validator.repository.PhoneNumberRepository;
import org.assignment.sms.validator.service.dto.PhoneNumberDTO;
import org.assignment.sms.validator.service.mapper.PhoneNumberMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Optional;
/**
 * Service Implementation for managing PhoneNumber.
 */
@Service
@Transactional
public class PhoneNumberServiceImpl implements PhoneNumberService {

    private final Logger log = LoggerFactory.getLogger(PhoneNumberServiceImpl.class);

    private final PhoneNumberRepository phoneNumberRepository;

    private final PhoneNumberMapper phoneNumberMapper;

    public PhoneNumberServiceImpl(PhoneNumberRepository phoneNumberRepository, PhoneNumberMapper phoneNumberMapper) {
        this.phoneNumberRepository = phoneNumberRepository;
        this.phoneNumberMapper = phoneNumberMapper;
    }

    /**
     * Save a phoneNumber.
     *
     * @param phoneNumberDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public PhoneNumberDTO save(PhoneNumberDTO phoneNumberDTO) {
        log.debug("Request to save PhoneNumber : {}", phoneNumberDTO);
        PhoneNumber phoneNumber = phoneNumberMapper.toEntity(phoneNumberDTO);
        phoneNumber = phoneNumberRepository.save(phoneNumber);
        return phoneNumberMapper.toDto(phoneNumber);
    }

    /**
     * Get all the phoneNumbers.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<PhoneNumberDTO> findAll(Pageable pageable) {
        log.debug("Request to get all PhoneNumbers");
        return phoneNumberRepository.findAll(pageable)
            .map(phoneNumberMapper::toDto);
    }


    /**
     * Get one phoneNumber by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<PhoneNumberDTO> findOne(Long id) {
        log.debug("Request to get PhoneNumber : {}", id);
        return phoneNumberRepository.findById(id)
            .map(phoneNumberMapper::toDto);
    }

    /**
     * Delete the phoneNumber by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete PhoneNumber : {}", id);
        phoneNumberRepository.deleteById(id);
    }
}
