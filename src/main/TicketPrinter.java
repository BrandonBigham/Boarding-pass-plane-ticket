package main;

import entity.Passenger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.SimpleTimeZone;

public class TicketPrinter {

    public static void main(String[] args){
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Passenger.class)
                .buildSessionFactory();

        Scanner input = new Scanner(System.in);
        long millis = System.currentTimeMillis();
        Date date = new Date(millis);


       System.out.println("Enter your first name");
        String firstName = input.nextLine();
        System.out.println("Enter your last name");
        String lastName = input.nextLine();
        System.out.println("Enter your email");
        String email  = input.nextLine();
        System.out.println("Enter your phone number");
        String phoneNumber = input.nextLine();
        System.out.println("what is your gender");
        String gender = input.nextLine();
        System.out.println("Enter your age");
        int age = input.nextInt();
        System.out.println("Enter the date");
        System.out.println(date);
        System.out.println("Enter your destination");
        String destination = input.nextLine();
        System.out.println("Enter your departure time as HH:MM");
        String time = input.nextLine();
        Time sqlTime = Time.valueOf(time+":00");
        System.out.println(sqlTime);

       try {
            Session session = factory.getCurrentSession();
            Passenger passenger = new Passenger(firstName,lastName,
                    email,phoneNumber,gender,age,date,destination,sqlTime);
            session.beginTransaction();
            session.save(passenger);
            session.getTransaction().commit();
        }finally {
           factory.close();
       }



    }

}
