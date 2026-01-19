package FileCollector;

public class IntegerChecker {

    public static boolean isInteger(String number){
        for(int i = 0; i < number.length(); i++){
            if(!Character.isDigit(number.charAt(i))){
                return false;
            }
        }
        return true;
    }
}
