package pita;

public class Calculations {
    public int factorial(int number){
        int factorial =1;
        while (number >1){
            factorial = factorial * number;
            number--;
        }
        return factorial;
    }
}
