package com.logos.tdd.headquarters;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.logos.tdd.map.Direction;
import com.logos.tdd.map.Location;
import com.logos.tdd.rover.Rover;
import com.logos.tdd.util.MapUtil;
import java.util.ArrayList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest({MapUtil.class})
@PowerMockIgnore("javax.management.*")
public class HeadquarterTest {

  @Test
  public void should_send_new_rover_when_receive_rover_in_gutter_given_headquarters_get_rover_in_gutter() {
    final Headquarter headquarter = new Headquarter();
    int x = 0;
    int y = 0;
    Direction direction = Direction.N;
    final Rover rover = new Rover(x, y, direction, headquarter, new ArrayList<>());
    PowerMockito.mockStatic(MapUtil.class);
    when(MapUtil.checkDropInGutter(Location.builder().x(x).y(y + 1).direction(direction).build()))
        .thenReturn(false);
    when(MapUtil.checkDropInGutter(Location.builder().x(x).y(y + 2).direction(direction).build()))
        .thenReturn(true);
    headquarter.setCurrentRover(rover);
    headquarter.sendCommands("MM");
    assertThat(headquarter.getCurrentRover().hashCode()).isNotEqualTo(rover.hashCode());
  }

}