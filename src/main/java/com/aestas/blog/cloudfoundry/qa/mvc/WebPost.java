package com.aestas.blog.cloudfoundry.qa.mvc;


import java.io.Serializable;

public class WebPost implements Serializable{

    private String content;
    private String name;
    private String time;

    public WebPost() {
    }


    /**
     * Returns the name.
     *
     * @return Returns the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name The name to set.
     */
    public void setName(String name) {
        this.name = name;
    }


    /**
     * Returns the content.
     *
     * @return Returns the content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content The content to set.
     */
    public void setContent(String content) {
        this.content = content;
    }


    /**
     * Returns the time.
     *
     * @return Returns the time
     */
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }


}