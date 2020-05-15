package com.notfoundcode.hellobpringboot.domain.service;

import com.notfoundcode.hellobpringboot.application.dto.NewsletterRequest;
import com.notfoundcode.hellobpringboot.application.dto.NewsletterResponse;
import com.notfoundcode.hellobpringboot.domain.command.NewsletterCommand;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class NewsletterService {

    private NewsletterCommand newsletterCommand;

    public NewsletterResponse createNewsletter(NewsletterRequest newsletterRequest) {
        return newsletterCommand.createNewsletter(newsletterRequest);
    }
}
