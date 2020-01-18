package com.logos.tdd.headquarters;

import com.logos.tdd.map.Direction;
import com.logos.tdd.map.Location;
import com.logos.tdd.rover.Rover;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

public class Headquarter implements RoverDropInGutterListener {

  List<Location> gutterLocations = new ArrayList<>();
  List<Rover> rovers = new ArrayList<>();
  @Setter
  @Getter
  Rover currentRover;

  @Override
  public void dropInGutter(Location location) {
    gutterLocations.add(location);
    rovers.add(this.currentRover);
    this.currentRover = new Rover(0, 0, Direction.N, this,gutterLocations);
  }

  public void sendCommands(String commands) {
    currentRover.commands(commands);
  }
}
