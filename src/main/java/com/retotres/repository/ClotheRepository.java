package com.retotres.repository;

import com.retotres.model.Clothe;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.retotres.repository.crud.ClotheCrudRepository;

/**
 *
 * @author lilia
 */
@Repository
public class ClotheRepository {
    
    @Autowired
    private ClotheCrudRepository clotheCrudRepository;

    public List<Clothe> getAll() {
        return clotheCrudRepository.findAll();
    }

    public Optional<Clothe> getByReference(String reference) {
        return clotheCrudRepository.findById(reference);
    }
    public Optional<Clothe> getClothe(String reference) {
        return clotheCrudRepository.findById(reference);
    }
    
    public Clothe create(Clothe clothe) {
        return clotheCrudRepository.save(clothe);
    }

    public void update(Clothe clothe) {
        clotheCrudRepository.save(clothe);
    }
    
    public void delete(Clothe clothe) {
        clotheCrudRepository.delete(clothe);
    }
    
    public List<Clothe> productByPrice(double precio) {
	return clotheCrudRepository.findByPriceLessThanEqual(precio);
}
}
