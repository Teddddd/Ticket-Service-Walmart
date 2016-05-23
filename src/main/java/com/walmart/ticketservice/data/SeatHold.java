/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.walmart.ticketservice.data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Tewodros
 */
public interface SeatHold {
    
    Optional<LocalDateTime> getHeldOn();

    Optional<LocalDateTime> getResearvedOn();

    int getSeatHoldId();

    void setSeatHoldId(int seatHoldId);
    
    String getCustomerEmail();
    
    void addSeats(List<Seat> seats);

    public void researve();
    
    String getResearvationCode();
}
