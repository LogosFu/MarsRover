package com.logos.tdd;

import static com.logos.tdd.type.Command.B;
import static com.logos.tdd.type.Command.H;
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
  private static Map<Direction, Function<Location, Location>> functionMap = new HashMap<>();
  private static Map<Command, Function<Location, Location>> commandFunctionMap = new HashMap<>();

  private static Function<Location, Location> moveAction = locationGiven -> functionMap
      .get(locationGiven.getDirection()).apply(locationGiven);
  private static Function<Location, Location> turnRightAction = LocationMove.getTurnRight;
  private static Function<Location, Location> turnLeftAction = LocationMove.getTurnLeft;


  public Rover(Integer x, Integer y, Direction direction) {
    location = Location.builder().x(x).y(y).direction(direction).build();
    functionMap = LocationMove.getForwardMap();
    commandFunctionMap.put(M, moveAction);
    commandFunctionMap.put(L, turnLeftAction);
    commandFunctionMap.put(R, turnRightAction);
  }

  public void command(Command command) {
    if (command == B) {
      functionMap = LocationMove.getBackMap();
    } else if (command == H) {
      functionMap = LocationMove.getForwardMap();
    } else {
      location = commandFunctionMap.get(command).apply(location);
    }
  }

  public void commands(String commands) {
    Arrays.stream(commands.split("")).map(Command::valueOf)
        .forEach(this::command);
  }
}
