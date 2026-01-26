package Planning.Board;

public class Piece {

    private char character;
    private boolean wiledCard;
    private int valueMultiplyer;

    public Piece(char character,int valueMultiplyer, boolean wiledCard) {
        this.character = character;
        this.valueMultiplyer = valueMultiplyer;
        this.wiledCard = wiledCard;
    }
}
