package com.deadvikingstudios.characterbuilder.model.rng;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DiceRoller
{
    private static Random random = new Random();
    private static final Pattern pattern = Pattern.compile("(?:(?<dice>[//^%*/+-]?(?<num>\\d+)?d(?<sides>100|20|12|10|8|6|4|2))(?<select>[dk][<>]?\\d+)*(?<reroll>r\\d+)*(?<math>[//^%*/+-]\\d+[^d]?)*)");



    public static int roll(int n, int sides)
    {
        int res = 0;
        for (int i = 0; i < n; i++)
        {
            res += random.nextInt(sides)+1;
        }
        return res;
    }

    public static int roll(String dice)
    {
        Matcher m = pattern.matcher(dice);

        if(m.matches())
        {
            int diceNum = (m.group("num") != null) ? Integer.parseInt(m.group(1)) : 1;
            int sides =  Integer.parseInt(m.group("sides"));


            return 0;
        }
        else
        {
            throw new IllegalArgumentException("Dice String does not match regex: " + pattern.pattern());
        }
    }

    public static void main(String args[])
    {
        String str = "4d6d1r1+2";
        Matcher m = pattern.matcher(str);
        if(m.matches())
        {
            System.out.println("match: " + m.group());
            System.out.println("dice: " + m.group("dice"));
            System.out.println("num: " + m.group("num"));
            System.out.println("sides: " + m.group("sides"));
            System.out.println("select: " + m.group("select"));
            System.out.println("reroll: " + m.group("reroll"));
            System.out.println("math: " + m.group("math"));
        }
    }

}


