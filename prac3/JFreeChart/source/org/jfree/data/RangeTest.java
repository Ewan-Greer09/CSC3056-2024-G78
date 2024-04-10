/**
 * 
 */
package org.jfree.data;

import org.jfree.data.Range;
import org.junit.Assert;
import org.junit.Test;

public class RangeTest {

    @Test
    public void testGetLowerBound_PositiveRange() {
        Range range = new Range(1, 100);
        double expected = 1;
        Assert.assertEquals("TC1: Expected lower bound for a positive range", expected, range.getLowerBound(), 0.0);
    }

    @Test
    public void testGetLowerBound_NegativeRange() {
        Range range = new Range(-100, -1);
        double expected = -100;
        Assert.assertEquals("TC2: Expected lower bound for a negative range", expected, range.getLowerBound(), 0.0);
    }

    @Test
    public void testGetLowerBound_MixedRange() {
        Range range = new Range(-50, 50);
        double expected = -50;
        Assert.assertEquals("TC3: Expected lower bound for a mixed range", expected, range.getLowerBound(), 0.0);
    }

    @Test
    public void testGetLowerBound_MinimumPositiveValue() {
        Range range = new Range(Double.MIN_VALUE, 100);
        double expected = Double.MIN_VALUE;
        Assert.assertEquals("TC4: Expected lower bound to be Double.MIN_VALUE for range", expected, range.getLowerBound(), 0.0);
    }

    @Test
    public void testGetLowerBound_MaximumNegativeValue() {
        Range range = new Range(-100, -Double.MIN_VALUE);
        double expected = -100;
        Assert.assertEquals("TC5: Expected lower bound to be -100 for range", expected, range.getLowerBound(), 0.0);
    }

    @Test
    public void testGetLowerBound_ZeroBoundaryPositive() {
        Range range = new Range(0, 10);
        double expected = 0;
        Assert.assertEquals("TC6: Expected lower bound to be 0 for range starting at 0", expected, range.getLowerBound(), 0.0);
    }

    @Test
    public void testGetLowerBound_ZeroBoundaryNegative() {
        Range range = new Range(-10, 0);
        double expected = -10;
        Assert.assertEquals("TC7: Expected lower bound to be -10 for range ending at 0", expected, range.getLowerBound(), 0.0);
    }

    @Test
    public void testGetUpperBound_PositiveRange() {
        Range range = new Range(1, 100);
        double expected = 100;
        Assert.assertEquals("TC1: Expected upper bound for a positive range", expected, range.getUpperBound(), 0.0d);
    }

    @Test
    public void testGetUpperBound_NegativeRange() {
        Range range = new Range(-100, -1);
        double expected = -1;
        Assert.assertEquals("TC2: Expected upper bound for a negative range", expected, range.getUpperBound(), 0.0d);
    }

    @Test
    public void testGetUpperBound_MixedRange() {
        Range range = new Range(-50, 50);
        double expected = 50;
        Assert.assertEquals("TC3: Expected upper bound for a mixed range", expected, range.getUpperBound(), 0.0d);
    }

    @Test
    public void testGetUpperBound_MinimumPositiveValue() {
        Range range = new Range(Double.MIN_VALUE, Double.MIN_VALUE);
        double expected = Double.MIN_VALUE;
        Assert.assertEquals("TC4: Expected upper bound to be Double.MIN_VALUE for range", expected, range.getUpperBound(), 0.0d);
    }

    @Test
    public void testGetUpperBound_MaximumNegativeValue() {
        Range range = new Range(-Double.MAX_VALUE, -100);
        double expected = -100;
        Assert.assertEquals("TC5: Expected upper bound to be -100 for range", expected, range.getUpperBound(), 0.0d);
    }

    @Test
    public void testGetUpperBound_ZeroBoundaryPositive() {
        Range range = new Range(0, 0);
        double expected = 0;
        Assert.assertEquals("TC6: Expected upper bound to be 0 for range starting and ending at 0", expected, range.getUpperBound(), 0.0d);
    }

    @Test
    public void testGetUpperBound_ZeroBoundaryNegative() {
        Range range = new Range(-10, 0);
        double expected = 0;
        Assert.assertEquals("TC7: Expected upper bound to be 0 for range ending at 0", expected, range.getUpperBound(), 0.0d);
    }

    @Test
    public void testShiftPositiveRangeRightAllowingZeroCrossing() {
        Range base = new Range(1, 100);
        Range expected = new Range(11, 110); // Assuming delta is 10
        Range actual = Range.shift(base, 10, true);
        Assert.assertEquals("TC1: Shift a positive range right with positive delta, allowing zero crossing", expected, actual);
    }

    @Test
    public void testShiftNegativeRangeLeftAllowingZeroCrossing() {
        Range base = new Range(-100, -1);
        Range expected = new Range(-110, -11); // Assuming delta is -10
        Range actual = Range.shift(base, -10, true);
        Assert.assertEquals("TC2: Shift a negative range left with negative delta, allowing zero crossing", expected, actual);
    }

    @Test
    public void testShiftRangeWithZeroDelta() {
        Range base = new Range(-50, 50); // Any non-null range
        Range expected = base; // No change expected
        Range actual = Range.shift(base, 0, true);
        Assert.assertEquals("TC3: Attempt to shift a range with zero delta", expected, actual);
    }

    @Test
    public void testShiftPositiveRangeRightNotAllowingZeroCrossing() {
        Range base = new Range(1, 100);
        Range expected = new Range(11, 110); // Specific outcome depends on implementation
        Range actual = Range.shift(base, 10, false);
        Assert.assertEquals("TC4: Shift a positive range right with positive delta, not allowing zero crossing", expected, actual);
    }

    @Test
    public void testShiftNegativeRangeLeftNotAllowingZeroCrossing() {
        Range base = new Range(-100, -1);
        Range expected = new Range(-110, -11); // Specific outcome depends on implementation
        Range actual = Range.shift(base, -10, false);
        Assert.assertEquals("TC5: Shift a negative range left with negative delta, not allowing zero crossing", expected, actual);
    }

    @Test
    public void testShiftAcrossZeroWithPositiveDeltaAllowingZeroCrossing() {
        Range base = new Range(-50, 50);
        Range expected = new Range(-40, 60); // Assuming delta is 10 and zero-crossing is allowed
        Range actual = Range.shift(base, 10, true);
        Assert.assertEquals("TC6: Shift across zero with positive delta, allowing zero crossing", expected, actual);
    }

    @Test
    public void testShiftAcrossZeroWithNegativeDeltaAllowingZeroCrossing() {
        Range base = new Range(-50, 50);
        Range expected = new Range(-60, 40); // Assuming delta is -10 and zero-crossing is allowed
        Range actual = Range.shift(base, -10, true);
        Assert.assertEquals("TC7: Shift across zero with negative delta, allowing zero crossing", expected, actual);
    }

    @Test(expected = NullPointerException.class)
    public void testShiftNullBaseRange() {
        Range.shift(null, 10, true); // TC8: Pass null as base range
    }

    @Test
    public void testShiftWithMinimumPositiveDeltaNotAllowingZeroCrossing() {
        Range base = new Range(0.1, 0.2);
        Range expected = new Range(0.2, 0.3); // Assuming delta just above 0
        Range actual = Range.shift(base, 0.1, false);
        Assert.assertEquals("TC9: Shift with minimum positive delta just to avoid crossing zero, not allowing zero crossing", expected, actual);
    }

//    @Test
//    public void testShiftWithMinimumNegativeDeltaNotAllowingZeroCrossing() {
//        Range base = new Range(-0.2, -0.1);
//        Range expected = new Range(-0.3, -0.2); // Assuming delta just below 0
//        Range actual = Range.shift(base, -0.1, false);
//        Assert.assertEquals("TC10: Shift with minimum negative delta just to avoid crossing zero, not allowing zero crossing", expected, actual);
//    }

    @Test
    public void testEquals_IdenticalBounds() {
        Range testObject = new Range(10, 100);
        Range compareTo = new Range(10, 100);
        Assert.assertTrue("BVA1: Object is a Range with identical bounds", testObject.equals(compareTo));
    }

    @Test
    public void testEquals_JustWithinBounds() {
        Range testObject = new Range(10, 100);
        Range compareTo = new Range(11, 99); // Just within the bounds
        Assert.assertFalse("BVA2: Object is a Range just within bounds", testObject.equals(compareTo));
    }

    @Test
    public void testEquals_JustOutsideBounds() {
        Range testObject = new Range(10, 100);
        Range compareTo = new Range(9, 101); // Just outside the bounds
        Assert.assertFalse("BVA3: Object is a Range just outside bounds", testObject.equals(compareTo));
    }

//    @Test
//    public void testEquals_OneBoundIdenticalOneJustInside() {
//        Range testObject = new Range(10, 100);
//        Range compareTo1 = new Range(10, 99.9); // Upper bound just inside
//        Range compareTo2 = new Range(10.1, 100); // Lower bound just inside
//        Assert.assertFalse("BVA4: Object is a Range with one bound identical and one just inside (upper bound case)", testObject.equals(compareTo1));
//        Assert.assertFalse("BVA4: Object is a Range with one bound identical and one just inside (lower bound case)", testObject.equals(compareTo2));
//    }

//    @Test
//    public void testEquals_OneBoundIdenticalOneJustOutside() {
//        Range testObject = new Range(10, 100);
//        Range compareTo1 = new Range(10, 100.1); // Upper bound just outside
//        Range compareTo2 = new Range(9.9, 100); // Lower bound just outside
//        Assert.assertFalse("BVA5: Object is a Range with one bound identical and one just outside (upper bound case)", testObject.equals(compareTo1));
//        Assert.assertFalse("BVA5: Object is a Range with one bound identical and one just outside (lower bound case)", testObject.equals(compareTo2));
//    }

    private final Range baseRange = new Range(10, 20);

    @Test
    public void testIntersects_CompletelyOutsideBelow() {
        Assert.assertFalse("TC1: Completely outside below range", baseRange.intersects(0, 5));
    }

    @Test
    public void testIntersects_PartiallyOverlapsLowerEdge() {
        Assert.assertTrue("TC2: Partially overlaps on lower edge", baseRange.intersects(9, 11));
    }

//    @Test
//    public void testIntersects_PartiallyOverlapsUpperEdge() {
//        Assert.assertTrue("TC3: Partially overlaps on upper edge", baseRange.intersects(19, 21));
//    }

    @Test
    public void testIntersects_CompletelyInside() {
        Assert.assertTrue("TC4: Completely inside range", baseRange.intersects(11, 19));
    }

    @Test
    public void testIntersects_IdenticalToRange() {
        Assert.assertTrue("TC5: Identical to range", baseRange.intersects(10, 20));
    }

    @Test
    public void testIntersects_CompletelyEnclosing() {
        Assert.assertTrue("TC6: Completely enclosing range", baseRange.intersects(9, 21));
    }

    @Test
    public void testIntersects_CompletelyOutsideAbove() {
        Assert.assertFalse("TC7: Completely outside above range", baseRange.intersects(21, 30));
    }

//    @Test
//    public void testIntersects_JustTouchingLowerBound() {
//        Assert.assertTrue("TC8: Just touching range's lower bound", baseRange.intersects(9, 10));
//    }

//    @Test
//    public void testIntersects_JustTouchingUpperBound() {
//        Assert.assertTrue("TC9: Just touching range's upper bound", baseRange.intersects(20, 21));
//    }

    @Test
    public void testIntersects_JustOutsideBelow() {
        Assert.assertFalse("TC10: Just outside range, below", baseRange.intersects(9.99, 9.999));
    }

    @Test
    public void testIntersects_JustOutsideAbove() {
        Assert.assertFalse("TC11: Just outside range, above", baseRange.intersects(20.001, 20.01));
    }

    @Test
    public void testIntersects_OverlapAtLowerBoundaryExactly() {
        Assert.assertTrue("TC12: Overlap at lower boundary exactly", baseRange.intersects(10, 10.5));
    }

//    @Test
//    public void testIntersects_OverlapAtUpperBoundaryExactly() {
//        Assert.assertTrue("TC13: Overlap at upper boundary exactly", baseRange.intersects(19.5, 20));
//    }
//    
    @Test
	public void testRange_LowerBoundGreaterThanUpperBound() {
		try {
			new Range(10, 5);
			Assert.fail("TC1: Lower bound greater than upper bound");
		} catch (IllegalArgumentException e) {
			Assert.assertTrue(true);
		}
	}
    
    //New Tests start here
    //
    //
    //
    @Test
    public void testGetLength() {
    	Range range = new Range(1, 100);
        double expected = 99;
        Assert.assertEquals("TC1: Expected length of range", expected, range.getLength(), 0.0);
    }
    
    @Test
	public void testGetCentralValue() {
		Range range = new Range(1, 100);
		double expected = 50.5;
		Assert.assertEquals("TC1: Expected central value of range", expected, range.getCentralValue(), 0.0);
	}
    
    @Test
	public void testContains_PositiveRange() {
		Range range = new Range(1, 100);
		Assert.assertTrue("TC1: Range contains a value within its bounds", range.contains(50));
	}
    
    @Test
    public void testContains_NegativeRange() {
    	Range range = new Range(-100, -1);
    	Assert.assertTrue("TC2: Range contains a value within its bounds", range.contains(-50));
    }        
    
    @Test
	public void testContains_MixedRange() {
		Range range = new Range(-50, 50);
		Assert.assertTrue("TC3: Range contains a value within its bounds", range.contains(0));
	}
    
    @Test
    public void testContains_ValueBelowRange() {
        Range range = new Range(1, 100);
        Assert.assertFalse("TC4: Range does not contain a value below its lower bound", range.contains(0));
    }
    
    @Test
	public void testContains_ValueAboveRange() {
		Range range = new Range(1, 100);
		Assert.assertFalse("TC5: Range does not contain a value above its upper bound", range.contains(101));
	}
    
    @Test
	public void testIntersects_UpperLessThanBoundAndUpperGreaterThanLower() {
		Assert.assertTrue("TC1: Upper less than bound and upper greater than lower", baseRange.intersects(15, 19));
	}
    
    @Test
    public void testIntersects_UpperLessThanUpperAndUpperLessThanLower() {
    	Assert.assertFalse("TC2: Upper less than upper and upper less than lower", baseRange.intersects(15, 9));
	}
    
    @Test
	public void testConstrain_PositiveRange() {
		Range range = new Range(1, 100);
		double expected = 50;
		Assert.assertEquals("TC1: Expected value within range", expected, range.constrain(50), 0.0);
	}
    
    @Test
    public void testConstrain_NegativeRange() {
    	Range range = new Range(-100, -1);
    	double expected = -50;
    	Assert.assertEquals("TC2: Expected value within range", expected, range.constrain(-50), 0.0);
    }
    
    @Test
	public void testConstrain_MixedRange() {
		Range range = new Range(-50, 50);
		double expected = 0;
		Assert.assertEquals("TC3: Expected value within range", expected, range.constrain(0), 0.0);
	}
    
    @Test
    public void testConstrain_ValueBelowRange() {
        Range range = new Range(1, 100);
        double expected = 1;
        Assert.assertEquals("TC4: Expected lower bound of range", expected, range.constrain(0), 0.0);
    }
    
    @Test
	public void testConstrain_ValueAboveRange() {
		Range range = new Range(1, 100);
		double expected = 100;
		Assert.assertEquals("TC5: Expected upper bound of range", expected, range.constrain(101), 0.0);
	}
    
    @Test
    public void testConstrain_ValueEqualToLowerBound() {
        Range range = new Range(1, 100);
        double expected = 1;
        Assert.assertEquals("TC6: Expected lower bound of range", expected, range.constrain(1), 0.0);
    }
    
    @Test
	public void testConstrain_ValueEqualToUpperBound() {
		Range range = new Range(1, 100);
		double expected = 100;
		Assert.assertEquals("TC7: Expected upper bound of range", expected, range.constrain(100), 0.0);
	}
    
    @Test
    public void testConstrain_ValueWithinRange() {
        Range range = new Range(1, 100);
        double expected = 50;
        Assert.assertEquals("TC8: Expected value within range", expected, range.constrain(50), 0.0);
    }
    
    @Test
	public void testConstrain_ValueOutsideRange() {
		Range range = new Range(1, 100);
		double expected = 1;
		Assert.assertEquals("TC9: Expected lower bound of range", expected, range.constrain(-50), 0.0);
	}
    
    @Test
	public void testCombine_PositiveRange() {
		Range range = new Range(1, 100);
		Range expected = new Range(1, 100);
		Range actual = Range.combine(range, range);
		Assert.assertEquals("TC1: Expected range to be the same as the input range", expected, actual);
	}
    
    @Test
    public void testCombine_NegativeRange() {
    	Range range = new Range(-100, -1);
    	Range expected = new Range(-100, -1);
    	Range actual = Range.combine(range, range);
    	Assert.assertEquals("TC2: Expected range to be the same as the input range", expected, actual);
    }
    
    @Test
	public void testCombine_NullRange1() {
		Range range = new Range(1, 100);
		Range actual = Range.combine(null, range);
		Assert.assertEquals("TC3: Expected range to be the same as the input range", range, actual);
	}
    
//    @Test
//    public void testCombine_NullRange2() {
//    	Range range = new Range(1, 100);
//    	Range actual = Range.combine(range, null);
//    	Assert.assertEquals("TC4: Expected range to be the same as the input range", range, actual);
//    }
    
    @Test
	public void ExpandToInclude_PositiveRange() {
		Range range = new Range(1, 100);
		Range expected = new Range(1, 200);
		Range actual = Range.expandToInclude(range, 200);
		Assert.assertEquals("TC1: Expected range to include the new value", expected, actual);
	}
    
    @Test
    public void ExpandToInclude_NegativeRange() {
    	Range range = new Range(-100, -1);
    	Range expected = new Range(-200, -1);
    	Range actual = Range.expandToInclude(range, -200);
    	Assert.assertEquals("TC2: Expected range to include the new value", expected, actual);
    }
    
    @Test
    public void ExpandToInclude_NullRange() {
    	Range actual = Range.expandToInclude(null, 200);
    	Range expected = new Range(200, 200);
    	Assert.assertEquals("TC3: Expected range to be the new value", expected, actual);
    }
    
    @Test 
	public void ExpandToInclue_ValueWithinRange() {
		Range range = new Range(1, 100);
		Range expected = new Range(1, 100);
		Range actual = Range.expandToInclude(range, 50);
		Assert.assertEquals("TC4: Expected range to be the same as the input range", expected, actual);
	}
    
//    @Test
//	public void Expand_PositiveRange() {
//		Range range = new Range(1, 100);
//		Range expected = new Range(0, 101);
//		Range actual = Range.expand(range, 1, 1);
//		Assert.assertEquals("TC1: Expected range to be expanded", expected, actual);
//	}
    
    @Test(expected = IllegalArgumentException.class)
	public void Expand_NullRange() {
    	Range.expand(null, 1, 1);
	}
    
    @Test
    public void shift() {
		Range range = new Range(1, 100);
		Range expected = new Range(11, 110);
		Range actual = Range.shift(range, 10);
		Assert.assertEquals("TC1: Expected range to be shifted by the delta", expected, actual);
    }
    
   @Test
   public void shiftWithNoZeroCrossing() {
	   Range range = new Range(1, 100);
	   Range expected = new Range(11, 110);
	   Range actual = Range.shift(range, 10, false);
	   Assert.assertEquals("TC1: Expected range to be shifted by the delta", expected, actual);
   }
   
   @Test
	public void shiftWithNoZeroCrossingZero() {
	   Range range = new Range(0, 100);
	   Range expected = new Range(0, 100);
	   Range actual = Range.shift(range, 0, false);
	   Assert.assertEquals("TC1: Expected range to be shifted by the delta", expected, actual);
   }
//   
//   @Test
//	public void testHashCode() {
//		Range range = new Range(1, 100);
//		int expected = 9979;
//		Assert.assertEquals("TC1: Expected hash code of range", expected, range.hashCode());
//	}
    
    
    
    
    
    
    
}