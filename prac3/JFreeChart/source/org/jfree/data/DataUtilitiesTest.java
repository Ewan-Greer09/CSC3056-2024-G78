package org.jfree.data;

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

    @Test(expected = NullPointerException.class)
    public void testCalculateColumnTotal_NullDataTable() {
        DataUtilities.calculateColumnTotal(null, 1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testCalculateColumnTotal_InvalidIndexNegative() {
        Values2D values = createValues2DForTest(new double[][]{{1, 2}, {3, 4}});
        DataUtilities.calculateColumnTotal(values, -1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testCalculateColumnTotal_InvalidIndexExceedsColumnCount() {
        Values2D values = createValues2DForTest(new double[][]{{1, 2}, {3, 4}});
        DataUtilities.calculateColumnTotal(values, 2);
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

    @Test(expected = IndexOutOfBoundsException.class)
    public void testCalculateColumnTotal_JustBelowMinimumIndex() {
        Values2D values = createValues2DForTest(new double[][]{{1, 2}, {3, 4}});
        DataUtilities.calculateColumnTotal(values, -1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testCalculateColumnTotal_JustAboveMaximumIndex() {
        Values2D values = createValues2DForTest(new double[][]{{1, 2}, {3, 4}});
        DataUtilities.calculateColumnTotal(values, 2); // Assuming 2 columns, index 2 is out of bounds
    }

    private Values2D createValues2DForTest(double[][] data) {
        DefaultKeyedValues2D v = new DefaultKeyedValues2D();

        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                v.addValue(data[i][j], i, j);
            }
        }

        return v;
    }

    @Test
    public void testCalculateRowTotal_ValidDataMultipleRows() {
        Values2D values = createValues2DForTest(new double[][]{{1, 2, 3}, {4, 5, 6}});
        double result = DataUtilities.calculateRowTotal(values, 1);
        Assert.assertEquals("Sum of row values should match", 7.0, result, 0.0d);
    }

    @Test
    public void testCalculateRowTotal_ValidDataSingleColumn() {
        Values2D values = createValues2DForTest(new double[][]{{1}, {2}, {3}});
        double result = DataUtilities.calculateRowTotal(values, 2); // Am I going insane or should this pass?
        Assert.assertEquals("Sum of row values should match", 3.0, result, 0.0d);
    }

    @Test
    public void testCalculateRowTotal_ValidDataSingleRow() {
        Values2D values = createValues2DForTest(new double[][]{{1, 2, 3}});
        double result = DataUtilities.calculateRowTotal(values, 0);
        Assert.assertEquals("Sum of row values should match", 6.0, result, 0.0d); // This should also pass?
    }

    @Test(expected = NullPointerException.class)
    public void testCalculateRowTotal_NullDataTable() {
        DataUtilities.calculateRowTotal(null, 1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testCalculateRowTotal_InvalidIndexNegative() {
        Values2D values = createValues2DForTest(new double[][]{{1, 2}, {3, 4}});
        DataUtilities.calculateRowTotal(values, -1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testCalculateRowTotal_InvalidIndexExceedsRowCount() {
        Values2D values = createValues2DForTest(new double[][]{{1, 2}, {3, 4}});
        DataUtilities.calculateRowTotal(values, 2);
    }

    @Test
    public void testCalculateRowTotal_MinimumSizeNonEmptyTable() {
        Values2D values = createValues2DForTest(new double[][]{{10}});
        double result = DataUtilities.calculateRowTotal(values, 0);
        Assert.assertEquals("Sum of single value should be value itself", 10.0, result, 0.0d); // should be 10 is giving 0
    }

    @Test
    public void testCalculateRowTotal_MinimumValidIndex() {
        Values2D values = createValues2DForTest(new double[][]{{1, 2}, {3, 4}});
        double result = DataUtilities.calculateRowTotal(values, 0);
        Assert.assertEquals("Sum of first row values should match", 3.0, result, 0.0d); // should be 3 is giving 1
    }

    @Test
    public void testCalculateRowTotal_MaximumValidIndex() {
        Values2D values = createValues2DForTest(new double[][]{{1, 2}, {3, 4}});
        double result = DataUtilities.calculateRowTotal(values, 1);
        Assert.assertEquals("Sum of last row values should match", 7.0, result, 0.0d); // should be 7 is 3
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testCalculateRowTotal_JustBelowMinimumIndex() {
        Values2D values = createValues2DForTest(new double[][]{{1, 2}, {3, 4}});
        DataUtilities.calculateRowTotal(values, -1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testCalculateRowTotal_JustAboveMaximumIndex() {
        Values2D values = createValues2DForTest(new double[][]{{1, 2}, {3, 4}, {5, 6}});
        DataUtilities.calculateRowTotal(values, 2); // value at 2 should not be null, but is being read as null
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

    @Test(expected = IllegalArgumentException.class)
    public void testCreateNumberArray2D_NullOuterArray() {
        DataUtilities.createNumberArray2D(null);
    }

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
        Assert.assertEquals("Cumulative percentage should reflect max value", Double.POSITIVE_INFINITY, result.getValue(0).doubleValue(), 0.00001d);
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

    @Test
    public void testGetCumulativePercentage_PositiveAndNegativeValuesPositiveSum() {
        KeyedValues input = createKeyedValues(new double[]{-5, 10});
        KeyedValues result = DataUtilities.getCumulativePercentages(input);
        Assert.assertEquals("First value cumulative percentage incorrect", -0.5, result.getValue(0).doubleValue(), 0.00001d);
        Assert.assertEquals("Second value cumulative percentage incorrect", 0.5, result.getValue(1).doubleValue(), 0.00001d);
    }

    @Test
    public void testGetCumulativePercentage_PositiveAndNegativeValuesNegativeSum() {
        KeyedValues input = createKeyedValues(new double[]{-10, 5});
        KeyedValues result = DataUtilities.getCumulativePercentages(input);
        // Assertions here will depend on how your implementation handles negative sums
    }

    // Utility method for creating a KeyedValues object with given values
    private KeyedValues createKeyedValues(double[] values) {
        DefaultKeyedValues kv = new DefaultKeyedValues();
        for (int i = 0; i < values.length; i++) {
            kv.addValue("Key" + i, values[i]);
        }
        return kv;
    }
    
    //New tests
    //
    //
    //
    
    @Test(expected = IllegalArgumentException.class)
    public void testGetCumulativePercentages_NullValue() {
		KeyedValues data = null;
		DataUtilities.getCumulativePercentages(data);
    }
    
    
    @Test
    public void testCalculateColumnTotal_NullValues() {
        DefaultKeyedValues2D v = new DefaultKeyedValues2D();

        Double[][] data = new Double[][] { { null, null }, { null, null } };
        
        // insert data into the table, even if it is null
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				v.addValue(data[i][j], i, j);
			}
		}
    	
    	double result = DataUtilities.calculateColumnTotal(v, 0);
    	Assert.assertEquals("Sum of column values should match", 0.0, result, 0.0d);
    }
    
    @Test
    public void testCalculateRowTotal_NullValues() {
        DefaultKeyedValues2D v = new DefaultKeyedValues2D();

        Double[][] data = new Double[][] { { null, null }, { null, null } };
        
        // insert data into the table, even if it is null
        for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				v.addValue(data[i][j], i, j);
			}
		}
                
		double result = DataUtilities.calculateRowTotal(v, 0);
		Assert.assertEquals("Sum of row values should match", 0.0, result, 0.0d);
	}
    
    @Test
    public void TestGetCumulativePercentages_NullValues() {
    	DefaultKeyedValues v = new DefaultKeyedValues();
    	
    	Double[] data = new Double[] { null, null };
    	
    	// insert data into the table, even if it is null
		for (int i = 0; i < data.length; i++) {
			v.addValue("Key" + i, data[i]);
		}
		
		KeyedValues result = DataUtilities.getCumulativePercentages(v);
		Assert.assertEquals("Cumulative percentage should reflect min value", 0.0, result.getValue(0).doubleValue(), 0.00001d);
    }
    
    @Test(expected = IllegalArgumentException.class)
	public void testCreateNumberArray2D_MultipleNullInnerArray() {
        double[][] input = { { 1.0 }, null, { 3.0 }, null };
        DataUtilities.createNumberArray2D(input);
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}