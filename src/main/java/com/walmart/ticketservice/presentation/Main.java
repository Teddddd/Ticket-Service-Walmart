/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.walmart.ticketservice.presentation;

import com.walmart.ticketservice.data.SeatHold;
import com.walmart.ticketservice.service.TicketService;
import com.walmart.ticketservice.service.TicketServiceImpl;
import java.util.Optional;

/**
 *
 * @author Tewodros
 */
public class Main {

    public static void main(String[] args) {
        TicketService ticketService = new TicketServiceImpl();
        System.out.println("Total Available level 1 seat: " + ticketService.numSeatsAvailable(Optional.of(1)));
        System.out.println("Total Available level 2 seat: " + ticketService.numSeatsAvailable(Optional.of(2)));
        SeatHold seatHold = ticketService.findAndHoldSeats(100, Optional.of(1), Optional.of(1), "a@b.c");
        System.out.println("Total Available level 1 seat: " + ticketService.numSeatsAvailable(Optional.of(1)));
        //email param is irrelevant here
        ticketService.reserveSeats(seatHold.getSeatHoldId(), "a@b.c");
        System.out.println("Total Available level 1 seat: " + ticketService.numSeatsAvailable(Optional.of(1)));
        System.out.println("Total Available level 2 seat: " + ticketService.numSeatsAvailable(Optional.of(2)));
    }
}
