package ssm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ssm.dao.NewsDao;
import ssm.entity.News;
import ssm.entity.Page;

import java.util.List;

/**
 * Created by Administrator on 2016/11/4.
 */
@Component
public class NewsService {
    @Autowired
    private NewsDao newsDao;
    public Page getLimit(Page page){
        page.setCurrentPage(page.getCurrentPage());
        List<News> limit = newsDao.getLimit(page);
        page.setList(limit);
        page.init();
        return page;
    }
}
