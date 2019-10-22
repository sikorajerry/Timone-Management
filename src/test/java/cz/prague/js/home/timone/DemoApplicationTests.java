package cz.prague.js.home.timone;

import cz.prague.js.home.timone.context.Context;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

@SpringBootTest(classes = TestApplicationConfiguration.class)
@RunWith(SpringRunner.class)
class DemoApplicationTests {

	@Autowired
	private Context context;

	@Test
	void correctDataTest() {
		List<String> strings = prepareData();

		strings.forEach(line -> {
			context.addRecord(line);
		});

		Map<String, Integer> records = context.getRecords();

		assertEquals(records.get("USD"), new Integer(1500));
		assertEquals(records.get("CZK"), new Integer(500));
	}

	@Test
	void wrongDataTest() {
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));

		context.addRecord("slv 300");
		assertEquals("Wrong entry ...".trim(), outContent.toString().trim());
	}

	private List<String> prepareData() {
		return Arrays.asList("USD 100", "USD 200", "USD 300", "USD 400", "USD 500",
				"CZK 100", "CZK 200", "CZK 300", "CZK 400", "CZK -500");
	}
}
