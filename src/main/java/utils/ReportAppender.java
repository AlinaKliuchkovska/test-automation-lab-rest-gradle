package utils;

import org.apache.logging.log4j.core.Filter;
import org.apache.logging.log4j.core.Layout;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.appender.AbstractAppender;
import org.apache.logging.log4j.core.config.Property;
import org.testng.Reporter;

import java.io.Serializable;

public class ReportAppender extends AbstractAppender {

    protected ReportAppender(String name, Filter filter, Layout<? extends Serializable> layout, boolean ignoreExceptions, Property[] properties) {
        super(name, filter, layout, ignoreExceptions, properties);
    }

    @Override
    public void append(LogEvent event) {
//        eventMap.put(Instant.now().toString(), event);
       Reporter.log(event.getMessage().toString());
        System.out.println("Loggggg " + event.getMessage().toString());
    }
}