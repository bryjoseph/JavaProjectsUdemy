public class Hello {

    public static void main(String[] args) {

        System.out.println("Hello World!");

        Ford ford = new Ford(12);
        ford.steer(45);
        ford.changeSpeed(30);
        ford.changeSpeed(20);

        // int has a width of 32 bits
        int myIntExample = 2_147_483_647;

        // about a quarter of the size of an int
        // byte has a width of 8 bits
        byte myByteValue = 10;
        byte testMathByte = (byte)(myByteValue/2);

        // about half the size of an int
        // short has a width of 16 bits
        short myShortValue = -32768;
        short myTestMathShort = (short)(myShortValue/2);

        // about double the width of an int
        // 9_223_372_036_854_775_807L is the biggest positive number for a Long
        long myLongValue = 100L;
        long myTestMathLong = (long)(myLongValue/2);

        long testLong = 50_000 + 10 * (testMathByte + myTestMathShort + myIntExample);

        System.out.println("Hello Broj");

        int myNumber = 5;
        int secondNumber =12;
        int thirdNumber = 6;

        int myTotal = myNumber + secondNumber + thirdNumber;

        int difference = 1000 - myTotal;

        System.out.println(difference);

        //Floats and Doubles
        //Float is a seven decimal points
        //Double is a 16 decimal points
        float testFloat = 5f / 2f;

        double testDouble = 5d / 2d;

        // code challenge
        int testPoundAmount = 100;
        double testKilo = .45359237;

        double result = testPoundAmount * testKilo;
        System.out.println(result);

        //Operators
        int mathResult = 1 + 2; // or - for subtraction

        int multResult =  mathResult * 2; // or / for division

        int remanderResult = multResult % 3;

        remanderResult++; // or -- if you want to subtract from the variable
        System.out.println(remanderResult);

        mathResult += 2;
        System.out.println(mathResult);
        // can also be any combination of operators
        mathResult -= 2;
        mathResult *= 2;
        mathResult /= 2;
        System.out.println(mathResult);

        //assignment operator vs testing operator
        boolean isAlien = false;
        //vs
        if (isAlien == false) System.out.println("It is not an alien");
        //or
        if (!isAlien) System.out.println("It is not an alien");

        boolean isCar = false;
        boolean wasCar = isCar ? true : false;  //the beginning value after the question mark is the true
        //the second value after the : is the else

        double doubleVar = 20d;
        double secondDubVar = 80d;
        double challResult = (doubleVar + secondDubVar) * 25;
        double remResult = challResult % 40;
        if(remResult <= 20) System.out.println("Total was over the limit");

        //expressions vs statements and keywords
        int score = 100;
        // (score to 100 is the expression)
        if(score > 99) {
            System.out.println("You got the high score!");
            score = 0;
        }
        // between the () of the if is an expression
        // between the () of println is an expression
        // score to 0 is an expression

        boolean gameOver = true;
        int gameScore = 800;
        int levelCompleted = 5;
        int bonus = 100;

        calculateScore(gameOver, gameScore, levelCompleted, bonus);

        int position1 = calculateHighScorePosition(1500);
        displayHighScorePosition("Fred", position1);

        int position2 = calculateHighScorePosition(900);
        displayHighScorePosition("Sally", position2);

        int position3 = calculateHighScorePosition(400);
        displayHighScorePosition("Joe", position3);

        int position4 = calculateHighScorePosition(50);
        displayHighScorePosition("Sally", position4);
    }

    public static int calculateScore(boolean gameOver, int gameScore, int levelCompleted, int bonus) {
//        boolean gameOver = true;
//        int score = 800;
//        int levelCompleted = 5;
//        int bonus = 100;

        if(gameOver) {
            int finalScore = gameScore + (levelCompleted * bonus);
            finalScore += 1000;
            System.out.println("Your final score was " + finalScore);
            return finalScore;
        }
        return -1;
    }

    public static void displayHighScorePosition(String playerName, int position) {
        System.out.println(playerName + " managed to get into position " + position + " on the high score table.");
    }

    public static int calculateHighScorePosition(int playerScore) {
//  approach 1 of going through and calculating position values;
//        if(playerScore >= 1000) {
//            return 1;
//        } else if (playerScore >= 500) {
//            return 2;
//        } else if (playerScore >= 100) {
//            return 3;
//        } else {
//            return 4;
//  }

//  approach 2 of going through and calculating position values with only ONE return value;
        int position = 4;

        if (playerScore >= 1000) {
            position = 1;
        } else if (playerScore >= 500) {
            position = 2;
        } else if (playerScore >= 100) {
            position = 3;
        }
        return position;
    }
}
