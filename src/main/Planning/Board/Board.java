package Planning.Board;

import FileCollector.BagFileCollector;
import FileCollector.BoardFileCollector;
import FileCollector.LanguageFileCollector;

import java.util.HashSet;

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
    /*
    *
    */
    private Player[] listPlayers;
    private Bag gameBag;
    private HashSet<String> acceptableCharacters;
    private boolean[] turnPassed;
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
        this.numberOfPiecesPerPlayer = 7;
        this.turnPassed = new boolean[numberOfPlayers];
        for(int i = 0; i < listPlayers.length; i++){
            listPlayers[i] = new Player();
        }
    }

    public void play() {
        for(int player = 0; player < this.listPlayers.length; player++){
            for(int indexPiecePlayer = 0; indexPiecePlayer < this.numberOfPiecesPerPlayer; indexPiecePlayer++){
                this.listPlayers[player].addPiece(this.gameBag.RemoveFromBagRandom());
            }
        }

        int player = 0;
        boolean gameOver = false;
        boolean firstTurn = true;

        while(!gameOver){
            this.turnPassed[player] = false;
            drawBoard();
            boolean nextPlayer = true;
            if(isOpenGame){
                System.out.println("OPEN GAME:");
                for(int i = 0; i < this.listPlayers.length; i++){
                    if(i != player){
                        System.out.print("PLAYER " + i + " PIECES:");
                        listPlayers[i].printPieces();
                    }
                }
            }

            PlayerMove move = listPlayers[player].makeMove();

            if(firstTurn){
                if(isFirstMoveOk(move.row, move.col, move.piecesSelected.length, move.directionDown)) {
                    firstTurn = false;
                }else{
                    continue;
                }
            }

            if(move.passTurn){
                turnPassed[player] = true;
            } else if(isMoveCorrect(move.row, move.col, move.piecesSelected, move.directionDown)){
                changeBoard(move.row, move.col, move.piecesSelected, move.directionDown);
                setScorForPlayer(player, move.row, move.col, move.directionDown, move.piecesSelected);
                for(int i = 0; i < move.indexPiecesMoved.length; i++){
                    listPlayers[player].changePiece(move.indexPiecesMoved[i], this.gameBag.RemoveFromBagRandom());
                }
            }else{
                System.out.println("IncorrectMove Try again");
                nextPlayer = false;
            }

            gameOver = isGameOver(player);

            if(nextPlayer) {
                player++;
                if (player == this.listPlayers.length) {
                    player = 0;
                }
            }
        }

    }

    private boolean isFirstMoveOk(int row, int col, int size, boolean directionDown){
        int i = 0;
        boolean findStartTile = false;
        while(i < size && row < board.length && col < board[row].length){
            if(this.board[row][col].isStartTile()){
                findStartTile = true;
            }
            if(directionDown){
                row++;
            }else{
                col++;
            }
            i++;
        }
        return findStartTile && i == size;
    }

    private boolean isMoveCorrect(int row, int col, Piece[] characters, boolean directionDown){
        StringBuilder builder = new StringBuilder();
        int i = 0;
        while(i < characters.length && row < board.length && col < board[row].length){
            if(this.board[row][col].getCharacter() != '.'){
                builder.append(board[row][col].getCharacter());
            } else {
                builder.append(characters[i].getCharacter());
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
        return i == characters.length;
    }

    private void changeBoard(int row, int col, Piece[] characters, boolean directionDown){
        for(int i = 0; i < characters.length;){
            if(board[row][col].getCharacter() == '.'){
                board[row][col].setCharacter(characters[i].getCharacter());
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

    private void setScorForPlayer(int player, int rowStart, int colStart, boolean upDown, Piece[] piecesPut){
        int wordMultiplayer = 1;
        int totalValue = 0;

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
    public void drawBoard(){
        printTopBottom(board[0].length);
        for(int i = 0; i < board.length; i++){
            StringBuilder builder = new StringBuilder();
            builder.append(i);
            for(int j = builder.length(); j < 6; j++){
                builder.append(' ');
            }

            for(int j = 0; j < board[i].length; j++){
                builder.append(board[i][j].getCharacter());
                int defaultLengthBetweenCharacters = 6;
                if(board[i][j].getValueMultiplayer() != 1){
                    builder.append(board[i][j].getValueMultiplayer());
                }
                if(board[i][j].isPremiumWord()){
                    builder.append('!');
                }
                for(int m = builder.length(); m < 12 + (defaultLengthBetweenCharacters * j); m++){
                    builder.append(' ');
                }
            }
            builder.append(i);
            System.out.println(builder);
        }
        printTopBottom(board[0].length);
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

    private boolean isGameOver(int player) {
        int playerPassedTurns = 0;
        for(int i = 0; i < this.listPlayers.length; i++){
            if(this.turnPassed[i]){
                playerPassedTurns++;
            }
        }
        if(playerPassedTurns == this.listPlayers.length){
            return true;
        }

        if(this.listPlayers[player].getPieces().isEmpty() && gameBag.bag.isEmpty()){
            return true;
        }

        return false;
    }
}
