package activitytest.example.com.myapplication.entity;

import java.lang.ref.SoftReference;

/**
 * Created by lawrence on 2017/3/9.
 */

public class Message  {
    private String title;
    private int color;
    private String condition;
    private int photo;
    private int wantpeople;
    public Message(String title,int color,int wantpeople,int photo){
        this.title=title;
        this.color=color;
        if (wantpeople==0){
            this.condition="等待中";
        }
        else {
            this.condition=wantpeople+"已申请";
        }
        this.photo=photo;
        this.wantpeople=wantpeople;
    }
    public String getTitle(){
        return title;
    }
    public int getColor(){
        return color;
    }
    public int getWantpeople(){
        return wantpeople;
    }
    public int getPhoto(){
        return photo;
    }
    public String getCondition(){
        return condition;
    }
}
