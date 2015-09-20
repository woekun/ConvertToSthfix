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
public class Normalized {
    public static String standardize(String s) {
        s = s.trim();
        s = s.replaceAll("", " ");
        s = s.replaceAll("\\s+", " ");
        return s;
    }

    public static String[] trimString(String s) {
        String temp[] = s.split(" ");
        return temp;
    }
}
