/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Date;

/**
 *
 * @author pupil
 */
public class History {
    private Customer customer;
    private Car car;
    private Date boughtDate;

    public History() {
    }

    public History(Customer buyeer, Car car, Date boughtDate) {
        this.customer = customer;
        this.car = car;
        this.boughtDate = boughtDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setBuyeer(Customer customer) {
        this.customer = customer;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Date getBoughtDate() {
        return boughtDate;
    }

    public void setBoughtDate(Date boughtDate) {
        this.boughtDate = boughtDate;
    }

    @Override
    public String toString() {
        return "History{" + "buyeer=" + customer + ", car=" + car + ", boughtDate=" + boughtDate + '}';
    }
    
}
