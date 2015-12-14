package web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import web.entity.StockDayInfoTO;
import web.manager.StocManager;
import web.tools.JsonBack;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by yuhao.zx on 14-9-20.
 */
@Controller
@RequestMapping("/stock")
public class RuleController {
    private final static Logger logger = LoggerFactory.getLogger(RuleController.class);
    public static int beforeDay = 5;
    public static int afterDay = 5;
    @Resource
    private StocManager stocManager;
    @RequestMapping(value="/dayreport" ,produces="application/json")
    @ResponseBody
    public void getList(HttpServletResponse response,@RequestParam String fcode,@RequestParam String date){
        try{
            new JsonBack(response).
                    put("result", stocManager.getCodesInst(fcode)).send();
        }catch (Exception e){
            logger.error("[RuleController-getList] ERROR "+e);
        }

    }

    @RequestMapping(value="/stocks" ,produces="application/json")
    @ResponseBody
    public void getStocks(HttpServletResponse response,@RequestParam String fcode,@RequestParam String date){
        try{
            SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date newsDay = s.parse(date);
            List<StockDayInfoTO> rs = stocManager.getStockByFcodes(fcode, beforeDay, afterDay, newsDay);
            Map<String,List<String>> total = new HashMap<String, List<String>>();
            for(StockDayInfoTO ele : rs){
                int daysBetween = daysBetween(ele.getTime(),newsDay);
                String key;
                if(ele.getOpen() > ele.getClose()){
                    key = "CRY";
                }else if(ele.getOpen() == ele.getClose()){
                    key = "COOL";
                }else{
                    key = "SMILE";
                }

                List<String> tem = total.get(key);
                if(null == tem){
                    tem = new ArrayList<String>();
                    tem.add(daysBetween+"&"+1+"&"+ele.getDate());
                }else{
                    boolean flag = false;
                    for(String foo:tem){
                        if(foo.startsWith(daysBetween+"&")){
                            int times = Integer.valueOf(foo.split("&")[1]);
                            tem.remove(foo);
                            times++;
                            tem.add(daysBetween+"&"+times+"&"+ele.getDate());
                            flag = true;
                            break;
                        }
                    }
                    if(!flag){
                        tem.add(daysBetween+"&"+1+"&"+ele.getDate());
                    }
                }
                total.put(key, tem);
            }

            new JsonBack(response).
                    put("result", total).send();
        }catch (Exception e){
            logger.error("[RuleController-getStocks] ERROR "+e);
        }

    }

    @RequestMapping(value="/sEmotion" ,produces="application/json")
    @ResponseBody
    public void getsEmotion(HttpServletResponse response,@RequestParam String stock,@RequestParam String date){
        try{
            new JsonBack(response).
                    put("result", stocManager.getDayEmotion(date,stock)).send();
        }catch (Exception e){
            logger.error("[RuleController-getList] ERROR "+e);
        }
    }

    @RequestMapping(value="/sEmotionRs" ,produces="application/json")
    @ResponseBody
    public void getsEmotionEff(HttpServletResponse response,@RequestParam String stock,@RequestParam String date){
        try{
            throw  new RuntimeException("nothing");
//            new JsonBack(response).
//                    put("result", stocManager.getEffective(date,stock)).send();
        }catch (Exception e){
            logger.error("[RuleController-getList] ERROR "+e);
        }
    }
    public int daysBetween(Date d1 ,Date d2){
        return (int)((double)(d1.getTime()-d2.getTime())/1000/3600/24);
    }

    @RequestMapping(value="/sEmotionRsAll" ,produces="application/json")
    @ResponseBody
    public void getsEmotionEffAll(HttpServletResponse response){
        try{
            new JsonBack(response).
                    put("result", stocManager.getEffectiveAll()).send();
        }catch (Exception e){
            logger.error("[RuleController-getList] ERROR "+e);
        }
    }
//    @Autowired
//    private RuleManager ruleManager;
//
//    @RequestMapping(value="/list" ,produces="application/json")
//    @ResponseBody
//    public void getList(@ModelAttribute Rule rule,HttpServletResponse response){
//        try {
//            List<Rule> list = ruleManager.getRuleList(rule);
//            Integer count = ruleManager.getCount(rule);
//
//            new JsonBack(response).
//                    put("result", list).
//                    put("count",count).
//                    send();
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//
//    }
//
//    @RequestMapping(value="/add" ,produces="application/json")
//     @ResponseBody
//     public void addRule(@ModelAttribute Rule rule,HttpServletResponse response){
//        try {
//            rule.setDeleted(0);
//            ruleManager.insert(rule);
//            new JsonBack(response).setIsSuccess(true).
//                    send();
//        } catch (ManagerException e) {
//            e.printStackTrace();
//        }catch (Exception ex){
//            ex.printStackTrace();
//        }
//    }
//
//    @RequestMapping(value="/delete" ,produces="application/json")
//    @ResponseBody
//    public void addRule(@RequestParam Long ruleId,HttpServletResponse response){
//        try {
//            ruleManager.delete(ruleId);
//            new JsonBack(response).setIsSuccess(true).
//                    send();
//        } catch (ManagerException e) {
//            e.printStackTrace();
//        }catch (Exception ex){
//            ex.printStackTrace();
//        }
//    }
//
//    @RequestMapping(value="/listAll" ,produces="application/json")
//    @ResponseBody
//    public void getListAll(HttpServletResponse response){
//        try {
//            Rule rule = new Rule();
//            rule.setPagging(false);
//            List<Rule> list = ruleManager.getRuleList(rule);
//            new JsonBack(response).
//                    put("result", list).
//                    send();
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//
//    }
 
}
