package cz.prague.js.home.timone.controller;


import cz.prague.js.home.timone.context.Context;
import cz.prague.js.home.timone.print.PrintTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Scanner;
import java.util.Timer;

/**
 * Controller hold input from command line and set the timer for
 * sheduler
 */
@Component
public class CommandLineController {
    public static final Scanner scanner = new Scanner(System.in);
    public static final String CMDLINE_EXIT = "exit";
    public static final  Integer MINUT = 60*1000;

    private Context context;
    private PrintTask printTask;

    @Autowired
    public CommandLineController(Context context, PrintTask printTask) {
        this.context = context;
        this.printTask = printTask;
    }

    @PostConstruct
    public void postConstruct() {
        this.startCommandLine();
    }

    public void startCommandLine() {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(printTask, 0, MINUT);

        System.out.println("Add parameters:");
        while (true) {
            String line = scanner.nextLine();
            if (line.equalsIgnoreCase(CMDLINE_EXIT))
                break;
            context.addRecord(line);
        }
        timer.cancel();
    }
}
