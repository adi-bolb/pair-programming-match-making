package org.findapair.testing;

import static org.mockito.Mockito.mock;

public class Dummy {
	public static <T> T dummy(Class<T> type) {
		return mock(type);
	}
}