package core;

import core.model.Rectangle;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;


public class DrawCommandPromptImpl implements IDrawCommandPrompt {
    private static Logger logger = LoggerFactory.getLogger(DrawCommandPromptImpl.class);
    private final IDraw iDraw;

    public DrawCommandPromptImpl(IDraw iDraw) {
        this.iDraw = iDraw;
    }

    @Override
    public String getMainMessage() {
        return "Please input command:";
    }

    @Override
    public boolean command(String[] commandArgs) {
        logger.debug(Arrays.toString(commandArgs));
        boolean result = false;
        try{
            switch (commandArgs[0].toUpperCase()) {
                case "C":
                    logger.info("Create canvus");
                    result = iDraw.getDisplayable(Integer.valueOf(commandArgs[1]), Integer.valueOf(commandArgs[2]));
                    break;
                case "L":
                    logger.info("create line ");
                    result = iDraw.getLine(Integer.valueOf(commandArgs[1]), Integer.valueOf(commandArgs[2]),
                            Integer.valueOf(commandArgs[3]), Integer.valueOf(commandArgs[4]));
                    break;
                case "R":
                    logger.info("create rectangle ");
                    result = iDraw.getRectangle(Integer.valueOf(commandArgs[1]), Integer.valueOf(commandArgs[2]),
                            Integer.valueOf(commandArgs[3]), Integer.valueOf(commandArgs[4]));
                    break;
                case "B":
                    logger.info("fill color");
                    result = iDraw.fill(Integer.valueOf(commandArgs[1]), Integer.valueOf(commandArgs[2]),commandArgs[3].charAt(0));
                    break;

                default:
                    break;
            }
        }catch (NumberFormatException e){
            logger.error("Invalid command argument");
        }catch(ArrayIndexOutOfBoundsException exception){
            logger.error("Invalid command arguments length");
        }
        return result;
    }

}
