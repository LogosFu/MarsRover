package com.logos.tdd;

import com.logos.tdd.type.Direction;
import java.util.Arrays;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Location {

  private Integer x;
  private Integer y;
  private Direction direction;
}
