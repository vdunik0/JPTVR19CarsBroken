/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import entity.Customer;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author pupil
 */
public class CustomerManager {
    private Random rn =new Random();
    Scanner scanner = new Scanner(System.in);
    Customer customer = new Customer();
    public Customer addCustomer() {
       System.out.println("--- Регистрация нового пользователя ---");
        System.out.print("Введите имя: ");
        customer.setFirstname(scanner.nextLine());
        System.out.print("Введите фамилию: ");
        customer.setLastname(scanner.nextLine());
        System.out.print("Введите телефон: ");
        customer.setPhone(scanner.nextLine());
        customer.setWallet(rn.nextInt(20000-1000)+1000);
        System.out.println("Имя читателя: "
                            +customer.getFirstname()
                            +" "
                            + customer.getLastname()
                    );
        return customer;
    }

    public void addCustomerToArray(List<Customer> listCustomer) {
        for (int i = 0; i < listCustomer.size(); i++) {
                        if(listCustomer.get(i) == null){
                            listCustomer.set(i, customer);
                            break;
                        }
    }
    }

    public void printListOfCustomers(List<Customer> listCustomer) {
        for (int i = 0; i < listCustomer.size(); i++) {
                        if(listCustomer.get(i) != null){
                            System.out.println(i+1+". " + listCustomer.get(i).toString());
                        }
                    }
    }
    
}
