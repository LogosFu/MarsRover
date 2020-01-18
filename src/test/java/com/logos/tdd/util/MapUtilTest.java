package com.logos.tdd.util;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


import com.logos.tdd.map.Location;
import java.util.List;
import java.util.stream.IntStream;
import org.junit.Test;

public class MapUtilTest {

  @Test
  public void should_return_true_when_check_drop_in_gutter_given10000_check() {
    final List<Integer> collect = IntStream.range(1, 100).flatMap(x -> IntStream.range(1, 100)
        .filter(y -> MapUtil.checkDropInGutter(Location.builder().x(x).y(y).build()))).boxed()
        .collect(
            toList());
    assertThat(collect.size()).isGreaterThan(0);
  }
}