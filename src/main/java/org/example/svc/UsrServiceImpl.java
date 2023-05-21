package org.example.svc;

import org.example.ent.Usr;
import org.example.repo.UsrRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsrServiceImpl implements UsrService {
    @Autowired
    private UsrRepository usrRepository;

    @Override
    public Usr save(Usr user) {
        return usrRepository.save(user);
    }

    @Override
    public List<Usr> findAll() {
        return usrRepository.findAll();
    }

    @Override
    public Usr findByUsername(String username) {
        return usrRepository.findByUsername(username).orElse(null);
    }

    @Override
    public boolean existsByUsername(String username) {
        return usrRepository.existsByUsername(username);
    }

    @Override
    public boolean existsByEmail(String email) {
        return usrRepository.existsByEmail(email);
    }
}
