package panamagl.platform;

public interface PlatformMatcher {
  /** Returns true if the platform matches this matcher definition {@link Platform}. */
  boolean matches(Platform platform);
}
