package com.notfoundcode.hellobpringboot.infraestructure.repository;

import com.notfoundcode.hellobpringboot.domain.model.Newsletter;
import org.springframework.data.repository.CrudRepository;

public interface NewsletterRepository extends CrudRepository<Newsletter, Long> {

    Newsletter findByEmail(String email);

}
