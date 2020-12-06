class Solution {
    public String interpret(String command) {
        command = command.replaceAll("\\(al\\)", "al");
        command = command.replaceAll("\\(\\)", "o");
        return command;
    }
}