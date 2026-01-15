package Planning.Board;

public class Tile {

    private char character;
    private boolean startTile;
    private boolean premiumWord;
    int valueMultiplayer;

    public char getCharacter() {
        return character;
    }

    public void setCharacter(char character) {
        this.character = character;
    }

    public boolean isStartTile() {
        return startTile;
    }

    public Tile() {
        char defaultCharacter = '.';
        int defaultValue = 1;
        this.character = defaultCharacter;
        this.valueMultiplayer = defaultValue;
//        this(defaultCharacter, defaultValue);
    }
    public Tile(char character, int valueMultiplyer) {
        this.character = character;
        this.valueMultiplayer = valueMultiplyer;
    }
    public void setStartTile(boolean startTile) {
        this.startTile = startTile;
    }

    public boolean isPremiumWord(){
        return this.premiumWord;
    }

    public int getValueMultiplayer() {
        return valueMultiplayer;
    }

    // dont know if this class is gonna play the role of pieces from your hand,
    // we still need to represent the wildcard
}
