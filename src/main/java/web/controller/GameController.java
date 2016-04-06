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
import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by yuhao.zx on 14-9-20.
 */
@Controller
@RequestMapping("/game")
public class GameController {
    private final static Logger logger = LoggerFactory.getLogger(GameController.class);

    public static Map<Integer,Boolean> coolName;
    public static String[] names = new String[]{"牛逼的算法工程师","酷炫的前端攻城狮"};
    static{
        coolName = new ConcurrentHashMap<Integer, Boolean>();
        coolName.put(0,true);
        coolName.put(1,true);
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        System.out.println(new String("酷炫的前端攻城狮".getBytes(),"utf-8"));
    }
    @RequestMapping(value="/login" ,produces="application/json")
    @ResponseBody
    public void getList(HttpServletResponse response,HttpServletRequest request){
        try{
            Cookie[] cookies = request.getCookies();
            String randomName = null;
            Integer row = -1;
            if(null == cookies || cookies.length <= 0){
                for(int i=0;i<names.length;i++){
                    if(coolName.get(i)){
                        coolName.put(i,false);
                        randomName = names[i];
                        row = i;
                        break;
                    }
                }
                Cookie cookie = new Cookie("loginName",row+"");
                cookie.setMaxAge(Integer.MAX_VALUE);
                response.addCookie(cookie);
            }else{
                logger.warn("loginName="+Integer.valueOf(cookies[0].getValue()));
                randomName = names[Integer.valueOf(cookies[0].getValue())];

                logger.warn(new String(randomName.getBytes(),"utf-8"));
            }

            new JsonBack(response).
                    put("loginName", new String(randomName.getBytes(),"utf-8")).send();
        }catch (Exception e){
            logger.error("[RuleController-getList] ERROR "+e);
        }
    }
}
