import org.junit.Test;

import rripp.pocketmd.server.ModelBuilder;


public class TheTimeTest {

	@Test
	public void allParametersTrainingTest() {
		ModelBuilder.build("OSL1", new String[]{ "TIMEPOST", "PULSE1", "IndSh1", "DAD1", "SAD1", "ShockTime", "TEMP1", "MVP1", "RESP1", "GLUC1", "GLASGO1", "AGE"});
		//ModelBuilder.build("OSL2", new String[]{ "TIMEPOST", "PULSE1", "IndSh1", "DAD1", "SAD1", "ShockTime", "TEMP1", "MVP1", "RESP1", "GLUC1", "GLASGO1", "AGE"});
		ModelBuilder.build("OSL3", new String[]{ "TIMEPOST", "PULSE1", "IndSh1", "DAD1", "SAD1", "ShockTime", "TEMP1", "MVP1", "RESP1", "GLUC1", "GLASGO1", "AGE"});
		//ModelBuilder.build("OSL4", new String[]{ "TIMEPOST", "PULSE1", "IndSh1", "DAD1", "SAD1", "ShockTime", "TEMP1", "MVP1", "RESP1", "GLUC1", "GLASGO1", "AGE"});
		ModelBuilder.build("OSL5", new String[]{ "TIMEPOST", "PULSE1", "IndSh1", "DAD1", "SAD1", "ShockTime", "TEMP1", "MVP1", "RESP1", "GLUC1", "GLASGO1", "AGE"});
		//ModelBuilder.build("OSL6", new String[]{ "TIMEPOST", "PULSE1", "IndSh1", "DAD1", "SAD1", "ShockTime", "TEMP1", "MVP1", "RESP1", "GLUC1", "GLASGO1", "AGE"});
		ModelBuilder.build("OSL7", new String[]{ "TIMEPOST", "PULSE1", "IndSh1", "DAD1", "SAD1", "ShockTime", "TEMP1", "MVP1", "RESP1", "GLUC1", "GLASGO1", "AGE"});
		//ModelBuilder.build("OSL8", new String[]{ "TIMEPOST", "PULSE1", "IndSh1", "DAD1", "SAD1", "ShockTime", "TEMP1", "MVP1", "RESP1", "GLUC1", "GLASGO1", "AGE"});
		ModelBuilder.build("OSL9", new String[]{ "TIMEPOST", "PULSE1", "IndSh1", "DAD1", "SAD1", "ShockTime", "TEMP1", "MVP1", "RESP1", "GLUC1", "GLASGO1", "AGE"});
		ModelBuilder.build("OSL10", new String[]{ "TIMEPOST", "PULSE1", "IndSh1", "DAD1", "SAD1", "ShockTime", "TEMP1", "MVP1", "RESP1", "GLUC1", "GLASGO1", "AGE"});
		ModelBuilder.build("ISH", new String[]{ "TIMEPOST", "PULSE1", "IndSh1",  "DAD1", "SAD1", "ShockTime", "TEMP1", "MVP1", "RESP1", "GLUC1", "GLASGO1", "AGE"});
	}
	@Test
	public void fewParemetersTrainingTest() {
		ModelBuilder.build("OSL1", new String[]{"SAD1", "DAD1", "TEMP1", "GLASGO1"});
		//ModelBuilder.build("OSL2", new String[]{"TIMEPOST", "MVP1"});
		ModelBuilder.build("OSL3", new String[]{"ShockTime", "GLASGO1"});
		//ModelBuilder.build("OSL4", new String[]{"SAD1", "MVP1"});
		ModelBuilder.build("OSL5", new String[]{"SAD1", "DAD1", "GLASGO1"});
		//ModelBuilder.build("OSL6", new String[]{"MVP1", "RESP1"});
		ModelBuilder.build("OSL7", new String[]{"TIMEPOST", "AGE"});
		//ModelBuilder.build("OSL8", new String[]{"ShockTime", "AGE"}); //very low correlation
		ModelBuilder.build("OSL9", new String[]{"ShockTime", "DAD1", "SAD1"});
		ModelBuilder.build("OSL10", new String[]{"MVP1", "RESP1"});
		ModelBuilder.build("ISH", new String[]{"TEMP1", "GLASGO1"});
	}
}
