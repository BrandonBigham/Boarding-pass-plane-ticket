package main;

import com.mysql.cj.Query;
import entity.Passenger;
import entity.Ticket;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import javax.persistence.EntityManager;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.*;

public class TicketPrinter {

    //private static SessionFactory factory;

    public static String Ticket(String[] arr1, String[] arr2) {
        String ticket = "";
        for (String x : arr1) {
            ticket += x;
        }
        for (String x : arr2) {
            ticket += x;
        }
        return ticket;
    }


    public static void main(String[] args) {


        SessionFactory factoryTicket = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Passenger.class)
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
        String email = input.nextLine();
        System.out.println("Enter your phone number");
        String phone_number = input.nextLine();
        System.out.println("what is your gender");
        String gender = input.nextLine();
        System.out.println("Enter your age");
        int age = input.nextInt();
        input.nextLine();
        System.out.println("Enter your destination");
        String destination = input.nextLine();
        System.out.println("Enter the date");
        System.out.println(date);

        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Ticket.class)
                .buildSessionFactory();
        Session session1 = factory.getCurrentSession();
        session1.beginTransaction();
        Criteria criteria = session1.createCriteria(Ticket.class);
        criteria.add(Restrictions.eq("destination", destination));
        Ticket ticket = (Ticket) criteria.uniqueResult();
        while (ticket == null) {
            System.out.println("There are no flights to " + destination);
            System.out.println("Enter another destination");
            destination = input.nextLine();
        }
        session1.getTransaction().commit();

        String time_zone = null;
        Time eta = null;

        try {
            //create a session
            Session session = factory.getCurrentSession();
            //start a transaction
            session.beginTransaction();

            //Query ticket: All tickets
            List<Ticket> theTickets = session.createQuery("from Ticket").getResultList();

            //Query all the tickets with destination
            theTickets = session.createQuery("from Ticket where destination='" + destination + "'").getResultList();

            time_zone = theTickets.get(0).getTimezone();
            eta = theTickets.get(0).getFlightTime();



            //commit the transaction
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            factory.close();
        }


        Time finaleta = null;
        //accounting for time-zone differences
        if (Objects.equals(time_zone, "PST")) {
            String eta1 = "";
            for (int i = 0; i < 2; i++) {
                eta1 += (String.valueOf(eta)).charAt(i);
            }

            int eta2 = Integer.parseInt(eta1) - 2;
            String eta3 = String.valueOf(eta2);
            for (int i = 2; i < 8; i++) {
                eta3 += (String.valueOf(eta)).charAt(i);
            }

            finaleta = Time.valueOf(eta3);
        }

        else if (Objects.equals(time_zone, "MST")) {
            String eta1 = "";
            for (int i = 0; i < 2; i++) {
                eta1 += (String.valueOf(eta)).charAt(i);
            }

            int eta2 = Integer.parseInt(eta1) - 1;
            String eta3 = String.valueOf(eta2);
            for (int i = 2; i < 8; i++) {
                eta3 += (String.valueOf(eta)).charAt(i);
            }

            finaleta = Time.valueOf(eta3);
        }

        else if (Objects.equals(time_zone, "EST")) {
            String eta1 = "";
            for (int i = 0; i < 2; i++) {
                eta1 += (String.valueOf(eta)).charAt(i);
            }

            int eta2 = Integer.parseInt(eta1) + 1;
            String eta3 = String.valueOf(eta2);
            for (int i = 2; i < 8; i++) {
                eta3 += (String.valueOf(eta)).charAt(i);
            }

            finaleta = Time.valueOf(eta3);
        }

        else if (Objects.equals(time_zone, "AKST")) {
            String eta1 = "";
            for (int i = 0; i < 2; i++) {
                eta1 += (String.valueOf(eta)).charAt(i);
            }

            int eta2 = Integer.parseInt(eta1) - 4;
            String eta3 = String.valueOf(eta2);
            for (int i = 2; i < 8; i++) {
                eta3 += (String.valueOf(eta)).charAt(i);
            }

            finaleta = Time.valueOf(eta3);
        }

        else if (Objects.equals(time_zone, "UTC-5")) {
            String eta1 = "";
            for (int i = 0; i < 2; i++) {
                eta1 += (String.valueOf(eta)).charAt(i);
            }

            int eta2 = Integer.parseInt(eta1) + 1;
            String eta3 = String.valueOf(eta2);
            for (int i = 2; i < 8; i++) {
                eta3 += (String.valueOf(eta)).charAt(i);
            }

            finaleta = Time.valueOf(eta3);
        }

        else if (Objects.equals(time_zone, "CET")) {
            String eta1 = "";
            for (int i = 0; i < 2; i++) {
                eta1 += (String.valueOf(eta)).charAt(i);
            }

            int eta2 = Integer.parseInt(eta1) + 7;
            String eta3 = String.valueOf(eta2);
            for (int i = 2; i < 8; i++) {
                eta3 += (String.valueOf(eta)).charAt(i);
            }

            finaleta = Time.valueOf(eta3);
        }

        else if (Objects.equals(time_zone, "UTC+3")) {
            String eta1 = "";
            for (int i = 0; i < 2; i++) {
                eta1 += (String.valueOf(eta)).charAt(i);
            }

            int eta2 = Integer.parseInt(eta1) + 9;
            String eta3 = String.valueOf(eta2);
            for (int i = 2; i < 8; i++) {
                eta3 += (String.valueOf(eta)).charAt(i);
            }

            finaleta = Time.valueOf(eta3);
        }

        else if (Objects.equals(time_zone, "UTC+9")) {
            String eta1 = "";
            for (int i = 0; i < 2; i++) {
                eta1 += (String.valueOf(eta)).charAt(i);
            }

            int eta2 = Integer.parseInt(eta1) + 15;
            String eta3 = String.valueOf(eta2);
            for (int i = 2; i < 8; i++) {
                eta3 += (String.valueOf(eta)).charAt(i);
            }

            finaleta = Time.valueOf(eta3);
        }


        System.out.println("Enter your departure time as HH:MM");
        String time = input.nextLine();
        Time sqlTime = Time.valueOf(time+":00");
        System.out.println(sqlTime);
        String[] timeSplit = time.split(":");
        String[] dateSplit = date.toString().split("-");

        long ticket_number = Long.parseLong(Ticket(timeSplit,dateSplit));


       try {
            Session session2 = factoryTicket.getCurrentSession();
            Passenger passenger = new Passenger(firstName, lastName,
                    email, phone_number, gender, age, date, destination, sqlTime, ticket_number, finaleta);
            session2.beginTransaction();
            session2.save(passenger);
            session2.getTransaction().commit();
        }finally {
           factoryTicket.close();
       }




        class CreateFile {
            public void main(String[] args) {
                try {
                    File myObj = new File("/Users/Dhruvil/Desktop/Java_Assignments/Boarding-pass-plane-ticket/src/Ticket.txt");
                    if (myObj.createNewFile()) {
                        System.out.println("File created: " + myObj.getName());
                    } else {
                        System.out.println("File already exists.");
                    }
                } catch (IOException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }
            }
        }

        String finalDestination = destination;
        int ticketPrice = ticket.getTicketPrice();

        Time finalEta = finaleta;
        class WriteToFile {
            public void main(String[] args) {
                try {
                    FileWriter myWriter = new FileWriter("/Users/Dhruvil/Desktop/Java_Assignments/Boarding-pass-plane-ticket/src/Ticket.txt");
                    myWriter.write("Boarding Pass #: " + ticket_number + "\nDate: " + date + "\nOrigin: DFW\n"
                            + "Destination: " + finalDestination + "\nETA: " + finalEta + "\nDeparture Time: " + sqlTime
                            + "\nName: " + firstName + " " + lastName + "\nEmail: " + email + "\nPhone Number: "
                            + phone_number + "\nGender: " + gender + "\nAge: " + age + "Total Ticket Price: " + ticketPrice);
                    myWriter.close();
                    System.out.println("Successfully wrote to the file.");
                } catch (IOException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }
            }
        }

        discount(age, gender, ticketPrice);
        printBoardingPass(ticket_number, date, finalDestination, finalEta, sqlTime, firstName, lastName, email, phone_number, gender, age, ticketPrice);
    }

    public static int discount(int age, String gender, int ticketPrice){
        if (age < 12 && gender.equals("female")){
            ticketPrice = (int) (ticketPrice * .25);
            return ticketPrice;
        } else if (age > 60 && gender.equals("female")){
            ticketPrice = (int) (ticketPrice * .15);
            return ticketPrice;
        } else if (age < 12){
            ticketPrice = (int) (ticketPrice * .5);
            return ticketPrice;
        } else if (age > 60){
            ticketPrice = (int) (ticketPrice * .4);
            return ticketPrice;
        } else if (gender.equals("female")){
            ticketPrice = (int) (ticketPrice * .75);
            return ticketPrice;
        }
        return ticketPrice;
    }

    public static void printBoardingPass(long ticket_number,Date date,String finalDestination,Time finaleta,Time sqlTime,String firstName,String lastName,String email,String phone_number,String gender,int age,int ticketPrice){
        System.out.println("Boarding Pass #: " + ticket_number + "\tDate: " + date + "\tOrigin: DFW"
                + "\tDestination: " + finalDestination + "\tETA: " + finaleta + "\tDeparture Time: " + sqlTime
                + "\nName: " + firstName + " " + lastName + "\tEmail: " + email + "\tPhone Number: "
                + phone_number + "\tGender: " + gender + " Age: " + age + "\nTotal Ticket Price: " + ticketPrice);
    }


}

