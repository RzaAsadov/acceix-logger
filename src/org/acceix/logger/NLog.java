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
import java.util.Arrays;

/**
 *
 * @author zrid
 */
public class NLog {
    
    public static int UNKNOWN=0;
    
    public static int ERROR=1;
    public static int WARNING=2;
    public static int MESSAGE=3;
    public static int SECURITY=4;
    public static int SECURITY_ATTENTION=5;
    public static int DB=6;

    
    private int logType;
    private int logBlock;
    private String module;
    private String action;
    private String user;
    
    private String logMessage;
    private String eventClass;
    private String eventMethod;
    private StackTraceElement[] stacktrace;
    private Timestamp logTimestamp;
    private int lineNumber;
    
    public String getLogTypeAsString () {
            if (logType==ERROR) return "Error";
            else if (logType==WARNING) return "Warning";
            else if (logType==MESSAGE) return "Message";
            else if (logType==SECURITY) return "Security";
            else if (logType==SECURITY_ATTENTION) return "Security attention";
            else return "Unknown";
    }   

    public void setModule(String module) {
        this.module = module;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getModule() {
        return module;
    }

    public String getAction() {
        return action;
    }

    public String getUser() {
        return user;
    }

    


    public void setLineNumber(int lineNumber) {
        this.lineNumber = lineNumber;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public void setStacktrace(StackTraceElement[] n_stacktrace) {
        //stacktrace = new StackTraceElement[n_stacktrace.length];
        stacktrace = Arrays.copyOf(n_stacktrace, n_stacktrace.length);
    }

    public StackTraceElement[] getStacktrace() {
        return stacktrace;
    }    
    

    public void setLogType(int logType) {
        this.logType = logType;
    }

    public int getLogType() {
        return logType;
    }

    public void setLogBlock(int logBlock) {
        this.logBlock = logBlock;
    }

    public int getLogBlock() {
        return logBlock;
    }
    
    

    public void setLogMessage(String logMessage) {
        this.logMessage = logMessage;
    }

    public String getLogMessage() {
        return logMessage;
    }

    public void setLogTimestamp(Timestamp logTimestamp) {
        this.logTimestamp = logTimestamp;
    }

    public Timestamp getLogTimestamp() {
        return logTimestamp;
    }

    public void setEventClass(String eventClass) {
        this.eventClass = eventClass;
    }

    public String getEventClass() {
        return eventClass;
    }

    public void setEventMethod(String eventMethod) {
        this.eventMethod = eventMethod;
    }

    public String getEventMethod() {
        return eventMethod;
    }
    
    @Override
    public String toString() {
        if (getLogType()==ERROR) {
            return "Log:" + " block=" + NLogBlock.asString(getLogBlock()) + " type=" + getLogTypeAsString() + " time=[" + getLogTimestamp() + "] Message=[" + getLogMessage() +  "] caller=" + getEventClass() + "->" + getEventMethod()  + " line=" + getLineNumber();
        } else {
            return "Log:" + " block=" + NLogBlock.asString(getLogBlock()) + " type=" + getLogTypeAsString() + " time=[" + getLogTimestamp() + "] Message=[" + getLogMessage() +  "]";
        }
    }
    
    
}

