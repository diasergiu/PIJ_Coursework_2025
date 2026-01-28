package Planning.Board;

import FileCollector.IntegerChecker;

public class PlayerMove {

    public int[] indexPiecesMoved;
    public Piece[] piecesSelected;
    public boolean directionDown;
    public int row;
    public int col;
    public boolean passTurn;

    public PlayerMove(int[] indexPiecesMoved, Piece[] piecesSelected) {
        this.indexPiecesMoved = indexPiecesMoved;
        this.piecesSelected = piecesSelected;
    }

    public PlayerMove() {
        this.passTurn = true;
    }

    public boolean isDirectionDown() {
        return directionDown;
    }

    public void setDirectionDown(boolean directionDown) {
        this.directionDown = directionDown;
    }

    public boolean setCoordinates(String message){
        if(message == null || message.length() == 0){
            return false;
        }

        int right = message.length() - 1;
        if(!IntegerChecker.isLowerCaseChar(message.substring(right))){
            return false;
        }
        if(!IntegerChecker.isInteger(message.substring(0, right))){
            return false;
        }
        this.col = message.charAt(right) - 96;
        this.row = Integer.parseInt(message.substring(0, right));
        return true;
    }
}
