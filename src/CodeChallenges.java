public class CodeChallenges {

    private static final String INVALID_VALUE_MESSAGE = "Invalid Value";

    public static void main(String[] args) {

        // test problem 1
        printMegaBytesAndKiloBytes(2050);

        // test problem 2
        boolean barking = bark(true, 22);
        System.out.println(barking);

        // test problem 3
        boolean isLeapYear = isLeapYear(2000);
        System.out.println(isLeapYear);

        //test problem 4
        System.out.println(getDurationString(83, 15));

        //test problem 5
        System.out.println(getDurationString(83));

        //test problem 6
        System.out.println(area(5.0));
        System.out.println(area(5.0, 4.0));
    }

    public static void printMegaBytesAndKiloBytes(int kiloBytes) {
        int megaByte = 1024;

        if (kiloBytes >= 0) {
            int mb = kiloBytes / megaByte;
            int remainder = kiloBytes % megaByte;

            System.out.println(kiloBytes + " KB = " + mb + " MB and " + remainder + " KB");
        } else {
            System.out.println(INVALID_VALUE_MESSAGE);
        }
    }

    public static boolean bark(boolean barking, int hourOfDay) {
        return (barking && (hourOfDay < 8 || hourOfDay > 22) && !(hourOfDay < 0 || hourOfDay > 23));
    }

    public static boolean isLeapYear(int year) {
        return year >= 1 && year < 9999 && ((year % 4 == 0) && !(year % 100 == 0) || (year % 400 == 0));
    }

    public static String getDurationString(long minutes, long seconds) {

        if((minutes < 0) || (seconds < 0 || seconds >= 59)) {
            return INVALID_VALUE_MESSAGE;
        } else {

            long hour = minutes / 60;
            long remainderMinutes = minutes % 60;

            String hoursString = hour + "h ";
            if(hour < 10) {
                hoursString = "0" + hoursString;
            }

            String minutesString = remainderMinutes + "m ";
            if(remainderMinutes < 10) {
                minutesString = "0" + minutesString;
            }

            String secondsString = seconds + "s";
            if(seconds < 10) {
                secondsString = "0" + secondsString;
            }

            // return hour + "h " + remainderMinutes + "m " + seconds + "s";
            return hoursString + minutesString + secondsString;
        }
    }

    public static String getDurationString(long seconds) {

        if(seconds < 0) {
            return INVALID_VALUE_MESSAGE;
        } else {

            long minute = seconds / 60;
            long remainderSeconds = seconds % 60;

            return minute + "m " + remainderSeconds + "s ";
        }
    }

    public static double area(double radius) {
        if(radius < 0) {
            return -1;
        } else {
            return (radius * radius) * 3.14159;
        }
    }

    public static double area(double x, double y) {

        if((x < 0 || y < 0) || (x < 0 && y < 0)) {
            return -1;
        } else {
            return x * y;
        }
    }
}
