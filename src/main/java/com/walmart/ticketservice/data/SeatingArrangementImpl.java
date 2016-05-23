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
class SeatingArrangementImpl implements SeatingArrangement {

    public SeatingArrangementImpl(int levelId, String levelName, double price, int rows, int seatsInRow) {
        this.levelId = levelId;
        this.levelName = levelName;
        this.price = price;
        this.rows = rows;
        this.seatsInRow = seatsInRow;
    }
    
    private int levelId;
    private String levelName;
    private double price;
    private int rows;
    private int seatsInRow;

    @Override
    public int getLevelId() {
        return levelId;
    }

    @Override
    public void setLevelId(int levelId) {
        this.levelId = levelId;
    }

    @Override
    public String getLevelName() {
        return levelName;
    }

    @Override
    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public int getRows() {
        return rows;
    }

    @Override
    public void setRows(int rows) {
        this.rows = rows;
    }

    @Override
    public int getSeatsInRow() {
        return seatsInRow;
    }

    @Override
    public void setSeatsInRow(int seatsInRow) {
        this.seatsInRow = seatsInRow;
    }
    
    

}
