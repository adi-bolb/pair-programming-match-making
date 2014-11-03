package org.matchmaking;

import static org.mockito.Mockito.mock;

public class Dummy {
	static <T> T dummy(Class<T> type) {
		return mock(type);
	}
}
