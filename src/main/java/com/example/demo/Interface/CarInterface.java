
package com.example.demo.Interface;

import com.example.demo.Modelo.Car;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Miguel Sneider
 */

public interface CarInterface extends CrudRepository <Car, Integer> {
    
}
