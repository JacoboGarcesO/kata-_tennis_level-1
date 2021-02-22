
public class TennisGame1 implements TennisGame {

    private int scorePlayer1 = 0;
    private int scorePlayer2 = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1")
            scorePlayer1 += 1;
        else
            scorePlayer2 += 1;
    }

    public String getScore() {
        String score = "";
        int temporalScore=0;
        if (scorePlayer1 == scorePlayer2)
        {
            switch (scorePlayer1)
            {
                case 0:
                    score = "Love-All";
                    break;
                case 1:
                    score = "Fifteen-All";
                    break;
                case 2:
                    score = "Thirty-All";
                    break;
                default:
                    score = "Deuce";
                    break;

            }
        }
        else if (scorePlayer1 >=4 || scorePlayer2 >=4)
        {
            int diferenceScore = scorePlayer1 - scorePlayer2;
            if (diferenceScore==1) score ="Advantage player1";
            else if (diferenceScore ==-1) score ="Advantage player2";
            else if (diferenceScore>=2) score = "Win for player1";
            else score ="Win for player2";
        }
        else
        {
            for (int i=1; i<3; i++)
            {
                if (i==1) temporalScore = scorePlayer1;
                else { score+="-"; temporalScore = scorePlayer2;}
                switch(temporalScore)
                {
                    case 0:
                        score+="Love";
                        break;
                    case 1:
                        score+="Fifteen";
                        break;
                    case 2:
                        score+="Thirty";
                        break;
                    case 3:
                        score+="Forty";
                        break;
                }
            }
        }
        return score;
    }
}
