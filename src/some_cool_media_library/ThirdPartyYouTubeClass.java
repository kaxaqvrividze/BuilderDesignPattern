package some_cool_media_library;
import java.util.HashMap;
// მოცემული კლასი აბრუნებს პოპულარულ ვიდეოებს
public class ThirdPartyYouTubeClass implements ThirdPartyYouTubeLib {

    @Override
    public HashMap<String, Video> popularVideos() {
        connectToServer("http://www.youtube.com");
        return getRandomVideos();
    }

    @Override
    public Video getVideo(String videoId) {
        connectToServer("http://www.youtube.com/" + videoId);
        return getSomeVideo(videoId);
    }

    // -----------------------------------------------------------------------
    // Fake methods to simulate network activity. They as slow as a real life.

    private int random(int min, int max) {
        return min + (int) (Math.random() * ((max - min) + 1));
    }

    private void experienceNetworkLatency() {
        int randomLatency = random(5, 10);
        for (int i = 0; i < randomLatency; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    private void connectToServer(String server) {
        System.out.print("Connecting to " + server + "... ");
        experienceNetworkLatency();
        System.out.print("Connected!" + "\n");
    }

    private HashMap<String, Video> getRandomVideos() {
        System.out.print("Downloading populars... ");

        experienceNetworkLatency();
        HashMap<String, Video> hmap = new HashMap<String, Video>();
// VideoBuilder გამოყენება
        hmap.put("catzzzzzzzzz", new Video.VideoBuilder("sadgahasgdas", "Catzzzz.avi").build());
        hmap.put("mkafksangasj", new Video.VideoBuilder("mkafksangasj", "Dog play with ball.mp4").build());
        hmap.put("dancesvideoo", new Video.VideoBuilder("asdfas3ffasd", "Dancing video.mpq").build());
        hmap.put("dlsdk5jfslaf", new Video.VideoBuilder("dlsdk5jfslaf", "Barcelona vs RealM.mov").build());
        hmap.put("3sdfgsd1j333", new Video.VideoBuilder("3sdfgsd1j333", "Programing lesson#1.avi").build());

        System.out.print("Done!" + "\n");
        return hmap;
    }

    private Video getSomeVideo(String videoId) {
        System.out.print("Downloading video... ");

        experienceNetworkLatency();
        // VideoBuilder გამოყენება
        Video video = new Video.VideoBuilder(videoId, "Some video title").build();

        System.out.print("Done!" + "\n");
        return video;
    }

}