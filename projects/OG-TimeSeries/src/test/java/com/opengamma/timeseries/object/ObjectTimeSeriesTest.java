/**
 * Copyright (C) 2009 - present by OpenGamma Inc. and the OpenGamma group of companies
 *
 * Please see distribution for license.
 */
package com.opengamma.timeseries.object;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;
import static org.testng.AssertJUnit.fail;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Objects;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opengamma.timeseries.ObjectTimeSeries;

/**
 * Abstract test class for {@code ObjectTimeSeries}.
 * 
 * @param <T>  the time type
 * @param <V>  the value type
 */
@Test(groups = "unit")
public abstract class ObjectTimeSeriesTest<T, V> {

  protected abstract ObjectTimeSeries<T, V> createEmptyTimeSeries();

  protected abstract ObjectTimeSeries<T, V> createTimeSeries(T[] times, V[] values);

  protected abstract ObjectTimeSeries<T, V> createTimeSeries(List<T> times, List<V> values);

  protected abstract ObjectTimeSeries<T, V> createTimeSeries(ObjectTimeSeries<T, V> dts);

  protected abstract T[] emptyTimes();

  protected abstract T[] testTimes();

  protected abstract T[] testTimes2();

  protected abstract V[] emptyValues();

  protected abstract V[] testValues();

  public void test_arrayConstructor() {
    ObjectTimeSeries<T, V> dts = createTimeSeries(emptyTimes(), emptyValues());
    assertEquals(0, dts.size());
    T[] times = testTimes();
    V[] values = testValues();
    dts = createTimeSeries(times, values);
    assertEquals(6, dts.size());
    Iterator<V> valuesIter = dts.valuesIterator();
    for (int i = 0; i < values.length; i++) {
      assertTrue(Objects.equals(values[i], valuesIter.next()));
    }
  }

  public void test_listConstructor() {
    ObjectTimeSeries<T, V> dts = createTimeSeries(new ArrayList<T>(), new ArrayList<V>());
    assertEquals(0, dts.size());
    T[] times = testTimes();
    V[] values = testValues();
    List<T> timesList = new ArrayList<T>();
    List<V> valuesList = new ArrayList<V>();
    for (int i = 0; i < times.length; i++) {
      timesList.add(times[i]);
      valuesList.add(values[i]);
    }
    dts = createTimeSeries(timesList, valuesList);
    assertEquals(6, dts.size());
    Iterator<V> valuesIter = dts.valuesIterator();
    for (int i = 0; i < 6; i++) {
      assertTrue(Objects.equals(values[i], valuesIter.next()));
    }
  }

  public void test_timeSeriesConstructor() {
    ObjectTimeSeries<T, V> dts = createEmptyTimeSeries();
    ObjectTimeSeries<T, V> dts2 = createTimeSeries(dts);
    assertEquals(0, dts2.size());
    T[] times = testTimes();
    V[] values = testValues();
    dts = createTimeSeries(times, values);
    dts2 = createTimeSeries(dts);
    assertEquals(6, dts2.size());
    Iterator<V> valuesIter = dts2.valuesIterator();
    for (int i = 0; i < 6; i++) {
      assertTrue(Objects.equals(values[i], valuesIter.next()));
    }
  }

  protected ObjectTimeSeries<T, V> createStandardTimeSeries() {
    T[] times = testTimes();
    V[] values = testValues();
    return createTimeSeries(times, values);
  }

  protected ObjectTimeSeries<T, V> createStandardTimeSeries2() {
    T[] times = testTimes2();
    V[] values = testValues();
    return createTimeSeries(times, values);
  }

  //-------------------------------------------------------------------------
  public void test_head() {
    ObjectTimeSeries<T, V> dts = createStandardTimeSeries();
    ObjectTimeSeries<T, V> head5 = (ObjectTimeSeries<T, V>) dts.head(5);
    Iterator<Entry<T, V>> iterator = head5.iterator();
    for (int i = 0; i < 5; i++) {
      Entry<T, V> entry = iterator.next();
      assertEquals(testTimes()[i], entry.getKey());
      assertEquals(testValues()[i], entry.getValue());
    }
    assertEquals(dts.head(0), createEmptyTimeSeries());
    assertEquals(createEmptyTimeSeries().head(0), createEmptyTimeSeries());
  }

  public void test_tail() {
    ObjectTimeSeries<T, V> dts = createStandardTimeSeries();
    ObjectTimeSeries<T, V> tail5 = (ObjectTimeSeries<T, V>) dts.tail(5);
    Iterator<Entry<T, V>> iterator = tail5.iterator();
    for (int i = 1; i < 6; i++) {
      Entry<T, V> entry = iterator.next();
      assertEquals(testTimes()[i], entry.getKey());
      assertEquals(testValues()[i], entry.getValue());
    }
    assertEquals(dts.tail(0), createEmptyTimeSeries());
    assertEquals(createEmptyTimeSeries().tail(0), createEmptyTimeSeries());
  }

  //-------------------------------------------------------------------------
  public void test_size() {
    ObjectTimeSeries<T, V> dts = createStandardTimeSeries();
    assertEquals(6, dts.size());
    ObjectTimeSeries<T, V> emptyTS = createEmptyTimeSeries();
    assertEquals(0, emptyTS.size());
  }

  public void test_isEmpty() {
    ObjectTimeSeries<T, V> empty = createEmptyTimeSeries();
    ObjectTimeSeries<T, V> dts = createStandardTimeSeries();
    assertTrue(empty.isEmpty());
    assertFalse(dts.isEmpty());
  }

  //-------------------------------------------------------------------------
  public void test_getLatestTime() {
    ObjectTimeSeries<T, V> empty = createEmptyTimeSeries();
    ObjectTimeSeries<T, V> dts = createStandardTimeSeries();
    T[] testDates = testTimes();
    assertEquals(testDates[5], dts.getLatestTime());
    try {
      empty.getLatestTime();
      fail();
    } catch (NoSuchElementException ex) {
      // expected
    }
  }

  public void test_getLatestValue() {
    ObjectTimeSeries<T, V> empty = createEmptyTimeSeries();
    ObjectTimeSeries<T, V> dts = createStandardTimeSeries();
    V[] values = testValues();
    assertEquals(values[values.length - 1], dts.getLatestValue());
    try {
      empty.getLatestValue();
      fail();
    } catch (NoSuchElementException ex) {
      // expected
    }
  }

  public void test_getEarliestTime() {
    ObjectTimeSeries<T, V> empty = createEmptyTimeSeries();
    ObjectTimeSeries<T, V> dts = createStandardTimeSeries();
    T[] testDates = testTimes();
    assertEquals(testDates[0], dts.getEarliestTime());
    try {
      empty.getEarliestTime();
      fail();
    } catch (NoSuchElementException ex) {
      // expected
    }
  }

  public void test_getEarliestValue() {
    ObjectTimeSeries<T, V> empty = createEmptyTimeSeries();
    ObjectTimeSeries<T, V> dts = createStandardTimeSeries();
    V[] values = testValues();
    assertEquals(values[0], dts.getEarliestValue());
    try {
      empty.getEarliestValue();
      fail();
    } catch (NoSuchElementException ex) {
      // expected
    }
  }

  //-------------------------------------------------------------------------
  public void test_valuesIterator() {
    Iterator<V> emptyValuesIter = createEmptyTimeSeries().valuesIterator();
    Iterator<V> dtsValuesIter = createStandardTimeSeries().valuesIterator();
    V[] values = testValues();
    for (int i = 0; i < 6; i++) {
      assertTrue(dtsValuesIter.hasNext());
      V val = dtsValuesIter.next();
      assertEquals(values[i], val);
    }
    try {
      dtsValuesIter.next();
    } catch (NoSuchElementException nsee) {
      assertFalse(emptyValuesIter.hasNext());
      try {
        emptyValuesIter.next();
        fail();
      } catch (NoSuchElementException nsuchee) {
        // expected
      }
    }
  }

  public void test_timeIterator() {
    Iterator<T> emptyTimesIter = createEmptyTimeSeries().timeIterator();
    Iterator<T> dtsTimesIter = createStandardTimeSeries().timeIterator();
    T[] testDates = testTimes();
    for (int i = 0; i < 6; i++) {
      assertTrue(dtsTimesIter.hasNext());
      T time = dtsTimesIter.next();
      assertEquals(testDates[i], time);
    }
    try {
      dtsTimesIter.next();
    } catch (NoSuchElementException nsee) {
      assertFalse(emptyTimesIter.hasNext());
      try {
        emptyTimesIter.next();
        fail();
      } catch (NoSuchElementException nsuchee) {
        // expected
      }
    }
  }

  public void test_iterator() {
    Iterator<Entry<T, V>> emptyIter = createEmptyTimeSeries().iterator();
    Iterator<Entry<T, V>> dtsIter = createStandardTimeSeries().iterator();
    T[] testDates = testTimes();
    V[] testValues = testValues();
    for (int i = 0; i < 6; i++) {
      assertTrue(dtsIter.hasNext());
      Entry<T, V> entry = dtsIter.next();
      T time = entry.getKey();
      assertEquals(entry.getValue(), testValues[i]);
      assertEquals(testDates[i], time);
    }
    try {
      dtsIter.next();
    } catch (NoSuchElementException nsee) {
      assertFalse(emptyIter.hasNext());
      try {
        emptyIter.next();
        fail();
      } catch (NoSuchElementException nsuchee) {
        // expected
      }
    }
  }

  //-------------------------------------------------------------------------
  @Test(expectedExceptions = IndexOutOfBoundsException.class)
  public void test_getDataPoint() {
    ObjectTimeSeries<T, V> emptyTS = createEmptyTimeSeries();
    ObjectTimeSeries<T, V> dts = createStandardTimeSeries();
    T[] testDates = testTimes();
    V[] testValues = testValues();
    for (int i = 0; i < 6; i++) {
      V val = dts.getValue(testDates[i]);
      assertEquals(val, testValues[i]);
      val = dts.getValueAtIndex(i);
      assertEquals(val, testValues[i]);
    }
    emptyTS.getValueAtIndex(0);
  }

  @DataProvider(name = "subSeries")
  Object[][] data_subSeries() {
    return new Object[][] {
        //        {0, true, 4, false, 4, 0},
        //        {0, true, 4, true, 5, 0},
        //        {0, false, 4, false, 3, 1},
        //        {0, false, 4, true, 4, 1},
        //        
        //        {4, true, 5, false, 1, 4},
        //        {4, true, 5, true, 2, 4},
        //        {4, false, 5, false, 0, -1},
        //        {4, false, 5, true, 1, 5},
        //        
        //        {4, true, 4, false, 0, -1},
        //        {4, true, 4, true, 1, 4},
        {4, false, 4, false, 0, -1 },  // matches TreeMap definition
        {4, false, 4, true, 0, -1 },
    };
  }

  @SuppressWarnings("cast")
  @Test(dataProvider = "subSeries")
  public void test_subSeriesInstantProviderInstantProvider(int startIndex, boolean startInclude, int endIndex, boolean endInclude, int expectedSize, int expectedFirstIndex) {
    ObjectTimeSeries<T, V> dts = createStandardTimeSeries();
    T[] testDates = testTimes();
    V[] testValues = testValues();
    ObjectTimeSeries<T, V> threeToFive = dts.subSeries(testDates[3], testDates[5]);
    assertEquals(2, threeToFive.size());
    Iterator<Entry<T, V>> iterator = threeToFive.iterator();
    for (int i = 3; i < 5; i++) {
      Entry<T, V> item = iterator.next();
      assertEquals(testDates[i], item.getKey());
      assertEquals(testValues[i], item.getValue());
    }
    ObjectTimeSeries<T, V> sub = dts.subSeries(testDates[startIndex], startInclude, testDates[endIndex], endInclude);
    assertEquals(expectedSize, sub.size());
    if (expectedFirstIndex >= 0) {
      assertEquals(testDates[expectedFirstIndex], sub.getTimeAtIndex(0));
    }
    if (startInclude && endInclude == false) {
      sub = dts.subSeries(testDates[startIndex], testDates[endIndex]);
      assertEquals(expectedSize, sub.size());
      if (expectedFirstIndex >= 0) {
        assertEquals(testDates[expectedFirstIndex], sub.getTimeAtIndex(0));
      }
    }
  }

  public void test_hashCode() {
    assertEquals(createStandardTimeSeries().hashCode(), createStandardTimeSeries().hashCode());
    assertEquals(createEmptyTimeSeries().hashCode(), createEmptyTimeSeries().hashCode());
  }

  public void test_equals() {
    assertEquals(createStandardTimeSeries(), createStandardTimeSeries());
    assertFalse(createStandardTimeSeries().equals(createEmptyTimeSeries()));
    assertFalse(createEmptyTimeSeries().equals(createStandardTimeSeries()));
    assertEquals(createEmptyTimeSeries(), createEmptyTimeSeries());
  }

  //-------------------------------------------------------------------------
//  @Test
//  public void test_noIntersectionOperation() {
//    ObjectTimeSeries<T, V> dts = createStandardTimeSeries();
//    ObjectTimeSeries<T, V> dts2 = createStandardTimeSeries2();
//    ObjectTimeSeries<T, V> ets = createEmptyTimeSeries();
//    assertEquals(dts, ets.noIntersectionOperation(dts));
//    assertEquals(dts, dts.noIntersectionOperation(ets));
//    try {
//      dts.noIntersectionOperation(dts2);
//      fail("Should have failed");
//    } catch (IllegalStateException ex) {
//      //do nothing - expected exception because the two timeseries have overlapping dates which will require intersection operation
//    }
//    ObjectTimeSeries<T, V> dts3 = dts2.subSeries(dts.getLatestTime(), false, dts2.getLatestTime(), false);
//    ObjectTimeSeries<T, V> noIntersecOp = dts.noIntersectionOperation(dts3);
//    assertEquals(dts.getValueAtIndex(0), noIntersecOp.getValueAtIndex(0));
//    assertEquals(dts.getValueAtIndex(1), noIntersecOp.getValueAtIndex(1));
//    assertEquals(dts.getValueAtIndex(2), noIntersecOp.getValueAtIndex(2));
//    assertEquals(dts.getValueAtIndex(3), noIntersecOp.getValueAtIndex(3));
//    assertEquals(dts.getValueAtIndex(4), noIntersecOp.getValueAtIndex(4));
//    assertEquals(dts.getValueAtIndex(5), noIntersecOp.getValueAtIndex(5));
//    assertEquals(dts3.getValueAtIndex(0), noIntersecOp.getValueAtIndex(6));
//    assertEquals(dts3.getValueAtIndex(1), noIntersecOp.getValueAtIndex(7));
//  }

  @Test
  public void test_intersectionFirstValue() {
    ObjectTimeSeries<T, V> dts = createStandardTimeSeries();
    ObjectTimeSeries<T, V> dts2 = createStandardTimeSeries2();
    ObjectTimeSeries<T, V> ets = createEmptyTimeSeries();
    assertEquals(ets, ets.intersectionFirstValue(dts));
    assertEquals(ets, dts.intersectionFirstValue(ets));
    
    ObjectTimeSeries<T, V> result = dts.intersectionFirstValue(dts2);
    assertEquals(3, result.size());
    assertEquals(Double.valueOf(4.0), result.getValueAtIndex(0));
    assertEquals(Double.valueOf(5.0), result.getValueAtIndex(1));
    assertEquals(Double.valueOf(6.0), result.getValueAtIndex(2));
    assertEquals(dts.getTimeAtIndex(3), result.getTimeAtIndex(0));
    assertEquals(dts.getTimeAtIndex(4), result.getTimeAtIndex(1));
    assertEquals(dts.getTimeAtIndex(5), result.getTimeAtIndex(2));
  }

}
