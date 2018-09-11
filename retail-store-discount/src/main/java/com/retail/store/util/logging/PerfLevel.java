package com.retail.store.util.logging;

import org.apache.log4j.Level;

/**
 * <p> Class defining the custom log level PERF. </p>
 * 
 * <p> The PERF level is above DEBUG level. So the log4j log level needs to be set to DEBUG to get the PERF level
 * loggings. </p>
 * 
 * @author Imteyaz Ahmad
 *
 */
public class PerfLevel extends Level {
    private static final long serialVersionUID = 4805101996865851868L;

    // PERF level value - greater than the DEBUG level value
    public static final int PERF_INT = DEBUG_INT + 10;

    public static final Level PERF = new PerfLevel(PERF_INT, "PERF", 7);

    protected PerfLevel(int level, String levelStr, int syslogEquivalent) {
        super(level, levelStr, syslogEquivalent);

    }

    public static Level toLevel(String sArg) {
        if (sArg != null && "PERF".equalsIgnoreCase(sArg)) {
            return PERF;
        }
        return (Level) toLevel(sArg, Level.INFO);
    }

    public static Level toLevel(int val) {
        if (val == PERF_INT) {
            return PERF;
        }
        return (Level) toLevel(val, Level.INFO);
    }

    public static Level toLevel(int val, Level defaultLevel) {
        if (val == PERF_INT) {
            return PERF;
        }
        return Level.toLevel(val, defaultLevel);
    }

    public static Level toLevel(String sArg, Level defaultLevel) {
        if (sArg != null && "PERF".equalsIgnoreCase(sArg)) {
            return PERF;
        }
        return Level.toLevel(sArg, defaultLevel);
    }
}
