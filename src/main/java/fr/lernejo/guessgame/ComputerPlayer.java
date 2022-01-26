package fr.lernejo.guessgame;

public class ComputerPlayer implements Player{
    private long max_age;
    private long min_age;
private long prev;
    private boolean isGreater;

    public ComputerPlayer(long max){
        max_age = max;
        min_age = -1;
        isGreater = false;
    }

    @Override
    public long askNextGuess() {
        long proposition = -1;
        if(min_age == -1l){
            proposition = max_age/2;
            min_age = 0;
        }else{
            min_age = isGreater ? prev : min_age;
            max_age = !isGreater ? prev : max_age;
            proposition = (min_age+max_age)/2;
        }
        prev = proposition;
        return proposition;
    }

    @Override
    public void respond(boolean lowerOrGreater) {
        isGreater = lowerOrGreater;
    }
}
