package org.example.svc;

import org.example.ent.Usr;

import java.util.List;

public interface UsrService {
    Usr save(Usr user);
    List<Usr> findAll();
    Usr findByUsername(String username);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
}
