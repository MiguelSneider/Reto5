
package com.example.demo.Repositorio;

import com.example.demo.Interface.CarInterface;
import com.example.demo.Modelo.Car;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Miguel Sneider
 */

@Repository
public class CarRepositorio {
    
    @Autowired
    private CarInterface carCrudRepository;
    
    public List<Car> getAll() {
        return (List<Car>) carCrudRepository.findAll();
    }
    
    public Optional<Car> getCar(int id) {
        return carCrudRepository.findById(id);
    }
    
    public Car save(Car car) {
        return carCrudRepository.save(car);
    }
    
    public void delete(Car car){
        carCrudRepository.delete(car);        
    }
    
    
}
