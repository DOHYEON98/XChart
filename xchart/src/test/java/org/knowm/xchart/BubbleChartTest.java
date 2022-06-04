package org.knowm.xchart;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.knowm.xchart.style.Styler;

public class BubbleChartTest {
	BubbleChart bubbleChart;
	
	@Before
	public void setUp() throws Exception {
	    bubbleChart =
	            new BubbleChartBuilder()
	                .width(800)
	                .height(600)
	                .title(getClass().getSimpleName())
	                .xAxisTitle("X")
	                .yAxisTitle("Y")
	                .build();
	    bubbleChart.getStyler().setLegendPosition(Styler.LegendPosition.InsideN);
	    bubbleChart.getStyler().setLegendLayout(Styler.LegendLayout.Horizontal);
	    bubbleChart.getStyler().setToolTipsEnabled(true);
	}

	@After
	public void tearDown() throws Exception {
		bubbleChart = null;
	}
	
	/**
	* Purpose: Add different length of data for yData and BubbleData
	* Input: sanityCheck xData.length==5 yData.length==5 BubbleData.length==4
	* Expected:
	* throw IllegalArgumentException
	*/ 
	@Test(expected = IllegalArgumentException.class)
	public void sanityCheckDifferentLengthYBubbleTest() {
		assertNotNull(bubbleChart.addSeries("test", Arrays.asList(10, 40, 80, 120, 350), 
				Arrays.asList(10, 40, 80, 120, 350), Arrays.asList(10, 40, 80, 350)));
	}
	
	/**
	* Purpose: Add different length of data for xData and yData
	* Input: sanityCheck xData.length==4 yData.length==5 BubbleData.length==5
	* Expected:
	* throw IllegalArgumentException
	*/ 
	@Test(expected = IllegalArgumentException.class)
	public void sanityCheckDifferentLengthXYTest() {
		assertNotNull(bubbleChart.addSeries("test", new double[] {10, 40, 80, 350}, 
				new double[] {10, 40, 80, 120, 350}, new double[] {10, 40, 80, 120, 350}));
	}
}
