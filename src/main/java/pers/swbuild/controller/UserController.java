package pers.swbuild.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pers.swbuild.pojo.User;


/**
 * @author Administrator
 *
 */
@Controller
@ResponseBody
@RequestMapping("/user")
public class UserController {

    private static Logger log = Logger.getLogger(UserController.class);

    /**
     * @param user
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "text/plain; charset=UTF-8")
    public String AddUser(User user){
        return "add";
    }

    /**
     *
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String QueryAll(){
        return "all";
    }


}
