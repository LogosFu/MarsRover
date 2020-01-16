package com.logos.tdd;

import static com.logos.tdd.type.Command.B;
import static com.logos.tdd.type.Command.H;
import static com.logos.tdd.type.Command.L;
import static com.logos.tdd.type.Command.M;
import static com.logos.tdd.type.Command.R;

import com.logos.tdd.moving.BackMovingFunctions;
import com.logos.tdd.moving.ForwardMovingFunctions;
import com.logos.tdd.moving.MovingFunctions;
import com.logos.tdd.type.Command;
import com.logos.tdd.type.CommandType;
import com.logos.tdd.type.Direction;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import lombok.Getter;

public class Rover {

  @Getter
  private Location location;
  private static Map<Command, Function<Location, Location>> commandFunctionMap = new HashMap<>();
  private static MovingFunctions movingFunctions;
  private static Function<Location, Location> moveAction = locationGiven ->  movingFunctions.getMovingFunction(locationGiven.getDirection()).apply(locationGiven);
  private static Function<Location, Location> turnRightAction = Location.getTurnRight;
  private static Function<Location, Location> turnLeftAction = Location.getTurnLeft;


  public Rover(Integer x, Integer y, Direction direction) {
    location = Location.builder().x(x).y(y).direction(direction).build();
    movingFunctions = ForwardMovingFunctions.getInstance();
    commandFunctionMap.put(M, moveAction);
    commandFunctionMap.put(L, turnLeftAction);
    commandFunctionMap.put(R, turnRightAction);
  }

  public void command(Command command) {
    if (command.getCommandType() == CommandType.CHANGE_MODEL) {
      changeMoveAction(command);
    } else {
      location = commandFunctionMap.get(command).apply(location);
    }
  }

  private void changeMoveAction(Command command) {
    if (command == B) {
      movingFunctions = BackMovingFunctions.getInstance();
    } else if (command == H) {
      movingFunctions = ForwardMovingFunctions.getInstance();
    }
  }

  public void commands(String commands) {
    Arrays.stream(commands.split("")).map(Command::valueOf)
        .forEach(this::command);
  }
}
