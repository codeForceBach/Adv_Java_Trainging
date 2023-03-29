package designPatterns.behaviors.state.lynda;

public class NextChapterState implements PlayerState{

    @Override
    public void play(MediaPlayer player) {
        player.setState(new PlayState());
        player.setIcon("PLAy");
        System.out.println("player start play.");
    }

    @Override
    public void stop(MediaPlayer player) {
        player.setState(new StopState());
        player.setIcon("STOP");
        System.out.println("player Stopped.");
    }

    @Override
    public void pause(MediaPlayer player) {
        player.setState(new PauseState());
        player.setIcon("PAUSE");
        System.out.println("player paused.");
    }

    @Override
    public void fastForward(MediaPlayer player) {
        player.setState(new FastForwardState());
        player.setIcon("FAST-FORWARD");
        System.out.println("player fast forwarding.");
    }

    @Override
    public void fastRewind(MediaPlayer player) {
        player.setState(new FastRewindState());
        player.setIcon("FAST-REWIND");
        System.out.println("player fast rewinding.");
    }

    @Override
    public void nextChapter(MediaPlayer player) {

    }

    @Override
    public void previousChapter(MediaPlayer player) {
        player.setState(new PreviousChapterState());
        player.setIcon("PREVIOUS");
        player.setChapter(player.getChapter() - 1);
        System.out.println("player skip to previous chapter. CH: " + (player.getChapter() - 1));
    }
}
