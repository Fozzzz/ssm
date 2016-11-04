package ssm.web;

import org.apache.ibatis.annotations.Insert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ssm.dao.NewsDao;
import ssm.entity.News;
import ssm.entity.Page;
import ssm.service.NewsService;

/**
 * Created by Administrator on 2016/11/4.
 */
@Controller
public class NewsWeb {
    @Autowired
    private NewsService newsService;
    @Autowired
    private NewsDao newsDao;

    @RequestMapping("/getLimit")
    public String getLimit(Page page, Model model) {
        model.addAttribute("page", newsService.getLimit(page));
        return "index";
    }

    @RequestMapping("/deleteById")
    public String deleteById(Integer n_id, Page page, Model model) {

        newsDao.delete(n_id);
        return getLimit(page, model);
    }

    @RequestMapping("/add")
    public String add(News news, Page page, Model model) {
        newsDao.add(news);
        return getLimit(page, model);
    }

    @RequestMapping("/update")
    public String update(News news, Page page, Model model) {
        newsDao.update(news);
        return getLimit(page, model);
    }

    @RequestMapping("/vague")
    public String vague(String vague,Page page,Model model){
        model.addAttribute("page",newsDao.getvague(page,vague));
        return "index";
    }
}
