/*
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 *
 * Copyright @2008-2010 the original author or authors.
 */

package org.assertj.swing.jide.grids;

import org.assertj.core.api.Fail;

import java.util.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Utility methods for tables when using FEST..
 * @author Peter Murray
 */
class AssertJSwingTableUtil {

  static void requireSelection(int[] expectedRows, int[] selectedRows) {
    assertEquals("The number of expected selected expectedRows do not match",
                 expectedRows.length,
                 selectedRows.length);

    Set<Integer> requiredRows = new HashSet<Integer>(expectedRows.length);
    for (int row : expectedRows) {
      requiredRows.add(row);
    }

    for (int row : selectedRows) {
      if (!requiredRows.remove(new Integer(row))) {
        Fail.fail("A row is selected that was not expected to be selected,  " + row);
      }
    }

    assertTrue("There are required row selections that are not selected, ["
               + getContents(requiredRows) + "]",
               requiredRows.isEmpty());
  }

  static String getContents(Collection c) {
    StringBuilder sb = new StringBuilder();
    for (Iterator it = c.iterator(); it.hasNext();) {
      sb.append(it.next());
      if (it.hasNext()) {
        sb.append(", ");
      }
    }
    return sb.toString();
  }
}