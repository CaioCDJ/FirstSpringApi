package com.api.spring_api.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.spring_api.models.User;
import com.api.spring_api.repositories.UserRepository;
import com.fasterxml.jackson.core.sym.Name;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/user")
//@AllArgsConstructor = anula o construtor do repositorio
public class UserController {
 
  private UserRepository _repository;
 
  // boa pratica
  public UserController(UserRepository repository){
    this._repository = repository;
  }
  

  @GetMapping
  public ResponseEntity<List<User>>List(){
    
    List<User> users = _repository.findAll();

    if(users.isEmpty()){
      return ResponseEntity.noContent().build();
    }

    return ResponseEntity.ok().body(users);
  }

  @GetMapping("/{id}")
  public ResponseEntity<User> getUserbyId(@PathVariable Long id){

    return _repository.findById(id)
      .map(record -> ResponseEntity.ok().body(record))
      .orElse(ResponseEntity.notFound().build());
  }

  
  @PostMapping
  public void create(@RequestBody User user){
    _repository.save(user);
  }

  @DeleteMapping("/{id}")
  public void remove(@PathVariable Long id){

    _repository.deleteById(id);
  }

}
