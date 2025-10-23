package com.java.cadastro_usuario.controller;
import com.java.cadastro_usuario.business.UserService;
import com.java.cadastro_usuario.infrastructure.entitys.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private  final UserService user_service;

    @PostMapping
    public ResponseEntity<User> save_user(@RequestBody User user){
        User savedUser = user_service.save_user(user);
        return ResponseEntity.ok(savedUser);
    }

    @GetMapping
    public ResponseEntity<User> get_user_by_email(@RequestParam String email){
        return ResponseEntity.ok(user_service.get_user_by_email(email));
    }

    @DeleteMapping
    public  ResponseEntity<Void> delete_user(@RequestParam String email){
        user_service.delete_user_by_email(email);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> update_user_by_id(@RequestParam Integer id, @RequestBody User user){
        user_service.update_user_by_id(id , user);
        return ResponseEntity.ok().build();
    }

}
