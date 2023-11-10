package com.generali.attachmentservice.attachment;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class AttachmentRepository implements AttachmentDao{

    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<Attachment> findAll() {
        String query = "SELECT id, name, content, created_at " +
                "FROM Attachments";

        return jdbcTemplate.query(query, new AttachmentMapper());
    }

    @Override
    public void addAttachment(Attachment attachment) {
        String query = "INSERT INTO Attachments (name, content) " +
                "VALUES (?,?)";

         jdbcTemplate.update(query,
                 attachment.name(),
                 attachment.content());
    }
}
