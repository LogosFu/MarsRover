package com.logos.tdd;


import static org.assertj.core.api.Assertions.assertThat;

import com.logos.tdd.rover.Rover;
import com.logos.tdd.rover.CommandType;
import com.logos.tdd.map.Direction;
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
  public void should_add_y_when_forward_given_rover_direction_is_n() {
    Integer x = 0;
    Integer y = 0;
    Direction direction = Direction.N;
    final Rover rover = new Rover(x, y, direction);
    rover.command(CommandType.B);
    rover.command(CommandType.H);
    rover.command(CommandType.M);
    assertThat(rover.getLocation().getX()).isEqualTo(x);
    assertThat(rover.getLocation().getY()).isEqualTo(y + 1);
    assertThat(rover.getLocation().getDirection()).isEqualTo(direction);
  }

  @Test
  public void should_add_x_when_forward_given_rover_direction_is_e() {
    Integer x = 0;
    Integer y = 0;
    Direction direction = Direction.E;
    final Rover rover = new Rover(x, y, direction);
    rover.command(CommandType.B);
    rover.command(CommandType.H);
    rover.command(CommandType.M);
    assertThat(rover.getLocation().getX()).isEqualTo(x + 1);
    assertThat(rover.getLocation().getY()).isEqualTo(y);
    assertThat(rover.getLocation().getDirection()).isEqualTo(direction);
  }

  @Test
  public void should_sub_y_when_forward_given_rover_direction_is_s() {
    Integer x = 0;
    Integer y = 0;
    Direction direction = Direction.S;
    final Rover rover = new Rover(x, y, direction);
    rover.command(CommandType.B);
    rover.command(CommandType.H);
    rover.command(CommandType.M);
    assertThat(rover.getLocation().getX()).isEqualTo(x);
    assertThat(rover.getLocation().getY()).isEqualTo(y - 1);
    assertThat(rover.getLocation().getDirection()).isEqualTo(direction);
  }

  @Test
  public void should_sub_x_when_forward_given_rover_direction_is_w() {
    Integer x = 0;
    Integer y = 0;
    Direction direction = Direction.W;
    final Rover rover = new Rover(x, y, direction);
    rover.command(CommandType.B);
    rover.command(CommandType.H);
    rover.command(CommandType.M);
    assertThat(rover.getLocation().getX()).isEqualTo(x - 1);
    assertThat(rover.getLocation().getY()).isEqualTo(y);
    assertThat(rover.getLocation().getDirection()).isEqualTo(direction);
  }

  @Test
  public void should_return_w_when_veer_l_given_rover_direction_is_n() {
    Integer x = 0;
    Integer y = 0;
    Direction direction = Direction.N;
    final Rover rover = new Rover(x, y, direction);
    rover.command(CommandType.L);
    assertThat(rover.getLocation().getX()).isEqualTo(x);
    assertThat(rover.getLocation().getY()).isEqualTo(y);
    assertThat(rover.getLocation().getDirection()).isEqualTo(Direction.W);
  }

  @Test
  public void should_return_s_when_veer_l_given_rover_direction_is_w() {
    Integer x = 0;
    Integer y = 0;
    Direction direction = Direction.W;
    final Rover rover = new Rover(x, y, direction);
    rover.command(CommandType.L);
    assertThat(rover.getLocation().getX()).isEqualTo(x);
    assertThat(rover.getLocation().getY()).isEqualTo(y);
    assertThat(rover.getLocation().getDirection()).isEqualTo(Direction.S);
  }

  @Test
  public void should_return_e_when_veer_l_given_rover_direction_is_s() {
    Integer x = 0;
    Integer y = 0;
    Direction direction = Direction.S;
    final Rover rover = new Rover(x, y, direction);
    rover.command(CommandType.L);
    assertThat(rover.getLocation().getX()).isEqualTo(x);
    assertThat(rover.getLocation().getY()).isEqualTo(y);
    assertThat(rover.getLocation().getDirection()).isEqualTo(Direction.E);
  }

  @Test
  public void should_return_n_when_veer_l_given_rover_direction_is_e() {
    Integer x = 0;
    Integer y = 0;
    Direction direction = Direction.E;
    final Rover rover = new Rover(x, y, direction);
    rover.command(CommandType.L);
    assertThat(rover.getLocation().getX()).isEqualTo(x);
    assertThat(rover.getLocation().getY()).isEqualTo(y);
    assertThat(rover.getLocation().getDirection()).isEqualTo(Direction.N);
  }

  @Test
  public void should_return_e_when_veer_r_given_rover_direction_is_n() {
    Integer x = 0;
    Integer y = 0;
    Direction direction = Direction.N;
    final Rover rover = new Rover(x, y, direction);
    rover.command(CommandType.R);
    assertThat(rover.getLocation().getX()).isEqualTo(x);
    assertThat(rover.getLocation().getY()).isEqualTo(y);
    assertThat(rover.getLocation().getDirection()).isEqualTo(Direction.E);
  }

  @Test
  public void should_return_n_when_veer_r_given_rover_direction_is_w() {
    Integer x = 0;
    Integer y = 0;
    Direction direction = Direction.W;
    final Rover rover = new Rover(x, y, direction);
    rover.command(CommandType.R);
    assertThat(rover.getLocation().getX()).isEqualTo(x);
    assertThat(rover.getLocation().getY()).isEqualTo(y);
    assertThat(rover.getLocation().getDirection()).isEqualTo(Direction.N);
  }

  @Test
  public void should_return_w_when_veer_r_given_rover_direction_is_s() {
    Integer x = 0;
    Integer y = 0;
    Direction direction = Direction.S;
    final Rover rover = new Rover(x, y, direction);
    rover.command(CommandType.R);
    assertThat(rover.getLocation().getX()).isEqualTo(x);
    assertThat(rover.getLocation().getY()).isEqualTo(y);
    assertThat(rover.getLocation().getDirection()).isEqualTo(Direction.W);
  }

  @Test
  public void should_return_s_when_veer_r_given_rover_direction_is_e() {
    Integer x = 0;
    Integer y = 0;
    Direction direction = Direction.E;
    final Rover rover = new Rover(x, y, direction);
    rover.command(CommandType.R);
    assertThat(rover.getLocation().getX()).isEqualTo(x);
    assertThat(rover.getLocation().getY()).isEqualTo(y);
    assertThat(rover.getLocation().getDirection()).isEqualTo(Direction.S);
  }

  @Test
  public void should_return_location_when_send_command_given_command() {
    String commands ="MMMMLLLRRRMMM";
    Integer x = 0;
    Integer y = 0;
    Direction direction = Direction.N;
    final Rover rover = new Rover(x, y, direction);
    rover.commands(commands);
    assertThat(rover.getLocation().getX()).isEqualTo(x);
    assertThat(rover.getLocation().getY()).isEqualTo(y+7);
    assertThat(rover.getLocation().getDirection()).isEqualTo(Direction.N);
  }

  @Test
  public void should_sub_y_when_back_given_rover_direction_is_n() {
    Integer x = 0;
    Integer y = 0;
    Direction direction = Direction.N;
    final Rover rover = new Rover(x, y, direction);
    rover.command(CommandType.B);
    rover.command(CommandType.M);
    assertThat(rover.getLocation().getX()).isEqualTo(x);
    assertThat(rover.getLocation().getY()).isEqualTo(y - 1);
    assertThat(rover.getLocation().getDirection()).isEqualTo(direction);
  }

  @Test
  public void should_sub_x_when_back_given_rover_direction_is_e() {
    Integer x = 0;
    Integer y = 0;
    Direction direction = Direction.E;
    final Rover rover = new Rover(x, y, direction);
    rover.command(CommandType.B);
    rover.command(CommandType.M);
    assertThat(rover.getLocation().getX()).isEqualTo(x - 1);
    assertThat(rover.getLocation().getY()).isEqualTo(y);
    assertThat(rover.getLocation().getDirection()).isEqualTo(direction);
  }

  @Test
  public void should_add_y_when_back_given_rover_direction_is_s() {
    Integer x = 0;
    Integer y = 0;
    Direction direction = Direction.S;
    final Rover rover = new Rover(x, y, direction);
    rover.command(CommandType.B);
    rover.command(CommandType.M);
    assertThat(rover.getLocation().getX()).isEqualTo(x);
    assertThat(rover.getLocation().getY()).isEqualTo(y + 1);
    assertThat(rover.getLocation().getDirection()).isEqualTo(direction);
  }

  @Test
  public void should_add_x_when_back_given_rover_direction_is_w() {
    Integer x = 0;
    Integer y = 0;
    Direction direction = Direction.W;
    final Rover rover = new Rover(x, y, direction);
    rover.command(CommandType.B);
    rover.command(CommandType.M);
    assertThat(rover.getLocation().getX()).isEqualTo(x + 1);
    assertThat(rover.getLocation().getY()).isEqualTo(y);
    assertThat(rover.getLocation().getDirection()).isEqualTo(direction);
  }
}
