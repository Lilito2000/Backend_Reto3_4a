package com.retotres.controller;

import com.retotres.model.Clothe;
import com.retotres.service.ClotheService;
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
 *
 * @author lilia
 */
@RestController
@RequestMapping("/api/clothe")
@CrossOrigin("*")
public class ClotheController {
 
    @Autowired
    private ClotheService clotheService;

    @GetMapping("/all")
    public List<Clothe> getAll() {
        return clotheService.getAll();
    }
    
    @GetMapping("/{reference}")
    public Optional<Clothe> getClothe(@PathVariable("reference") String reference) {
        return clotheService.getClothe(reference);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Clothe create(@RequestBody Clothe clothe) {
        return clotheService.create(clothe);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Clothe update(@RequestBody Clothe clothe) {
        return clotheService.update(clothe);
    }

    @DeleteMapping("/{reference}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("reference") String reference) {
        return clotheService.delete(reference);
    }
  
}
