
package com.example.demo.Servicio;

import com.example.demo.Modelo.Car;
import com.example.demo.Repositorio.CarRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Miguel Sneider
 */

@Service
public class CarServicio {
    
    @Autowired    
    private CarRepositorio carRepository;
    
    public List<Car> getAll(){
        return carRepository.getAll();
    }
    
    public Optional<Car> getCar(int carId) {
        return carRepository.getCar(carId);
    }
    
    public Car save(Car car) {
        if(car.getIdCar() == null) {
            return carRepository.save(car);
        } else {
            Optional<Car> e = carRepository.getCar(car.getIdCar());
                if (e.isEmpty()) {
                    return carRepository.save(car);
                } else {
                    return car;
                }
        }
    }
    
        public Car update(Car car){
        if (car.getIdCar () != null) {
            Optional<Car> s = carRepository.getCar(car.getIdCar());
            if (!s.isEmpty()){
                if (car.getName() != null){
                    s.get().setName(car.getName());
                }
                if (car.getBrand() != null){
                    s.get().setBrand(car.getBrand());
                }
                if (car.getYear() != null){
                    s.get().setYear(car.getYear());
                }
                if (car.getDescription() != null){
                    s.get().setDescription(car.getDescription());
                }
                if (car.getGama() != null){
                    s.get().setGama(car.getGama());
                }
                carRepository.save(s.get());
                return s.get();
            } else {
                return car;
            }
        } else {
            return car;
        }
    }
    
    public boolean deleteCar(int carId){
        Boolean d = getCar(carId).map( car -> {
           carRepository.delete(car);
           return true;                 
        }) .orElse(false);
        
        return d;
    }

}
