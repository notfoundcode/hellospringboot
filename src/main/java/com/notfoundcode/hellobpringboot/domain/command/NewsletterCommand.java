package com.notfoundcode.hellobpringboot.domain.command;

import com.notfoundcode.hellobpringboot.application.dto.NewsletterRequest;
import com.notfoundcode.hellobpringboot.application.dto.NewsletterResponse;
import com.notfoundcode.hellobpringboot.domain.model.Newsletter;
import com.notfoundcode.hellobpringboot.infraestructure.exception.IdNotFoundException;
import com.notfoundcode.hellobpringboot.infraestructure.repository.NewsletterRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class NewsletterCommand {

    private NewsletterRepository newsletterRepository;
    private Newsletter newsletter;

    public NewsletterCommand(NewsletterRepository newsletterRepository) {
        this.newsletterRepository = newsletterRepository;
    }

    public NewsletterResponse createNewsletter(NewsletterRequest newsletterRequest){
        newsletter = newsletterRepository.findByEmail(newsletterRequest.getEmail());
        return newsletter != null
                    ? new NewsletterResponse(this.saveNewsletter(new Newsletter(newsletterRequest, newsletter)))
                    : new NewsletterResponse(this.saveNewsletter(new Newsletter(newsletterRequest)));
    }

    private Newsletter saveNewsletter(Newsletter newsletter) {
        log.warn("Newsletter: {}", newsletter.toString());
        return newsletterRepository.save(newsletter);
    }

    public NewsletterResponse unsubscribeNewsletter(Long id) throws IdNotFoundException {
        return new NewsletterResponse(newsletterRepository.findById(id).map(nl -> {
            log.warn("Found id {}", nl.toString());
            newsletterRepository.deleteById(nl.getId());
            return nl;
        }).orElseThrow(() -> new IdNotFoundException("We couldn't find the id in our database")));
    }
}
