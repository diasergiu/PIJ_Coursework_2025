package Planning.Board;

import FileCollector.IntegerChecker;

import java.util.HashSet;
import java.util.Scanner;

// players can pass turns
public class Player {

    // gets extra 60 points if he uses all 7 tiles
    private int score;
    private Piece[] pieces;
    Scanner scanner;

    public Player(){
        int defaultTilesPerPlayer = 7;
        pieces = new Piece[defaultTilesPerPlayer];
        scanner = new Scanner(System.in);
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setPieceAtIndex(Piece piece, int index){
        this.pieces[index] = piece;
    }

    public void printPieces(){
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < this.pieces.length; i++){
            builder.append("[" + pieces[i].getCharacter() + pieces[i].getValueMultiplyer() + ']');
        }
        System.out.println(builder.toString());
    }

    public PlayerMove makeMove(){
        String selectedPieces = "";
        boolean correctPieceSelection = false;
        int[] result = new int[0];
        while(!correctPieceSelection) {
            correctPieceSelection = true;
            printPieces();
            System.out.println("What word do you chose. Please type in the index of the piece");
            selectedPieces = scanner.nextLine();
            if(selectedPieces.equals("pass")){
                return new PlayerMove();
            }
            if(IntegerChecker.isInteger(selectedPieces)){
                System.out.println("Please use only numbers between 0 and" + pieces.length);
                correctPieceSelection = false;
                continue;
            }

            HashSet<Integer> dontSelectSamePiece = new HashSet<>();
            result = new int[selectedPieces.length()];
            Piece[] pieces = new Piece[result.length];
            for (int i = 0; i < result.length; i++) {
                result[i] = Character.getNumericValue(selectedPieces.charAt(i));
                if(result[i] > this.pieces.length){
                    System.out.println("Please use only numbers between 0 and" + pieces.length);
                    correctPieceSelection = false;
                    break;
                }
                if(dontSelectSamePiece.contains(result[i])){
                    correctPieceSelection = false;
                    System.out.println("Please dont select the same piece twice");
                    break;
                }
                dontSelectSamePiece.add(result[i]);
                pieces[i] = this.pieces[result[i]];
            }
        }
        PlayerMove move = new PlayerMove(result, pieces);
        while(!move.setCoordinates(scanner.nextLine()));
        move.setDirectionDown(getDirection());
        return move;
    }

    private boolean getDirection(){
        String direction = "";
        while(!direction.equals("D") || !direction.equals("L")){
            System.out.println("What direction do you with to move to do you prefer _D_own or _L_eft");
            direction = scanner.nextLine();
        }
        boolean directionDown = false;
        if(direction.equals("D")){
            directionDown = true;
        }
        return directionDown;
    }
}
