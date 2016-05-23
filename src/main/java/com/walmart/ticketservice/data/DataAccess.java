/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.walmart.ticketservice.data;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Tewodros
 */
public class DataAccess {

    private static DataAccess instance;

    private static void initData() {
        seatingArrangements.add(new SeatingArrangementImpl(1, "Orchestra", 100, 25, 50));
        seatingArrangements.add(new SeatingArrangementImpl(2, "Main", 75, 20, 100));
        seatingArrangements.add(new SeatingArrangementImpl(3, "Balcony 1", 50, 15, 100));
        seatingArrangements.add(new SeatingArrangementImpl(4, "Balcony 2", 40, 15, 100));

        int seatId = 1;
        for (SeatingArrangement seatingArrangement : seatingArrangements) {
            int seatNumber = 1;
            for (int i = 0; i < seatingArrangement.getSeatsInRow() * seatingArrangement.getRows(); i++) {
                seats.add(new SeatImpl(seatId++, seatingArrangement.getLevelId(), seatingArrangement.getLevelName().substring(0, 1) + seatNumber++, null));
            }
        }
    }

    private DataAccess() {
    }

    public static DataAccess getInstance() {
        if (instance == null) {
            instance = new DataAccess();
            initData();
        }

        return instance;
    }

    private static List<SeatingArrangement> seatingArrangements = new ArrayList<>();
    private static List<Seat> seats = new ArrayList<>();
    private static List<SeatHold> seatHolds = new ArrayList<>();

    public List<SeatHold> getAllSeatHolds() {
        return seatHolds;
    }

    public SeatHold getSeatHold(int setHoldId) {
        return seatHolds.stream().filter(sh -> sh.getSeatHoldId() == setHoldId).findFirst().get();
    }

    public List<Seat> getAllSeats() {
        return seats;
    }

    public void addSeatHold(SeatHold seatHold) {
        Optional<Integer> maxId = seatHolds.stream().map(sh -> sh.getSeatHoldId()).max(Comparator.comparing(shi -> shi));
        if (maxId.isPresent()) {
            seatHold.setSeatHoldId(maxId.get());
        } else {
            seatHold.setSeatHoldId(1);
        }
        seatHolds.add(seatHold);
    }
}
