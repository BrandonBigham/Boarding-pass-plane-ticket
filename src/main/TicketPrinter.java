package main;

import com.mysql.cj.Query;
import entity.Passenger;
import entity.Ticket;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import javax.persistence.EntityManager;
import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.SimpleTimeZone;

public class TicketPrinter {

    private static SessionFactory factory;

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


      /*
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

       */
        System.out.println("Enter your destination");
        String destination = input.nextLine();

        Session session1 = factoryTicket.getCurrentSession();
        session1.beginTransaction();
        Criteria criteria = session1.createCriteria(Ticket.class);
        criteria.add(Restrictions.eq("destination", destination));
        Ticket ticket = (Ticket) criteria.uniqueResult();
        while (ticket == null) {
            System.out.println("There are no flights to " + destination);
            System.out.println("Enter another destination");
            destination = input.nextLine();
        }
        System.out.println(ticket.getTicketPrice());
        session1.getTransaction().commit();
        factoryTicket.close();

        Session session = factory.openSession();
       // String time_zone = (String) session.createQuery("select ticket.timezone from Ticket ticket where ticket.destination = :destination").setString("destination",destination).uniqueResult();
       // Time eta = (Time) session.createQuery("select ticket.eta from Ticket ticket where ticket.destination = :destination").setString("destination",destination).uniqueResult();
        Time finaleta = null;
        factory.close();

        if (ticket.getTimezone().equals("PST")) {
            String eta1 = "";
            for (int i = 0; i < 2; i++) {
                eta1 += (String.valueOf(ticket.getFlightTime())).charAt(i);
            }

            int eta2 = Integer.parseInt(eta1) - 2;
            String eta3 = String.valueOf(eta2);
            for (int i = 2; i < 8; i++) {
                eta3 += (String.valueOf(ticket.getFlightTime())).charAt(i);
            }

            finaleta = Time.valueOf(eta3);
        }

        else if (ticket.getTimezone().equals("MST")) {
            String eta1 = "";
            for (int i = 0; i < 2; i++) {
                eta1 += (String.valueOf(ticket.getFlightTime())).charAt(i);
            }

            int eta2 = Integer.parseInt(eta1) - 1;
            String eta3 = String.valueOf(eta2);
            for (int i = 2; i < 8; i++) {
                eta3 += (String.valueOf(ticket.getFlightTime())).charAt(i);
            }

            finaleta = Time.valueOf(eta3);
        }

        else if (ticket.getTimezone().equals("EST")) {
            String eta1 = "";
            for (int i = 0; i < 2; i++) {
                eta1 += (String.valueOf(ticket.getFlightTime())).charAt(i);
            }

            int eta2 = Integer.parseInt(eta1) + 1;
            String eta3 = String.valueOf(eta2);
            for (int i = 2; i < 8; i++) {
                eta3 += (String.valueOf(ticket.getFlightTime())).charAt(i);
            }

            finaleta = Time.valueOf(eta3);
        }

        else if (ticket.getTimezone().equals("AKST")) {
            String eta1 = "";
            for (int i = 0; i < 2; i++) {
                eta1 += (String.valueOf(ticket.getFlightTime())).charAt(i);
            }

            int eta2 = Integer.parseInt(eta1) - 4;
            String eta3 = String.valueOf(eta2);
            for (int i = 2; i < 8; i++) {
                eta3 += (String.valueOf(ticket.getFlightTime())).charAt(i);
            }

            finaleta = Time.valueOf(eta3);
        }

        else if (ticket.getTimezone().equals( "UTC-5")) {
            String eta1 = "";
            for (int i = 0; i < 2; i++) {
                eta1 += (String.valueOf(ticket.getFlightTime())).charAt(i);
            }

            int eta2 = Integer.parseInt(eta1) + 1;
            String eta3 = String.valueOf(eta2);
            for (int i = 2; i < 8; i++) {
                eta3 += (String.valueOf(ticket.getFlightTime())).charAt(i);
            }

            finaleta = Time.valueOf(eta3);
        }

        else if (ticket.getTimezone().equals("CET")) {
            String eta1 = "";
            for (int i = 0; i < 2; i++) {
                eta1 += (String.valueOf(ticket.getFlightTime())).charAt(i);
            }

            int eta2 = Integer.parseInt(eta1) + 7;
            String eta3 = String.valueOf(eta2);
            for (int i = 2; i < 8; i++) {
                eta3 += (String.valueOf(ticket.getFlightTime())).charAt(i);
            }

            finaleta = Time.valueOf(eta3);
        }

        else if (ticket.getTimezone().equals("UTC+3")) {
            String eta1 = "";
            for (int i = 0; i < 2; i++) {
                eta1 += (String.valueOf(ticket.getFlightTime())).charAt(i);
            }

            int eta2 = Integer.parseInt(eta1) + 9;
            String eta3 = String.valueOf(eta2);
            for (int i = 2; i < 8; i++) {
                eta3 += (String.valueOf(ticket.getFlightTime())).charAt(i);
            }

            finaleta = Time.valueOf(eta3);
        }

        else if (ticket.getTimezone().equals("UTC+9")) {
            String eta1 = "";
            for (int i = 0; i < 2; i++) {
                eta1 += (String.valueOf(ticket.getFlightTime())).charAt(i);
            }

            int eta2 = Integer.parseInt(eta1) + 15;
            String eta3 = String.valueOf(eta2);
            for (int i = 2; i < 8; i++) {
                eta3 += (String.valueOf(ticket.getFlightTime())).charAt(i);
            }

            finaleta = Time.valueOf(eta3);
        }

        System.out.println("Enter your departure time as HH:MM");
        String time = input.nextLine();
        Time sqlTime = Time.valueOf(time+":00");
        System.out.println(sqlTime);
        String[] timeSplit = time.split(":");
        String[] dateSplit = date.toString().split("-");
        System.out.println(Ticket(timeSplit,dateSplit));

       
       /*
       try {
            Session session2 = factory.getCurrentSession();
            Passenger passenger = new Passenger(firstName,lastName,
                    email,phoneNumber,gender,age,date,destination,sqlTime,Ticket(timeSplit,dateSplit), needs eta);
            session.beginTransaction();
            session.save(passenger);
            session.getTransaction().commit();
        }finally {
           factory.close();
       }

        */






    }

}
