package com.greatlearning.tickettrackapp.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatlearning.tickettrackapp.model.Ticket;
import com.greatlearning.tickettrackapp.service.TicketService;

@Controller
@RequestMapping("/admin")
public class TicketController {

	@Autowired
	private TicketService ticketService;

	public TicketController(TicketService ticketService) {
		this.ticketService = ticketService;
	}

	@GetMapping("/tickets")
	public String ticketList(Model model) {
		List<Ticket> tickets = this.ticketService.viewAllTickets();
		model.addAttribute("tickets", tickets);
		return "ticket/list-tickets";
	}

	@PostMapping("/tickets/save")
	public String saveTicket(@ModelAttribute("ticket") Ticket ticket) {
		Date date1 = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
		String str = formatter.format(date1);
		ticket.setDate(str);
		this.ticketService.saveTicket(ticket);

		return "redirect:/admin/tickets";
	}

	@PostMapping("/tickets/edit")
	public String showFormForEdit(@RequestParam("id") int id, Model model) {

		Ticket theTicket = ticketService.findTicketById(id);

		model.addAttribute("ticket", theTicket);

		return "ticket/edit-ticket";
	}

	@PostMapping("/delete")
	public String deleteTicket(@RequestParam("id") int id) {
		this.ticketService.deleteTicket(id);
		return "redirect:/admin/tickets";
	}

	@GetMapping("/tickets/newTicket")
	public String showFormForAdd(Model model) {
		Ticket ticket = new Ticket();

		model.addAttribute("ticket", ticket);

		return "ticket/ticket-form";
	}

	@GetMapping("/tickets/view")
	public String viewTicket(@RequestParam("id") int id, Model model) {
		Ticket theTicket1 = ticketService.findTicketById(id);

		model.addAttribute("ticket", theTicket1);

		return "ticket/view-ticket";
	}

	@GetMapping("/search")
	public String searchBar(@RequestParam("title") String title, Model model) {
		if (title != null) {
			Ticket theTicket2 = ticketService.findTicketByTitle(title);

			if (theTicket2 != null) {
				model.addAttribute("ticket", theTicket2);
				return "ticket/view-ticket";
			} else {

				model.addAttribute("errorMessage", "Ticket not found for title: " + title);
				List<Ticket> tickets = ticketService.viewAllTickets();
				model.addAttribute("tickets", tickets);
				return "ticket/list-tickets";
			}
		} else {
			List<Ticket> tickets = ticketService.viewAllTickets();
			model.addAttribute("tickets", tickets);
			return "ticket/list-tickets";
		}
	}

}
