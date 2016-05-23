/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.walmart.ticketservice.data;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.stream.Stream;

/**
 *
 * @author Tewodros
 */
public class SeatImpl implements Seat {

    public SeatImpl(int seatId, int levelId, String seatNumber, SeatHold seatHold) {
        this.seatId = seatId;
        this.levelId = levelId;
        this.seatNumber = seatNumber;
        this.seatHold = seatHold;
    }

    private int seatId;
    private int levelId;
    private String seatNumber;
    private SeatHold seatHold;

    @Override
    public SeatHold getSeatHold() {
        return seatHold;
    }

    @Override
    public void setSeatHold(SeatHold seatHold) {
        this.seatHold = seatHold;
    }

    @Override
    public int getSeatId() {
        return seatId;
    }

    @Override
    public void setSeatId(int seatId) {
        this.seatId = seatId;
    }

    @Override
    public String getSeatNumber() {
        return seatNumber;
    }

    @Override
    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    @Override
    public int getLevelId() {
        return levelId;
    }

    @Override
    public void setLevelId(int levelId) {
        this.levelId = levelId;
    }

    @Override
    public boolean isAvailable() {
        return (this.getSeatHold() == null
                || (this.getSeatHold().getResearvedOn() == null || !this.getSeatHold().getResearvedOn().isPresent())
                && ChronoUnit.SECONDS.between(this.getSeatHold().getHeldOn().get(), LocalDateTime.now()) > AppSettings.TICKET_HOLD_PERIOD);
    }
}
