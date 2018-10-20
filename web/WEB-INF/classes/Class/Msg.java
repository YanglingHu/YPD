/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

/**
 *
 * @author Administrator
 */
public class Msg {
    private int id;
    private String getter;
    private String poster;
    private String posterid;
    private String content;

    public Msg() {
        this.id = 0;
        this.getter = "";
        this.poster = "";
        this.posterid = "";
        this.content = "";
    }

    
    public Msg(int _id, String _getter, String _poster, String _posterid, String _content) {
        this.id = _id;
        this.getter = _getter;
        this.poster = _poster;
        this.posterid = _posterid;
        this.content = _content;
    }

    
    
    public int getId() {
        return id;
    }

    public void setId(int _id) {
        this.id = _id;
    }

    public String getGetter() {
        return getter;
    }

    public void setGetter(String _getter) {
        this.getter = _getter;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String _poster) {
        this.poster = _poster;
    }

    public String getPosterid() {
        return posterid;
    }

    public void setPosterid(String _posterid) {
        this.posterid = _posterid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String _content) {
        this.content = _content;
    }
    
}    
