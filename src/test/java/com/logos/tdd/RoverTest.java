package com.logos.tdd;


import static com.logos.tdd.type.Command.L;
import static com.logos.tdd.type.Command.M;
import static com.logos.tdd.type.Command.R;
import static org.assertj.core.api.Assertions.assertThat;

import com.logos.tdd.type.Command;
import com.logos.tdd.type.Direction;
import java.util.List;
import org.junit.Test;

public class RoverTest {

  @Test
  public void should_return_x_y_and_direction_when_init_given_x_y_direction() {
    int x = 1;
    int y = 2;
    Direction direction = Direction.N;

    final Rover rover = new Rover(x, y, direction);

    assertThat(rover.getLocation().getX()).isEqualTo(x);
    assertThat(rover.getLocation().getY()).isEqualTo(y);
    assertThat(rover.getLocation().getDirection()).isEqualTo(direction);
  }

  @Test
  public void should_add_y_when_command_m_given_rover_direction_is_n() {
    int x = 1;
    int y = 2;
    Direction direction = Direction.N;
    final Rover rover = new Rover(x, y, direction);
    rover.execute(M);
    assertThat(rover.getLocation().getX()).isEqualTo(x);
    assertThat(rover.getLocation().getY()).isEqualTo(y + 1);
    assertThat(rover.getLocation().getDirection()).isEqualTo(direction);
  }

  @Test
  public void should_sub_y_when_command_m_given_rover_direction_is_s() {
    int x = 1;
    int y = 2;
    Direction direction = Direction.S;
    final Rover rover = new Rover(x, y, direction);
    rover.execute(M);
    assertThat(rover.getLocation().getX()).isEqualTo(x);
    assertThat(rover.getLocation().getY()).isEqualTo(y - 1);
    assertThat(rover.getLocation().getDirection()).isEqualTo(direction);
  }

  @Test
  public void should_add_x_when_command_m_given_rover_direction_is_e() {
    int x = 1;
    int y = 2;
    Direction direction = Direction.E;
    final Rover rover = new Rover(x, y, direction);
    rover.execute(M);
    assertThat(rover.getLocation().getX()).isEqualTo(x + 1);
    assertThat(rover.getLocation().getY()).isEqualTo(y);
    assertThat(rover.getLocation().getDirection()).isEqualTo(direction);
  }

  @Test
  public void should_sub_x_when_command_m_given_rover_direction_is_w() {
    int x = 1;
    int y = 2;
    Direction direction = Direction.W;
    final Rover rover = new Rover(x, y, direction);
    rover.execute(M);
    assertThat(rover.getLocation().getX()).isEqualTo(x - 1);
    assertThat(rover.getLocation().getY()).isEqualTo(y);
    assertThat(rover.getLocation().getDirection()).isEqualTo(direction);
  }

  @Test
  public void should_return_w_when_command_l_given_rover_direction_is_n() {
    int x = 1;
    int y = 2;
    Direction direction = Direction.N;
    final Rover rover = new Rover(x, y, direction);
    rover.execute(L);
    assertThat(rover.getLocation().getX()).isEqualTo(x);
    assertThat(rover.getLocation().getY()).isEqualTo(y);
    assertThat(rover.getLocation().getDirection()).isEqualTo(Direction.W);
  }

  @Test
  public void should_return_s_when_command_l_given_rover_direction_is_w() {
    int x = 1;
    int y = 2;
    Direction direction = Direction.W;
    final Rover rover = new Rover(x, y, direction);
    rover.execute(L);
    assertThat(rover.getLocation().getX()).isEqualTo(x);
    assertThat(rover.getLocation().getY()).isEqualTo(y);
    assertThat(rover.getLocation().getDirection()).isEqualTo(Direction.S);
  }


  @Test
  public void should_return_e_when_command_l_given_rover_direction_is_s() {
    int x = 1;
    int y = 2;
    Direction direction = Direction.S;
    final Rover rover = new Rover(x, y, direction);
    rover.execute(L);
    assertThat(rover.getLocation().getX()).isEqualTo(x);
    assertThat(rover.getLocation().getY()).isEqualTo(y);
    assertThat(rover.getLocation().getDirection()).isEqualTo(Direction.E);
  }

  @Test
  public void should_return_n_when_command_l_given_rover_direction_is_e() {
    int x = 1;
    int y = 2;
    Direction direction = Direction.E;
    final Rover rover = new Rover(x, y, direction);
    rover.execute(L);
    assertThat(rover.getLocation().getX()).isEqualTo(x);
    assertThat(rover.getLocation().getY()).isEqualTo(y);
    assertThat(rover.getLocation().getDirection()).isEqualTo(Direction.N);
  }

  @Test
  public void should_get_E_when_command_r_given_rover_direction_is_N() {
    int x = 1;
    int y = 2;
    Direction direction = Direction.N;
    final Rover rover = new Rover(x, y, direction);
    rover.execute(R);
    assertThat(rover.getLocation().getX()).isEqualTo(x);
    assertThat(rover.getLocation().getY()).isEqualTo(y);
    assertThat(rover.getLocation().getDirection()).isEqualTo(Direction.E);
  }
  @Test
  public void should_get_N_when_command_r_given_rover_direction_is_W() {
    int x = 1;
    int y = 2;
    Direction direction = Direction.W;
    final Rover rover = new Rover(x, y, direction);
    rover.execute(R);
    assertThat(rover.getLocation().getX()).isEqualTo(x);
    assertThat(rover.getLocation().getY()).isEqualTo(y);
    assertThat(rover.getLocation().getDirection()).isEqualTo(Direction.N);
  }
  @Test
  public void should_get_W_when_command_r_given_rover_direction_is_S() {
    int x = 1;
    int y = 2;
    Direction direction = Direction.S;
    final Rover rover = new Rover(x, y, direction);
    rover.execute(R);
    assertThat(rover.getLocation().getX()).isEqualTo(x);
    assertThat(rover.getLocation().getY()).isEqualTo(y);
    assertThat(rover.getLocation().getDirection()).isEqualTo(Direction.W);
  }
  @Test
  public void should_get_S_when_command_r_given_rover_direction_is_E() {
    int x = 1;
    int y = 2;
    Direction direction = Direction.E;
    final Rover rover = new Rover(x, y, direction);
    rover.execute(R);
    assertThat(rover.getLocation().getX()).isEqualTo(x);
    assertThat(rover.getLocation().getY()).isEqualTo(y);
    assertThat(rover.getLocation().getDirection()).isEqualTo(Direction.S);
  }

  @Test
  public void returnCommandListWhenParsingCommandGivenCommands() {
    String commands  = "MMMLLRRLLL";
    int x = 1;
    int y = 2;
    Direction direction = Direction.E;
    final Rover rover = new Rover(x, y, direction);
    final List<Command> decoding = rover.decoding(commands);

  }
}