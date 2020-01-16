package com.logos.tdd.type;

import static com.logos.tdd.type.CommandType.CHANGE_LOCATION;
import static com.logos.tdd.type.CommandType.CHANGE_MODEL;

import lombok.Getter;

public enum Command {
  M(CHANGE_LOCATION),
  L(CHANGE_LOCATION),
  R(CHANGE_LOCATION),
  B(CHANGE_MODEL),
  H(CHANGE_MODEL);

  @Getter
  private CommandType commandType;

  Command(CommandType commandType) {
    this.commandType = commandType;
  }
}
