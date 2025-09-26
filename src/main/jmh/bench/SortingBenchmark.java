package practice.DesignAss1.bench;

import org.openjdk.jmh.annotations.*;
import practice.DesignAss1.deterministicSelect;
import practice.DesignAss1.mergeSort;
import practice.DesignAss1.quickSort;

import java.util.concurrent.TimeUnit;
import java.util.Random;
import java.util.Arrays;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Thread)
public class SortingBenchmark {

    private static final Random rand = new Random();
    private int[] array;

    @Param({"100", "1000", "5000"})
    public int n;

    @Setup(Level.Iteration)
    public void setUp() {
        array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = rand.nextInt(1_000_000);
        }
    }

    @Benchmark
    public void testMergeSort() {
        int[] copy = Arrays.copyOf(array, array.length);
        mergeSort.resetDepth();
        mergeSort.mergeSort(copy);
    }

    @Benchmark
    public void testQuickSort() {
        int[] copy = Arrays.copyOf(array, array.length);
        quickSort.resetDepth();
        quickSort.quickSort(copy);
    }

    @Benchmark
    public void testDeterministicSelect() {
        int[] copy = Arrays.copyOf(array, array.length);
        int k = rand.nextInt(n);
        deterministicSelect.resetDepth();
        deterministicSelect.select(copy, k);
    }
}
