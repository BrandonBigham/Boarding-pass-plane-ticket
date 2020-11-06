package entity;

import javax.persistence.*;
import java.sql.*;

@Entity //This will let Java know that this is an entity that we are going to map to a database table.
    @Table(name = "passenger") //This is for the actual name of the database table name we are mapping to the class.
    public class Passenger {

        //Database Mapping
        @Id //This will map the primary key
        @GeneratedValue(strategy = GenerationType.IDENTITY) //This is used with auto increment for your primary key.
        @Column(name = "id") //This is mapping the primary key to the id column in your database.
        private int id;

        @Column(name = "first_name") //This will map the firstName field to the column named first_name in the passenger table.
        private String firstName;

        @Column(name = "last_name") //This will map the lastName field to the column named last_name in the passenger table.
        private String lastName;

        @Column(name = "email") //This will map the company field to the column named email in the passenger table.
        private String email;

        @Column(name = "phone_number") //This will map the company field to the column named phone_number in the passenger table.
        private String phone_number;

        @Column(name = "gender") //This will map the company field to the column named gender in the passenger table.
        private String gender;

        @Column(name = "age") //This will map the company field to the column named age in the passenger table.
        private int age;

        @Column(name = "date") //This will map the company field to the column named date in the passenger table.
        private Date date;

        @Column(name = "destination") //This will map the company field to the column named destination in the passenger table.
        private  String destination;

        @Column(name = "departure_time") //This will map the company field to the column named departure_time in the passenger table.
        private Time departure_time;

        @Column(name = "ticket_number") //This will map the company field to the column named departure_time in the passenger table.
        private long ticket_number;

        @Column(name = "eta") //This will map the company field to the column named departure_time in the passenger table.
        private Time eta;

        //Constructors
        public Passenger() {
        }

        public Passenger(String firstName, String lastName, String email, String phone_number, String gender, int age, Date date, String destination, Time departure_time, long ticket_number, Time eta) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
            this.phone_number = phone_number;
            this.gender = gender;
            this.age = age;
            this.date = date;
            this.destination = destination;
            this.departure_time = departure_time;
            this.ticket_number = ticket_number;
            this.eta= eta;
        }

        //Getters and Setters


        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPhone_number() {
            return phone_number;
        }

        public void setPhone_number(String phone_number) {
            this.phone_number = phone_number;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public String getDestination() {
            return destination;
        }

        public void setDestination(String destination) {
            this.destination = destination;
        }

        public Time getDeparture_time() {
            return departure_time;
        }

        public void setDeparture_time(Time departure_time) {
            this.departure_time = departure_time;
        }

        public long getTicket_number() {
            return ticket_number;
        }

        public void setTicket_number(int ticket_number) {
            this.ticket_number = ticket_number;
        }

        public Time getEta() {
            return eta;
        }

        public void setEta(Time eta) {
            this.eta = eta;
        }

}
