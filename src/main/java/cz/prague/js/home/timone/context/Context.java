package cz.prague.js.home.timone.context;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Jiri Sikora
 * Context hold the data and method on data
 */
@Service
public class Context {
    Logger logger = LoggerFactory.getLogger(Context.class);

    private Map<String, Integer> records =  new ConcurrentHashMap<>();

    public void addRecord(String record)  {
        String[] str = record.split(" ");
        String current = str[0];

        if (isValidUpperCaseAndThreeDigits(current) && (str.length == 2) ) {

        try {
            Integer value = Integer.parseInt(str[1]);
            records.put(current, records.containsKey(current) ? records.get(current) + value : value);
            } catch (Exception ex) {
            logger.info("context", ex);
            }
        } else {
            System.out.println("Wrong entry ...");
        }
    }

    private boolean isValidUpperCaseAndThreeDigits(String currentcy) {
        return currentcy.matches("[A-Z]{3}");
    }

    public Map<String, Integer> getRecords() {
        return records;
    }


}
