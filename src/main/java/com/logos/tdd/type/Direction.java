package com.logos.tdd.type;

import lombok.Getter;

public enum Direction {
  N(0),
  W(1),
  S(2),
  E(3);
  @Getter
  private Integer code;

  Direction(int code) {
    this.code = code;
  }

  public static Direction parse(int code) {

    switch (code) {
      case 1:
        return W;
      case 2:
        return S;
      case 3:
        return E;
      default:
        return N;
    }
  }
}
