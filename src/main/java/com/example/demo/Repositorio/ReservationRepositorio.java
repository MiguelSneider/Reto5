
package com.example.demo.Repositorio;

import com.example.demo.Interface.ReservationInterface;
import com.example.demo.Modelo.Client;
import com.example.demo.Modelo.Reservation;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Miguel Sneider
 */
@Repository

public class ReservationRepositorio {
    @Autowired
    private ReservationInterface reservationCrudRepository;
    
       public List<Reservation> getAll(){
        return (List<Reservation>) reservationCrudRepository.findAll();
    }
       
     public Optional<Reservation> getReservation(int id){
        return reservationCrudRepository.findById(id);
    }

    public Reservation save(Reservation reservation){
        return reservationCrudRepository.save(reservation);
    }
    
    public void delete(Reservation reservation){
        reservationCrudRepository.delete(reservation);        
    }
    
    public List<Reservation> getReservationByStatus(String Status) {
        return reservationCrudRepository.findAllByStatus(Status);
    }
    
    public List<Reservation> DateTimeReservation(Date a, Date b) {
        return reservationCrudRepository.findAllByStartDateAfterAndStartDateBefore(a, b);
    }
    
    public List<CountClient> getTopClient() {
        List<CountClient> res = new ArrayList<>();
        List<Object[]> report = reservationCrudRepository.countTotalReservationsByClient();
            for(int i=0; i<report.size(); i++){
                res.add(new CountClient((Long)report.get(i)[1],(Client) report.get(i)[0]));
            }
        return res;    
    }
}