package com.retotres.controller;

import com.retotres.model.User;
import com.retotres.model.User;
import com.retotres.service.UserService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Reto No. 3: Orden de Pedidos – Listado y Aprobación Orden de Pedidos
 * @author lilia
 * versión 1.0
 * fecha 11-12-2021
 */
@RestController
@RequestMapping("/api/user")
@CrossOrigin("*")
public class UserController {
    
    // Atributo
    @Autowired
    private UserService userService;

    /**
     * Método para mostrar todos los usuarios
     * @return usuarios
     */
    @GetMapping("/all")
    public List<User> getAll() {
        return userService.getAll();
    }
    
    /**
     * Método para mostrar un usuario por el id
     * @param id
     * @return usuario
     */
    @GetMapping("/{id}")
    public Optional <User> getUser(@PathVariable("id") int id) {
        return userService.getUser(id);
    }

    /**
     * Método para crear nuevos usuarios
     * @param user
     * @return
     */
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User create(@RequestBody User user) {
        return userService.create(user);
    }
    
    /**
     * Método para modificar la información del usuario
     * @param user
     * @return
     */
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public User update(@RequestBody User user) {
        return userService.update(user);
    }

    /**
     * Método para eliminar un usuario
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id) {
        return userService.delete(id);
    }
    
    /**
     * Método para autenticar la validez de un usuario
     * @param email
     * @param password
     * @return
     */
    @GetMapping("/{email}/{password}")
    public User authenticateUser(@PathVariable("email") String email, @PathVariable("password") String password) {
        return userService.authenticateUser(email, password);
    }
    
    /**
     * Método para verificar la existencia de un usuario
     * @param email
     * @return
     */
    @GetMapping("/emailexist/{email}")
    public boolean emailExists(@PathVariable("email") String email) {
        return userService.emailExists(email);
    }
    
    /**
     * Método para mostrar la fecha de cumpleaños de un usuario
     * @param monthBirthtDay
     * @return
     */
    @GetMapping("/birthday/{month}")
    public List<User> birthtDayList(@PathVariable("month") String monthBirthtDay) {
        return userService.birthtDayList(monthBirthtDay);
    }
}
