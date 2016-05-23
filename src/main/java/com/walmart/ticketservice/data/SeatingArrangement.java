/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.walmart.ticketservice.data;

/**
 *
 * @author Tewodros
 */
public interface SeatingArrangement {

    int getLevelId();

    String getLevelName();

    double getPrice();

    int getRows();

    int getSeatsInRow();

    void setLevelId(int levelId);

    void setLevelName(String levelName);

    void setPrice(double price);

    void setRows(int rows);

    void setSeatsInRow(int seatsInRow);
    
}
