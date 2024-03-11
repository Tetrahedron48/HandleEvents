package org.example;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或
// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //TIP 当文本光标位于高亮显示的文本处时按 <shortcut actionId="ShowIntentionActions"/>
        // 查看 IntelliJ IDEA 建议如何修正。
        int num,flag=0;
        Event event = new Event();
        System.out.println("Enter the event ID: ");
        String eventID = scanner.nextLine();
        event.setEventID(eventID);
        System.out.println("Enter the event name: ");
        String eventName = scanner.nextLine();
        event.setEventName(eventName);
        System.out.println("Enter the event venue: ");
        String eventVenue = scanner.nextLine();
        event.setEventVenue(eventVenue);

        do {
            System.out.println("Enter the event date(format: yyyy/MM/dd):");
            String eventDate = scanner.next();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
            try {
                Date date = dateFormat.parse(eventDate);
                event.setEventDate(date);
                flag=1;
            } catch (ParseException e) {
                System.out.println("Invalid date format. Please enter date in the format yyyy/MM/dd.");
            }
        }while (flag==0);
        System.out.println("Enter the number of attendees: ");
        num = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < num; i++) {
            System.out.println("Enter the name of attendee " + (i + 1) + ": ");
            String attendee = scanner.nextLine();
            System.out.println("Enter the email of attendee " + (i + 1) + ": ");
            String email = scanner.nextLine();
            System.out.println("Enter the phone of attendee " + (i + 1) + ": ");
            String phone = scanner.nextLine();
            System.out.println("Enter the address of attendee " + (i + 1) + ": ");
            String address = scanner.nextLine();
            event.getEventAttendees().add(new Attendees(attendee,email,phone,address));
        }
        event.organizeEvent();
        System.out.println("The details of the event are: ");
        System.out.println("Event ID: "+event.getEventID());
        System.out.println("Event Name: "+event.getEventName());
        System.out.println("Event Venue: "+event.getEventVenue());
        System.out.println("Event Date: "+event.getEventDate());
        System.out.println("Event Attendees: ");
        for (Attendees attendee : event.getEventAttendees()) {
            System.out.println('\n'+"Name: "+attendee.getName());
            System.out.println("Email: "+attendee.getEmail());
            System.out.println("Phone: "+attendee.getPhone());
            System.out.println("Address: "+attendee.getAddress());
        }
    }
}