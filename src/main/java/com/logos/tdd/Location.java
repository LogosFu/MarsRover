package com.logos.tdd;

import com.logos.tdd.type.Direction;
import java.util.function.Function;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Location {

  private Integer x;
  private Integer y;
  Direction direction;

  public static Function<Location, Location> addY = location -> new Location(location.getX(),
      location.getY() + 1, location.getDirection());
  public static Function<Location, Location> addX = location -> new Location(location.getX() + 1,
      location.getY(), location.getDirection());
  public static Function<Location, Location> subX = location -> new Location(location.getX() - 1,
      location.getY(), location.getDirection());
  public static Function<Location, Location> subY = location -> new Location(location.getX(),
      location.getY() - 1, location.getDirection());
  public static Function<Location, Location> getTurnLeft = l -> Location.builder()
      .x(l.getX()).y(l.getY()).direction(Direction.parse((l.getDirection().getCode() + 1) % 4))
      .build();
  public static Function<Location, Location> getTurnRight = l -> Location.builder()
      .x(l.getX()).y(l.getY()).direction(Direction.parse((l.getDirection().getCode() + 3) % 4))
      .build();
}
