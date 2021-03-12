package com.rambo.algorithm;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * @author rambo.pan
 * @version 1.0
 * @date 2021/2/3 10:26 AM
 */
public class TestScriptEngine {
    public static void main(String[] args) {

        ScriptEngineManager manager = new ScriptEngineManager();

        ScriptEngine engine = manager.getEngineByName("JavaScript");
        String expression = "boxBarcode.length <= 19";

            try {
                engine.eval( "boxBarcode='999999'");
            }catch(Exception e){
                e.printStackTrace();
            }
        try {
            boolean result = (boolean) engine.eval(expression);
            System.out.println(result);
        } catch (ScriptException e) {
            e.printStackTrace();
        }
    }
}
