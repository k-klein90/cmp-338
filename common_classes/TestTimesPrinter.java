package common_classes;

public class TestTimesPrinter {

    public static void print(TestTimes testTimes){
        testTimes.setTimeUnits(TestTimes.TimeUnits.Seconds);
        testTimes.setMemoryUnits(TestTimes.MemoryUnits.KiloBytes);
        double[] arrOfTimes = testTimes.getTestTimes();
        double[] arrOfMemUsages = testTimes.getMemoryUsages();

        System.out.println("Test times (s):\tMemory usages (KB):");
        for (int i = 0; i < arrOfTimes.length; i++){
            System.out.println(arrOfTimes[i] + "\t\t" + arrOfMemUsages[i]);
        }
        System.out.println("Average test time (s): " + testTimes.getAverageTestTime());
        System.out.println("Average memory usage (KB): " + testTimes.getAverageMemoryUsage() + "\n");

    }

}