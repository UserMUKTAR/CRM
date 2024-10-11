package com.easybyts.CRM.repository;

import com.easybyts.CRM.enums.SupportTicketPriority;
import com.easybyts.CRM.enums.SupportTicketStatus;
import com.easybyts.CRM.model.SupportTicket;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SupportTicketRepository extends JpaRepository<SupportTicket, Long> {

//    @Query("SELECT t FROM SupportTicket t WHERE t.status = :status AND t.priority = :priority")
//    List<SupportTicket> findByStatusAndPriority(@Param("status") SupportTicketStatus status,
//                                                @Param("priority") SupportTicketPriority priority);

    List<SupportTicket> findByStatus(SupportTicketStatus status);

    List<SupportTicket> findByPriority(SupportTicketPriority priority);



}
