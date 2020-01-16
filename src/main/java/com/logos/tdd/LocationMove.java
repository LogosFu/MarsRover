package com.logos.tdd;

import com.logos.tdd.type.Direction;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class LocationMove {

  public static Map<Direction, Function<Location, Location>> getForwardMap() {
    Map<Direction, Function<Location, Location>> functionMap = new HashMap<>();
    functionMap.put(Direction.N, Location.addY);
    functionMap.put(Direction.S, Location.subY);
    functionMap.put(Direction.W, Location.subX);
    functionMap.put(Direction.E, Location.addX);
    return functionMap;
  }

  public static Map<Direction, Function<Location, Location>> getBackMap() {
    Map<Direction, Function<Location, Location>> functionMap = new HashMap<>();
    functionMap.put(Direction.N, Location.subY);
    functionMap.put(Direction.S, Location.addY);
    functionMap.put(Direction.W, Location.addX);
    functionMap.put(Direction.E, Location.subX);
    return functionMap;
  }
}
