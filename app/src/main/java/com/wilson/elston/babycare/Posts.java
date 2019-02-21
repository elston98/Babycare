package com.wilson.elston.babycare;

public class Posts {
    private String postText;
    private String postUser;

    public Posts(String postText,String postUser)
    {
        this.postText=postText;
        this.postUser=postUser;

    }
    public Posts()
    {

    }

    public String getPostText() {
        return postText;
    }

    public String getPostUser() {
        return postUser;
    }

    public void setPostText(String postText) {
        this.postText = postText;
    }

    public void setPostUser(String postUser) {
        this.postUser = postUser;
    }
}
