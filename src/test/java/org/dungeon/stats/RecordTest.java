/*
 * Copyright (C) 2015 Bernardo Sulzbach
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.dungeon.stats;

import static org.junit.Assert.*;

import org.dungeon.stats.Record.Type;

import org.junit.Test;

public class RecordTest {

  @Test
  public void testUpdate() throws Exception {
    Record maximumRecord = new Record(Type.MAXIMUM);
    assertNull(maximumRecord.getValue());
    assertEquals("N/A", maximumRecord.toString());
    maximumRecord.update(1);
    assertTrue(maximumRecord.getValue().equals(1));
    assertEquals("1", maximumRecord.toString());
    maximumRecord.update(0); // An update that does not change the Record.
    assertTrue(maximumRecord.getValue().equals(1));
    assertEquals("1", maximumRecord.toString());
    maximumRecord.update(2); // An update that changes the Record.
    assertTrue(maximumRecord.getValue().equals(2));
    assertEquals("2", maximumRecord.toString());

    Record minimumRecord = new Record(Type.MINIMUM);
    assertNull(minimumRecord.getValue());
    assertEquals("N/A", minimumRecord.toString());
    minimumRecord.update(1);
    assertTrue(minimumRecord.getValue().equals(1));
    assertEquals("1", minimumRecord.toString());
    minimumRecord.update(0); // An update that changes the Record.
    assertTrue(minimumRecord.getValue().equals(0));
    assertEquals("0", minimumRecord.toString());
    minimumRecord.update(2); // An update that does not change the Record.
    assertTrue(minimumRecord.getValue().equals(0));
    assertEquals("0", minimumRecord.toString());
  }

}