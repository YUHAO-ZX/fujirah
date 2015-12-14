package web.entity;

/**
 * Created by yuhao.zx on 15-9-15.
 */
public class EmotionInfoTO {
    private String symbol;
    private String date;
    private Integer positiveScore;
    private Integer negativeScore;
    private String effectiveDay ;

    public String getEffectiveDay() {
        return effectiveDay;
    }

    public void setEffectiveDay(String effectiveDay) {
        this.effectiveDay = effectiveDay;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getPositiveScore() {
        return positiveScore;
    }

    public void setPositiveScore(Integer positiveScore) {
        this.positiveScore = positiveScore;
    }

    public Integer getNegativeScore() {
        return negativeScore;
    }

    public void setNegativeScore(Integer negativeScore) {
        this.negativeScore = negativeScore;
    }
}
