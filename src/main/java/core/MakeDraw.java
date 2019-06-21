package core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class MakeDraw {
    private static Logger logger = LoggerFactory.getLogger(MakeDraw.class);

    public static void main(String[] args){

        IDraw idraw = new DrawImpl();
        DrawCommandPromptImpl drawCommandPrompt = new DrawCommandPromptImpl(idraw);
        logger.info("Start draw program");
        System.out.println("Please start your draw!");
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        while(!quit){

            System.out.println(drawCommandPrompt.getMainMessage());

            String command = scanner.nextLine();
            String[] commandArgs = command.split(" ");

            if(commandArgs[0].equalsIgnoreCase("Q"))
                quit = true;
            else{
                if (drawCommandPrompt.command(commandArgs))
                    idraw.display();
                else{
                    logger.info("Command not valid");
                    System.out.println("Command not valid");
                }

            }
        }
    }
}
