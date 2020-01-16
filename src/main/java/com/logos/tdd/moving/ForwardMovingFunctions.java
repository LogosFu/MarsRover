package com.logos.tdd.moving;

import com.logos.tdd.Location;
import com.logos.tdd.type.Direction;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class ForwardMovingFunctions implements MovingFunctions {

  static Map<Direction, Function<Location, Location>> functionMap = new HashMap<>();

  static {
    functionMap.put(Direction.N, Location.addY);
    functionMap.put(Direction.S, Location.subY);
    functionMap.put(Direction.W, Location.subX);
    functionMap.put(Direction.E, Location.addX);
  }

  private ForwardMovingFunctions() {

  }

  public static ForwardMovingFunctions getInstance() {
    return Inner.instance;
  }

  private static class Inner {

    private static final ForwardMovingFunctions instance = new ForwardMovingFunctions();
  }


  @Override
  public Function<Location, Location> getMovingFunction(Direction direction) {
    return functionMap.get(direction);
  }
}
