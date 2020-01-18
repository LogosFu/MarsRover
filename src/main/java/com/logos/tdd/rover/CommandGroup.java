package com.logos.tdd.rover;

public enum CommandGroup {
  CHANGE_MODEL, CHANGE_LOCATION;

  private static CommandGroup checkGroupOfCommand(CommandType commandType) {
    switch (commandType) {
      case B:
      case H:
        return CHANGE_MODEL;
      default:
        return CHANGE_LOCATION;
    }
  }

  public static Boolean isChangeModelCommand(CommandType commandType) {
    return CommandGroup.checkGroupOfCommand(commandType) == CHANGE_MODEL;
  }

  public static Boolean isChangeLocationCommand(CommandType commandType) {
    return CommandGroup.checkGroupOfCommand(commandType) == CHANGE_LOCATION;
  }
}
