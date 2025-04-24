/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.electricista.controller;

import com.electricista.domain.Ticket;
import com.electricista.domain.Electrician;
import com.electricista.dao.TicketRepository;
import com.electricista.dao.ElectricianRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 * @author joshu
 */
@Controller
@RequestMapping("/admin/tickets")
public class TicketController {

    private final TicketRepository ticketRepository;
    private final ElectricianRepository technicianRepository;

    public TicketController(TicketRepository ticketRepository, ElectricianRepository technicianRepository) {
        this.ticketRepository = ticketRepository;
        this.technicianRepository = technicianRepository;
    }

    @GetMapping
    public String showTickets(Model model, @RequestParam(value = "status", required = false) String status) {
        List<Ticket> tickets = (status == null || status.isEmpty())
                ? ticketRepository.findAll()
                : ticketRepository.findByStatus(status);
        model.addAttribute("tickets", tickets);
        model.addAttribute("statuses", List.of("Pendiente", "Asignado", "Resuelto"));
        model.addAttribute("technicians", technicianRepository.findAll());
        return "admin/tickets";
    }

    @PostMapping("/{id}/assign")
    public String assignTicket(@PathVariable Long id, @RequestParam Long technicianId) {
        Ticket ticket = ticketRepository.findById(id).orElseThrow();
        Electrician technician = technicianRepository.findById(technicianId).orElseThrow();
        ticket.setTechnician(technician);
        ticket.setStatus("Asignado");
        ticketRepository.save(ticket);
        return "redirect:/admin/tickets";
    }

    @PostMapping("/{id}/resolve")
    public String resolveTicket(@PathVariable Long id) {
        Ticket ticket = ticketRepository.findById(id).orElseThrow();
        ticket.setStatus("Resuelto");
        ticketRepository.save(ticket);
        return "redirect:/admin/tickets";
    }
}
