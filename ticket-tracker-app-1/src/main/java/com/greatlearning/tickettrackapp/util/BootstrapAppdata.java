package com.greatlearning.tickettrackapp.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

import com.greatlearning.tickettrackapp.model.Ticket;
import com.greatlearning.tickettrackapp.repository.TicketsJpaRepository;

@Configuration
public class BootstrapAppdata {

	@Autowired
	private TicketsJpaRepository ticketRepository;

	@EventListener(ApplicationReadyEvent.class)
	public void onReady(ApplicationReadyEvent event) {

		Ticket MumbaiTicket = new Ticket();

		MumbaiTicket.setTitle("Ticket1");
		MumbaiTicket.setDescription("Ticket to Mumbai");
		MumbaiTicket.setContent(
				"Mumbai (formerly called Bombay) is a densely populated city on India’s west coast. A financial center, it's India's largest city.");
		Date date1 = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
		String str = formatter.format(date1);
		MumbaiTicket.setDate(str);

		Ticket ticket2 = new Ticket();

		ticket2.setTitle("Ticket2");
		ticket2.setDescription("Ticket to Bangalore");
		ticket2.setContent(
				"Bengaluru (also called Bangalore) is the capital of India's southern Karnataka state. The center of India's high-tech industry, "
						+ "the city is also known for its parks and nightlife");
		@SuppressWarnings("unused")
		Date date2 = new Date();
		SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yy");
		String str1 = formatter1.format(date1);
		ticket2.setDate(str1);

		this.ticketRepository.save(MumbaiTicket);
		this.ticketRepository.save(ticket2);
	}

}
