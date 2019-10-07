import java.util.Calendar;
import java.util.GregorianCalendar;

public class PrintACalendar {
    public static void main(String[] args) {
        PrintCalendar cal = new PrintCalendar(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
    }
}

class PrintCalendar {
    Calendar c;

    PrintCalendar(int month, int year) {
        c = new GregorianCalendar(year, month - 1, 1);
        print();
    }

    private String getMonth(int month) {
        String[] monthNames = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
                "October", "November", "December" };
        return monthNames[month];
    }

    private void print() {
        System.out.println();
        System.out.println(" " + getMonth(c.get(Calendar.MONTH)) + ", " + c.get(Calendar.YEAR));

        System.out.println("-----------------------------");
        System.out.println(" Sun Mon Tue Wed Thu Fri Sat");

        printMonthBody(c.get(Calendar.YEAR), c.get(Calendar.MONTH));
        System.out.println();
    }

    /** Print month body */
    private void printMonthBody(int year, int month) {

        int startDay = c.get(Calendar.DAY_OF_WEEK) - 1;
        int numDaysInMonth = c.getActualMaximum(Calendar.DATE);

        int day = c.get(Calendar.DATE);

        // Pad space before the first day of the month
        int i = 0;
        for (i = 0; i < startDay; i++)
            System.out.print("    ");

        // print days
        while (day <= numDaysInMonth) {
            System.out.printf("%4d", day);

            if (c.get(Calendar.DAY_OF_WEEK) % 7 == 0)
                System.out.println();

            day++;
            c.roll(Calendar.DATE, true);
        }
        System.out.println();
    }
}