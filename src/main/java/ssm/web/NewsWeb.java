package ssm.web;

import org.apache.ibatis.annotations.Insert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ssm.entity.Page;
import ssm.service.NewsService;

/**
 * Created by Administrator on 2016/11/4.
 */
@Controller
public class NewsWeb {
    @Autowired
    private NewsService newsService;
    @RequestMapping("/getLimit")
    public String getLimit(Page page,Model model){
        model.addAttribute("page",newsService.getLimit(page));
        return "index";
    }
}
