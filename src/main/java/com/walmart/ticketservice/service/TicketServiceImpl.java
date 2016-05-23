/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.walmart.ticketservice.service;

import com.walmart.ticketservice.data.AppSettings;
import com.walmart.ticketservice.data.DataAccess;
import com.walmart.ticketservice.data.Seat;
import java.util.Optional;
import java.util.stream.Collectors;
import com.walmart.ticketservice.data.SeatHold;
import com.walmart.ticketservice.data.SeatHoldImpl;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author Tewodros
 */
public class TicketServiceImpl implements TicketService {

    @Override
    public int numSeatsAvailable(Optional<Integer> venueLevel) {
        return (int) DataAccess.getInstance().getAllSeats().stream()
                .filter(s -> (!venueLevel.isPresent() || s.getLevelId() == venueLevel.get()) && s.isAvailable()).count();
    }

    @Override
    public SeatHold findAndHoldSeats(int numSeats, Optional<Integer> minLevel, Optional<Integer> maxLevel, String customerEmail) {
        List<Seat> seats = DataAccess.getInstance().getAllSeats().stream()
                .filter(s -> s.isAvailable()
                        && (!minLevel.isPresent() || s.getLevelId() >= minLevel.get())
                        && (!maxLevel.isPresent() || s.getLevelId() <= maxLevel.get())
                )
                .sorted(Comparator.comparing(s -> s.getLevelId()))
                .limit(numSeats)
                .collect(Collectors.toList());

        SeatHold seatHold = new SeatHoldImpl(customerEmail);
        seatHold.addSeats(seats);
        DataAccess.getInstance().addSeatHold(seatHold);

        return seatHold;
    }

    @Override
    public String reserveSeats(int seatHoldId, String customerEmail) {
        SeatHold seatHold = DataAccess.getInstance().getSeatHold(seatHoldId);
        seatHold.researve();
        return seatHold.getResearvationCode();
    }

}
