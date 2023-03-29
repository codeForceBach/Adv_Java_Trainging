package designPatterns.behaviors.state.lynda;

public class FastRewindState implements PlayerState{

    @Override
    public void play(MediaPlayer player) {
        player.setState(new StopState());
        player.setIcon("STOP");
        System.out.println("player Stopped.");
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

    }

    @Override
    public void nextChapter(MediaPlayer player) {
        player.setState(new NextChapterState());
        player.setIcon("NEXT");
        player.setChapter(player.getChapter() + 1);
        System.out.println("player skip to next chapter. CH: " + player.getChapter() + 1);
    }

    @Override
    public void previousChapter(MediaPlayer player) {
        player.setState(new PreviousChapterState());
        player.setIcon("PREVIOUS");
        player.setChapter(player.getChapter() - 1);
        System.out.println("player skip to previous chapter. CH: " + (player.getChapter() - 1));
    }
}
