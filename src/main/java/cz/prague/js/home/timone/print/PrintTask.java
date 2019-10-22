package cz.prague.js.home.timone.print;

import cz.prague.js.home.timone.context.Context;
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

    private void printToStandartOutput() {
        context.getRecords().forEach((k,v)-> System.out.println("Currency: " + k + " Amount : " + v));
    }

    @Override
    public void run() {
        this.printToStandartOutput();
    }
}
