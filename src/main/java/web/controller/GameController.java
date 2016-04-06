package web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import web.tools.JsonBack;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by yuhao.zx on 14-9-20.
 */
@Controller
@RequestMapping("/game")
public class GameController {
    private final static Logger logger = LoggerFactory.getLogger(GameController.class);

    public static Map<String,Boolean> coolName;
    public static String[] names = new String[]{"牛逼的算法工程师","酷炫的前端攻城狮"};
    static{
        coolName = new ConcurrentHashMap<String, Boolean>();
        coolName.put("牛逼的算法工程师",true);
        coolName.put("酷炫的前端攻城狮",true);
    }
    @RequestMapping(value="/login" ,produces="application/json")
    @ResponseBody
    public void getList(HttpServletResponse response,HttpServletRequest request){
        try{
            Cookie[] cookies = request.getCookies();
            String randomName = null;
            if(null == cookies || cookies.length <= 0){
                for(String name : names){
                    if(coolName.get(name)){
                        coolName.put("name",false);
                        randomName = name;
                        break;
                    }
                }
                if(null == randomName){
                    randomName = "悲剧的没名字的";
                }
                Cookie cookie = new Cookie("loginName",randomName);
                cookie.setMaxAge(Integer.MAX_VALUE);
                response.addCookie(cookie);
            }else{
                logger.warn("loginName="+cookies[0].getValue());
                randomName = cookies[0].getValue();
            }

            new JsonBack(response).
                    put("loginName", randomName).send();
        }catch (Exception e){
            logger.error("[RuleController-getList] ERROR "+e);
        }
    }
}
