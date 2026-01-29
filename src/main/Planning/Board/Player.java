package Planning.Board;

import FileCollector.IntegerChecker;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

// players can pass turns
public class Player {

    // gets extra 60 points if he uses all 7 tiles
    private int score;
    private List<Piece> pieces;
    Scanner scanner;

    public Player(){
        int defaultTilesPerPlayer = 7;
        pieces = new ArrayList<Piece>();
        scanner = new Scanner(System.in);
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public List<Piece> getPieces() {
        return pieces;
    }

    public void setPieces(List<Piece> pieces) {
        this.pieces = pieces;
    }

    public void changePiece(int index, Piece piece){
        this.pieces.set(index, piece);
    }

    public void addPiece(Piece piece){
        this.pieces.add(piece);
    }

    public void printPieces(){
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < this.pieces.size(); i++){
            builder.append("[" + pieces.get(i).getCharacter() + pieces.get(i).getValueMultiplyer() + ']');
        }
        System.out.println(builder.toString());
    }

    public PlayerMove makeMove(){
        String selectedPieces = "";
        boolean correctPieceSelection = false;
        int[] result = new int[0];
        Piece[] piecesSelected = new Piece[0]; // see later if this causes problems
        while(!correctPieceSelection) {
            correctPieceSelection = true;
            System.out.print("Your pieces are: ");
            printPieces();
            System.out.println("What word do you chose. Please type in the index of the piece. from 0 to " + this.pieces.size() );
            selectedPieces = scanner.nextLine();
            if(selectedPieces.equals("pass")){
                return new PlayerMove();
            }
            if(!IntegerChecker.isInteger(selectedPieces)){
                System.out.println("Please use only numbers between 0 and" + pieces.size());
                correctPieceSelection = false;
                continue;
            }

            HashSet<Integer> dontSelectSamePiece = new HashSet<>();
            result = new int[selectedPieces.length()];
            piecesSelected = new Piece[result.length];
            for (int i = 0; i < result.length; i++) {
                result[i] = Character.getNumericValue(selectedPieces.charAt(i));
                if(result[i] > this.pieces.size()){
                    System.out.println("Please use only numbers between 0 and" + piecesSelected.length);
                    correctPieceSelection = false;
                    break;
                }
                if(dontSelectSamePiece.contains(result[i]) || result[i] >= this.pieces.size()){
                    correctPieceSelection = false;
                    System.out.println("Invalid answer please try again");
                    break;
                }
                dontSelectSamePiece.add(result[i]);
                if(this.pieces.get(result[i]).getCharacter() == '?'){
                    piecesSelected[i] = wildCardPiece(this.pieces.get(result[i]));
                }
                else {
                    piecesSelected[i] = this.pieces.get(result[i]);
                }
            }
        }
        PlayerMove move = new PlayerMove(result, piecesSelected);
        String coordinates;
        boolean corectCoordinates = false;
        do{
            System.out.println("Chose the row and the column ");
            corectCoordinates = move.setCoordinates(scanner.nextLine());
            if(!corectCoordinates){
                System.out.println("Incorect Coordinates, please try again");
            }
        } while(!corectCoordinates);
        move.setDirectionDown(getDirection());
        return move;
    }

    private Piece wildCardPiece(Piece piece){
        boolean legitemateRespons = false;
        Piece pieceReturn = new Piece(piece.getCharacter(), piece.getValueMultiplyer(), true);
        while(!legitemateRespons){
            System.out.println("You have selected a wild card please chose a character for that wild card");
            String newChar = scanner.nextLine();
            if(IntegerChecker.isLowerCaseChar(newChar)){
                pieceReturn.setCharacter(newChar.charAt(0));
                legitemateRespons = true;
            }else{
                System.out.println("Wrong input please try again");
            }
        }
        return pieceReturn;
    }

    private boolean getDirection(){
        String direction = "";
        while(!direction.equals("D") && !direction.equals("L")){
            System.out.println("What direction do you with to move to do you prefer _D_own or _L_eft");
            direction = scanner.nextLine();
        }
        boolean directionDown = false;
        if(direction.equals("D")){
            directionDown = true;
        }
        return directionDown;
    }

    public void removePieceByIndex(int[] index){
        for(int j : index) {
            this.pieces.remove(j);
        }
    }
}
