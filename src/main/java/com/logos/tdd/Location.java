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

  public static Function<Location, Location> addY = location -> Location.builder()
      .direction(location.getDirection())
      .x(location.getX())
      .y(location.getY() + 1).build();

  public static Function<Location, Location> addX = location -> Location.builder()
      .direction(location.getDirection())
      .x(location.getX() + 1)
      .y(location.getY()).build();


  public static Function<Location, Location> subX = location -> Location.builder()
      .direction(location.getDirection())
      .x(location.getX() - 1)
      .y(location.getY()).build();

  public static Function<Location, Location> subY = location -> Location.builder()
      .direction(location.getDirection())
      .x(location.getX())
      .y(location.getY() - 1).build();

  public static Function<Location, Location> TurnLeft =
      location -> Location.builder().x(location.getX()).y(location.getY())
          .direction(Direction.parse((location.getDirection().getCode() + 1) % 4)).build();


  public static Function<Location, Location> TurnRight =
      location -> Location.builder().x(location.getX()).y(location.getY())
          .direction(Direction.parse((location.getDirection().getCode() + 3) % 4)).build();
}
