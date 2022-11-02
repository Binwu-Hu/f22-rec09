package edu.cmu.cs.cs214.rec09.plugin;

import edu.cmu.cs.cs214.rec09.framework.core.GameFramework;
import edu.cmu.cs.cs214.rec09.framework.core.GamePlugin;

import edu.cmu.cs.cs214.rec09.framework.core.GameFramework;
import edu.cmu.cs.cs214.rec09.framework.core.GamePlugin;
import edu.cmu.cs.cs214.rec09.games.TicTacToe;
import edu.cmu.cs.cs214.rec09.games.TicTacToe.Player;

public class TicTacToePlugin implements GamePlugin<String> {

    private static final int SIZE = 3;
    private static final String GAME_NAME = "TicTacToe";
    private GameFramework framework;
    private TicTacToe game;

    @Override
    public String getGameName() {
        return GAME_NAME;
    }

    @Override
    public int getGridWidth() {
        return SIZE;
    }

    @Override
    public int getGridHeight() {
        return SIZE;
    }

    @Override
    public void onRegister(GameFramework framework) {
        this.framework = framework;
        
    }

    @Override
    public void onNewGame() {
        framework.setFooterText("Play Tic Tac Toe");
        game = new TicTacToe();
    }

    @Override
    public void onNewMove() {
        
    }

    @Override
    public boolean isMoveValid(int x, int y) {
        return game.isValidPlay(x, y);
    }

    @Override
    public boolean isMoveOver() {
        return true;
    }

    @Override
    public void onMovePlayed(int x, int y) {
        framework.setSquare(x, y, game.currentPlayer().toString());
        game.play(x, y);
    }

    @Override
    public boolean isGameOver() {
        return game.isOver();
    }

    @Override
    public String getGameOverMessage() {
        Player winner = game.winner();
        return winner.toString() + " won";
    }

    @Override
    public void onGameClosed() {
        // do nothing
        
    }

    @Override
    public String currentPlayer() {
        return game.currentPlayer().toString();
    }
    
}
