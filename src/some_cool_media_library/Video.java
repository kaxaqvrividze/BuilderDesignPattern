package some_cool_media_library;
// მოცემული კლასი შევცვალე Builder patter-ნით
public class Video {
    public  String id;
    public  String data;
    public  String title;

    private Video(VideoBuilder builder) {
        this.id = builder.id;
        this.data = builder.data;
        this.title = builder.title;
    }

    public static class VideoBuilder {
        private final String id;
        private String data;
        private final String title;

        public VideoBuilder(String id, String title){
            this.id = id;
            this.title = title;
            this.data = "Random video";
        }

        public VideoBuilder data(String data){
            this.data = data;
            return this;
        }

        public Video build(){
            return new Video(this);
        }
    }
}
