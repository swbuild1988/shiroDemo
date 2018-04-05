package pers.swbuild.controller;


import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pers.swbuild.pojo.User;

@Controller
@ResponseBody
@RequestMapping("/login")
public class LoginController {

    private static Logger log = Logger.getLogger(LoginController.class);

    /**
     * @param user
     * @return
     */
    @RequestMapping(value = "/auth", method = RequestMethod.POST, produces = "text/plain; charset=UTF-8")
    public String login(User user){
        Subject subject= SecurityUtils.getSubject();
        UsernamePasswordToken token=new UsernamePasswordToken(user.getUserName(), user.getPassword());
        try{
            subject.login(token);
            Session session=subject.getSession();
            log.info("sessionId:"+session.getId());
            log.info("sessionHost:"+session.getHost());
            log.info("sessionTimeout:"+session.getTimeout());
            session.setAttribute("info", "session 测试");
            return "success";
        }catch(Exception e){
            return "fail";
        }
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String Logout(){
        try {
            Subject currentUser = SecurityUtils.getSubject();
            currentUser.logout();
            System.out.println("logout");
            return "logout";
        } catch (Exception e){
            return "fail";
        }
    }


}