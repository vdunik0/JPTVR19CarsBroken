/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools.manager;

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
            customer = listCustomer.get(customerNumber-1);
            history.getCustomer();
            carManager.printListCars(listCars);
            int carNumber = scanner.nextInt();
            scanner.nextLine();
            car = listCars.get(carNumber-1);
            history.setCar(car);
            Calendar calendar = new GregorianCalendar();
            history.setBoughtDate(calendar.getTime());
            if (customer.getWallet() < car.getPrice()){
                System.out.println("У пользователя недостаточно средств");
            }else{
                int newWallet = customer.getWallet()-car.getPrice();
                customer.setWallet(newWallet);
                listCars.remove(car);
            }
        return history;
    }

    private void printHistory(History history) {
        System.out.printf("Книга \"%s %s\" выдана %s %s%n"
                ,history.getCar().getModel()
                ,history.getCar().getManufacturer()
                ,history.getCustomer().getFirstname()
                ,history.getCustomer().getLastname()
        );
    }
    public void printListOfBoughtCars(List<History> listHistories){
        for (int i = 0; i < listHistories.size(); i++) {
            System.out.println(listHistories.get(i).toString());
        }
    }
    public void addHistoryToArray(History history, List<History> listHistory) {
        listHistory.add(history);
    }
}

