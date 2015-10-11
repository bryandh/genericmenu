# genericmenu
This simple tool allows you to easily create a generic console menu.

# usage
All you need to make use of this tool is explained in the following code example:

```java
GenericMenu genericMenu = new GenericMenu();

// Add a menu item using a Lambda expression.
genericMenu.addMenuItem("0", "First menu item", () -> {
    System.out.println("This is the first menu item");
    System.out.println("This menu item features a Lambda expression to define the function this menu item calls (Java version >= 1.8");
}  

// Add another menu item using a Runnable.
genericMenu.addMenuItem("1", "Second menu item", new Runnable(){
    @Override
    public void run(){
        System.out.println("This is the second menu item");
        System.out.println("This menu item features a Runnable to define the function this menu item calls");
    }
}

// Finally initalize the menu
genericMenu.initMenu();
```

This example results in the following menu representation:  
![Image of menu](http://puu.sh/kGiYZ/18d0bf35ae.png)

As you can see in the image displayed above, the menu has a default Quit menu item.

As explained in the previous code example, there are multiple ways to bind code to a menu item.  
The Lambda expression way ( () -> { // Code here. } ) is only usable with Java version 1.8 or higher.

**Adding a menu item takes three parameters:**
1. The String that has to be entered to execute the menu item.
2. Second; The name of the menu item.
3. The code that will be run when the menu item gets selected, either Lambda function or a Runnable.
