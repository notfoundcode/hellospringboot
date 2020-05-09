package com.notfoundcode.hellobpringboot.application.resource;

import com.notfoundcode.hellobpringboot.application.dto.NewsletterRequest;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class NewsletterResource {

    @PostMapping(value = "/newsletter", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = MediaType.TEXT_HTML_VALUE)
    public String postNewsletter(NewsletterRequest newsletterRequest, Model model){
        model.addAttribute("newsletterData",  newsletterRequest);
        return "newsletterResult";
    }
}
