package ssm.entity;

/**
 * Created by Administrator on 2016/11/4.
 */
public class News {
    private Integer n_id;
    private String n_name;
    private String n_content;
    private String n_type;

    public News() {
    }

    public News(Integer n_id, String n_name, String n_content, String n_type) {

        this.n_id = n_id;
        this.n_name = n_name;
        this.n_content = n_content;
        this.n_type = n_type;
    }

    public Integer getN_id() {
        return n_id;
    }

    public void setN_id(Integer n_id) {
        this.n_id = n_id;
    }

    public String getN_name() {
        return n_name;
    }

    public void setN_name(String n_name) {
        this.n_name = n_name;
    }

    public String getN_content() {
        return n_content;
    }

    public void setN_content(String n_content) {
        this.n_content = n_content;
    }

    public String getN_type() {
        return n_type;
    }

    public void setN_type(String n_type) {
        this.n_type = n_type;
    }
}
