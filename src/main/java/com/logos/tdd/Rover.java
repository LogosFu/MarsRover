package com.logos.tdd;

import static com.logos.tdd.type.Direction.E;
import static com.logos.tdd.type.Direction.N;
import static com.logos.tdd.type.Direction.S;
import static com.logos.tdd.type.Direction.W;

import com.logos.tdd.type.Command;
import com.logos.tdd.type.Direction;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import lombok.Getter;

public class Rover {

  @Getter
  private Location location;
  private Map<Direction, Function<Location, Location>> forwardFuncMap = new HashMap<>();

  public Rover(Integer x, Integer y, Direction direction) {
    location = Location.builder().x(x).y(y).direction(direction).build();
    forwardFuncMap.put(N, Location.addY);
    forwardFuncMap.put(E, Location.addX);
    forwardFuncMap.put(W, Location.subX);
    forwardFuncMap.put(S, Location.subY);
  }


  public void command(Command command) {
    switch (command){
      case M:
        this.location = forwardFuncMap.get(this.location.getDirection()).apply(this.location);
        break;
      case L:
        this.location = Location.TurnLeft.apply(this.location);
        break;
      case R:
        this.location = Location.TurnRight.apply(this.location);
        break;

    }
  }
}
