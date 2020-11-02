/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jptvr19cars;

import tools.savers.HistorySaver;
import tools.manager.ShopManager;
import tools.savers.CustomerSaver;
import tools.manager.CarManager;
import entity.Customer;
import entity.Car;
import entity.History;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import tools.manager.CustomerManager;
import tools.savers.CarSaver;
        
/**
 *
 * @author pupil
 */
public class App {
    
   
    private List<Car> listCars = new ArrayList<>();
    private List<Customer> listCustomer = new ArrayList<>();
    private List<History> listHistories = new ArrayList<>();
    
    private CustomerManager customerManager = new CustomerManager();
    private CarManager carManager = new CarManager();
    private Customer customer = new Customer();
    private History history = new History();
    private ShopManager shopManager = new ShopManager();
    private CustomerSaver customerSaver = new CustomerSaver();
    private CarSaver carSaver = new CarSaver();
    private HistorySaver historySaver = new HistorySaver();
    
    public App() {
        listCars = carSaver.loadCars();
        listCustomer = customerSaver.loadCustomer();
        listHistories = historySaver.loadCustomer();
    }

    public void run() {
        /**
        * 1.Добавить товар
        * 2.Список товаров
        * 3.Добавить покупателя
        * 4.Список покупателя
        * 5.Покупателю купить товар(при покупке товара из кошелька покупателя вычитать стоимость)
        **/
        boolean repeat = true;
        System.out.println("--- Библиотека ---");
        do{
            System.out.println("Задачи: ");
            System.out.println("0. Выйти из программы");
            System.out.println("1. Добавить новую машину");
            System.out.println("2. Список машин");
            System.out.println("3. Зарегистрировать покупателя");
            System.out.println("4. Список покупателей");
            System.out.println("5. Оформить машину покупателю");
            System.out.println("6. Список купленных машиных");
            System.out.print("Выберите задачу: ");
            Scanner scanner = new Scanner(System.in);
            String task = scanner.nextLine();
            switch (task) {
                case "0":
                    System.out.println("--- конец программы ---");
                    repeat = false;
                    break;
                case "1":
                    System.out.println("Добавить новую машину");
                    Car car = carManager.createCar();
                    carManager.addCarToArray(car,listCars);
                    carSaver.saveCars(listCars);
                    break;
                case "2":
                    System.out.println("Список машин");
                    carManager.printListCars(listCars);
                    break;
                case "3":
                    System.out.println("--- Зарегистрировать покупателя ---");
                    Customer customer = customerManager.addCustomer();
                    System.out.println("Имя читателя: "
                            +customer.getFirstname()
                            +" "
                            + customer.getLastname()
                    );
                    customerManager.addCustomerToArray(listCustomer);
                    customerSaver.saveCustomer(listCustomer);
                    break;
                case "4":
                    System.out.println("--- Список покупателей ---");
                    customerManager.printListOfCustomers(listCustomer);
                    break;
                case "5":
                    History history = shopManager.buyCar(listCars, listCustomer);
                    shopManager.addHistoryToArray(history, listHistories);
                    historySaver.saveHistory(listHistories);
                    carSaver.saveCars(listCars);
                    customerSaver.saveCustomer(listCustomer);
                    break;
                case "6":
                    shopManager.printListOfBoughtCars(listHistories);
                    break;
                default:
                    System.out.println("Нет такой задачи.");
            }
        }while(repeat);
    }
}