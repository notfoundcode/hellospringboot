package com.notfoundcode.hellobpringboot.domain.model;

import com.notfoundcode.hellobpringboot.application.dto.NewsletterRequest;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
@Getter
@Entity
public class Newsletter {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String email;

    public Newsletter(NewsletterRequest newsletterRequest) {
        this.name = newsletterRequest.getName();
        this.email = newsletterRequest.getEmail();
    }

    public Newsletter(NewsletterRequest newsletterRequest, Newsletter olderNewsletter){
        this.id = olderNewsletter.getId();
        this.name = newsletterRequest.getName();
        this.email = olderNewsletter.getEmail();
    }
}
