package com.logos.tdd.rover;

import static com.logos.tdd.rover.CommandType.B;
import static com.logos.tdd.rover.CommandType.H;
import static com.logos.tdd.rover.CommandType.L;
import static com.logos.tdd.rover.CommandType.M;
import static com.logos.tdd.rover.CommandType.R;

import com.logos.tdd.headquarters.RoverDropInGutterListener;
import com.logos.tdd.map.Direction;
import com.logos.tdd.map.Location;
import com.logos.tdd.moving.BackMovingFunctions;
import com.logos.tdd.moving.ForwardMovingFunctions;
import com.logos.tdd.moving.MovingFunctions;
import com.logos.tdd.util.MapUtil;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import lombok.Getter;

public class Rover {

  @Getter
  private Location location;
  private RoverDropInGutterListener dropInGutterListener;
  private static Map<CommandType, Function<Location, Location>> commandFunctionMap = new HashMap<>();
  private static MovingFunctions movingFunctions;
  private static Function<Location, Location> moveAction = locationGiven -> movingFunctions
      .getMovingFunction(locationGiven.getDirection()).apply(locationGiven);
  private static Function<Location, Location> turnRightAction = Location.getTurnRight;
  private static Function<Location, Location> turnLeftAction = Location.getTurnLeft;


  public Rover(Integer x, Integer y, Direction direction,
      RoverDropInGutterListener dropInGutterListener) {
    this.location = Location.builder().x(x).y(y).direction(direction).build();
    this.dropInGutterListener = dropInGutterListener;
    movingFunctions = ForwardMovingFunctions.getInstance();
    commandFunctionMap.put(M, moveAction);
    commandFunctionMap.put(L, turnLeftAction);
    commandFunctionMap.put(R, turnRightAction);
  }

  public void command(CommandType commandType) {
    if (CommandGroup.isChangeModelCommand(commandType)) {
      changeMoveAction(commandType);
    }
    if (CommandGroup.isChangeLocationCommand(commandType)) {
      location = commandFunctionMap.get(commandType).apply(location);
      checkIsDropInGutter();
    }
  }

  private void changeMoveAction(CommandType commandType) {
    if (commandType == B) {
      movingFunctions = BackMovingFunctions.getInstance();
    } else if (commandType == H) {
      movingFunctions = ForwardMovingFunctions.getInstance();

    }
  }

  private void checkIsDropInGutter() {
    if (MapUtil.checkDropInGutter(location)) {
      if (Objects.nonNull(dropInGutterListener)) {
        dropInGutterListener.dropInGutter(location);
      }
    }
  }

  public void commands(String commands) {
    CommandType.decodeCommand(commands).forEach(this::command);
  }

}
