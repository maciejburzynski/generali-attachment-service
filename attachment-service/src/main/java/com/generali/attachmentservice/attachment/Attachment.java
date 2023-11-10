package com.generali.attachmentservice.attachment;

import java.time.LocalDateTime;

public record Attachment(
        Long id,
        String name,
        String content,
        LocalDateTime createdAt
) {
}
