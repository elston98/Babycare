package com.wilson.elston.babycare;

public class note_content {
    private String title;
    private String content;

    public note_content(String title,String content)
    {
        this.title=title;
        this.content=content;

    }
    public note_content()
    {

    }
    public String getTitle()
    {
        return title;
    }
    public void setTitle(String title)
    {
        this.title=title;
    }
    public String getContent()
    {
        return content;
    }
    public void setContent(String content)
    {
        this.content=content;
    }
}
