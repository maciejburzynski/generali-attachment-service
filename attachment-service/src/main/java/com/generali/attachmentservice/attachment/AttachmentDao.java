package com.generali.attachmentservice.attachment;

import java.util.List;

public interface AttachmentDao {

    List<Attachment> findAll();
    void addAttachment(Attachment attachment);

}
