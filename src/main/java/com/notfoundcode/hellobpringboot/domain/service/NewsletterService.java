package com.notfoundcode.hellobpringboot.domain.service;

import com.notfoundcode.hellobpringboot.application.dto.NewsletterRequest;
import com.notfoundcode.hellobpringboot.application.dto.NewsletterResponse;
import com.notfoundcode.hellobpringboot.domain.command.NewsletterCommand;
import com.notfoundcode.hellobpringboot.infraestructure.exception.IdNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class NewsletterService {

    private NewsletterCommand newsletterCommand;

    public NewsletterResponse createNewsletter(NewsletterRequest newsletterRequest) {
        return newsletterCommand.createNewsletter(newsletterRequest);
    }

    public NewsletterResponse unsubscribeNewsletter(Long id) throws IdNotFoundException {
        return newsletterCommand.unsubscribeNewsletter(id);
    }
}
