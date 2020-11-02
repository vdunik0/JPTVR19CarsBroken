/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import entity.Car;
import entity.Customer;
import entity.History;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author pupil
 */
public class ShopManager {
    private Customer customer = new Customer();
    private Car car = new Car();
    private History history = new History();
    private Scanner scanner = new Scanner(System.in);
    private CustomerManager customerManager = new CustomerManager();
    private CarManager carManager = new CarManager();
    public History buyCar(List<Car> listCars, List<Customer> listCustomer) {
        
        System.out.println("--- Список читателей ---");
            customerManager.printListOfCustomers(listCustomer);
            System.out.print("Выберите номер читателя: ");
            int customerNumber = scanner.nextInt();
            scanner.nextLine();
            listCustomer = (List<Customer>) listCustomer.get(customerNumber-1);
            history.getCustomer();
            carManager.printListCars(listCars);
            int carNumber = scanner.nextInt();
            scanner.nextLine();
            Car car = listCars.get(carNumber-1);
            history.setCar(car);
            Calendar calendar = new GregorianCalendar();
            history.setBoughtDate(calendar.getTime());
            customer.setWallet(customer.getWallet()-car.getPrice());
            this.printHistory(history);
        return history;
    }

    private void printHistory(History history) {
        System.out.printf("Книга \"%s\" выдана %s %s%n"
                ,history.getCar().getModel()
                ,history.getCustomer().getFirstname()
                ,history.getCustomer().getLastname()
        );
    }
    private void printListOfBoughtCars(List<List> listHistory){
        for (int i = 0; i < listHistory.size(); i++) {
            System.out.printf("Книга \"%s\" выдана %s %s%n"
                ,history.getCar().getModel()
                ,history.getCustomer().getFirstname()
                ,history.getCustomer().getLastname()
        );
        }
    }
    public void addHistoryToArray(History history, List<History> listHistory) {
        listHistory.add(history);
    }
}

