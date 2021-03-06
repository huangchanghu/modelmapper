package org.modelmapper.internal;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

import org.modelmapper.config.Configuration.AccessLevel;
import org.testng.annotations.Test;

/**
 * @author Jonathan Halterman
 */
@Test
public class InheritingConfigurationTest {
  public void testHashCode() {
    InheritingConfiguration config1 = new InheritingConfiguration();
    InheritingConfiguration config2 = new InheritingConfiguration();

    assertEquals(config1.hashCode(), config2.hashCode());
    config1.enableFieldMatching(true);
    assertFalse(config1.hashCode() == config2.hashCode());
    config2.enableFieldMatching(true);
    assertEquals(config1.hashCode(), config2.hashCode());
    config2.setMethodAccessLevel(AccessLevel.PRIVATE);
    assertFalse(config1.hashCode() == config2.hashCode());
  }

  // public void shouldMergeInheritedConfiguration() {
  // ModelMapper modelMapper = new ModelMapper();
  // MatchingConfiguration modelMapperConfig = modelMapper.getConfiguration();
  // MatchingConfiguration personMapConfig = modelMapper.getTypeMap(Object.class, String.class)
  // .getConfiguration();
  //
  // modelMapperConfig.setFieldAccessLevel(AccessLevel.Private);
  // assertEquals(modelMapperConfig.getFieldAccessLevel(), personMapConfig.getFieldAccessLevel());
  //
  // personMapConfig.setFieldAccessLevel(AccessLevel.Public);
  // assertFalse(modelMapperConfig.getFieldAccessLevel().equals(
  // personMapConfig.getFieldAccessLevel()));
  // }

  public void testEquals() {
    InheritingConfiguration config1 = new InheritingConfiguration();
    InheritingConfiguration config2 = new InheritingConfiguration();

    assertEquals(config1, config2);
    config1.enableFieldMatching(true);
    assertFalse(config1.equals(config2));
    config2.enableFieldMatching(true);
    assertEquals(config1, config2);
    config2.setMethodAccessLevel(AccessLevel.PRIVATE);
    assertFalse(config1.equals(config2));
  }
}
