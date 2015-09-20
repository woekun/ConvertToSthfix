/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithm;

import Convert.IConvert;
import Util.Helper.Intermediate;
import Util.Helper.Normalized;
import static Util.Helper.Normalized.standardize;
import static Util.Helper.Normalized.trimString;
import static Util.Helper.Setting.Priority;
import java.util.Stack;

/**
 *
 * @author HIPPY
 */
public class PostfixToInfix implements IConvert {

    @Override
    public String Convert(String s) {
        Stack<Intermediate> stack = new Stack<>();
        String source[] = trimString(Normalized.standardize(s));

        for (String item : source) {
            if (Priority(item) == 1) {
                Intermediate rightIntermediate = stack.pop();
                Intermediate leftIntermediate = stack.pop();

                String newExpr = leftIntermediate.expr + item + rightIntermediate.expr;

                stack.push(new Intermediate(newExpr, item));
            } else if (Priority(item) == 2 || Priority(item) == 3) {
                String leftExpr, rightExpr;

                Intermediate rightIntermediate = stack.pop();
                if (Priority(rightIntermediate.oper) == 1) {
                    rightExpr = "(" + rightIntermediate.expr + ")";
                } else {
                    rightExpr = rightIntermediate.expr;
                }

                Intermediate leftIntermediate = stack.pop();
                if (Priority(leftIntermediate.oper) == 1) {
                    leftExpr = "(" + leftIntermediate.expr + ")";
                } else {
                    leftExpr = leftIntermediate.expr;
                }

                String newExpr = leftExpr + item + rightExpr;

                stack.push(new Intermediate(newExpr, item));
            } else {
                stack.push(new Intermediate(item, ""));
            }
        }

        return standardize(stack.peek().expr);
    }
}
