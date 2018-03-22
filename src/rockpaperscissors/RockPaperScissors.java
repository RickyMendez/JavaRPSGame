package rockpaperscissors;

import javax.swing.*;
import java.util.Random;

/**
 * ENUM RockPaperScissors - Provides constants with the functionality to generate and store a random computer opponent
 * and determine what object beats the other when a user selects one of them.
 */
public enum RockPaperScissors {
    ROCK("rock.jpeg"),
    PAPER("paper.jpeg"),
    SCISSORS("scissors.jpeg");

    private ImageIcon image;
    private RockPaperScissors rpsComp;

    RockPaperScissors(String fp){
        this.image = new ImageIcon(getClass().getResource(fp));
    }

    /**
     * METHOD getImage - access the image
     * @return ImageIcon
     */
    public ImageIcon getImage() {
        return image;
    }

    /**
     * METHOD getOpponent - access the stored randomly generated computer enum
     * @return RockPaperScissors Object
     */
    public RockPaperScissors getOpponent() {
        return rpsComp;
    }

    /**
     * METHOD evaluate - creates the random computer opponent and determines the winner
     * @return String result
     */
    public String evaluate(){
        Random rand = new Random();
        RockPaperScissors[] rpsArr = RockPaperScissors.values();
        String result;

        this.rpsComp = rpsArr[rand.nextInt(rpsArr.length)];

        if (this.equals(rpsComp)){
            result = "It's a draw";
        } else {
            result = String.format("You %s", (
                    (this.equals(rpsArr[0]) && rpsComp.equals(rpsArr[2])) ||
                    (this.equals(rpsArr[1]) && rpsComp.equals(rpsArr[0])) ||
                    (this.equals(rpsArr[2]) && rpsComp.equals(rpsArr[1]))
                ) ?  "WIN!": "lose");
        }
        return result;
    }
}
