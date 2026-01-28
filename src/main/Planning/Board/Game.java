package Planning.Board;

import java.io.File;
import java.util.Scanner;

import FileCollector.*;

// game must have human or computer players
// game can be open or closed (you can see the tiles that the other player can have)
public class Game {
    private Scanner scanner;
    private static final String PATH_BAG = "resources/Bags";
    private static final String PATH_BOARDS = "resources/Boards";
    private static final String PATH_LANGUAGE = "resources/Language";

    public Game() {
        scanner = new Scanner(System.in);
    }

    //Both players have a rack of up to 7 tiles which is refilled from a tile
    // bag after every move. Each tile has a letter and a numerical value.
    public void InnitializeGame(){
        boolean doYouWantToClose = false;
        while(!doYouWantToClose){
            File[] listOfBoards = getFileFromDirectory(PATH_BOARDS);
            File[] listOfBags = getFileFromDirectory(PATH_BAG);
            File[] listOfLanguages = getFileFromDirectory(PATH_LANGUAGE);
            String messageBoard = "Which kind of board would you like ";
            String messageBags = "What kind of bag would you like";
            String messageLanguage = "Select a language for the game";
            String pathToBoard = getFileNameFromNumber(listOfBoards, new BoardFileCollector(), messageBoard);
            String pathToBags = getFileNameFromNumber(listOfBags, new BagFileCollector(), messageBags);
            String pathToLanguage = getFileNameFromNumber(listOfLanguages, new LanguageFileCollector(), messageLanguage);

            int numberOfPlayers = numberOfPlayers();

            boolean openGame = openOrClosedGame();
            Board newGame = new Board(pathToBags, pathToBoard, pathToLanguage, numberOfPlayers, openGame);
            newGame.play();

            String closeOrContinue = scanner.nextLine();
            if(closeOrContinue.equals("Close")){
                doYouWantToClose = true;
            }
        }
    }
    private String getFileNameFromNumber(File[] files, FileCollector fileChecker, String message){
//        Scanner scanner = new Scanner(System.in);
        StringBuilder path = new StringBuilder();
        while(!fileChecker.isFileCorrect(path.toString())){
            path = getStringFromEnum(fileChecker);
            System.out.println(message);
            printListOfFiles(files);
            String number = scanner.nextLine();
            if(IntegerChecker.isInteger(number)){
                int selected = Integer.parseInt(number);
                if(selected >= 0 && selected < files.length){
                    path.append('/');
                    path.append(files[selected].getName());
                }
            }
        }
        return path.toString();
    }

    private StringBuilder getStringFromEnum(FileCollector fileCollector){
        if(fileCollector instanceof BagFileCollector){
            return new StringBuilder(PATH_BAG);
        }
        if(fileCollector instanceof BoardFileCollector){
            return new StringBuilder(PATH_BOARDS);
        }
        return new StringBuilder(PATH_LANGUAGE);

    }
    private void printListOfFiles(File[] files){
        for(int i = 0; i < files.length; i++){
            System.out.println(i + "  " + files[i].getName());
        }
    }
    private File[] getFileFromDirectory(String path){
        File folder = new File(path);
        return folder.listFiles();
    }

    private boolean openOrClosedGame(){
        System.out.println("do you want an _O_pen game or _C_losed game");
        while(true){
//            Scanner scanner = new Scanner(System.in);
            String gameType = scanner.nextLine();
            if(gameType.equals("O")){
                return true;
            }
            else if(gameType.equals("C")){
                return false;
            }
            System.out.println("Not a valid respons plese chose again");
        }
    }

    private int numberOfPlayers(){
        System.out.println("How many players do you want");
        String numberPlayersCheck = "";
//        Scanner scanner = new Scanner(System.in);
        while(!numberPlayersCheck.equals("exit")){
            numberPlayersCheck = scanner.nextLine();
            if(IntegerChecker.isInteger(numberPlayersCheck)){
                return Integer.parseInt(numberPlayersCheck);
            }
        }
        return 0;
    }


    /*
        The boards needs to have rows between 7 and 26
        column between 10 and 99
        and total amount os space needs to be bigger or equal to 192
    */


}
