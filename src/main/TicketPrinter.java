package main;

import entity.Passenger;
import entity.Ticket;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.SimpleTimeZone;

public class TicketPrinter {

    public static String Ticket(String[] arr1, String[] arr2){
        String ticket = "";
        for(String x: arr1) {
            ticket += x;
        }
        for (String x: arr2){
            ticket += x;
        }
        return ticket;
    }

    public static void main(String[] args){
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Passenger.class)
                .buildSessionFactory();

        SessionFactory factoryTicket = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Ticket.class)
                .buildSessionFactory();

        Scanner input = new Scanner(System.in);
        long millis = System.currentTimeMillis();
        Date date = new Date(millis);
        ArrayList<String> tickets = new ArrayList<>();



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
      /*  while (destination.equals()){
            System.out.println("There is no flights to "+ destination);
            destination = input.nextLine();
        }

       */
        System.out.println("Enter your departure time as HH:MM");
        String time = input.nextLine();
        Time sqlTime = Time.valueOf(time+":00");
        System.out.println(sqlTime);
        String[] timeSplit = time.split(":");
        String[] dateSplit = date.toString().split("-");
        System.out.println(Ticket(timeSplit,dateSplit));
        try (factoryTicket){
            Session session = factoryTicket.getCurrentSession();
            session.beginTransaction();
            List<Ticket> ticketList = session.createQuery("from Ticket").getResultList();
            ticketList = session.createQuery("from Ticket where destination=''").getResultList();

        }
       
/*
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

 */





    }

}
