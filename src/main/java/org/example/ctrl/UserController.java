package org.example.ctrl;

import org.example.ent.Usr;
import org.example.svc.UsrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UsrService usrService;

    @GetMapping("/allusers")
    public ResponseEntity<List<Usr>> users() {
        return ResponseEntity.ok(usrService.findAll());
    }

//    @GetMapping("/api/private/users")
//    @PreAuthorize("isAuthenticated()")
//    public ResponseEntity<String> getUsers() {
//        // Implement your private endpoint logic here
//    }
}
