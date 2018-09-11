package com.retail.store.util;

import java.io.File;

/**
 * All the constants needed for the processing server are define here
 * 
 * @author Imteyaz Ahmad
 * 
 */
public interface StoreBillingConstants {
    // File Paths
    public static final String CONFIG_DIRECTORY = System.getProperty("user.dir") + File.separator + "config"
            + File.separator;
    
    public static final String LOG4J_FILE_PATH = CONFIG_DIRECTORY + "log4j.xml"; 
}
