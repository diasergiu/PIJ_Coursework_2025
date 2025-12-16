package Planning.Board;

public class Tile {

    char character;
    boolean startTile;
    int valueMultiplyer;

    public Tile(char character, int valueMultiplyer) {
        this.character = character;
        this.valueMultiplyer = valueMultiplyer;
    }

    // dont know if this class is gonna play the role of pieces from your hand,
    // we still need to represent the wildcard
}
