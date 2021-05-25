package com.liugs.stu.spring.guide.websocket;

/**
 * @author liugs
 * @createTime 2021/5/25 21:59
 */
public class Greeting {
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Greeting(String content) {
        this.content = content;
    }

    public Greeting() {
    }
}
