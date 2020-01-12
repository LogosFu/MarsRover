package com.logos.tdd.type;

public enum Command {
  M, L, R;

  public static Command decoding(String command) {
    switch (command) {
      case "L":
        return L;
      case "R":
        return R;
      default:
        return M;
    }
  }
}
