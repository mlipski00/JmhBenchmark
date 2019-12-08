package org.sample;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class PrimitiveBenchmark {


  public static void main(String[] args) throws RunnerException {
    Options opt = new OptionsBuilder()
        .include(GetListElementBenchmark.class.getSimpleName())
        .forks(1)
        .build();
    new Runner(opt).run();
  }

  @State(Scope.Thread)
  public static class MyState {
    @Param("100000")
    int NSIZE;
  }

  @Benchmark
  @BenchmarkMode(Mode.AverageTime)
  @OutputTimeUnit(TimeUnit.MICROSECONDS)
  public void intOutsideLoop(GetListElementBenchmark.MyState state, Blackhole blackhole) {
    Random random = new Random();
    int randomIndex;
    for (int i = 0; i < state.NSIZE; i++) {
      randomIndex = random.nextInt(state.NSIZE);
      blackhole.consume(randomIndex);
    }
  }


  @Benchmark
  @BenchmarkMode(Mode.AverageTime)
  @OutputTimeUnit(TimeUnit.MICROSECONDS)
  public void intInsideLoop(MyState state, Blackhole blackhole) {
    Random random = new Random();
    for (int i = 0; i < state.NSIZE; i++) {
      int randomIndex = random.nextInt(state.NSIZE);
      blackhole.consume(randomIndex);
    }
  }
}
