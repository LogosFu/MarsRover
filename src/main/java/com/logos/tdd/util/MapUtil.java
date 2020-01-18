package com.logos.tdd.util;

import com.logos.tdd.map.Location;
import java.util.Random;

public class MapUtil {

  public static boolean checkDropInGutter(Location location) {
    if (location.getX() == 0 && location.getY() == 0) {
      return false;
    }
    return (location.getX() + location.getY()) % 9 == new Random().nextInt(10);
  }
}
