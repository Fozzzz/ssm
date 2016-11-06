package ssm.dao;

import org.apache.ibatis.annotations.*;
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

    //通过ID
    @Select("select * from news where n_id=#{n_id}")
    News getById(Integer n_id);

    //模糊查询（通过name）
    @Select("select count(*) from news where n_name like #{vague}")
    int getvaguesum(String vague);
    @Select("select * from news where n_name like #{vague} limit #{currentNumber},#{pageNumber}")
    List<News> getvague(@Param("vague") String vague,@Param("currentNumber")Integer currentNumber,@Param("pageNumber")Integer pageNumber);

    //通过内容
    @Select("select count(*) from news where n_content like #{content}")
    int getcontentsum(String content);
    @Select("select * from news where n_content like #{content} limit #{currentNumber},#{pageNumber}")
    List<News> getcontent(@Param("content") String content,@Param("currentNumber")Integer currentNumber,@Param("pageNumber")Integer pageNumber);

    //通过类型
    @Select("select count(*) from news where n_type like #{type}")
    int gettypesum(String type);
    @Select("select * from news where n_type like #{type} limit #{currentNumber},#{pageNumber}")
    List<News> gettype(@Param("type") String type,@Param("currentNumber")Integer currentNumber,@Param("pageNumber")Integer pageNumber);
}
