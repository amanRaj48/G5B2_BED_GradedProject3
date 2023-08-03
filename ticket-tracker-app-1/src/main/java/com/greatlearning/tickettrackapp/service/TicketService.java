package com.greatlearning.tickettrackapp.service;

import java.util.List;

import com.greatlearning.tickettrackapp.model.Ticket;

public interface TicketService {

	Ticket saveTicket(Ticket ticket);

	List<Ticket> viewAllTickets();

	Ticket editTicket(long id, Ticket ticket);

	Ticket findTicketById(long id);

	Ticket findTicketByTitle(String title);

	void deleteTicket(long id);

}
