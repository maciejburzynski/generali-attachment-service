package com.generali.attachmentservice.attachment;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.SQLException;
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

/*
Not used in the project
Demonstrates how to create savepoint to be able to work with @Transactional and Propagation mode = NESTED
JPA does not support Savepoints at the moment (10.11.2023 21:37)
 */
    private void savePoint() throws SQLException {
        Connection connection = jdbcTemplate.getDataSource().getConnection();
        connection.setSavepoint();
        connection.setSavepoint("SP1");
        connection.setSavepoint("SP2");
    }


}
