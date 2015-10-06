package core;

public class MenuItem {
	private String key;
	private String name;
	private Runnable runnable;

	/**
	 * Constructor that initializes only the key and name class variables
	 * 
	 * @param key
	 *            key of the MenuItem
	 * @param name
	 *            name of the MenuItem
	 */
	public MenuItem(String key, String name) {
		this.key = key;
		this.name = name;
	}

	/**
	 * Constructor that initializes all the class variables
	 * 
	 * @param key
	 *            key of the MenuItem
	 * @param name
	 *            name of the MenuItem
	 * @param runnable
	 *            runnable of the MenuItem
	 */
	public MenuItem(String key, String name, Runnable runnable) {
		this.key = key;
		this.name = name;
		this.runnable = runnable;
	}

	/**
	 * Gets the key property
	 * 
	 * @return key property
	 */
	public String getKey() {
		return key;
	}

	/**
	 * Gets the name property
	 * 
	 * @return name property
	 */
	public String getName() {
		return name;
	}

	/**
	 * Gets the runnable property
	 * 
	 * @return runnable property
	 */
	public Runnable getRunnable() {
		return runnable;
	}
}
