package com.notfoundcode.hellobpringboot.application.dto;

import com.notfoundcode.hellobpringboot.domain.model.Newsletter;
import lombok.Getter;

@Getter
public class NewsletterResponse {

    private String name;
    private String email;

    public NewsletterResponse(Newsletter newsletter) {
        this.name = newsletter.getName();
        this.email = newsletter.getEmail();
    }
    //getters is automatically added because the class is annotated with @Getter - Thanks Lombok :)
}
