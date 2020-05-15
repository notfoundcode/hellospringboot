package com.notfoundcode.hellobpringboot.application.resource;

import com.notfoundcode.hellobpringboot.application.dto.NewsletterRequest;
import com.notfoundcode.hellobpringboot.application.dto.NewsletterResponse;
import com.notfoundcode.hellobpringboot.domain.service.NewsletterService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class NewsletterResource {

    private NewsletterService newsletterService;

    public NewsletterResource(NewsletterService newsletterService) {
        this.newsletterService = newsletterService;
    }

    @PostMapping(value = "/newsletter",
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            produces = MediaType.TEXT_HTML_VALUE)
    public String postNewsletter(NewsletterRequest newsletterRequest, Model model) {
        NewsletterResponse newsletterResponse = this.newsletterService.createNewsletter(newsletterRequest);
        model.addAttribute(newsletterResponse);
        return "newsletterResult";
    }
}
