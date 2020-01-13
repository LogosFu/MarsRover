package com.logos.tdd.type;

public enum Command {
  M, L, R;

  public static Command parse(String code) {
    switch (code) {

      case "L":
        return L;
      case "R":
        return R;
      default:
        return M;
    }
  }
}
