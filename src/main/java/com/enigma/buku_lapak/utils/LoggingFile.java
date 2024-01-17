package com.enigma.buku_lapak.utils;


import org.apache.log4j.Logger;

public class LoggingFile {

    private static StringBuilder sbuilds = new StringBuilder();
    private static Logger logger = Logger.getLogger(LoggingFile.class);
    public static void exceptionStringz(String[] datax,Exception e, String flag) {
        if(flag.equals("y"))
        {
            sbuilds.setLength(0);
            logger.info(sbuilds.append(System.getProperty("line.separator")).
                    append("ERROR IN CLASS =>").append(datax[0]).append(System.getProperty("line.separator")).
                    append("METHOD            =>").append(datax[1]).append(System.getProperty("line.separator")).
                    append("ERROR IS          =>").append(e.getMessage()).
                    append(System.getProperty("line.separator")).toString());
            sbuilds.setLength(0);
        }
    }

}
