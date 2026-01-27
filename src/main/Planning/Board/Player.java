package Planning.Board;

// players can pass turns
public class Player {

    // gets extra 60 points if he uses all 7 tiles
    private int score;
    private Piece[] pieces;

    public Player(){
        int defaultTilesPerPlayer = 7;
        pieces = new Piece[defaultTilesPerPlayer];
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

    // be able to pass turn if they dont have a word
}
