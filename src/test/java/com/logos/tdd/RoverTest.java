package com.logos.tdd;


import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.validateMockitoUsage;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.logos.tdd.headquarters.RoverDropInGutterListener;
import com.logos.tdd.map.Location;
import com.logos.tdd.rover.Rover;
import com.logos.tdd.rover.CommandType;
import com.logos.tdd.map.Direction;
import com.logos.tdd.util.MapUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest({MapUtil.class})
@PowerMockIgnore("javax.management.*")
public class RoverTest {

  @Test
  public void should_return_coordinates_and_direction_when_init_given_rover_with_coordinates_and_direction() {
    int x = 0;
    int y = 0;
    Direction direction = Direction.N;
    final Rover rover = new Rover(x, y, direction, null);
    assertThat(rover.getLocation().getX()).isEqualTo(x);
    assertThat(rover.getLocation().getY()).isEqualTo(y);
    assertThat(rover.getLocation().getDirection()).isEqualTo(direction);
  }

  @Test
  public void should_add_y_when_forward_given_rover_direction_is_n() {
    int x = 0;
    int y = 0;
    Direction direction = Direction.N;
    final Rover rover = new Rover(x, y, direction, null);
    rover.command(CommandType.B);
    rover.command(CommandType.H);
    rover.command(CommandType.M);
    assertThat(rover.getLocation().getX()).isEqualTo(x);
    assertThat(rover.getLocation().getY()).isEqualTo(y + 1);
    assertThat(rover.getLocation().getDirection()).isEqualTo(direction);
  }

  @Test
  public void should_add_x_when_forward_given_rover_direction_is_e() {
    int x = 0;
    int y = 0;
    Direction direction = Direction.E;
    final Rover rover = new Rover(x, y, direction, null);
    rover.command(CommandType.B);
    rover.command(CommandType.H);
    rover.command(CommandType.M);
    assertThat(rover.getLocation().getX()).isEqualTo(x + 1);
    assertThat(rover.getLocation().getY()).isEqualTo(y);
    assertThat(rover.getLocation().getDirection()).isEqualTo(direction);
  }

  @Test
  public void should_sub_y_when_forward_given_rover_direction_is_s() {
    int x = 0;
    int y = 0;
    Direction direction = Direction.S;
    final Rover rover = new Rover(x, y, direction, null);
    rover.command(CommandType.B);
    rover.command(CommandType.H);
    rover.command(CommandType.M);
    assertThat(rover.getLocation().getX()).isEqualTo(x);
    assertThat(rover.getLocation().getY()).isEqualTo(y - 1);
    assertThat(rover.getLocation().getDirection()).isEqualTo(direction);
  }

  @Test
  public void should_sub_x_when_forward_given_rover_direction_is_w() {
    int x = 0;
    int y = 0;
    Direction direction = Direction.W;
    final Rover rover = new Rover(x, y, direction, null);
    rover.command(CommandType.B);
    rover.command(CommandType.H);
    rover.command(CommandType.M);
    assertThat(rover.getLocation().getX()).isEqualTo(x - 1);
    assertThat(rover.getLocation().getY()).isEqualTo(y);
    assertThat(rover.getLocation().getDirection()).isEqualTo(direction);
  }

  @Test
  public void should_return_w_when_veer_l_given_rover_direction_is_n() {
    int x = 0;
    int y = 0;
    Direction direction = Direction.N;
    final Rover rover = new Rover(x, y, direction, null);
    rover.command(CommandType.L);
    assertThat(rover.getLocation().getX()).isEqualTo(x);
    assertThat(rover.getLocation().getY()).isEqualTo(y);
    assertThat(rover.getLocation().getDirection()).isEqualTo(Direction.W);
  }

  @Test
  public void should_return_s_when_veer_l_given_rover_direction_is_w() {
    int x = 0;
    int y = 0;
    Direction direction = Direction.W;
    final Rover rover = new Rover(x, y, direction, null);
    rover.command(CommandType.L);
    assertThat(rover.getLocation().getX()).isEqualTo(x);
    assertThat(rover.getLocation().getY()).isEqualTo(y);
    assertThat(rover.getLocation().getDirection()).isEqualTo(Direction.S);
  }

  @Test
  public void should_return_e_when_veer_l_given_rover_direction_is_s() {
    int x = 0;
    int y = 0;
    Direction direction = Direction.S;
    final Rover rover = new Rover(x, y, direction, null);
    rover.command(CommandType.L);
    assertThat(rover.getLocation().getX()).isEqualTo(x);
    assertThat(rover.getLocation().getY()).isEqualTo(y);
    assertThat(rover.getLocation().getDirection()).isEqualTo(Direction.E);
  }

  @Test
  public void should_return_n_when_veer_l_given_rover_direction_is_e() {
    int x = 0;
    int y = 0;
    Direction direction = Direction.E;
    final Rover rover = new Rover(x, y, direction, null);
    rover.command(CommandType.L);
    assertThat(rover.getLocation().getX()).isEqualTo(x);
    assertThat(rover.getLocation().getY()).isEqualTo(y);
    assertThat(rover.getLocation().getDirection()).isEqualTo(Direction.N);
  }

  @Test
  public void should_return_e_when_veer_r_given_rover_direction_is_n() {
    int x = 0;
    int y = 0;
    Direction direction = Direction.N;
    final Rover rover = new Rover(x, y, direction, null);
    rover.command(CommandType.R);
    assertThat(rover.getLocation().getX()).isEqualTo(x);
    assertThat(rover.getLocation().getY()).isEqualTo(y);
    assertThat(rover.getLocation().getDirection()).isEqualTo(Direction.E);
  }

  @Test
  public void should_return_n_when_veer_r_given_rover_direction_is_w() {
    int x = 0;
    int y = 0;
    Direction direction = Direction.W;
    final Rover rover = new Rover(x, y, direction, null);
    rover.command(CommandType.R);
    assertThat(rover.getLocation().getX()).isEqualTo(x);
    assertThat(rover.getLocation().getY()).isEqualTo(y);
    assertThat(rover.getLocation().getDirection()).isEqualTo(Direction.N);
  }

  @Test
  public void should_return_w_when_veer_r_given_rover_direction_is_s() {
    int x = 0;
    int y = 0;
    Direction direction = Direction.S;
    final Rover rover = new Rover(x, y, direction, null);
    rover.command(CommandType.R);
    assertThat(rover.getLocation().getX()).isEqualTo(x);
    assertThat(rover.getLocation().getY()).isEqualTo(y);
    assertThat(rover.getLocation().getDirection()).isEqualTo(Direction.W);
  }

  @Test
  public void should_return_s_when_veer_r_given_rover_direction_is_e() {
    int x = 0;
    int y = 0;
    Direction direction = Direction.E;
    final Rover rover = new Rover(x, y, direction, null);
    rover.command(CommandType.R);
    assertThat(rover.getLocation().getX()).isEqualTo(x);
    assertThat(rover.getLocation().getY()).isEqualTo(y);
    assertThat(rover.getLocation().getDirection()).isEqualTo(Direction.S);
  }

  @Test
  public void should_return_location_when_send_command_given_command() {
    String commands = "MMMMLLLRRRMMM";
    int x = 0;
    int y = 0;
    Direction direction = Direction.N;
    final Rover rover = new Rover(x, y, direction, null);
    rover.commands(commands);
    assertThat(rover.getLocation().getX()).isEqualTo(x);
    assertThat(rover.getLocation().getY()).isEqualTo(y + 7);
    assertThat(rover.getLocation().getDirection()).isEqualTo(Direction.N);
  }

  @Test
  public void should_sub_y_when_back_given_rover_direction_is_n() {
    int x = 0;
    int y = 0;
    Direction direction = Direction.N;
    final Rover rover = new Rover(x, y, direction, null);
    rover.command(CommandType.B);
    rover.command(CommandType.M);
    assertThat(rover.getLocation().getX()).isEqualTo(x);
    assertThat(rover.getLocation().getY()).isEqualTo(y - 1);
    assertThat(rover.getLocation().getDirection()).isEqualTo(direction);
  }

  @Test
  public void should_sub_x_when_back_given_rover_direction_is_e() {
    int x = 0;
    int y = 0;
    Direction direction = Direction.E;
    final Rover rover = new Rover(x, y, direction, null);
    rover.command(CommandType.B);
    rover.command(CommandType.M);
    assertThat(rover.getLocation().getX()).isEqualTo(x - 1);
    assertThat(rover.getLocation().getY()).isEqualTo(y);
    assertThat(rover.getLocation().getDirection()).isEqualTo(direction);
  }

  @Test
  public void should_add_y_when_back_given_rover_direction_is_s() {
    int x = 0;
    int y = 0;
    Direction direction = Direction.S;
    final Rover rover = new Rover(x, y, direction, null);
    rover.command(CommandType.B);
    rover.command(CommandType.M);
    assertThat(rover.getLocation().getX()).isEqualTo(x);
    assertThat(rover.getLocation().getY()).isEqualTo(y + 1);
    assertThat(rover.getLocation().getDirection()).isEqualTo(direction);
  }

  @Test
  public void should_add_x_when_back_given_rover_direction_is_w() {
    int x = 0;
    int y = 0;
    Direction direction = Direction.W;
    final Rover rover = new Rover(x, y, direction, null);
    rover.command(CommandType.B);
    rover.command(CommandType.M);
    assertThat(rover.getLocation().getX()).isEqualTo(x + 1);
    assertThat(rover.getLocation().getY()).isEqualTo(y);
    assertThat(rover.getLocation().getDirection()).isEqualTo(direction);
  }

  @Test
  public void should_send_drop_in_gutter_message_when_move_given_gutter_front() {

    final RoverDropInGutterListener listener = mock(RoverDropInGutterListener.class);

    int x = 0;
    int y = 0;
    Direction direction = Direction.N;
    final Rover rover = new Rover(x, y, direction, listener);
    PowerMockito.mockStatic(MapUtil.class);
    when(MapUtil.checkDropInGutter(Location.builder().x(x).y(y + 1).direction(direction).build()))
        .thenReturn(false);
    when(MapUtil.checkDropInGutter(Location.builder().x(x).y(y + 2).direction(direction).build()))
        .thenReturn(true);

    rover.commands("MM");
    verify(listener).dropInGutter(Location.builder().x(x).y(y + 2).direction(direction).build());
  }

  @Test
  public void should_do_nothing_when_get_command_given_rover_in_gutter() {

    final RoverDropInGutterListener listener = mock(RoverDropInGutterListener.class);

    int x = 0;
    int y = 0;
    Direction direction = Direction.N;
    final Rover rover = new Rover(x, y, direction, listener);
    PowerMockito.mockStatic(MapUtil.class);
    when(MapUtil.checkDropInGutter(Location.builder().x(x).y(y + 1).direction(direction).build()))
        .thenReturn(false);
    when(MapUtil.checkDropInGutter(Location.builder().x(x).y(y + 2).direction(direction).build()))
        .thenReturn(true);
    rover.commands("MM");
    assertThat(rover.getLocation()).isEqualToComparingFieldByField(
        Location.builder().x(x).y(y + 2).direction(direction).build());
    rover.commands("RRRMMLL");
    assertThat(rover.getLocation()).isEqualToComparingFieldByField(
        Location.builder().x(x).y(y + 2).direction(direction).build());

  }
}
