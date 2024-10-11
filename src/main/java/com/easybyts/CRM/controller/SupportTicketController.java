package com.easybyts.CRM.controller;


import com.easybyts.CRM.enums.SupportTicketPriority;
import com.easybyts.CRM.enums.SupportTicketStatus;
import com.easybyts.CRM.model.SupportTicket;
import com.easybyts.CRM.service.SupportTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/support_tickets")
public class SupportTicketController {

    @Autowired
    private SupportTicketService supportTicketService;


    @PostMapping
    public ResponseEntity<SupportTicket> createTicket(@RequestBody SupportTicket supportTicket){
        SupportTicket createdTicket = supportTicketService.createTicket(supportTicket);
        return  new ResponseEntity<>(createdTicket, HttpStatus.CREATED);
    }

    @GetMapping
    public List<SupportTicket> getAllTicket(){
        return supportTicketService.getAllTickets();

    }
    @GetMapping("/{id}")
    public ResponseEntity<SupportTicket> getTicketById( @PathVariable Long id){
        SupportTicket ticket = supportTicketService.getTicketById(id);

        return new ResponseEntity<>(ticket, HttpStatus.OK);
    }


    @PutMapping("/{id}/assign")
    public ResponseEntity<SupportTicket> updateAssignedAgent(@PathVariable Long id,
                                                             @RequestBody Map<String, String> request) {
        String assignedAgent = request.get("assignedAgent");

        // Ensure that the assignedAgent field is present in the request body
        if (assignedAgent == null || assignedAgent.isEmpty()) {
            throw new IllegalArgumentException("Assigned agent is required");
        }

        // Update the assigned agent using the service method
        SupportTicket updatedTicket = supportTicketService.assignAgent(id, assignedAgent);
        return ResponseEntity.ok(updatedTicket);
    }


    @GetMapping("/status/{status}")
    public List<SupportTicket> getTicketsByStatus(@PathVariable SupportTicketStatus status) {
        return supportTicketService.getTicketByStatus(status);
    }


    @PutMapping("/{id}/status")
    public ResponseEntity<SupportTicket> updateTicketStatus(@PathVariable Long id,
                                                            @RequestBody Map<String, String> request) {
        String statusString = request.get("status");

        // the status is passing as a string
        if (statusString == null) {
            throw new IllegalArgumentException("Status is required");
        }

        // Converting string to enum
        SupportTicketStatus status;
        try {
            status = SupportTicketStatus.valueOf(statusString.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid status value: " + statusString);
        }

        // Updating the status using the service method
        SupportTicket updatedTicket = supportTicketService.updateTicketStatus(id, status);
        return ResponseEntity.ok(updatedTicket);
    }




    @GetMapping("/priority/{priority}")
    public List<SupportTicket> getTicketByPriority(@PathVariable SupportTicketPriority priority){
        return supportTicketService.getTicketByPriority(priority);
    }


    @DeleteMapping("/{id}")
    public void deleteTicket(@PathVariable Long id){
        supportTicketService.deleteTicket(id);

    }











}
