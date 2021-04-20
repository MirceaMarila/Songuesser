package game;

public class LeaderboardInformation {

    int Score;
    String Username;

    public LeaderboardInformation() {
    }

    public LeaderboardInformation(int score, String username) {
        Score = score;
        Username = username;
    }

    public int getScore() {
        return Score;
    }

    public void setScore(int score) {
        Score = score;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }
}
