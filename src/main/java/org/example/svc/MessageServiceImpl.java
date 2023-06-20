package org.example.svc;

import org.example.ent.Message;
import org.example.repo.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageRepository messageRepository;

    @Override
    public Message save(Message message) {
        return messageRepository.save(message);
    }

    @Override
    public List<Message> findAll() {
        return messageRepository.findAll();
    }
}
