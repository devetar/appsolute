package org.example.ent;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @ManyToOne
    private Usr usr;
    private LocalDateTime timestamp;
    private String text;

    @Transient
    private final DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    public Message() {
    }

    public Message(Usr usr, String text) {
        this.usr = usr;
        this.text = text;
        timestamp = LocalDateTime.now();
    }

    public String printable() {
        return usr.getUsername() + " (" + format.format(timestamp) + "): " + text;
    }

    public Usr getUsr() {
        return usr;
    }

    public void setUsr(Usr usr) {
        this.usr = usr;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
