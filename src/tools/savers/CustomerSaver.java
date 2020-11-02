/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools.savers;

import entity.Customer;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pupil
 */
public class CustomerSaver {

    public void saveCustomer(List<Customer> listCustomer) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream("listCustomer");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(listCustomer);
            oos.flush();
        } catch (FileNotFoundException ex) {
            System.out.println("Не найден файл");
        } catch (IOException ex) {
            System.out.println("Ошибка ввода/вывода");
        }
    }

    public List<Customer> loadCustomer() {
        List<Customer> listCustomer = new ArrayList<>();
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream("listCustomer");
            ois = new ObjectInputStream(fis);
            listCustomer = (List<Customer>) ois.readObject();
        } catch (FileNotFoundException ex) {
            System.out.println("Не найден файл");
        } catch (IOException ex) {
            System.out.println("Ошибка ввода/вывода");
        } catch (ClassNotFoundException ex) {
            System.out.println("Не найден класс");
        }
        return listCustomer;
    }
    }
