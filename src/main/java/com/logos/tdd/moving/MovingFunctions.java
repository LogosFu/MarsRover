package com.logos.tdd.moving;

import com.logos.tdd.map.Location;
import com.logos.tdd.map.Direction;
import java.util.function.Function;

public interface MovingFunctions {

  Function<Location, Location> getMovingFunction(Direction direction);
}
