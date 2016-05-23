/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.walmart.ticketservice.data;

import java.util.stream.Stream;

/**
 *
 * @author Tewodros
 */
public interface Seat {
    
    SeatHold getSeatHold();

    void setSeatHold(SeatHold seatHold);
    
    int getSeatId();

    void setSeatId(int seatId);

    String getSeatNumber();

    void setSeatNumber(String seatNumber);

    int getLevelId();

    void setLevelId(int levelId);

    public boolean isAvailable();
}
