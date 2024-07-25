package common_classes;

/**
 * This interface will be used to organize and manage test times and memory
 * usages that are measured for specific operations.
 *
 * @author Sameh A. Fakhouri
 */
public interface TestTimesInterface {

	/**
	 * This enum specifies what unit of time the user wants run times to be
	 * presented in when the user retrieves said times using one of the get
	 * methods. The enum has the following values:
	 * 		<ol>
	 * 			<li>NanoSeconds</li>
	 * 			<li>MicroSeconds</li>
	 * 			<li>MilliSeconds</li>
	 * 			<li>Seconds</li>
	 * 		</ol>
	 */
	enum TimeUnits {
		NanoSeconds (1),
		MicroSeconds (1_000),
		MilliSeconds (1_000_000),
		Seconds (1_000_000_000);

		public final double divFactor;

		TimeUnits(double divFactor) {
			this.divFactor = divFactor;
		}
	}

	/**
	 * This enum specifies what unit of information the user wants memory usages
	 * to be presented in when the user retrieves said memory usages using one of
	 * the get methods. The enum has the following values:
	 * 		<ol>
	 * 			<li>Bytes</li>
	 * 			<li>KiloBytes</li>
	 * 			<li>MegaBytes</li>
	 * 		</ol>
	 */
	enum MemoryUnits {
		Bytes (1),
		KiloBytes (1024),
		MegaBytes (1024*1024);

		public final double divFactor;

		MemoryUnits(double divFactor) {
			this.divFactor = divFactor;
		}
	}

	/**
	 * This method obtains the <b>TimeUnits</b> variable for this object.
	 * The default TimeUnits value is <b>NanoSeconds</b>.
	 *
	 * @return	this object's TimeUnits variable.
	 */
	TimeUnits getTimeUnits();

	/**
	 * This method sets the value of this object's <b>TimeUnits</b> variable.
	 *
	 * @param timeUnits		the desired TimeUnits value.
	 */
	void setTimeUnits(TimeUnits timeUnits);

	/**
	 * This method obtains the <b>MemoryUnits</b> variable for this object.
	 * The default MemoryUnits value is <b>Bytes</b>.
	 *
	 * @return	this object's MemoryUnits variable.
	 */
	MemoryUnits getMemoryUnits();

	/**
	 * This method sets the value of this object's <b>MemoryUnits</b> variable.
	 *
	 * @param memoryUnits	the desired MemoryUnits value.
	 */
	void setMemoryUnits(MemoryUnits memoryUnits);

	/**
	 * This method retrieves the last test time as a <b>double</b> conversion
	 * to this object's selected <b>TimeUnits</b> value. If no test times
	 * have been added, the method will return a zero.
	 *
	 * @return	the last test time, or zero.
	 */
	double getLastTestTime();

	/**
	 * This method retrieves the last recorded memory usage as a <b>double</b>
	 * conversion to this object's selected <b>MemoryUnits</b> value. If no
	 * memory usages have been added, the method will return a zero.
	 *
	 * @return	the last memory usage, or zero.
	 */
	double getLastMemoryUsage();

	/**
	 * This method returns an array of the last 10 test times as <b>double</b>s
	 * that have been converted to this object's selected <b>TimeUnits</b>
	 * value. If fewer than 10 test times have been added, the remaining test
	 * times will be zeros. If more than 10 test times have been added, the array
	 * will contain the last 10 test times.
	 *
	 * @return	an array of doubles representing the last 10 test times.
	 */
	double[] getTestTimes();

	/**
	 * This method returns an array of the last 10 memory usages as <b>double</b>s
	 * that have been converted to this object's selected <b>MemoryUnits</b>
	 * value. If fewer than 10 memory usages have been added, the remaining memory
	 * usages will be zeros. If more than 10 memory usages have been added, the
	 * array will contain the last 10 memory usages.
	 *
	 * @return an array of doubles representing the last 10 memory usages.
	 */
	double[] getMemoryUsages();

	/**
	 * This method resets all 10 saved test times and memory usages to zero.
	 */
	void reset();

	/**
	 * This method obtains the start time and memory usage for an operation.
	 */
	void getStartData();

	/**
	 * This method adds a test time to the list of test times, and a memory usage
	 * to the list of memory usages.
	 */
	void addTestData();

	/**
	 * This method obtains the average test time as a <b>double</b> by averaging
	 * all the non-zero test times that are available. The time is converted to
	 * this object's selected <b>TimeUnits</b> value. If no test times have been
	 * added, the method returns a zero.
	 *
	 * @return 	a double representing the average of all the non-zero test times,
	 * 			or zero.
	 */
	double getAverageTestTime();

	/**
	 * This method obtains the average memory usage as a <b>double</b> by averaging
	 * all the non-zero memory usages that are available. The average is converted
	 * to this object's selected <b>TimeUnits</b> value. If no memory usages have
	 * been added, the method returns a zero.
	 *
	 * @return	a double representing the average of all the non-zero memory usages,
	 * 			or zero.
	 */
	double getAverageMemoryUsage();

}