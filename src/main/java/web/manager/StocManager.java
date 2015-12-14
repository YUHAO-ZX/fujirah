package web.manager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import web.dao.DayReportDao;
import web.dao.EmotionDao;
import web.dao.StocDao;
import web.entity.*;

import javax.annotation.Resource;
import java.io.*;
import java.nio.charset.Charset;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by yuhao.zx on 15-9-14.
 */
@Service
public class StocManager {
    private final static Logger logger = LoggerFactory.getLogger(StocManager.class);
    @Resource(name = "stockDAO")
    private StocDao stocDao;
    @Resource(name = "dayReportDAO")
    private DayReportDao dayReportDao;
    @Resource(name = "emotionDAO")
    private EmotionDao emotionDao;

    public Map<String,EmotionInfoTO> getDayEmotion(String date,String symbol) throws ParseException {
        try{
            Map<String,Integer> emotion = getEmotionD();
            Map<String,EmotionInfoTO> result = new HashMap<String, EmotionInfoTO>();
            List<EmotionTO> rs;

            logger.error("date:"+date);
            if(null == date || date.trim().equals("")){
                rs = emotionDao.selectEmotionsBystock(symbol);
            }else{
                rs = emotionDao.selectEmotionsByday(date, symbol);
            }
            logger.error("selectEmotionsBystock size:"+rs.size());
            logger.error("emotion size:"+emotion.size());
            for(EmotionTO ele : rs){
                String effectTime = getKeyOfDay(ele.getPublishTime());
                if(null == effectTime){
                    logger.error("getkey error id="+ele.getId());
                    continue;
                }
                String key = ele.getStockId()+"&"+effectTime;
                EmotionInfoTO ett ;
                if(result.get(key) == null){
                    ett = new EmotionInfoTO();
                    ett.setDate(ele.getPublishTime());
                    ett.setNegativeScore(0);
                    ett.setPositiveScore(0);
                    ett.setSymbol(ele.getStockId());
                    ett.setEffectiveDay(effectTime);
                    result.put(key,ett);
                }else{
                    ett = result.get(key);
                }
                if(ele.getSegment() == null){
                    logger.error("get segment is null");
                    continue;
                }
                String[] keywords = ele.getSegment().split(" ");
                for(String keyword:keywords){
                    Integer em = emotion.get(keyword);
                    if(em != null){
                        if(em < 0){
                            ett.setNegativeScore(ett.getNegativeScore() + 1);
                        }else {
                            ett.setPositiveScore(ett.getPositiveScore()+1);
                        }
                    }
                }
            }

//            int totalEffeSize = 0;
//            int meetSize = 0;
//            for(String key:result.keySet()){
//                SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//                EmotionInfoTO ele = result.get(key);
//                if(ele.getNegativeScore().equals(ele.getPositiveScore())||(ele.getNegativeScore() == 0 && ele.getPositiveScore() == 0)){
//                    continue;
//                }
//                totalEffeSize ++;
//                ele.getDate();
//                Date d = s.parse(ele.getEffectiveDay()+" 00:00:00");
//                StockDayInfo stock = dayReportDao.selectDayreportBySymbolAndDay(ele.getSymbol(),d);
//                if(null == stock){
//                    totalEffeSize --;
//                    continue;
//                }
//                if((stock.getClose()-stock.getOpen())*(ele.getPositiveScore()-ele.getNegativeScore()) > 0){
//                    meetSize ++;
//                }
//            }
//            logger.error("[effective====] " + (double) meetSize / (double) totalEffeSize+"====="+meetSize+"====="+totalEffeSize);
//        logger.error("涨:"+niu+" 跌:"+xiong+" 平0:"+pin+" 平:"+pinR);
            return result;
        }catch (Exception e){
            logger.error("getDayEmotion line Number"+e.getStackTrace()[0].getLineNumber()+"");
        }
        return null;
    }

    public Map<String,String> getEffective(String date,String symbol){
        Map<String,String> info = new HashMap<String, String>();
        try {
            Map<String,EmotionInfoTO> result = getDayEmotion(date,symbol);
            int totalEffeSize = 0;
            int meetSize = 0;
            for(String key:result.keySet()){
                SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                EmotionInfoTO ele = result.get(key);
                if(ele.getNegativeScore().equals(ele.getPositiveScore())||(ele.getNegativeScore() == 0 && ele.getPositiveScore() == 0)){
                    continue;
                }
                totalEffeSize ++;
                ele.getDate();
                Date d = s.parse(ele.getEffectiveDay()+" 00:00:00");
                StockDayInfo stock = dayReportDao.selectDayreportBySymbolAndDay(ele.getSymbol(),d);
                if(null == stock){
                    totalEffeSize --;
                    continue;
                }
                if((stock.getClose()-stock.getOpen())*(ele.getPositiveScore()-ele.getNegativeScore()) > 0){
                    meetSize ++;
                }
            }
            if(totalEffeSize != 0){
                logger.error("[effective====] " + (double) meetSize / (double) totalEffeSize+"====="+meetSize+"====="+totalEffeSize);
                info.put("totalEff",totalEffeSize+"");
                info.put("meetSize",meetSize+"");
                info.put("effective",((double) meetSize / (double) totalEffeSize)+"");
            }
        } catch (ParseException e) {
            logger.error(e.getStackTrace().toString());
            logger.error("line Number "+e.getStackTrace()[0].getLineNumber()+"");
        }catch (Exception e){
            logger.error("line Number "+e.getStackTrace()[0].getLineNumber()+"");
        }
        return info;
    }
    public Map<String,String> getEffectiveAll(){
        List<String> stocks = emotionDao.selectEmositonReadable();
        Map<String,String> result = new HashMap<String, String>();
        Double times = 0d;
        Double totalEff = 0d;
        for(String ele : stocks){
            Map<String,String> rs = getEffective("",ele);
            if(null != rs && rs.get("effective") != null){
                times += 1d;
                String eff = rs.get("effective");
                totalEff += Double.valueOf(eff);
            }
        }
        result.put("res",String.valueOf(totalEff/times));
        return result;
    }
    private static String getKeyOfDay(String date){
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        SimpleDateFormat s1 = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date1 = s.parse(date);
            Calendar c = Calendar.getInstance();
            c.setTime(date1);
            int hour = c.get(Calendar.HOUR_OF_DAY);
            int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
            if(hour >= 17){
                if(dayOfWeek == 6){
                    c.add(Calendar.DAY_OF_MONTH,3);
                }else{
                    c.add(Calendar.DAY_OF_MONTH,1);
                }
            }
            return s1.format(c.getTime());
        } catch (ParseException e) {
            logger.error("getKeyOfDay:"+e);
            return null;
        }
    }

    private Map<String,Integer> getEmotionD(){
        Map<String,Integer> rs = new HashMap<String, Integer>();
        try{
            InputStream is = this.getClass().getResourceAsStream("/EmotionD/ntusd-negative.txt");
            InputStreamReader read = new InputStreamReader(
                    is, Charset.forName("UTF-8"));
            BufferedReader bufferedReader = new BufferedReader(read);
            String lineTxt;
            while((lineTxt = bufferedReader.readLine()) != null){
                rs.put(lineTxt,-1);
            }
            read.close();

            is = this.getClass().getResourceAsStream("/EmotionD/ntusd-positive.txt");
            read = new InputStreamReader(
                    is, Charset.forName("UTF-8"));
            bufferedReader = new BufferedReader(read);
            while((lineTxt = bufferedReader.readLine()) != null){
                rs.put(lineTxt.trim(),1);
            }
            read.close();
        }catch (Exception e){
            logger.error(e.getMessage() + " " + e.getCause());
        }
        return rs;
    }
    public List<StockCodes> getCodesInst(String fcode){
        if(null == fcode){
            return null;
        }
        return stocDao.selectByIndustryCode(fcode);
    }

    public List<StockDayInfoTO> getStockByFcodes(String fcode,int fordDays,int behindDays,Date newsDay){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(newsDay);
        calendar.add(Calendar.DAY_OF_MONTH,fordDays);
        Date endTime = calendar.getTime();
        calendar.add(Calendar.DAY_OF_MONTH,-(fordDays+behindDays));
        Date startTime = calendar.getTime();
        logger.error("error info");
        List<StockCodes> instoccode = getCodesInst(fcode);
        List<StockDayInfoTO> rs2 = new ArrayList<StockDayInfoTO>();
        for(StockCodes ele : instoccode){
            List<StockDayInfo>  rs = dayReportDao.selectDayreportWithTime(ele.getSymbol(),startTime,endTime);
            for(StockDayInfo foo : rs){
                StockDayInfoTO sdit = new StockDayInfoTO();
                sdit.setTime(foo.getTime());
                sdit.setSymbol(foo.getSymbol());
                sdit.setClose(foo.getClose());
                Date time = foo.getTime();
                SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                sdit.setDate(s.format(time));
                sdit.setHigh(foo.getHigh());
                sdit.setLow(foo.getLow());
                sdit.setOpen(foo.getOpen());
                sdit.setVolume(foo.getVolume());
                rs2.add(sdit);
            }
        }
        return rs2;
    }

}
