package com.logos.tdd.type;

import lombok.Getter;

public enum Direction {
  N(0),
  W(1),
  S(2),
  E(3);

  @Getter
  private Integer code;

  Direction(int i) {
    this.code = i;
  }

  public static Direction parse(Integer code) {
    switch (code) {
      case 0:
        return N;
      case 1:
        return W;
      case 2:
        return S;
      default:
        return E;
    }
  }
}
