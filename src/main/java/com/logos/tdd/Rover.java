package com.logos.tdd;

import static java.util.stream.Collectors.toList;

import com.logos.tdd.type.Command;
import com.logos.tdd.type.Direction;
import java.util.Arrays;
import java.util.List;
import lombok.Getter;

public class Rover {

  @Getter
  private Location location;

  public Rover(Integer x, Integer y, Direction direction) {
    this.location = Location.builder().x(x).y(y).direction(direction).build();
  }

  public void execute(Command command) {
    switch (command) {
      case M:
        location.forward();
        break;
      case L:
        location.turnLeft();
        break;
      case R:
        location.turnRight();
        break;
    }
  }

  public List<Command> decoding(String commands) {
    return Arrays.stream(commands.split("")).map(Command::decoding).collect(toList());
  }

  public Location getCommand(String commands) {
    decoding(commands).forEach(this::execute);
    return this.location;
  }
}
