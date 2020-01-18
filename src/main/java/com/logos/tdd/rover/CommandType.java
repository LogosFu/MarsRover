package com.logos.tdd.rover;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum CommandType {
  M, L, R, B, H;
  public static List<CommandType> decodeCommand(String commands) {
    return Arrays.stream(commands.split(""))
        .map(CommandType::valueOf)
        .collect(Collectors.toList());
  }
}
