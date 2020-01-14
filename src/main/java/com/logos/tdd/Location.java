package com.logos.tdd;

import com.logos.tdd.type.Direction;
import java.util.Arrays;
import java.util.function.Function;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Location {

  private Integer x;
  private Integer y;
  private Direction direction;

  public static Function<Location, Location> getNorthFront = location -> Location.builder()
      .x(location.getX()).y(location.getY() + 1).direction(location.getDirection()).build();

  public static Function<Location, Location> getEastFront = location -> Location.builder()
      .x(location.getX() + 1).y(location.getY()).direction(location.getDirection()).build();

  public static Function<Location, Location> getWestFront = location -> Location.builder()
      .x(location.getX() - 1).y(location.getY()).direction(location.getDirection()).build();

  public static Function<Location, Location> getSouthFront = location -> Location.builder()
      .x(location.getX()).y(location.getY() - 1).direction(location.getDirection()).build();

  public static Function<Location, Location> getTurnLeft = l -> Location.builder()
      .x(l.getX()).y(l.getY()).direction(Direction.parse((l.getDirection().getCode() + 1) % 4))
      .build();

  public static Function<Location, Location> getTurnRight = l -> Location.builder()
      .x(l.getX()).y(l.getY()).direction(Direction.parse((l.getDirection().getCode() + 3) % 4))
      .build();

}
