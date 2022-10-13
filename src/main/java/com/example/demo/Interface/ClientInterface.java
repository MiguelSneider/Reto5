
package com.example.demo.Interface;

import com.example.demo.Modelo.Client;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Miguel Sneider
 */

public interface ClientInterface extends CrudRepository <Client, Integer> {
    
}
