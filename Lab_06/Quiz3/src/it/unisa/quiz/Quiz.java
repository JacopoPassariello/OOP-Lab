package it.unisa.quiz;

public class Quiz implements Measurable {

    private final double score;

    public Quiz(double score) {
        this.score = score;
    }

    public double getMeasure()
    {
        return this.score;
    }

    @Override
    public int compareTo(Measurable n)
    {
        return Double.compare(this.score,n.getMeasure());
    }

    @Override
    public String toString() {
        return "Quiz{" +
                "score=" + score +
                '}';
    }
}
