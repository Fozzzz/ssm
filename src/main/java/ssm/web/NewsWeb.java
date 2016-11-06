package ssm.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ssm.dao.NewsDao;
import ssm.entity.News;
import ssm.entity.Page;
import ssm.service.NewsService;

import java.util.List;

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
    //通过name
    @RequestMapping("/vague")
    public String vague(String vague,String type, Page page, Model model){
        page.setCurrentPage(page.getCurrentPage());
        vague="%"+vague+"%";
        if (type.equals("标题")){
            List<News> limit = newsDao.getvague(vague,page.getCurrentNumber(),page.getPageNumber());
            page.setList(limit);
            page.setTotalNumber(newsDao.getvaguesum(vague));
        }else if(type.equals("内容")){
            List<News> limit = newsDao.getcontent(vague,page.getCurrentNumber(),page.getPageNumber());
            page.setList(limit);
            page.setTotalNumber(newsDao.getcontentsum(vague));
        }else if(type.equals("类型")){
            List<News> limit = newsDao.gettype(vague,page.getCurrentNumber(),page.getPageNumber());
            page.setList(limit);
            page.setTotalNumber(newsDao.gettypesum(vague));
        }
        page.init();
        model.addAttribute("page",page);
        return "index";
    }

}
