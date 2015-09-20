/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithm;

import Convert.IConvert;
import Util.Helper.Normalized;
import static Util.Helper.Normalized.standardize;
import static Util.Helper.Normalized.trimString;
import static Util.Helper.Setting.isOperand;
import static Util.Helper.Setting.isOperator;
import java.util.Stack;

/**
 *
 * @author HIPPY
 */
public class PostfixToPrefix implements IConvert {

    @Override
    public String Convert(String s) {
        Stack<String> stack = new Stack<>();
        String source[] = trimString(Normalized.standardize(s));

        for (String item : source) {
            if (isOperand(item)) {
                stack.push(item);
            } else if (isOperator(item)) {
                String a = stack.pop();
                String b = stack.pop();
                stack.push(item + b + a);
            }
        }
        return standardize(stack.peek());
    }

}
