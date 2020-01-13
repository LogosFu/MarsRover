package com.logos.tdd;


import static com.logos.tdd.type.Command.L;
import static com.logos.tdd.type.Command.M;
import static com.logos.tdd.type.Command.R;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.InstanceOfAssertFactories.predicate;

import com.logos.tdd.type.Command;
import com.logos.tdd.type.Direction;
import java.util.Arrays;
import java.util.List;
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
    rover.command(Command.M);

    assertThat(rover.getLocation().getX()).isEqualTo(x);
    assertThat(rover.getLocation().getY()).isEqualTo(Integer.sum(y , 1));
    assertThat(rover.getLocation().getDirection()).isEqualTo(direction);
  }
  @Test
  public void should_add_x_when_forward_given_rover_direction_is_e() {
    Integer x = 0;
    Integer y = 0;
    Direction direction = Direction.E;
    final Rover rover = new Rover(x, y, direction);
    rover.command(Command.M);

    assertThat(rover.getLocation().getX()).isEqualTo(x +1);
    assertThat(rover.getLocation().getY()).isEqualTo(y);
    assertThat(rover.getLocation().getDirection()).isEqualTo(direction);
  }

  @Test
  public void should_sub_y_when_forward_given_rover_direction_is_s() {
    Integer x = 0;
    Integer y = 0;
    Direction direction = Direction.S;
    final Rover rover = new Rover(x, y, direction);
    rover.command(Command.M);

    assertThat(rover.getLocation().getX()).isEqualTo(x );
    assertThat(rover.getLocation().getY()).isEqualTo(y -1);
    assertThat(rover.getLocation().getDirection()).isEqualTo(direction);
  }

  @Test
  public void should_sub_x_when_forward_given_rover_direction_is_w() {
    Integer x = 0;
    Integer y = 0;
    Direction direction = Direction.W;
    final Rover rover = new Rover(x, y, direction);
    rover.command(Command.M);

    assertThat(rover.getLocation().getX()).isEqualTo(x -1);
    assertThat(rover.getLocation().getY()).isEqualTo(y);
    assertThat(rover.getLocation().getDirection()).isEqualTo(direction);
  }

  @Test
  public void should_return_w_when_veer_l_given_rover_direction_is_n() {
    Integer x = 0;
    Integer y = 0;
    Direction direction = Direction.N;
    final Rover rover = new Rover(x, y, direction);
    rover.command(Command.L);

    assertThat(rover.getLocation().getX()).isEqualTo(x );
    assertThat(rover.getLocation().getY()).isEqualTo(y);
    assertThat(rover.getLocation().getDirection()).isEqualTo(Direction.W);
  }

  @Test
  public void should_return_s_when_veer_l_given_rover_direction_is_w() {
    Integer x = 0;
    Integer y = 0;
    Direction direction = Direction.W;
    final Rover rover = new Rover(x, y, direction);
    rover.command(Command.L);

    assertThat(rover.getLocation().getX()).isEqualTo(x );
    assertThat(rover.getLocation().getY()).isEqualTo(y);
    assertThat(rover.getLocation().getDirection()).isEqualTo(Direction.S);
  }

  @Test
  public void should_return_e_when_veer_l_given_rover_direction_is_s() {

    Integer x = 0;
    Integer y = 0;
    Direction direction = Direction.S;
    final Rover rover = new Rover(x, y, direction);
    rover.command(Command.L);

    assertThat(rover.getLocation().getX()).isEqualTo(x );
    assertThat(rover.getLocation().getY()).isEqualTo(y);
    assertThat(rover.getLocation().getDirection()).isEqualTo(Direction.E);

  }

  @Test
  public void should_return_n_when_veer_l_given_rover_direction_is_e() {
    Integer x = 0;
    Integer y = 0;
    Direction direction = Direction.E;
    final Rover rover = new Rover(x, y, direction);
    rover.command(Command.L);

    assertThat(rover.getLocation().getX()).isEqualTo(x );
    assertThat(rover.getLocation().getY()).isEqualTo(y);
    assertThat(rover.getLocation().getDirection()).isEqualTo(Direction.N);
  }

  @Test
  public void return_command_list_when_parsing_command_given_commands() {
    String commands = "MMMLLRRLLL";
    int x = 1;
    int y = 2;
    Direction direction = Direction.E;
    final Rover rover = new Rover(x, y, direction);
    final List<Command> decoding = rover.decoding(commands);
    assertThat(decoding).isEqualTo(Arrays.asList(M, M, M, L, L, R, R, L, L, L));
  }
}
