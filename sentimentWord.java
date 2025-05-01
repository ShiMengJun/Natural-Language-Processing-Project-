public class SentimentWord {
    private String word;
    private double score;

    public SentimentWord(String word, double score) {
        this.word = word;
        this.score = score;
    }

    public String getWord() {
        return word;
    }

    public double getScore() {
        return score;
    }
}
