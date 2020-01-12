package com.logos.tdd;

import com.logos.tdd.type.Command;
import com.logos.tdd.type.Direction;
import lombok.Getter;

public class Rover {

  @Getter
  private Location location;

  public Rover(Integer x, Integer y, Direction direction) {
    this.location = Location.builder().x(x).y(y).direction(direction).build();
  }

  public void execute(Command command) {
    switch (command){
      case M:
        location.forward();
        break;
      case L:
        location.turnLeft();
        break;
    }
  }
}
