package com.generali.attachmentservice.attachment;


import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.ZoneId;

public class AttachmentMapper implements RowMapper<Attachment> {

    @Override
    public Attachment mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        return  new Attachment(
                resultSet.getLong("id"),
                resultSet.getString("name"),
                resultSet.getString("content"),
                resultSet.getTimestamp("created_at").toLocalDateTime());
    }
}
