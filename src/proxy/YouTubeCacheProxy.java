package proxy;


import some_cool_media_library.ThirdPartyYouTubeClass;
import some_cool_media_library.ThirdPartyYouTubeLib;
import some_cool_media_library.Video;

import java.util.HashMap;

public class YouTubeCacheProxy implements ThirdPartyYouTubeLib {
    private ThirdPartyYouTubeLib youtubeService;
    private HashMap<String, Video> cachePopular = new HashMap<String, Video>();
    private HashMap<String, Video> cacheAll = new HashMap<String, Video>();

    public YouTubeCacheProxy() {
        this.youtubeService = new ThirdPartyYouTubeClass();
    }

    // ამკლასში ვამოწმებთ პოპულარული ვიდეოების ქეშს თუ ქეში ცარიელია მაშინ ვიძახებთ YoutubeService
    @Override
    public HashMap<String, Video> popularVideos() {
        if (cachePopular.isEmpty()) {
            cachePopular = youtubeService.popularVideos();
        } else {
            System.out.println("Retrieved list from cache.");
        }
        return cachePopular;
    }

    // ამკლასში ვამოწმებთ ვიდეოების ქეშს თუ ქეში ცარიელია მაშინ ვიძახებთ YoutubeService
    // და ვახდენთ cacheall ში putს
    @Override
    public Video getVideo(String videoId) {
        Video video = cacheAll.get(videoId);
        if (video == null) {
            video = youtubeService.getVideo(videoId);
            cacheAll.put(videoId, video);
        } else {
            System.out.println("Retrieved video '" + videoId + "' from cache.");
        }
        return video;
    }
// ვშლით ქეშებს
    public void reset() {
        cachePopular.clear();
        cacheAll.clear();
    }
}