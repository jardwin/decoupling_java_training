package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.util.Scanner;

public class HumanPlayer implements Player{
    private final Logger _log = LoggerFactory.getLogger("player");
    private final Scanner scan = new Scanner(System.in);

    @Override
    public long askNextGuess() {
        System.out.println("Enter a number to be guess");
        long number = -1;
        while (number==-1){
            try {
                number = Long.parseLong(scan.nextLine());
            }catch (Exception e){
                _log.log("Error occurred. message : "+e.getMessage());
                System.out.println("The format number is not valid");
            }
        }

        _log.log("The user give the number "+number);
        return number;
    }

    @Override
    public void respond(boolean lowerOrGreater) {
        if(lowerOrGreater){
            System.out.println("guess number is greater");
            _log.log("The number given by the user is greater than the guess");
        }else{
            System.out.println("guess number is lower");
            _log.log("The number given by the user is lower than the guess");
        }
    }
}
