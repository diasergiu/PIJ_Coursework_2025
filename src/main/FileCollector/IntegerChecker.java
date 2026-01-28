package FileCollector;

public class IntegerChecker {

    public static boolean isInteger(String number){
        if(number.length() == 0){
            return false;
        }
        for(int i = 0; i < number.length(); i++){
            if(!Character.isDigit(number.charAt(i))){
                return false;
            }
        }
        return true;
    }

    public static boolean isLowerCaseChar(String character){
        if(character.length() != 1){
            return false;
        }
        if(character.charAt(0) < 97 || character.charAt(0) > 122){
            return false;
        }
        return true;
    }
}
