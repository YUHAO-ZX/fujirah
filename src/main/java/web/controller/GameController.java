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

/**
 * Created by yuhao.zx on 14-9-20.
 */
@Controller
@RequestMapping("/game")
public class GameController {
    private final static Logger logger = LoggerFactory.getLogger(GameController.class);

    @RequestMapping(value="/login" ,produces="application/json")
    @ResponseBody
    public void getList(HttpServletResponse response,HttpServletRequest request){
        try{
            Cookie[] cookies = request.getCookies();
            if(null == cookies || cookies.length <= 0){
                Cookie cookie = new Cookie("loginName","nice boy");
                cookie.setMaxAge(Integer.MAX_VALUE);
                response.addCookie(cookie);
            }else{
                logger.warn("loginName="+cookies[0].getComment());
            }
            new JsonBack(response).
                    put("loginName", "nice boy").send();
        }catch (Exception e){
            logger.error("[RuleController-getList] ERROR "+e);
        }

    }
}
