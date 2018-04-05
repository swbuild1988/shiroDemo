package pers.swbuild.controller;


import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HtmlController {

    private static Logger logger = Logger.getLogger(HtmlController.class);

    @RequestMapping("/{page}")
    public String GetHtml(@PathVariable String page){
        logger.info("get page request : " + page );
        return page;
    }
}
