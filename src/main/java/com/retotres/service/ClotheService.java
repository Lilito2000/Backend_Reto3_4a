package com.retotres.service;

import com.retotres.model.Clothe;
import com.retotres.repository.ClotheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author lilia
 */
@Service
public class ClotheService {

    @Autowired
    private ClotheRepository clotheRepository;

    public List<Clothe> getAll() {
        return clotheRepository.getAll();
    }

    public Optional<Clothe> getClothe(String reference) {
        return clotheRepository.getClothe(reference);
    }

    public Clothe create(Clothe clothe) {
        if (clothe.getReference() == null) {
            return clothe;
        } else {
            return clotheRepository.create(clothe);
        }
    }

    public Clothe update(Clothe clothe) {

        if (clothe.getReference() != null) {
            Optional<Clothe> clotheDb = clotheRepository.getByReference(clothe.getReference());
            if (!clotheDb.isEmpty()) {
                
                if (clothe.getSize()!= null) {
                    clotheDb.get().setSize(clothe.getSize());
                }
                
                if (clothe.getCategory() != null) {
                    clotheDb.get().setCategory(clothe.getCategory());
                }
                
                if (clothe.getDescription() != null) {
                    clotheDb.get().setDescription(clothe.getDescription());
                }
                if (clothe.getPrice() != 0.0) {
                    clotheDb.get().setPrice(clothe.getPrice());
                }
                if (clothe.getQuantity() != 0) {
                    clotheDb.get().setQuantity(clothe.getQuantity());
                }
                if (clothe.getPhotography() != null) {
                    clotheDb.get().setPhotography(clothe.getPhotography());
                }
                clotheDb.get().setAvailability(clothe.isAvailability());
                clotheRepository.update(clotheDb.get());
                return clotheDb.get();
            } else {
                return clothe;
            }
        } else {
            return clothe;
        }
    }

    public boolean delete(String reference) {
        Boolean aBoolean = getClothe(reference).map(accesory -> {
            clotheRepository.delete(accesory);
            return true;
        }).orElse(false);
        return aBoolean;
    }

    public List<Clothe> productByPrice(double price) {
        return clotheRepository.productByPrice(price);
    }

}
