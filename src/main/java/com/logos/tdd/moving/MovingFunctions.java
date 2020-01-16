package com.logos.tdd.moving;

import com.logos.tdd.Location;
import com.logos.tdd.type.Direction;
import java.util.function.Function;

public interface MovingFunctions {

  Function<Location, Location> getMovingFunction(Direction direction);
}
