package com.logos.tdd;

import static com.logos.tdd.type.Command.L;
import static com.logos.tdd.type.Command.M;
import static com.logos.tdd.type.Command.R;

import com.logos.tdd.type.Command;
import com.logos.tdd.type.Direction;
import java.util.Arrays;
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
    functionMap.put(Direction.N, LocationMove.getNorthFront);
    functionMap.put(Direction.S, LocationMove.getSouthFront);
    functionMap.put(Direction.W, LocationMove.getWestFront);
    functionMap.put(Direction.E, LocationMove.getEastFront);
  }

  public void command(Command command) {
    if (command == M) {
      location = functionMap.get(location.getDirection()).apply(location);
    }
    if (command == L) {
      location = LocationMove.getTurnLeft.apply(location);
    }

    if (command == R) {
      location = LocationMove.getTurnRight.apply(location);
    }
  }

  public void commands(String commands) {
    Arrays.stream(commands.split("")).map(Command::valueOf)
        .forEach(this::command);
  }
}
