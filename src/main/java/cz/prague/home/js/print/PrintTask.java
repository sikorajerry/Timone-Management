package cz.prague.home.js.print;

import cz.prague.home.js.context.Context;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.TimerTask;

/**
 * Created by Jiri Sikora
 * PrintTask
 * that is responsible for the screen dump
 */
@Component
public class PrintTask extends TimerTask {

    @Autowired
    private Context context;

    public void printToStandartOutput() {

        context.getRecords().forEach((k,v)->{
            System.out.println("Currency: " + k + " Amount : " + v);
        });
    }

    @Override
    public void run() {
        this.printToStandartOutput();
    }
}
