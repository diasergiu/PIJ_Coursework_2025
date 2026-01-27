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

    public char getCharacter() {
        return character;
    }

    public void setCharacter(char character) {
        this.character = character;
    }

    public int getValueMultiplyer() {
        return valueMultiplyer;
    }

    public void setValueMultiplyer(int valueMultiplyer) {
        this.valueMultiplyer = valueMultiplyer;
    }
}
