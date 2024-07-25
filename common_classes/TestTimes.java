package common_classes;

/**
 * @author Sameh A. Fakhouri
 */
public class TestTimes implements TestTimesInterface {

    private static final int TEST_BUFFER_SIZE = 10;
    private int testsCounter = 0;
    private boolean isWrapped = false;

    private TimeUnits timeUnits = TimeUnits.NanoSeconds;
    private MemoryUnits memoryUnits = MemoryUnits.Bytes;

    private long[] testTimes = new long[TEST_BUFFER_SIZE];
    private long[] memoryUsages = new long[TEST_BUFFER_SIZE];
    private long startTime;
    private long startMemory;

    public TestTimes(){
        init();
    }

    private void init(){
        testsCounter = 0;
        isWrapped = false;
        timeUnits = TimeUnits.NanoSeconds;
        memoryUnits = MemoryUnits.Bytes;
        for (int i = 0; i < TEST_BUFFER_SIZE; i++) {
            testTimes[i] = 0;
            memoryUsages[i] = 0;
        }
    }

    @Override
    public TimeUnits getTimeUnits() {
        return timeUnits;
    }

    @Override
    public void setTimeUnits(TimeUnits timeUnits) {
        this.timeUnits = timeUnits;
    }

    @Override
    public MemoryUnits getMemoryUnits() {
        return memoryUnits;
    }

    @Override
    public void setMemoryUnits(MemoryUnits memoryUnits) {
        this.memoryUnits = memoryUnits;
    }

    @Override
    public double getLastTestTime(){
        long lastTime = testTimes[(testsCounter + TEST_BUFFER_SIZE-1) % TEST_BUFFER_SIZE];
        return lastTime / timeUnits.divFactor;
    }

    @Override
    public double getLastMemoryUsage() {
        long lastMem = memoryUsages[(testsCounter + TEST_BUFFER_SIZE-1) % TEST_BUFFER_SIZE];
        return lastMem / memoryUnits.divFactor;
    }

    @Override
    public double[] getTestTimes(){
        double[] convertedTimes = new double[TEST_BUFFER_SIZE];
        int offset = isWrapped ? testsCounter : 0;
        for (int i = 0; i < TEST_BUFFER_SIZE; i++) {
            convertedTimes[i] = testTimes[(offset + i) % TEST_BUFFER_SIZE] / timeUnits.divFactor;
        }
        return convertedTimes;
    }

    @Override
    public double[] getMemoryUsages() {
        double[] convertedMems = new double[TEST_BUFFER_SIZE];
        int offset = isWrapped ? testsCounter : 0;
        for (int i = 0; i < TEST_BUFFER_SIZE; i++) {
            convertedMems[i] = memoryUsages[(offset + i) % TEST_BUFFER_SIZE] / memoryUnits.divFactor;
        }
        return convertedMems;
    }

    @Override
    public void reset(){
        init();
    }

    @Override
    public void getStartData(){
        startTime = System.nanoTime();
        startMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    }

    @Override
    public void addTestData(){
        long testTime = System.nanoTime() - startTime;
        long memoryUsage = (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) - startMemory;
        testTimes[testsCounter] = testTime;
        memoryUsages[testsCounter] = memoryUsage;
        testsCounter = (testsCounter + 1) % TEST_BUFFER_SIZE;
    }

    @Override
    public double getAverageTestTime(){
        double sum = 0;
        int numActualTests = 0;
        for (long time : testTimes){
            if (time != 0){
                sum += time;
                numActualTests++;
            }
        }
        if (numActualTests == 0){
            return 0;
        }
        return (sum / (double)numActualTests) / timeUnits.divFactor;
    }

    @Override
    public double getAverageMemoryUsage() {
        double sum = 0;
        int numActualTests = 0;
        for (long mem : memoryUsages){
            if (mem != 0){
                sum += mem;
                numActualTests++;
            }
        }
        if (numActualTests == 0){
            return 0;
        }
        return (sum / (double)numActualTests) / memoryUnits.divFactor;
    }

}
