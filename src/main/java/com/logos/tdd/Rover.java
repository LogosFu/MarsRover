package com.logos.tdd;

import static com.logos.tdd.type.Command.L;
import static com.logos.tdd.type.Command.M;

import com.logos.tdd.type.Command;
import com.logos.tdd.type.Direction;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import lombok.Getter;

public class Rover {

  @Getter
  private Location location;

  private Map<Direction, Function<Location, Location>> functionMap = new HashMap<>();

  public Rover(Integer x, Integer y, Direction direction) {
    location = Location.builder().x(x).y(y).direction(direction).build();
    functionMap.put(Direction.N, Location.getNorthFront);
    functionMap.put(Direction.S, Location.getSouthFront);
    functionMap.put(Direction.W, Location.getWestFront);
    functionMap.put(Direction.E, Location.getEastFront);
  }

  public void command(Command command) {
    if (command == M) {
      location = functionMap.get(location.getDirection()).apply(location);
    }
    if (command == L){
      location = Location.getTurnLeft.apply(location);
    }
  }
}
