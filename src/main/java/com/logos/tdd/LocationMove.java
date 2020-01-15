package com.logos.tdd;

import com.logos.tdd.type.Direction;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class LocationMove {

  public static Function<Location, Location> addY = location -> Location.builder()
      .x(location.getX()).y(location.getY() + 1).direction(location.getDirection()).build();
  public static Function<Location, Location> addX = location -> Location.builder()
      .x(location.getX() + 1).y(location.getY()).direction(location.getDirection()).build();
  public static Function<Location, Location> subX = location -> Location.builder()
      .x(location.getX() - 1).y(location.getY()).direction(location.getDirection()).build();
  public static Function<Location, Location> subY = location -> Location.builder()
      .x(location.getX()).y(location.getY() - 1).direction(location.getDirection()).build();
  public static Function<Location, Location> getTurnLeft = l -> Location.builder()
      .x(l.getX()).y(l.getY()).direction(Direction.parse((l.getDirection().getCode() + 1) % 4))
      .build();
  public static Function<Location, Location> getTurnRight = l -> Location.builder()
      .x(l.getX()).y(l.getY()).direction(Direction.parse((l.getDirection().getCode() + 3) % 4))
      .build();

  public static Map<Direction, Function<Location, Location>> getForwardMap() {
    Map<Direction, Function<Location, Location>> functionMap = new HashMap<>();
    functionMap.put(Direction.N, LocationMove.addY);
    functionMap.put(Direction.S, LocationMove.subY);
    functionMap.put(Direction.W, LocationMove.subX);
    functionMap.put(Direction.E, LocationMove.addX);
    return functionMap;
  }

  public static Map<Direction, Function<Location, Location>> getBackMap() {
    Map<Direction, Function<Location, Location>> functionMap = new HashMap<>();
    functionMap.put(Direction.N, LocationMove.subY);
    functionMap.put(Direction.S, LocationMove.addY);
    functionMap.put(Direction.W, LocationMove.addX);
    functionMap.put(Direction.E, LocationMove.subX);
    return functionMap;
  }
}
