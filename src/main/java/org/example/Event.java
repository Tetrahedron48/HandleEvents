package org.example;



import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;


public class Event {
    private String eventID;
    private String eventName;
    private String eventVenue;
    private Date eventDate;
private List<Attendees> eventAttendees=new ArrayList<>();

    public String getEventID() {
        return eventID;
    }

    public void setEventID(String eventID) {
        this.eventID = eventID;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventVenue() {
        return eventVenue;
    }

    public void setEventVenue(String eventVenue) {
        this.eventVenue = eventVenue;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public List<Attendees> getEventAttendees() {
        return eventAttendees;
    }

    public void setEventAttendees(List<Attendees> eventAttendees) {
        this.eventAttendees = eventAttendees;
    }

    public void organizeEvent(){
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        do {
            System.out.println("\n1. Add Attendee");
            System.out.println("2. Remove Attendee");
            System.out.println("3. Update Attendee");
            System.out.println("4. Find Attendee");
            System.out.println("5. Display Total Number of Attendees");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Attendee Name to Add: ");
                    String attendeeToAdd = scanner.next();
                    System.out.print("Enter the email of attendee: ");
                    String email = scanner.next();
                    System.out.print("Enter the phone of attendee: ");
                    String phone = scanner.next();
                    System.out.print("Enter the address of attendee: ");
                    String address = scanner.next();
                    eventAttendees.add(new Attendees(attendeeToAdd,email,phone,address));
                    System.out.println("Attendee added successfully.");
                    break;
                case 2:
                    System.out.print("Enter Attendee Name to Remove: ");
                    String attendeeToRemove = scanner.next();
                    if (eventAttendees.removeIf(attendees -> attendees.getName().equals(attendeeToRemove))) {
                        System.out.println("Attendee removed successfully.");
                    } else {
                        System.out.println("Attendee not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter Attendee Name to Update: ");
                    String attendeeToUpdate = scanner.next();
                    for (Attendees attendee : eventAttendees) {
                        if (attendee.getName().equals(attendeeToUpdate)) {
                            System.out.print("Enter the new name of attendee: ");
                            String updatedName = scanner.next();
                            attendee.setName(updatedName);
                            System.out.print("Enter the new email of attendee: ");
                            String updatedEmail = scanner.next();
                            attendee.setEmail(updatedEmail);
                            System.out.print("Enter the new phone of attendee: ");
                            String updatedPhone = scanner.next();
                            attendee.setPhone(updatedPhone);
                            System.out.print("Enter the new address of attendee: ");
                            String updatedAddress = scanner.next();
                            attendee.setAddress(updatedAddress);
                            System.out.println("Attendee updated successfully.");
                            break;
                        }else {
                            System.out.println("Attendee not found.");
                        }
                    }
                    break;
                case 4:
                    System.out.print("Enter Attendee Name to Find: ");
                    String attendeeToFind = scanner.next();
                    if (eventAttendees.stream().anyMatch(attendees -> attendees.getName().equals(attendeeToFind))) {
                        System.out.println(attendeeToFind + " is attending the event.");
                    } else {
                        System.out.println(attendeeToFind + " is not attending the event.");
                    }
                    break;
                case 5:
                    System.out.println("Total number of attendees: " + eventAttendees.size());
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 6);
    }





    public Event() {
    }
}
