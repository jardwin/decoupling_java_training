package fr.lernejo.logger;

public class LoggerFactory {
    public static Logger getLogger(String name){
        return new ContextualLogger(new FilteredLogger(new ConsoleLogger(), message->message.contains("Simulation")),name);
    }
}
