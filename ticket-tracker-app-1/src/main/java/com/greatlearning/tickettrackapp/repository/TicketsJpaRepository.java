package com.greatlearning.tickettrackapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greatlearning.tickettrackapp.model.Ticket;

public interface TicketsJpaRepository extends JpaRepository<Ticket,Long> {

	Ticket findByTitleLike(String title);
	
	

}
