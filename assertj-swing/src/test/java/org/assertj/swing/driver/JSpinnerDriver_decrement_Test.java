/*
 * Created on Feb 25, 2008
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 * 
 * Copyright @2008-2013 the original author or authors.
 */
package org.assertj.swing.driver;

import org.junit.Test;

/**
 * Tests for {@link JSpinnerDriver#decrement(javax.swing.JSpinner)}.
 * 
 * @author Alex Ruiz
 */
public class JSpinnerDriver_decrement_Test extends JSpinnerDriver_TestCase {
  @Test
  public void should_decrement_value() {
    showWindow();
    updateValue("Sam");
    driver.decrement(spinner);
    assertThatFirstValueIsSelected();
  }

  @Test
  public void should_throw_error_if_JSpinner_is_disabled() {
    disableSpinner();
    thrown.expectIllegalStateIsDisabledComponent();
    driver.decrement(spinner);
  }

  @Test
  public void should_throw_error_if_JSpinner_is_not_showing_on_the_screen() {
    thrown.expectIllegalStateIsNotShowingComponent();
    driver.decrement(spinner);
  }
}