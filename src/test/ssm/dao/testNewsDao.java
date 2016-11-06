package ssm.dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ssm.entity.News;
import ssm.entity.Page;

import java.util.List;

/**
 * Created by Administrator on 2016/11/4.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/spring.xml")
public class testNewsDao {
    @Autowired
    private NewsDao newsDao;
    @Test
    public void testgetLimit(){
        Page page = new Page();
        page.setCurrentPage(1);
        List<News> limit = newsDao.getLimit(page);
        Assert.assertNotNull(limit);
    }
    @Test
    public void testgetAll(){
        List<News> limit = newsDao.getAll();
        Assert.assertNotNull(limit);
    }
    @Test
    public void testgetById(){
        News byId = newsDao.getById(2);
        Assert.assertNotNull(byId);
    }

    //模糊
    @Test
    public void testvaguesum(){
        int list=newsDao.getvaguesum("%2%");
        Assert.assertEquals(7,list);

    }
    @Test
    public void testvague(){
        Page page=new Page();
        page.setPageNumber(1);
        List<News> list=newsDao.getvague("%2%",1,6);
        Assert.assertNotNull(list);
    }
    @Test
    public void testcontent(){
        Page page=new Page();
        page.setPageNumber(1);
        List<News> list=newsDao.getcontent("%2%",1,6);
        Assert.assertNotNull(list);
    }
    @Test
    public void testtype(){
        Page page=new Page();
        page.setPageNumber(1);
        List<News> list=newsDao.gettype("%2%",1,6);
        Assert.assertNotNull(list);
    }
}
