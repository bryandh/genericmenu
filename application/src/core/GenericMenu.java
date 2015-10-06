package core;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GenericMenu {
	private ArrayList<MenuItem> menuItems;
	private Scanner scanner;

	/**
	 * Constructor initializes the class variables
	 */
	public GenericMenu() {
		this.menuItems = new ArrayList<MenuItem>();
		this.scanner = new Scanner(System.in);
	}

	/**
	 * Adds a MenuItem with only a key and a name to the menuItems ArrayList 
	 * 
	 * @param key	the key the menu item will belong to
	 * @param name	the name of the menu item
	 */
	private void addMenuItem(String key, String name) {
		MenuItem menuItem = new MenuItem(key, name);
		menuItems.add(menuItem);
	}

	/**
	 * Adds a MenuItem with key, name and runnable to the menuItems ArrayList
	 * 
	 * @param key		the key the menu item will belong to
	 * @param name		the name of the menu item
	 * @param runnable	the method that will be run when the menu item is chosen
	 */
	public void addMenuItem(String key, String name, Runnable runnable) {
		MenuItem menuItem = new MenuItem(key, name, runnable);
		menuItems.add(menuItem);
	}
	
	/**
	 * Prints all the existing menu items in the console in the format [key]: name
	 */
	public void printMenuItems() {
		for (MenuItem menuItem : menuItems) {
			System.out.println("[" + menuItem.getKey() + "]: " + menuItem.getName());
		}
	}

	/**
	 * Runs the runnable of the menu item that matches the given key
	 * 
	 * @param key			key of the menu item to run the runnable of
	 * @throws Exception	exception when there is no matching menu item found for the given key
	 */
	public void runCommand(String key) throws Exception {
		// filter the menu item(s) with the corresponding key
		Stream<MenuItem> filteredMenuItemsStream = menuItems.stream().filter(i -> i.getKey().equals(key));
		
		// convert stream to ArrayList
		ArrayList<MenuItem> filteredMenuItems = (ArrayList<MenuItem>) filteredMenuItemsStream.collect(Collectors.toList());
		
		if(filteredMenuItems.size() > 0)
			// if there are any menu items with the given key, run their runnables
			filteredMenuItems.forEach(i -> i.getRunnable().run());
		else
			// if not, throw an exception that the key doesn't exist
			throw new Exception("No valid option for '" + key + "' found, try again.");
	}

	/**
	 * Makes the scanner wait for a line of input
	 * 
	 * @return returns the input as String
	 */
	public String scanLine() {
		System.out.print("> ");
		return scanner.nextLine();
	}

	/**
	 * Adds the default menu items, for example the quit menu item should always be in there
	 * Beware: default menu items should always be added to the input switch
	 */
	public void addDefaultMenuItems() {
		addMenuItem("Q", "Quit");
	}
	
	public void initMenu(){
		addDefaultMenuItems();
		
		Boolean quit = false;

		while (!quit) {
			// show the menu items every time
			printMenuItems();

			// allow for input
			String option = scanLine();

			// show the input
			System.out.println("\nEntered " + option);

			// act depending on the input
			try {
				switch (option.toLowerCase()) {
				case "q":
					System.out.println("Quitting application...");
					quit = true;
					break;
				default:
					try {
						runCommand(option);
					} catch (Exception ex) {
						System.out.println("An error has occured: " + ex.getMessage());
					}
					break;
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}

			System.out.println();
		}
	}
}