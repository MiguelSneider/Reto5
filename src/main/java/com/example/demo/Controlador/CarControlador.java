
package com.example.demo.Controlador;

import com.example.demo.Modelo.Car;
import com.example.demo.Servicio.CarServicio;
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
 * @author Miguel Sneider
 */

@RestController
@RequestMapping("/api/Car")
@CrossOrigin(origins = "*") 
public class CarControlador {
    
    @Autowired
    private CarServicio carService;
    
    @GetMapping("/all")
    public List<Car> getCars() {
        return carService.getAll();
    }
    
    @GetMapping("/ {id}")
    public Optional<Car> getCar(@PathVariable("id") int carId) {
        return carService.getCar(carId);
    }
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Car save(@RequestBody Car car) {
        return carService.save(car);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
     public Car update(@RequestBody Car car) {
        return carService.update(car);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int carId) {
        return carService.deleteCar(carId);
    }
}
