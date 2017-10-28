package com.deadvikingstudios.characterbuilder.model.rng;

import java.util.regex.Pattern;

public class DiceParser
{
    private static final Pattern DIE = Pattern.compile("(?<die>[//^%*/+-]?(?<num>\\d+)?d(?<sides>\\d))");
    private static final Pattern SELECT = Pattern.compile("(?<select>[dk][<>]?\\d+)");
    private static final Pattern REROLL = Pattern.compile("(?<reroll>r\\d+)");
    private static final Pattern MATH = Pattern.compile("(?<math>[//^%*/+-]\\d+[^d]?)");
}
