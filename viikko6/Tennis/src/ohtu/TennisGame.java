package ohtu;

public class TennisGame {
    
    private int player1Score = 0;
    private int player2Score = 0;
    private final String player1Name;
    private final String player2Name;
    private final String[] correspondingCalls;

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
        this.correspondingCalls = new String[5];
        addCalls();
    }
    
    public void addCalls() {
        correspondingCalls[0] = "Love";
        correspondingCalls[1] = "Fifteen";
        correspondingCalls[2] = "Thirty";
        correspondingCalls[3] = "Forty";
        correspondingCalls[4] = "Deuce";
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(this.player1Name)) {
            player1Score++;
        } else {
            player2Score++;
        }
    }
    
    public String playerWithMostPoints() {
        if (player1Score > player2Score) {
            return this.player1Name;
        } else {
            return this.player2Name;
        }
    }
    
    public String scoreFourOrOver() {
        if (player1Score == player2Score) {
            return correspondingCalls[4];
        }
        if (Math.abs(player1Score - player2Score) == 1) {
            return "Advantage " + playerWithMostPoints();
        }
        return "Win for " + playerWithMostPoints();
    }
    
    public String scoreUnderFour() {
        if (player1Score == player2Score) {
            return correspondingCalls[player1Score] + "-All";
        } else {
            return correspondingCalls[player1Score] + "-" + correspondingCalls[player2Score];
        }
    }

    public String getScore() {
        if (player1Score >= 4 || player2Score >= 4) {
            return scoreFourOrOver();
        } else {
            return scoreUnderFour();
        }
    }
}