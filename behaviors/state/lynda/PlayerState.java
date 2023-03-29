package designPatterns.behaviors.state.lynda;

public interface PlayerState {
    void play(MediaPlayer player);

    void stop(MediaPlayer player);

    void pause(MediaPlayer player);

    void fastForward(MediaPlayer player);

    void fastRewind(MediaPlayer player);

    void nextChapter(MediaPlayer player);

    void previousChapter(MediaPlayer player);
}
