package com.retotres.repository.crud;

import com.retotres.model.Clothe;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author Lilia
 */
public interface ClotheCrudRepository extends MongoRepository<Clothe, String> {
    public List<Clothe> findByPriceLessThanEqual(double precio);
}
