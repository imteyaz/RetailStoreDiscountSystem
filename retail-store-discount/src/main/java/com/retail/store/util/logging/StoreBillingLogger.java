package com.retail.store.util.logging;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import com.retail.store.util.StoreBillingConstants;

/**
 * Wrapper class on log4j Logger for logging with custom level log levels
 * 
 * @author Imteyaz Ahmad
 *
 */
public class StoreBillingLogger {
    private Logger logger = null;

    static {

        DOMConfigurator.configureAndWatch(StoreBillingConstants.LOG4J_FILE_PATH, 5000);

        // shutdown log4j (and its monitor thread) on shutdown
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                LogManager.shutdown();
            }
        });
    }

    public StoreBillingLogger(Class<?> className) {

        this.logger = Logger.getLogger(className.getName());

        this.logger.setLevel(Logger.getRootLogger().getLevel());

    }

    /**
     * Logs the start of of a particular transaction.
     * 
     * @param transactionId
     */
    public void beginTransaction(String transactionId) {
        if (transactionId != null && !transactionId.isEmpty()) {
            logger.info(transactionId + ":: Transaction started");
        }
    }

    /**
     * Logs the completion of a particular transaction
     * 
     * @param transactionId
     */
    public void endTransaction(String transactionId) {
        if (transactionId != null && !transactionId.isEmpty()) {
            logger.info(transactionId + ":: Transaction complete");
        }
    }

    /**
     * writes the log message to the configured logging file.
     * 
     * @param logLevel
     *            - desired log level for the message
     * @param transactionId
     *            - associated transactionId for the message
     * @param logMessage
     *            - message to be logged
     */
    public void logMsg(LOG_LEVEL logLevel, String transactionId, String logMessage) {
    	
    	long threadId = Thread.currentThread().getId();
        
    	String prefixMsg = transactionId +"::"+threadId+"::";

        switch (logLevel) {
        case DEBUG:
            logger.debug(prefixMsg + logMessage);
            break;
        case INFO:
            logger.info(prefixMsg + logMessage);
            break;
        case WARN:
            logger.warn(prefixMsg + logMessage);
            break;
        case ERROR:
            logger.error(prefixMsg + logMessage);
            break;
        case TRACE:
            logger.trace(prefixMsg + logMessage);
            break;
        case PERF:
            logger.log(PerfLevel.PERF, prefixMsg + logMessage);
            break;
        case FATAL:
            logger.log(PerfLevel.FATAL, prefixMsg + logMessage);
            break;
        default:
            logger.debug(prefixMsg + logMessage);
        }

    }

    /**
     * Possible Log levels for MinaPro
     * 
     * @author 3123248
     *
     */
    public static enum LOG_LEVEL {
        DEBUG, INFO, WARN, ERROR, TRACE, PERF, FATAL
    }

    /**
     * Logs the exception stack trace with custom log message
     * 
     * @param logMessage
     * @param ex
     */
    public void logException(String logMessage, Exception ex) {
        logger.error(logMessage, ex);
    }
}
