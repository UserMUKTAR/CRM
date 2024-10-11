package com.easybyts.CRM.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

//@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum SupportTicketStatus {
    OPEN,
    IN_PROGRESS,
    RESOLVED,
    CLOSED
}
