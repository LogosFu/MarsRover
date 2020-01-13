package com.logos.tdd;

import com.logos.tdd.type.Command;
import com.logos.tdd.type.Direction;
import lombok.Getter;

public class Rover {

  @Getter
  private Location location;

  public Rover(Integer x, Integer y, Direction direction) {
    location = Location.builder().x(x).y(y).direction(direction).build();
  }

  public void command(Command command) {
    if (command == Command.M) {
      switch (location.getDirection()){
        case N:
          location = location.addY();
          break;
        case E:
          location = location.addX();
          break;
      }
    }
  }
}
