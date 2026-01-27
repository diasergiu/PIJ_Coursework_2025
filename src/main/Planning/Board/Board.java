package Planning.Board;

import FileCollector.BagFileCollector;
import FileCollector.BoardFileCollector;
import FileCollector.LanguageFileCollector;

import java.util.HashSet;
import java.util.Random;

public class Board {

    /*
    *   The board of the game. A grid a objects Tile
    *   Number of columns must be between 7 and 26
    *   Number of rows must be between 10 and 99
    *   The board must have at least 192 Tiles
    *   Board can be loaded from a file ( example the DefaultBoard)
     */
    Tile[][] board;
    private boolean isOpenGame;
    // we have a bag that holds a certain amount of pieces or tiles that the player can draw from to
    // get back to 7 pieces after he played some
    /*
    *
    */
    private Player[] listPlayers;
    private Bag gameBag;
    private HashSet<String> acceptableCharacters;
    private int[] bagsWithCharacters;
    private int numberOfPiecesPerPlayer;
    public Board(int n, int m){
        board = new Tile[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                board[i][j] = new Tile();
            }
        }
    }
    public Board(String pathToBags, String pathToBoard, String pathToLanguage, int numberOfPlayers, boolean openGame){
        this.board = BoardFileCollector.getBoardFromFile(pathToBoard);
        this.gameBag = BagFileCollector.getBagFromFile(pathToBags);
        this.acceptableCharacters = LanguageFileCollector.getLanguageFromFile(pathToLanguage);
        this.listPlayers = new Player[numberOfPlayers];
        this.isOpenGame = openGame;
        for(int i = 0; i < listPlayers.length; i++){
            listPlayers[i] = new Player();
        }
    }

    private void makeBoardFromFile(String path){

    }
    public void play() {
        for(int player = 0; player < this.listPlayers.length; player++){
            for(int indexPiecePlayer = 0; indexPiecePlayer < 7; indexPiecePlayer++){
                Random rand = new Random();
                int pieceToRemove = rand.nextInt(this.gameBag.size());
                Piece piece = this.gameBag.RemoveFromBag(pieceToRemove);
                putPieceForPlayer(player, piece, indexPiecePlayer);
            }
        }

        int player = 0;
        while(!isGameOver()){
            drawBoard();
            if(isOpenGame){
                System.out.println("OPEN GAME:");
                for(int i = 0; i < this.listPlayers.length; i++){
                    if(i != player){
                        listPlayers[i].printPieces();
                    }
                }
            }

            listPlayers[player].printPieces();

        }

    }
    private void putPieceForPlayer(int player, Piece piece, int index){
        this.listPlayers[player].setPieceAtIndex(piece, index);
    }

    private boolean isMoveCorrect(int row, int col, String characters, boolean directionDown){
        StringBuilder builder = new StringBuilder();
        int i = 0;
        while(i < characters.length() && row < board.length && col < board[row].length){
            if(this.board[row][col].getCharacter() != '.'){
                builder.append(board[row][col].getCharacter());
            } else {
                builder.append(characters.charAt(i));
                i++;
            }
            if(directionDown){
                row++;
            }else{
                col++;
            }
        }
        if(!acceptableCharacters.contains(builder.toString())){
            return false;
        }
        return i == characters.length();
    }

    private void changeBoard(int row, int col, String characters, boolean directionDown){
        for(int i = 0; i < characters.length();){
            if(board[row][col].getCharacter() == '.'){
                board[row][col].setCharacter(characters.charAt(i));
                i++;
            }

            if(directionDown){
                row++;
            }
            else{
                col++;
            }
        }
    }

    private void setScorForPlayer(int player, int rowStart, int colStart, int rowEnd, int colEnd, Piece[] piecesPut){
        int wordMultiplayer = 1;
        int totalValue = 0;
        boolean upDown = true;
        if(rowStart == rowEnd){
            upDown = false;
        }

        for(int i = 0; i < piecesPut.length;){
            if(piecesPut[i].getCharacter() == board[rowStart][colStart].getCharacter()) {
                int currentMultiplayer = 1;
                if (board[rowStart][i].isPremiumWord()) {
                    wordMultiplayer *= board[rowStart][i].getValueMultiplayer();
                } else {
                    currentMultiplayer = board[rowStart][i].getValueMultiplayer();
                }
                currentMultiplayer *= piecesPut[i].getValueMultiplyer();
                totalValue += currentMultiplayer;
                i++;
            }

            if(upDown){
                rowStart++;
            }else{
                colStart++;
            }
        }

        totalValue *= wordMultiplayer;
        if(piecesPut.length == this.numberOfPiecesPerPlayer){
            totalValue += 60;
        }

        Player playerUpdate = this.listPlayers[player];
        playerUpdate.setScore(playerUpdate.getScore() + totalValue);
    }

    // when we put pieces on the board we calculate if there are characters between the two piece placed
    // need a way to select pieces that we have on the table
    // we need to place those peices on the board
    // we need an efficient way to veriffie it they formed a word, and any words that might intersect with the word placed by us
    // we need to be able to take back pieces after we place them and take them back after we place a wrong word
    // game ends where there are no more tiles in the tileBag and a player dosent have any more tiles
    // the game can also end if all players pass their turn.
    public void drawBoard(){
        printTopBottom(board[0].length);
        for(int i = 0; i < board.length; i++){
            System.out.print(i + "     ");
            for(int j = 0; j < board[i].length; j++){
                StringBuilder builder = new StringBuilder();
                builder.append(board[i][j].getCharacter());
                int defaultLengthBetweenCharacters = 6;
                if(board[i][j].getValueMultiplayer() != 1){
                    builder.append(board[i][j].getValueMultiplayer());
                }
                if(board[i][j].isPremiumWord()){
                    builder.append('!');
                }
                for(int m = builder.length(); m < defaultLengthBetweenCharacters; m++){
                    builder.append(' ');
                }
                System.out.print(builder);
            }
            System.out.println(i);
        }
        printTopBottom(board[0].length);
    }

    // to do
    private boolean isGameOver() {
        return false;
    }

    private void printTopBottom(int col){
        StringBuilder  _builder = new StringBuilder();
        _builder.append("      ");
        char character = 'a';
        for(int i = 0; i < col; i++){
            _builder.append((char)(character + i));
            _builder.append("     ");
        }
        System.out.println(_builder);
    }
}
