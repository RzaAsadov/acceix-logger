/*
 * The MIT License
 *
 * Copyright 2022 Rza Asadov (rza at asadov dot me).
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

/**
 *
 * @author zrid
 */
public class NLogBlock {
    
    public static int AUTH=1;
    public static int DB=2;
    public static int WEB_CRUD=4;
    public static int WEB=5;
    public static int OBJECTS=6;
    public static int FUNCTIONS=7;
    public static int DBSTORED=8;
    public static int SCRIPTS=9; 
    public static int VIEW=10;
    public static int ASSET=11;
    public static int DBTRIGGER=12;
    public static int DBVIEW=13;
    public static int DBEVENT=14;
    public static int DBTABLE=15;
    
    public static int UNKNOWN=100;


    public static String asString(int blockType) {
        
        if (blockType==AUTH) return "AUTH";
        if (blockType==DB) return "DB";
        if (blockType==WEB_CRUD) return "WEB_CRUD";
        if (blockType==WEB) return "WEB";
        if (blockType==OBJECTS) return "OBJECTS";
        if (blockType==FUNCTIONS) return "FUNCTIONS";
        if (blockType==DBSTORED) return "DBSTOREDS";
        if (blockType==SCRIPTS) return "SCRIPTS";
        if (blockType==VIEW) return "VIEWS";
        if (blockType==ASSET) return "ASSETS";
        
        return "UNKNOWN";
    }
    
}
