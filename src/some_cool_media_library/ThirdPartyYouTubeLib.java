package some_cool_media_library;
import java.util.HashMap;


public interface ThirdPartyYouTubeLib {
    // აბრუნებს სტრინგის და ვიდეო კლასის HashMap-ს
    HashMap<String, Video> popularVideos();
    // აბრუნებს მოცემული კლასის ობიექტს
    Video getVideo(String videoId);

}