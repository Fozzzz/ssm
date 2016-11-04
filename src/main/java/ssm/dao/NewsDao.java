package ssm.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;
import ssm.entity.News;
import ssm.entity.Page;

import java.util.List;

/**
 * Created by Administrator on 2016/11/4.
 */
@Component
public interface NewsDao {
    @Insert("insert into news(n_name,n_content,n_type) values(#{n_name},#{n_content},#{n_type})")
    int add(News news);

    @Delete("delete from news where n_id=#{n_id}")
    int delete(Integer n_id);

    @Update("update news set n_name=#{n_name},n_content=#{n_content},n_type=#{n_type} where n_id=#{n_id}")
    int update(News news);

    @Select("select * from news")
    List<News> getAll();

    @Select("select * from news limit #{currentNumber},#{pageNumber}")
    List<News> getLimit(Page page);

    @Select("select * from news where n_id=#{n_id}")
    News getById(Integer n_id);
}
