
package com.example.demo.Repositorio;

import com.example.demo.Interface.GamaInterface;
import com.example.demo.Modelo.Gama;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Miguel Sneider
 */

@Repository
public class GamaRepositorio {
    
    @Autowired    
    private GamaInterface gamaCrudRepository;
    
    public List<Gama> getAll() {
        return (List<Gama>) gamaCrudRepository.findAll();
    }
    
    public Optional<Gama> getGama(int id) {
        return gamaCrudRepository.findById(id);
    }
    
    public Gama save(Gama gama) {
        return gamaCrudRepository.save(gama);
    }
    
    public void delete(Gama gama){
        gamaCrudRepository.delete(gama);        
    }
    
}
