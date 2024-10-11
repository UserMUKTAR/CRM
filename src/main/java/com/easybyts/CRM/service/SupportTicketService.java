package com.easybyts.CRM.service;

import com.easybyts.CRM.enums.SupportTicketPriority;
import com.easybyts.CRM.enums.SupportTicketStatus;
import com.easybyts.CRM.exception.ResourceNotFoundException;
import com.easybyts.CRM.model.SupportTicket;
import com.easybyts.CRM.repository.SupportTicketRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupportTicketService {

    @Autowired
    private SupportTicketRepository supportTicketRepository;


    public SupportTicket createTicket(SupportTicket supportTicket){
//        supportTicket.setStatus(SupportTicketStatus.OPEN);
        return supportTicketRepository.save(supportTicket);
    }

    public List<SupportTicket> getAllTickets(){
        return supportTicketRepository.findAll();
    }

     public SupportTicket getTicketById(Long id){
        return supportTicketRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Ticket not found with id: " + id));

     }


     public SupportTicket assignAgent(Long id, String agentName){
        SupportTicket ticket = getTicketById(id);
        ticket.setAssignedAgent(agentName);
        return supportTicketRepository.save(ticket);
     }


     public void deleteTicket(Long id){
        SupportTicket ticket = getTicketById(id);
        supportTicketRepository.deleteById(id);
     }



     public List<SupportTicket> getTicketByStatus(SupportTicketStatus status){
        return supportTicketRepository.findByStatus(status);
     }




    public List<SupportTicket> getTicketByPriority(SupportTicketPriority priority){
        return supportTicketRepository.findByPriority(priority);
    }


    public SupportTicket updateTicketStatus(Long id, SupportTicketStatus newStatus){

        SupportTicket ticket = getTicketById(id);
        ticket.setStatus(newStatus);
        return supportTicketRepository.save(ticket);

//        Optional<SupportTicket> ticketOptional = supportTicketRepository.findById(id);
//
//        if (ticketOptional.isEmpty()){
//            throw new ResourceNotFoundException("Support ticket with id: " + id + "Not found.");
//        }
//        SupportTicket ticket = ticketOptional.get();
//        System.out.println("Before Update: Status = " + ticket.getStatus());  // Log current status
//        System.out.println("New Status: " + newStatus);  // Log new status
//
//        ticket.setStatus(newStatus);
//
//        SupportTicket updatedTicket = supportTicketRepository.save(ticket);
//
//        System.out.println("After Update: Status = " + updatedTicket.getStatus());  // Log after update
//
//        return updatedTicket;
    }

}
