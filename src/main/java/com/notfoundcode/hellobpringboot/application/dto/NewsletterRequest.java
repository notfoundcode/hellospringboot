package com.notfoundcode.hellobpringboot.application.dto;

import lombok.Data;

@Data
public class NewsletterRequest {

    private String name;
    private String email;

    //getters and setters is automatically added because the class is annotated with @Data - Thanks Lombok :)

}
