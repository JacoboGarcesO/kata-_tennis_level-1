public class TennisGame1 implements TennisGame {

    private int pointPlayer1 = 0;
    private int pointPlayer2 = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(this.player1Name))
            pointPlayer1 += 1;
        else
            pointPlayer2 += 1;
    }

    public String getScore() {
        String score = "";
        int temporalScore=0;
        if (equalScore()) score = caseEqualScore();
        else if (highestScoreToFour()) score = playerAdvantage();
        else {
            for (int i=1; i<3; i++) {
                if (i==1) temporalScore = pointPlayer1;
                else { score+="-"; temporalScore = pointPlayer2;}
                score+=temporalScore(temporalScore);
            }
        }
        return score;
    }

    private boolean equalScore (){
        return pointPlayer1 == pointPlayer2;
    }

    private String caseEqualScore(){
        switch (pointPlayer1)
        {
            case 0: return "Love-All";
            case 1: return "Fifteen-All";
            case 2: return "Thirty-All";
            default: return "Deuce";
        }
    }

    private boolean highestScoreToFour(){
        return pointPlayer1 >=4 || pointPlayer2 >=4;
    }

    private String playerAdvantage (){
        int diference = pointPlayer1 - pointPlayer2;
        if (player1Advantage()) return "Advantage player1";
        else if(player2Advantage()) return "Advantage player2";
        else if (player1Win()) return "Win for player1";
        else return "Win for player2";
    }

    private boolean player1Advantage(){
        return (pointPlayer1 - pointPlayer2) == 1;
    }

    private boolean player2Advantage(){
        return (pointPlayer1 - pointPlayer2) == -1;
    }

    private boolean player1Win(){
        return (pointPlayer1 - pointPlayer2) >= 2;
    }

    private String temporalScore(int temporalScore){
        switch(temporalScore)
        {
            case 0: return "Love";
            case 1: return "Fifteen";
            case 2: return "Thirty";
            default: return "Forty";
        }
    }

}