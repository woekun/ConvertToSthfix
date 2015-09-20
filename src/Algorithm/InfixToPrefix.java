/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithm;

import Convert.IConvert;
import static Util.Helper.Normalized.standardize;
import static Util.Helper.Normalized.trimString;
import static Util.Helper.Setting.Priority;
import static Util.Helper.Setting.isOperand;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

/**
 *
 * @author HIPPY
 */
public class InfixToPrefix implements IConvert {

    @Override
    public String Convert(String s) {
        Stack<String> stack = new Stack();
        StringBuilder prefix = new StringBuilder();

        String source[] = trimString(standardize(s));
        Collections.reverse(Arrays.asList(source));

        for (String item : source) {
            if (isOperand(item)) {
                prefix.append(item).append(" ");
            } else if (item.equals(")")) {
                stack.push(item);
            } else if (item.equals("(")) {
                String t = stack.pop();
                while (!t.equals(")")) {
                    prefix.append(t).append(" ");
                    t = stack.pop();
                }
            } else {
                while (!stack.empty() && Priority(item) <= Priority(stack.peek())) {
                    prefix.append(stack.pop()).append(" ");
                }
                stack.push(item);
            }
        }

        while (stack.size() > 0) {
            prefix.append(stack.pop()).append(" ");
        }
        return standardize(prefix.reverse().toString());

    }

}
