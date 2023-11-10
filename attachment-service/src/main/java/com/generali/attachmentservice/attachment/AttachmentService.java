package com.generali.attachmentservice.attachment;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AttachmentService {

    private final AttachmentDao attachmentDao;

    List<Attachment> findAll(){
       return attachmentDao.findAll();
    }

    void addAttachment(Attachment attachment){
        attachmentDao.addAttachment(attachment);
    }

}
