package org.knowm.xchart.internal.chartpart;

import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;
import java.util.function.Function;

/** @author Marc Jakobi */
public class Formatter_Custom extends Format {

  private final Function<Double, String> customFormattingFunction;

  public Formatter_Custom(Function<Double, String> customFormattingFunction) {
    this.customFormattingFunction = customFormattingFunction;
  }

  @Override
  public StringBuffer format(Object numberObject, StringBuffer stringBuffer, FieldPosition fieldPosition) {
    Number number = (Number) numberObject;
    stringBuffer.append(customFormattingFunction.apply(number.doubleValue()));
    return stringBuffer;
  }

  @Override
  public Object parseObject(String string, ParsePosition parsePosition) {
    return null;
  }
}
