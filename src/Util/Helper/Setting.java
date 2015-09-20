/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util.Helper;

/**
 *
 * @author HIPPY
 */
public class Setting {

    public static int Priority(String s) {
        if(s.equals("^")){
            return 3;
        }
        if (s.equals("*") || s.equals("/") || s.equals("%")) {
            return 2;
        }
        if (s.equals("+") || s.equals("-")) {
            return 1;
        }
        return 0;
    }

    public static boolean isOperator(String s) {
        return s.matches("\\+|\\-|\\*|\\/|\\%|\\^");
    }

    public static boolean isOperand(String s) {
        return s.matches("\\d+$|[a-z]|[A-Z]");
    }
}
