package org.jfree.data.test;

import org.jfree.data.DataUtilities;
import org.jfree.data.DefaultKeyedValues;
import org.jfree.data.DefaultKeyedValues2D;
import org.jfree.data.KeyedValues;
import org.jfree.data.Values2D;
import org.junit.Assert;
import org.junit.Test;

public class DataUtilitiesTest {

    @Test
    public void testCalculateColumnTotal_ValidDataMultipleRowsAndColumns() {
        Values2D values = createValues2DForTest(new double[][]{{1, 2, 3}, {4, 5, 6}});
        double result = DataUtilities.calculateColumnTotal(values, 1);
        Assert.assertEquals("Sum of column values should match", 7.0, result, 0.0d);
    }

    @Test
    public void testCalculateColumnTotal_ValidDataSingleRow() {
        Values2D values = createValues2DForTest(new double[][]{{1, 2, 3}});
        double result = DataUtilities.calculateColumnTotal(values, 2);
        Assert.assertEquals("Sum of column values should match", 3.0, result, 0.0d);
    }

    @Test
    public void testCalculateColumnTotal_ValidDataSingleColumn() {
        Values2D values = createValues2DForTest(new double[][]{{1}, {4}});
        double result = DataUtilities.calculateColumnTotal(values, 0);
        Assert.assertEquals("Sum of column values should match", 5.0, result, 0.0d);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCalculateColumnTotal_NullDataTable() {
        DataUtilities.calculateColumnTotal(null, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCalculateColumnTotal_InvalidIndexNegative() {
        Values2D values = createValues2DForTest(new double[][]{{1, 2}, {3, 4}});
        DataUtilities.calculateColumnTotal(values, -1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCalculateColumnTotal_InvalidIndexExceedsColumnCount() {
        Values2D values = createValues2DForTest(new double[][]{{1, 2}, {3, 4}, {5, 6}});
        DataUtilities.calculateColumnTotal(values, 2); // Assuming only 2 columns, index 2 is out of bounds
    }

    @Test
    public void testCalculateColumnTotal_MinimumSizeNonEmptyTable() {
        Values2D values = createValues2DForTest(new double[][]{{10}});
        double result = DataUtilities.calculateColumnTotal(values, 0);
        Assert.assertEquals("Sum of single value should be value itself", 10.0, result, 0.0d);
    }

    @Test
    public void testCalculateColumnTotal_MinimumValidIndex() {
        Values2D values = createValues2DForTest(new double[][]{{1, 2}, {3, 4}});
        double result = DataUtilities.calculateColumnTotal(values, 0);
        Assert.assertEquals("Sum of first column values should match", 4.0, result, 0.0d);
    }

    @Test
    public void testCalculateColumnTotal_MaximumValidIndex() {
        Values2D values = createValues2DForTest(new double[][]{{1, 2}, {3, 4}});
        double result = DataUtilities.calculateColumnTotal(values, 1);
        Assert.assertEquals("Sum of last column values should match", 6.0, result, 0.0d);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCalculateColumnTotal_JustBelowMinimumIndex() {
        Values2D values = createValues2DForTest(new double[][]{{1, 2}, {3, 4}});
        DataUtilities.calculateColumnTotal(values, -1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCalculateColumnTotal_JustAboveMaximumIndex() {
        Values2D values = createValues2DForTest(new double[][]{{1, 2}, {3, 4}, {5, 6}});
        DataUtilities.calculateColumnTotal(values, 2); // Assuming 2 columns, index 2 is out of bounds
    }

    // Helper method to create a Values2D instance for testing.
    // This should be replaced with actual instantiation or mocking as per your project setup.
    private Values2D createValues2DForTest(double[][] data) {
    	DefaultKeyedValues2D v = new DefaultKeyedValues2D();
        
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				v.addValue(data[i][j], i, j);
			}
		}
    	
    	Values2D v2d = v; 
        
    	return v2d;
    }
    
    @Test
    public void testCalculateRowTotal_ValidDataMultipleRows() {
        Values2D values = createValues2DForTest(new double[][]{{1, 2, 3}, {4, 5, 6}});
        double result = DataUtilities.calculateRowTotal(values, 1);
        Assert.assertEquals("Sum of row values should match", 15.0, result, 0.0d);
    }

    @Test
    public void testCalculateRowTotal_ValidDataSingleColumn() {
        Values2D values = createValues2DForTest(new double[][]{{1}, {2}, {3}});
        double result = DataUtilities.calculateRowTotal(values, 2);
        Assert.assertEquals("Sum of row values should match", 3.0, result, 0.0d);
    }

    @Test
    public void testCalculateRowTotal_ValidDataSingleRow() {
        Values2D values = createValues2DForTest(new double[][]{{1, 2, 3}});
        double result = DataUtilities.calculateRowTotal(values, 0);
        Assert.assertEquals("Sum of row values should match", 6.0, result, 0.0d);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCalculateRowTotal_NullDataTable() {
        DataUtilities.calculateRowTotal(null, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCalculateRowTotal_InvalidIndexNegative() {
        Values2D values = createValues2DForTest(new double[][]{{1, 2}, {3, 4}});
        DataUtilities.calculateRowTotal(values, -1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCalculateRowTotal_InvalidIndexExceedsRowCount() {
        Values2D values = createValues2DForTest(new double[][]{{1, 2}, {3, 4}});
        DataUtilities.calculateRowTotal(values, 2); // Assuming 2 rows, index 2 is out of bounds
    }

    @Test
    public void testCalculateRowTotal_MinimumSizeNonEmptyTable() {
        Values2D values = createValues2DForTest(new double[][]{{10}});
        double result = DataUtilities.calculateRowTotal(values, 0);
        Assert.assertEquals("Sum of single value should be value itself", 10.0, result, 0.0d);
    }

    @Test
    public void testCalculateRowTotal_MinimumValidIndex() {
        Values2D values = createValues2DForTest(new double[][]{{1, 2}, {3, 4}});
        double result = DataUtilities.calculateRowTotal(values, 0);
        Assert.assertEquals("Sum of first row values should match", 3.0, result, 0.0d);
    }

    @Test
    public void testCalculateRowTotal_MaximumValidIndex() {
        Values2D values = createValues2DForTest(new double[][]{{1, 2}, {3, 4}});
        double result = DataUtilities.calculateRowTotal(values, 1);
        Assert.assertEquals("Sum of last row values should match", 7.0, result, 0.0d);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCalculateRowTotal_JustBelowMinimumIndex() {
        Values2D values = createValues2DForTest(new double[][]{{1, 2}, {3, 4}});
        DataUtilities.calculateRowTotal(values, -1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCalculateRowTotal_JustAboveMaximumIndex() {
        Values2D values = createValues2DForTest(new double[][]{{1, 2}, {3, 4}, {5, 6}});
        DataUtilities.calculateRowTotal(values, 2); // Assuming 2 rows, index 2 is out of bounds
    }

    @Test
    public void testCreateNumberArray_EmptyArray() {
        double[] input = {};
        Number[] expected = new Number[0];
        Number[] actual = DataUtilities.createNumberArray(input);
        Assert.assertArrayEquals("Empty input should result in an empty Number array", expected, actual);
    }

    @Test
    public void testCreateNumberArray_SingleElementMinPositive() {
        double[] input = {Double.MIN_VALUE};
        Number[] expected = {Double.MIN_VALUE};
        Number[] actual = DataUtilities.createNumberArray(input);
        Assert.assertArrayEquals("Single element array with Double.MIN_VALUE should match expected", expected, actual);
    }

    @Test
    public void testCreateNumberArray_SingleElementMaxPositive() {
        double[] input = {Double.MAX_VALUE};
        Number[] expected = {Double.MAX_VALUE};
        Number[] actual = DataUtilities.createNumberArray(input);
        Assert.assertArrayEquals("Single element array with Double.MAX_VALUE should match expected", expected, actual);
    }

    @Test
    public void testCreateNumberArray_SingleElementZero() {
        double[] input = {0};
        Number[] expected = {0};
        Number[] actual = DataUtilities.createNumberArray(input);
        Assert.assertArrayEquals("Single element array with 0 should match expected", expected, actual);
    }

    @Test
    public void testCreateNumberArray_TwoElementsMinAndMinusMin() {
        double[] input = {Double.MIN_VALUE, -Double.MIN_VALUE};
        Number[] expected = {Double.MIN_VALUE, -Double.MIN_VALUE};
        Number[] actual = DataUtilities.createNumberArray(input);
        Assert.assertArrayEquals("Array with Double.MIN_VALUE and -Double.MIN_VALUE should match expected", expected, actual);
    }

    @Test
    public void testCreateNumberArray_TwoElementsMaxAndMinusMax() {
        double[] input = {Double.MAX_VALUE, -Double.MAX_VALUE};
        Number[] expected = {Double.MAX_VALUE, -Double.MAX_VALUE};
        Number[] actual = DataUtilities.createNumberArray(input);
        Assert.assertArrayEquals("Array with Double.MAX_VALUE and -Double.MAX_VALUE should match expected", expected, actual);
    }

    @Test
    public void testCreateNumberArray_SpecialValueNaN() {
        double[] input = {Double.NaN};
        Number[] actual = DataUtilities.createNumberArray(input);
        Assert.assertTrue("Array with Double.NaN should contain NaN", Double.isNaN(actual[0].doubleValue()));
    }

    @Test
    public void testCreateNumberArray_SpecialValuePositiveInfinity() {
        double[] input = {Double.POSITIVE_INFINITY};
        Number[] expected = {Double.POSITIVE_INFINITY};
        Number[] actual = DataUtilities.createNumberArray(input);
        Assert.assertArrayEquals("Array with Double.POSITIVE_INFINITY should match expected", expected, actual);
    }

    @Test
    public void testCreateNumberArray_SpecialValueNegativeInfinity() {
        double[] input = {Double.NEGATIVE_INFINITY};
        Number[] expected = {Double.NEGATIVE_INFINITY};
        Number[] actual = DataUtilities.createNumberArray(input);
        Assert.assertArrayEquals("Array with Double.NEGATIVE_INFINITY should match expected", expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateNumberArray_NullArray() {
        DataUtilities.createNumberArray(null);
    }
    
    @Test
    public void testCreateNumberArray2D_EmptyArray() {
        double[][] input = new double[0][0];
        Number[][] expected = new Number[0][0];
        Number[][] actual = DataUtilities.createNumberArray2D(input);
        Assert.assertArrayEquals("TC1: Expected an empty Number[][] array", expected, actual);
    }

    @Test
    public void testCreateNumberArray2D_SingleElementArray() {
        double[][] input = {{1.0}};
        Number[][] expected = {{1.0}};
        Number[][] actual = DataUtilities.createNumberArray2D(input);
        Assert.assertArrayEquals("TC2: Expected a Number[][] array with one element", expected, actual);
    }

    @Test
    public void testCreateNumberArray2D_RegularArray() {
        double[][] input = {{1.0, 2.0}, {3.0, 4.0}};
        Number[][] expected = {{1.0, 2.0}, {3.0, 4.0}};
        Number[][] actual = DataUtilities.createNumberArray2D(input);
        Assert.assertArrayEquals("TC3: Expected a correctly transformed Number[][] array", expected, actual);
    }

    @Test
    public void testCreateNumberArray2D_JaggedArray() {
        double[][] input = {{1.0}, {2.0, 3.0}};
        Number[][] expected = {{1.0}, {2.0, 3.0}};
        Number[][] actual = DataUtilities.createNumberArray2D(input);
        Assert.assertArrayEquals("TC4: Expected a Number[][] array with varying lengths", expected, actual);
    }

    @Test
    public void testCreateNumberArray2D_SpecialValuesInArray() {
        double[][] input = {{Double.NaN}, {Double.POSITIVE_INFINITY}};
        Number[][] actual = DataUtilities.createNumberArray2D(input);
        Assert.assertTrue("TC5: First element should be NaN", Double.isNaN(actual[0][0].doubleValue()));
        Assert.assertEquals("Second element should be positive infinity", Double.POSITIVE_INFINITY, actual[1][0].doubleValue(), 0.0d);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateNumberArray2D_NullOuterArray() {
        DataUtilities.createNumberArray2D(null);
    }

    // The following test case might need to be adjusted based on the actual behavior of your DataUtilities implementation
    // since JUnit 4 does not directly support a mechanism for expecting an exception for a part of the test method.
    @Test(expected = IllegalArgumentException.class)
    public void testCreateNumberArray2D_NullInnerArray() {
        double[][] input = {{1.0}, null};
        DataUtilities.createNumberArray2D(input);
    }

    @Test
    public void testCreateNumberArray2D_MinimumSizeNonEmptyArray() {
        double[][] input = {{1.0}};
        Number[][] expected = {{1.0}};
        Number[][] actual = DataUtilities.createNumberArray2D(input);
        Assert.assertArrayEquals("BVA1: Expected a Number[][] array with one element", expected, actual);
    }

    @Test
    public void testCreateNumberArray2D_JaggedArrayWithMinimumAndLargerRows() {
        double[][] input = {{1.0}, {1.0, 2.0, 3.0}};
        Number[][] expected = {{1.0}, {1.0, 2.0, 3.0}};
        Number[][] actual = DataUtilities.createNumberArray2D(input);
        Assert.assertArrayEquals("BVA2: Expected a Number[][] array correctly representing the input", expected, actual);
    }

    @Test
    public void testCreateNumberArray2D_ArrayContainingEmptyRows() {
        double[][] input = {{}, {1.0, 2.0}};
        Number[][] expected = {{null}, {1.0, 2.0}}; // Assuming handling of empty inner arrays as {null}
        Number[][] actual = DataUtilities.createNumberArray2D(input);
        Assert.assertArrayEquals("BVA3: Expected a Number[][] array with an empty row and column", expected, actual);
    }
    
    @Test
    public void testGetCumulativePercentage_MinPositiveValue() {
        KeyedValues input = createKeyedValues(new double[]{Double.MIN_VALUE});
        KeyedValues result = DataUtilities.getCumulativePercentages(input);
        Assert.assertEquals("Cumulative percentage should reflect min value", 1.0, result.getValue(0).doubleValue(), 0.00001d);
    }

    @Test
    public void testGetCumulativePercentage_MaxPositiveValue() {
        KeyedValues input = createKeyedValues(new double[]{Double.MAX_VALUE});
        KeyedValues result = DataUtilities.getCumulativePercentages(input);
        Assert.assertEquals("Cumulative percentage should reflect max value", 1.0, result.getValue(0).doubleValue(), 0.00001d);
    }

    @Test
    public void testGetCumulativePercentage_SingleZero() {
        KeyedValues input = createKeyedValues(new double[]{0});
        KeyedValues result = DataUtilities.getCumulativePercentages(input);
        Assert.assertEquals("Cumulative percentage for a single zero should be 0", 0.0, result.getValue(0).doubleValue(), 0.00001d);
    }

    @Test
    public void testGetCumulativePercentage_MixedDatasetWithNaNAndInfinity() {
        KeyedValues input = createKeyedValues(new double[]{Double.NaN, Double.POSITIVE_INFINITY});
        // This test's expectations might vary based on your implementation's handling of NaN and infinity
        // Adjust the assertions based on expected behavior
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetCumulativePercentage_SumOfZero() {
        KeyedValues input = createKeyedValues(new double[]{-5, 5});
        DataUtilities.getCumulativePercentages(input);
        // Expected to throw due to division by zero, or handle according to your implementation
    }

    @Test
    public void testGetCumulativePercentage_PositiveAndNegativeValuesPositiveSum() {
        KeyedValues input = createKeyedValues(new double[]{-5, 10});
        KeyedValues result = DataUtilities.getCumulativePercentages(input);
        Assert.assertEquals("First value cumulative percentage incorrect", 0.33333, result.getValue(0).doubleValue(), 0.00001d);
        Assert.assertEquals("Second value cumulative percentage incorrect", 1.0, result.getValue(1).doubleValue(), 0.00001d);
    }

    @Test
    public void testGetCumulativePercentage_PositiveAndNegativeValuesNegativeSum() {
        KeyedValues input = createKeyedValues(new double[]{-10, 5});
        KeyedValues result = DataUtilities.getCumulativePercentages(input);
        // Assertions here will depend on how your implementation handles negative sums
    }

    // Utility method for creating a KeyedValues object with given values
    private KeyedValues createKeyedValues(double[] values) {
		DefaultKeyedValues v = new DefaultKeyedValues();
		for (int i = 0; i < values.length; i++) {
			v.addValue("Key" + i, values[i]);
		}
		return v;
    }
}