package TicTacToe.Model;


public class Player {
    private String playerId;
    private PlayingPiece playingPiece;

    public Player(String playerId, PlayingPiece playingPiece) {
        this.playingPiece = playingPiece;
        this.playerId = playerId;
    }

    public String getPlayerId() {
        return playerId;
    }

    public PlayingPiece getPlayingPiece() {
        return playingPiece;
    }

    public void setPlayingPiece(PlayingPiece playingPiece) {
        this.playingPiece = playingPiece;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }
}
