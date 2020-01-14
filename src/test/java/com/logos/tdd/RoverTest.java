package com.logos.tdd;


import static com.logos.tdd.type.Command.L;
import static com.logos.tdd.type.Command.M;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.InstanceOfAssertFactories.predicate;

import com.logos.tdd.type.Command;
import com.logos.tdd.type.Direction;
import org.junit.Test;

public class RoverTest {

  @Test
  public void should_return_coordinates_and_direction_when_init_given_rover_with_coordinates_and_direction() {
    Integer x = 0;
    Integer y = 0;
    Direction direction = Direction.N;
    final Rover rover = new Rover(x, y, direction);
    assertThat(rover.getLocation().getX()).isEqualTo(x);
    assertThat(rover.getLocation().getY()).isEqualTo(y);
    assertThat(rover.getLocation().getDirection()).isEqualTo(direction);
  }

  @Test
  public void shouldAddYWhenForwardGivenRoverDirectionIsN() {
    Integer x = 0;
    Integer y = 0;
    Direction direction = Direction.N;
    final Rover rover = new Rover(x, y, direction);
    rover.command(Command.M);
    assertThat(rover.getLocation().getX()).isEqualTo(x);
    assertThat(rover.getLocation().getY()).isEqualTo(y + 1);
    assertThat(rover.getLocation().getDirection()).isEqualTo(direction);
  }

  @Test
  public void shouldAddXWhenForwardGivenRoverDirectionIsE() {
    Integer x = 0;
    Integer y = 0;
    Direction direction = Direction.E;
    final Rover rover = new Rover(x, y, direction);
    rover.command(Command.M);
    assertThat(rover.getLocation().getX()).isEqualTo(x + 1);
    assertThat(rover.getLocation().getY()).isEqualTo(y);
    assertThat(rover.getLocation().getDirection()).isEqualTo(direction);
  }

  @Test
  public void ShouldSubYWhenForwardGivenRoverDirectionIsS() {
    Integer x = 0;
    Integer y = 0;
    Direction direction = Direction.S;
    final Rover rover = new Rover(x, y, direction);
    rover.command(Command.M);
    assertThat(rover.getLocation().getX()).isEqualTo(x);
    assertThat(rover.getLocation().getY()).isEqualTo(y - 1);
    assertThat(rover.getLocation().getDirection()).isEqualTo(direction);
  }

  @Test
  public void shouldSubXWhenForwardGivenRoverDirectionIsW() {
    Integer x = 0;
    Integer y = 0;
    Direction direction = Direction.W;
    final Rover rover = new Rover(x, y, direction);
    rover.command(Command.M);
    assertThat(rover.getLocation().getX()).isEqualTo(x - 1);
    assertThat(rover.getLocation().getY()).isEqualTo(y);
    assertThat(rover.getLocation().getDirection()).isEqualTo(direction);
  }
}