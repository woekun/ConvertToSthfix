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
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

/**
 *
 * @author HIPPY
 */
public class PrefixToPostfix implements IConvert {

    @Override
    public String Convert(String s) {
        Stack<String> stack = new Stack<>();
        String source[] = trimString(Normalized.standardize(s));
        Collections.reverse(Arrays.asList(source));

        for (String item : source) {
            if (isOperand(item)) {
                stack.push(item);
            } else if (isOperator(item)) {
                String a = stack.pop();
                String b = stack.pop();
                stack.push(a + b + item);
            }
        }
        return standardize(stack.peek());
    }

}
