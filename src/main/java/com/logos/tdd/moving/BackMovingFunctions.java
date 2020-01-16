package com.logos.tdd.moving;

import com.logos.tdd.Location;
import com.logos.tdd.type.Direction;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import lombok.Singleton;

@Singleton(style = Singleton.Style.HOLDER)
public class BackMovingFunctions implements MovingFunctions {

  static Map<Direction, Function<Location, Location>> functionMap = new HashMap<>();

  static {
    functionMap.put(Direction.N, Location.subY);
    functionMap.put(Direction.S, Location.addY);
    functionMap.put(Direction.W, Location.addX);
    functionMap.put(Direction.E, Location.subX);
  }

  private BackMovingFunctions() {

  }

  public static BackMovingFunctions getInstance() {
    return BackMovingFunctions.Inner.instance;
  }

  private static class Inner {

    private static final BackMovingFunctions instance = new BackMovingFunctions();
  }


  @Override
  public Function<Location, Location> getMovingFunction(Direction direction) {
    return functionMap.get(direction);
  }
}
