package activitytest.example.com.myapplication.entity;

/**
 * Created by lawrence on 2017/2/22.
 */

public class offer {
    private String title;
    private String pay;
    private String time;
    private int ImageId;
    public offer(String title,String pay,String time,int imageId){
        this.title=title;
        this.pay=pay;
        this.time=time;
        this.ImageId =imageId;
    }
    public String getTitle(){
        return title;
    }
    public String getPay(){
        return pay;
    }
    public String getTime(){
        return time;
    }
    public int getImageId() {
        return ImageId;
    }
}
