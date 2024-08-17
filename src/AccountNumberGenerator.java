public class AccountNumberGenerator {
    private static int currentNumber = 0;

    public static int getNext(){
        currentNumber++;
        return currentNumber;
    }

    public static int getCurrentNumber(){
        return currentNumber;
    }

    public static void reset(){
        currentNumber = 0;
    }
}
