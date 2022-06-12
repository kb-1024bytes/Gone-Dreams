package org.tensorflow.lite.examples.posenet;

import static org.junit.Assert.*;

import android.content.Context;
import androidx.test.InstrumentationRegistry;
import androidx.test.runner.AndroidJUnit4;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
  @Test
  public void useAppContext() {
    Context appContext = InstrumentationRegistry.getTargetContext();

    assertEquals("org.tensorflow.lite.examples.posenet.test", appContext.getPackageName());
  }
}
