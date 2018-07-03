public class Loops {

    public static void main(String[] args) {
        // code test 1
        // for(double i = 2.0; i < 9; i++)  <--to count up
        for(double i = 8.0; i >= 2; i--) { //<-- to count down
            double amount = 10000;

            double result = calculateInterest(amount, i);

            System.out.println("10,000 at " + i + "% = " + String.format("%.2f",result));
        }

        // code test 2
        int count = 0;
        for(int i = 2; i < 101; i++) {
            if(isPrime(i)) {
                count++;
                System.out.println("The number " + i + " is a prime number!");
                if(count == 6) {
                    System.out.println("Exiting the loop");
                    break;
                }
            }
        }

        // code test 3
        int testSum = 0;
        int testCount = 0;
        for(int i = 1; i <= 1000; i++) {
            if((i % 3 == 0) && (i % 5 == 0)) {
                testSum += i;
                testCount++;
                System.out.println("The number " + i + " is divisible by 3 and 5");
                if(testCount == 5) {
                    System.out.println("Exit the loop");
                    break;
                }
            }
        }
        System.out.println("Sum = " + testSum);


        // code test 4
        int result = sumOdd(10, 5);
        System.out.println(result);


        // while example
        int whileCount = 0;
        while(whileCount != 6) {
            System.out.println("Count value is " + whileCount);
            whileCount++;
        }

        //equivalent in for loop of the while statement
        for(int i = 0; i < 6; i++) {
            System.out.println("Count value is " + i);
        }

        //do while example (difference is do while will always execute once)
        int doCount = 1;
        do {
            System.out.println("DoWhile Count value was " + doCount);
            doCount++;
        } while(doCount != 6);

        // code test 5
        boolean isEvenResult = isEvenNumber(7);
        System.out.println(isEvenResult);

        int evenStart = 2;
        int evenEnd = 20;
        int evenCount = 0;

        while(evenStart <= evenEnd) {
            evenStart++;
            if(!isEvenNumber(evenStart)) {
                continue; //<-- similar to break except it continues within the loop, break will jump out of the loop
            }
            System.out.println("Even number " + evenStart);

            evenCount++;
            if(evenCount >= 5) {
                break;
            }
        }
        System.out.println("Total number of even numbers found " + evenCount);

        // code test 6
        System.out.println("The sum of all of the digits from an int passed in are " + sumDigits(125));

        //code test 7
        boolean palidromeTest = isPalindrome(-222);
        System.out.println(palidromeTest);

        // code test 8
        int firstLastResult = sumFirstAndLastDigit(5);
        System.out.println(firstLastResult);

        // code test 9
        numberToWords(100);
        // cont. test 9 testing reverse
        int reverseResult = reverse(100);
        System.out.println(reverseResult);

        // code test 9 cont.
        int digitCountResult = getDigitCount(5200);
        System.out.println(digitCountResult);

        // code test 10
        int evenSum = getEvenDigitSum(252);
        System.out.println(evenSum);

        // code test 11
        System.out.println(hasSharedDigit(15, 55));

        // code test 12
        System.out.println(hasSameLastDigit(9, 99, 999));

        // code test 13
        int divisorResult = getGreatestCommonDivisor(81, 153);
        System.out.println(divisorResult);

        // code test 14
        printFactors(-1);

        // code test 15
        System.out.println(isPerfectNumber(28));

        //code test 16
        System.out.println(canPack(2,1,5));
    }


    public static double calculateInterest(double amount, double interestRate) {
        return (amount *(interestRate/100));
    }

    public static boolean isPrime(int n) {
        if(n == 1) {
            return false;
        }
        for(int i = 2; i <= (long) Math.sqrt(n); i++) {
            if(n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isOdd(int number) {
        if((number <= 0) || (number % 2 == 0)) {
            return false;
        }
        return true;
    }

    public static int sumOdd(int start, int end) {
        int sum = 0;

        if((end < start) || (start <= 0) || (end <= 0)) {
            return -1;
        }

        for(int i = start; i <= end; i++) {
            if(isOdd(i)) {
                sum += i;
            }
        }
        return sum;
    }

    public static boolean isEvenNumber(int number) {
        if(number % 2 == 0) {
            return true;
        }
        return false;
    }

    public static int sumDigits(int number) {
        if(number < 10) {
            return -1;
        }

        int sum = 0; // <-- the variable to handle the sum value

        while(number > 0) { // <--the number variable will change with the next 2 calculations

            // extract the least significant digit
            int digit = number % 10; // <--% 10 removes the last digit of a number ex(125 % 10) = 5
            sum += digit; // add the least significant digit to the sum variable

            // drop the least-significant digit to continue the while loop
            number /= 10; // same as number = number / 10;
        } // this means 125 / 10 = 12.5
        return sum;
    }

    public static boolean isPalindrome(int number) {

        int reverse = 0;
        int i = number;

        while(i != 0) {
            int lastDigit = i % 10;

            reverse = reverse * 10 + lastDigit;

            i /= 10;
        }

        // final logic
        return reverse == number;
    }

    public static int sumFirstAndLastDigit(int number) {
        int sum = 0;

        if(number < 0) {
            return -1;
        }

        // outside of a loop because it only needs to happen once
        int lastDigit = number % 10;
        // add to sum
        sum += lastDigit;

        // keep shrinking the number by one decimal place until the value is under two digits (hence greater than = 10)
        while(number >= 10) {
            number /= 10;
        }
        // once the loop stops this is the first digit of the number
        int firstDigit = number;
        // also add to the sum
        sum += firstDigit;
        // return the sum
        return sum;
    }

    public static int getEvenDigitSum(int number) {
        int sum = 0;
        if(number < 0) {
            return -1;
        }

        while(number > 0) {
            // first get the last digit of the passed in number
            int lastDigit = number % 10;
            // if that last digit divides evenly into 2 it's an even number
            if(lastDigit % 2 == 0) {
                // add the digit to the running sum total
                sum += lastDigit;
            }
            // move left by one digit for the while loop
            number /= 10;
        }
        // return the sum
        return sum;
    }

    public static boolean hasSharedDigit(int numberOne, int numberTwo) {
        if((numberOne <= 9 || numberOne >= 100) || (numberTwo <= 9 || numberTwo >= 100)) {
            return false;
        }

        int aa = numberOne % 10;
        numberOne /= 10;
        int bb = numberOne %10;

        int cc = numberTwo % 10;
        numberTwo /= 10;
        int dd = numberTwo % 10;

        if((aa == cc) || (aa == dd) || (bb == cc) || (bb == dd)) {
            return true;
        }
        return false;
    }

    public static boolean hasSameLastDigit(int numberOne, int numberTwo, int numberThree) {
        if((numberOne <= 9 || numberOne >= 1001) || (numberTwo <= 9 || numberTwo >= 1001)) {
            return false;
        }

        int aa = numberOne % 10;

        int bb = numberTwo %10;

        int cc = numberThree % 10;

        if((aa == bb) || (aa == cc) || (bb == cc)) {
            return true;
        }
        return false;
    }

    public static int getGreatestCommonDivisor(int first, int second) {
        int hCommonDivisor = 1;

        if(first < 10 || second < 10) {
            return -1;
        } else {
            int digit = 1;
            int max = first;
            if(first < second) {
                max = second;
            }
            while(digit < max) {
                if((first % digit == 0) && (second % digit == 0))  {
                    hCommonDivisor = digit;
                }
                digit++;
            }
            return hCommonDivisor;
        }
    }

    public static void printFactors(int number) {
        if(number < 1) {
            System.out.println("Invalid Value");
        } else {
            int digit = 1;
            while(digit <= number) {
                if(number % digit == 0) {
                    System.out.println(digit);
                }
                digit++;
            }
        }
    }

    public static boolean isPerfectNumber(int number) {
        if(number < 1) {
            return false;
        } else {
            int digit = 1;
            int sum = 0;
            while(digit < number) {
                if(number % digit == 0) {
                    sum += digit;
                }
                digit++;
            }
            return sum == number;
        }
    }

    public static void numberToWords(int number) {
        if(number < 0) {
            System.out.println("Invalid Value");
        }

        int digitCount = getDigitCount(number);

        number = reverse(number);

        int newDigitCount = getDigitCount(number);

        int difference = digitCount - newDigitCount;

        while(number > 0) {
            int lastDigit = number % 10;
            switch (lastDigit) {
                case 0:
                    System.out.println("Zero");
                    break;
                case 1:
                    System.out.println("One");
                    break;
                case 2:
                    System.out.println("Two");
                    break;
                case 3:
                    System.out.println("Three");
                    break;
                case 4:
                    System.out.println("Four");
                    break;
                case 5:
                    System.out.println("Five");
                    break;
                case 6:
                    System.out.println("Six");
                    break;
                case 7:
                    System.out.println("Seven");
                    break;
                case 8:
                    System.out.println("Eight");
                    break;
                case 9:
                    System.out.println("Nine");
                    break;
                default:
                    System.out.println("Invalid Value");
            }
            number /= 10;
        }
        for(int i = difference; i > 0; i--) {
            System.out.println("Zero");
        }
    }

    public static int reverse(int number) {

        int reverse = 0;
        int i = number;

        while(i != 0) {
            int lastDigit = i % 10;

            reverse = reverse * 10 + lastDigit;

            i /= 10;
        }
        return reverse;
    }

    public static int getDigitCount(int number) {
        if(number < 0 ) {
            return -1;
        }
        int count = 0;

        do {
            count++;
            number /= 10;
        } while (number > 0);

        return count;
    }

    public static boolean canPack(int bigCount, int smallCount, int goal) {
        if(bigCount < 0 || smallCount < 0 || goal < 0) {
            return false;
        }

        int largeKilo = 5;

        if (bigCount * largeKilo == goal) return true;

        if (bigCount * largeKilo > goal) {
            return goal % largeKilo <= smallCount;
        }

        if (bigCount * largeKilo < goal){
            return goal - (bigCount * largeKilo) <= smallCount;
        }
        return false;
    }
}
