
package com.example.demo.Servicio;

import com.example.demo.Modelo.Reservation;
import com.example.demo.Repositorio.CountClient;
import com.example.demo.Repositorio.ReservationRepositorio;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Miguel Sneider
 */

@Service
public class ReservationServicio {

    @Autowired    
    private ReservationRepositorio reservationRepository;
    
    public List<Reservation> getAll(){
        return reservationRepository.getAll();
    }
    
    public Optional<Reservation> getReservation(int reservationId) {
        return reservationRepository.getReservation(reservationId);
    }
    
    public Reservation save(Reservation reservation) {
        if(reservation.getIdReservation() == null) {
            return reservationRepository.save(reservation);
        } else {
            Optional<Reservation> e = reservationRepository.getReservation(reservation.getIdReservation());
                if (e.isEmpty()) {
                    return reservationRepository.save(reservation);
                } else {
                    return reservation;
                }
        }
    }
    
    public Reservation update(Reservation reservation){
        if (reservation.getIdReservation () != null) {
            Optional<Reservation> s = reservationRepository.getReservation(reservation.getIdReservation());
            if (!s.isEmpty()){
                if (reservation.getStartDate() != null){
                    s.get().setStartDate(reservation.getStartDate());
                }
                if (reservation.getDevolutionDate() != null){
                    s.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if (reservation.getStatus() != null){
                    s.get().setStatus(reservation.getStatus());
                }
                reservationRepository.save(s.get());
                return s.get();
                
                } else {
                    return reservation;
            }
        } else {
            return reservation;
        }
    }
    
    public boolean deleteReservation(int reservationId){
        Boolean d = getReservation(reservationId).map( reservation -> {
           reservationRepository.delete(reservation);
           return true;                 
        }) .orElse(false);
        
        return d;
    }
    
    public Status getReservationStatusReport(){
        List<Reservation> completed = reservationRepository.getReservationByStatus("completed");
        List<Reservation> cancelled = reservationRepository.getReservationByStatus("cancelled");
        return new Status(completed.size(), cancelled.size());
    }
    
    public List<Reservation> DateTimeReservation(String dataA, String dataB){
        SimpleDateFormat consult = new SimpleDateFormat("yyyy-MM-dd");
        Date a = new Date();
        Date b = new Date();
        
        try {
            a = consult.parse(dataA);
            b = consult.parse(dataB);
        } catch  (ParseException e) {
            e.printStackTrace();
        }
        if(a.before(b)){
            return reservationRepository.DateTimeReservation(a, a);
        } else {
            return new ArrayList<>();
        }        
    }
    
    public List<CountClient> getTopClient(){
        return reservationRepository.getTopClient();
    }
}