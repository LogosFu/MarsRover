package com.logos.tdd;

import com.logos.tdd.type.Direction;
import java.util.Arrays;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Location {

  private Integer x;
  private Integer y;
  private Direction direction;

  public void forward() {
    switch (direction) {
      case N:
        y += 1;
        break;
      case S:
        y -= 1;
        break;
      case E:
        x += 1;
        break;
      case W:
        x -= 1;
        break;
    }
  }

  public void turnLeft() {
    final int indexOfDirection = Arrays.asList(Direction.values()).indexOf(direction);
    this.direction = Direction.values()[(indexOfDirection + 1) %4 ];
  }

  public void turnRight() {
    final int indexOfDirection = Arrays.asList(Direction.values()).indexOf(direction);
    this.direction = Direction.values()[(indexOfDirection + 3) %4];
  }
}
