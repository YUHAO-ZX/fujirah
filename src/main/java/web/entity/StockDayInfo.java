package web.entity;

import java.util.Date;

/**
 * Created by yuhao.zx on 15-9-14.
 */
public class StockDayInfo {
    Long id;
    String symbol;
    float high;
    float open;
    float volume;
    float close;
    float low;
    float chg;
    float percent;
    float turnrate;
    float ma5;
    float ma10;
    float ma20;
    float ma30;
    float dif;
    float dea;
    float macd;
    Date time;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public float getHigh() {
        return high;
    }

    public void setHigh(float high) {
        this.high = high;
    }

    public float getOpen() {
        return open;
    }

    public void setOpen(float open) {
        this.open = open;
    }

    public float getVolume() {
        return volume;
    }

    public void setVolume(float volume) {
        this.volume = volume;
    }

    public float getClose() {
        return close;
    }

    public void setClose(float close) {
        this.close = close;
    }

    public float getLow() {
        return low;
    }

    public void setLow(float low) {
        this.low = low;
    }

    public float getChg() {
        return chg;
    }

    public void setChg(float chg) {
        this.chg = chg;
    }

    public float getPercent() {
        return percent;
    }

    public void setPercent(float percent) {
        this.percent = percent;
    }

    public float getTurnrate() {
        return turnrate;
    }

    public void setTurnrate(float turnrate) {
        this.turnrate = turnrate;
    }

    public float getMa5() {
        return ma5;
    }

    public void setMa5(float ma5) {
        this.ma5 = ma5;
    }

    public float getMa10() {
        return ma10;
    }

    public void setMa10(float ma10) {
        this.ma10 = ma10;
    }

    public float getMa20() {
        return ma20;
    }

    public void setMa20(float ma20) {
        this.ma20 = ma20;
    }

    public float getMa30() {
        return ma30;
    }

    public void setMa30(float ma30) {
        this.ma30 = ma30;
    }

    public float getDif() {
        return dif;
    }

    public void setDif(float dif) {
        this.dif = dif;
    }

    public float getDea() {
        return dea;
    }

    public void setDea(float dea) {
        this.dea = dea;
    }

    public float getMacd() {
        return macd;
    }

    public void setMacd(float macd) {
        this.macd = macd;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
