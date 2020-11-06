package entity;

import javax.persistence.*;
import java.sql.Time;

@Entity
@Table(name = "ticket")
public class Ticket {
    @Id //This will map the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //This is used with auto increment for your primary key.
    @Column(name = "id") //This is mapping the primary key to the id column in your database.
    private int id;

    @Column(name = "destination")
    private String destination;

    @Column(name = "flight_time")
    private Time flightTime;

    @Column(name = "timezone")
    private String timezone;

    @Column(name = "ticket_price")
    private int ticketPrice;

    //Constructors
    public Ticket(String destination, Time flightTime, String timezone, int ticketPrice) {
        this.destination = destination;
        this.flightTime = flightTime;
        this.timezone = timezone;
        this.ticketPrice = ticketPrice;
    }
    public Ticket() {
    }

    //Getters & Setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getDestination() {
        return destination;
    }
    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Time getFlightTime() {
        return flightTime;
    }
    public void setFlightTime(Time flightTime) {
        this.flightTime = flightTime;
    }

    public  String getTimezone() {
        return timezone;
    }
    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public int getTicketPrice() {
        return ticketPrice;
    }
    public void setTicketPrice(int ticketPrice) {
        this.ticketPrice = ticketPrice;
    }
}
