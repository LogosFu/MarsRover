package com.logos.tdd;

import com.logos.tdd.type.Direction;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Location {

  private Integer x;
  private Integer y;
  private Direction direction;

  public Location addY() {
    return Location.builder().direction(direction).x(x).y(y + 1).build();
  }

  public Location addX() {
    return Location.builder().direction(direction).x(x + 1).y(y).build();
  }
}
