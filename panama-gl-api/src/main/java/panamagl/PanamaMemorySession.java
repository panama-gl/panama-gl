package panamagl;

import java.lang.foreign.MemorySession;

public class PanamaMemorySession {
	public static MemorySession get() {
		return MemorySession.global();
	}
}
