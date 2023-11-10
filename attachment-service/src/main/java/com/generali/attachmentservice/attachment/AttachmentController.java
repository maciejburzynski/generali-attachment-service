package com.generali.attachmentservice.attachment;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AttachmentController {

    @GetMapping("/")
    String hello() {
        return "hello";
    }
}
