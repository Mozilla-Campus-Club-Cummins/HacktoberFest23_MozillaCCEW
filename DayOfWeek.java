//           Determine the day of the week of entered date using the logic of Zeller's Congruence algorithm.

package day_Of_Week;
import java.util.*;

public class DayOfWeek {
	
	
	 public static boolean isLeapYear(int year) {
         if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
             return true;
         }
         return false;
     }
	 
 public static int calculate_Day(int date,int month,int year){ //function to calculate day of given date using Zeller's Congruence formula
     if(month<3){                          // month adjustment
         month = (month + 12);
         year--;
     }
     int cenYear=year%100;  //year within century
     int centuryNo=year/100;  // number of century

     int formula;
     formula = (date + (13 * (month + 1) / 5) + cenYear + (cenYear / 4) + (centuryNo / 4) - (2 * centuryNo));
     int dayOfWeek= formula % 7;
     return dayOfWeek;
}
 
 public static void main(String[] args) { //main method
     Scanner input = new Scanner(System.in);
     System.out.println("Enter date:");
     int date= input.nextInt();
     System.out.println("Enter month:");
     int month=input.nextInt();
     System.out.println("Enter year");
     int year = input.nextInt();
     
     if (month == 2 && date == 29 && !isLeapYear(year)) {
         System.out.println("Invalid input. February 29th is not valid for a non-leap year.");
     }
     else {
         int day_of_week = calculate_Day(date,month,year); // getting index of the day from formula
         String[] days_in_week={"Saturday","Sunday","Monday","Tuesday","Wednesday","Thursday","Friday"}; // days arranged according to Zeller's Congruence rule
         System.out.println("The day on the given date is:"+days_in_week[day_of_week]);
     }
     input.close();}
}
