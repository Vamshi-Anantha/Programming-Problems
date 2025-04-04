// Question 2: Time Conversion
// Problem Statement
// Given a time in 12-hour AM/PM format, convert it to 24-hour military time.

// Example
// vbnet
// Copy
// Edit
// Input:  "07:05:45PM"
// Output: "19:05:45"

// Input:  "12:00:00AM"
// Output: "00:00:00"
// Function Signature
// java
// Copy
// Edit
// static String timeConversion(String s)
// Constraints
// The input time is always in the correct format.

// Sample Input
// makefile
// Copy
// Edit
// 07:05:45PM
// Sample Output
// makefile
// Copy
// Edit
// 19:05:45
// Java Solution

import java.util.Scanner;

public class TimeConversion {
    public static String timeConversion(String s) {
        int hour = Integer.parseInt(s.substring(0, 2));
        String minutesSeconds = s.substring(2, 8); // Extract :MM:SS
        String meridian = s.substring(8, 10); // Extract AM or PM

        if (meridian.equals("AM")) {
            if (hour == 12) {
                hour = 0; // Convert 12 AM to 00
            }
        } else { // PM case
            if (hour != 12) {
                hour += 12; // Convert PM times except 12 PM
            }
        }

        return String.format("%02d%s", hour, minutesSeconds);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter time in 12-hour format (hh:mm:ssAM/PM): ");
        String inputTime = scanner.next();
        String convertedTime = timeConversion(inputTime);
        System.out.println("Converted 24-hour format: " + convertedTime);
        scanner.close();
    }
}
