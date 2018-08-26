package org.assignment.sms.validator.web.rest;

import com.codahale.metrics.annotation.Timed;
import org.assignment.sms.validator.service.PhoneNumberService;
import org.assignment.sms.validator.web.rest.errors.BadRequestAlertException;
import org.assignment.sms.validator.web.rest.util.HeaderUtil;
import org.assignment.sms.validator.web.rest.util.PaginationUtil;
import org.assignment.sms.validator.service.dto.PhoneNumberDTO;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing PhoneNumber.
 */
@RestController
@RequestMapping("/api")
public class PhoneNumberResource {

    private final Logger log = LoggerFactory.getLogger(PhoneNumberResource.class);

    private static final String ENTITY_NAME = "phoneNumber";

    private final PhoneNumberService phoneNumberService;

    public PhoneNumberResource(PhoneNumberService phoneNumberService) {
        this.phoneNumberService = phoneNumberService;
    }

    /**
     * POST  /phone-numbers : Create a new phoneNumber.
     *
     * @param phoneNumberDTO the phoneNumberDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new phoneNumberDTO, or with status 400 (Bad Request) if the phoneNumber has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/phone-numbers")
    @Timed
    public ResponseEntity<PhoneNumberDTO> createPhoneNumber(@RequestBody PhoneNumberDTO phoneNumberDTO) throws URISyntaxException {
        log.debug("REST request to save PhoneNumber : {}", phoneNumberDTO);
        if (phoneNumberDTO.getId() != null) {
            throw new BadRequestAlertException("A new phoneNumber cannot already have an ID", ENTITY_NAME, "idexists");
        }
        PhoneNumberDTO result = phoneNumberService.save(phoneNumberDTO);
        return ResponseEntity.created(new URI("/api/phone-numbers/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /phone-numbers : Updates an existing phoneNumber.
     *
     * @param phoneNumberDTO the phoneNumberDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated phoneNumberDTO,
     * or with status 400 (Bad Request) if the phoneNumberDTO is not valid,
     * or with status 500 (Internal Server Error) if the phoneNumberDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/phone-numbers")
    @Timed
    public ResponseEntity<PhoneNumberDTO> updatePhoneNumber(@RequestBody PhoneNumberDTO phoneNumberDTO) throws URISyntaxException {
        log.debug("REST request to update PhoneNumber : {}", phoneNumberDTO);
        if (phoneNumberDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        PhoneNumberDTO result = phoneNumberService.save(phoneNumberDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, phoneNumberDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /phone-numbers : get all the phoneNumbers.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of phoneNumbers in body
     */
    @GetMapping("/phone-numbers")
    @Timed
    public ResponseEntity<List<PhoneNumberDTO>> getAllPhoneNumbers(Pageable pageable) {
        log.debug("REST request to get a page of PhoneNumbers");
        Page<PhoneNumberDTO> page = phoneNumberService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/phone-numbers");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /phone-numbers/:id : get the "id" phoneNumber.
     *
     * @param id the id of the phoneNumberDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the phoneNumberDTO, or with status 404 (Not Found)
     */
    @GetMapping("/phone-numbers/{id}")
    @Timed
    public ResponseEntity<PhoneNumberDTO> getPhoneNumber(@PathVariable Long id) {
        log.debug("REST request to get PhoneNumber : {}", id);
        Optional<PhoneNumberDTO> phoneNumberDTO = phoneNumberService.findOne(id);
        return ResponseUtil.wrapOrNotFound(phoneNumberDTO);
    }

    /**
     * DELETE  /phone-numbers/:id : delete the "id" phoneNumber.
     *
     * @param id the id of the phoneNumberDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/phone-numbers/{id}")
    @Timed
    public ResponseEntity<Void> deletePhoneNumber(@PathVariable Long id) {
        log.debug("REST request to delete PhoneNumber : {}", id);
        phoneNumberService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
