
package com.example.demo.Servicio;


import com.example.demo.Modelo.Client;
import com.example.demo.Repositorio.ClientRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Miguel Sneider
 */

@Service
public class ClientServicio {
    @Autowired    
    private ClientRepositorio clientRepository;
    
    public List<Client> getAll(){
        return clientRepository.getAll();
    }
    
    public Optional<Client> getClient(int clientId) {
        return clientRepository.getClient(clientId);
    }
    
    public Client save(Client client) {
        if(client.getIdClient() == null) {
            return clientRepository.save(client);
        } else {
            Optional<Client> s = clientRepository.getClient(client.getIdClient());
                if (s.isEmpty()) {
                    return clientRepository.save(client);
                } else {
                    return client;
                }
        }
    }
    
        public Client update(Client client){
        if (client.getIdClient () != null) {
            Optional<Client> s = clientRepository.getClient(client.getIdClient());
            if (!s.isEmpty()){
                if (client.getName() != null){
                    s.get().setName(client.getName());
                }
                if (client.getAge() != null){
                    s.get().setAge(client.getAge());
                }
                if (client.getPassword() != null){
                    s.get().setPassword(client.getPassword());
                }
                clientRepository.save(s.get());
                return s.get();
            } else {
                return client;
            }
        }
        return client;
    }
    
     public boolean deleteClient(int clientId){
        Boolean d = getClient(clientId).map( client -> {
           clientRepository.delete(client);
           return true;                 
        }) .orElse(false);
        
        return d;
    }
}
