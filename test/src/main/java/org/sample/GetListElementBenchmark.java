package org.sample;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class GetListElementBenchmark {

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
    Random random = new Random();
    List<Integer> arrayList = random
        .ints(100000)
        .collect(ArrayList::new, List::add, List::addAll);

    List<Integer> linkedList = random
        .ints(100000)
        .collect(LinkedList::new, List::add, List::addAll);
  }

  @Benchmark
  @BenchmarkMode(Mode.AverageTime)
  @OutputTimeUnit(TimeUnit.MICROSECONDS)
  public void getRandomFromArrayList(MyState state, Blackhole blackhole) {
    Random random = new Random();
    for (int i = 0; i < state.NSIZE; i++) {
      int randomIndex = random.nextInt(state.NSIZE);
      blackhole.consume(state.arrayList.get(randomIndex));
    }
  }

  @Benchmark
  @BenchmarkMode(Mode.AverageTime)
  @OutputTimeUnit(TimeUnit.MICROSECONDS)
  public void getRandomFromLinkedList(MyState state, Blackhole blackhole) {
    Random random = new Random();
    for (int i = 0; i < state.NSIZE; i++) {
      int randomIndex = random.nextInt(state.NSIZE);
      blackhole.consume(state.linkedList.get(randomIndex));
    }
  }
}
