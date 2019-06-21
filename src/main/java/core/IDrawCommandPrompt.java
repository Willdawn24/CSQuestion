package core;

public interface IDrawCommandPrompt {
    String getMainMessage();
    boolean command(String[] command);
}
