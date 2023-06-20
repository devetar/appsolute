package org.example.svc;

import org.example.ent.Message;

import java.util.List;

public interface MessageService {
    Message save(Message message);
    List<Message> findAll();
}
