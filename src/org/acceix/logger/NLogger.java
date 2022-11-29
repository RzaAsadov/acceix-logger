/*
 * The MIT License
 *
 * Copyright 2022 Rza Asadov (rza dot asadov at gmail dot com).
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package org.acceix.logger;

import java.sql.Timestamp;
import java.util.Date;
import java.util.LinkedList;
import java.util.Map;

/**
 *
 * @author zrid
 */
public class NLogger {

    private static int limit = 3000;
    private static Map<String,Object> envs;
    
    public NLogger(Map<String,Object> envs) {
       NLogger.envs = envs;
       NLogger.limit = Integer.valueOf((String) NLogger.envs.getOrDefault("log_limit","1000"));
    }
    

    private static  LinkedList<NLog> logs = new LinkedList<>();    
    
    public synchronized  static void logger (int logBlock,int logType,String module,String action,String user,String message) {
        
        StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
        StackTraceElement e = stacktrace[2];
        
        NLog log = new NLog();
        
        log.setModule(module);
        log.setAction(action);
        log.setUser(user);
        log.setLogType(logType);
        log.setLogBlock(logBlock);
        log.setEventClass(e.getClassName());
        log.setEventMethod(e.getMethodName().replaceAll("lambda\\$", "").replaceAll("\\$[0-9]*", ""));
        log.setStacktrace(stacktrace);
        log.setLogMessage(message);
        log.setLogTimestamp(new Timestamp(new Date().getTime()));
        log.setLineNumber(e.getLineNumber());
        


            if (logType==NLog.ERROR) {
                System.out.println(log + "\n");
            } else {
                //System.out.println(log);
            }

        logs.add(log);
        
        if (logs.size() > limit) {
            int l = limit / 10;
            
            for (int i=0; i < l; i++)
                logs = new LinkedList<>(); 
        }
        
    }    

    public static LinkedList<NLog> getLogs() {
        return logs;
    }
    

}
