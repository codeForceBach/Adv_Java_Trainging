package designPatterns.behaviors.state.lynda;

public class MediaPlayer {

    private PlayerState state = new StopState();
    private String icon = "STOP";
    private int chapter = 0;

    public int getChapter() {
        return chapter;
    }

    public void setChapter(int chapter) {
        this.chapter = chapter;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public PlayerState getState() {
        return state;
    }

    public void setState(PlayerState state) {
        this.state = state;
    }

    public void play(){
        state.play(this);
    }

    public void stoop(){
        state.stop(this);
    }

    public void pause(){
        state.pause(this);
    }

    public void fastForward(){
        state.fastForward(this);
    }

    public void fastRewind(){
        state.fastRewind(this);
    }

    public void nextChapter(){
        state.nextChapter(this);
    }

    public void previousChapter(){
        state.previousChapter(this);
    }


}
