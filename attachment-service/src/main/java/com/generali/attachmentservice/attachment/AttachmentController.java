package com.generali.attachmentservice.attachment;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AttachmentController {

    private final AttachmentService attachmentService;


    @GetMapping("/api/attachments")
    List<Attachment> getAll() {
        return attachmentService.findAll();
    }

    @PostMapping("/api/attachments")
    void addAttachment(@RequestBody Attachment attachment) {
        attachmentService.addAttachment(attachment);
    }
}
