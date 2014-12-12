JGameSimplified
===============

Simple wrapper to make setting up a very simple game easy for people with basic understanding of java.

##Scope
This wrapper is designed to be used for single state/scene games and flexibility is often sacrificed for simplicity for the purpose of catering to a demographic of beginners.

##Contributing
Feel free to fork and alter but please keep these basic guidlines in mind:

* This project's goal is to make the introduction to game development easy
* This project is not intended to be the most efficient way of doing things but instead the easiest way for beginners to learn

##Tutorial
Creating a game with JGameSimplified is **simple.** The first step is downloading the JGameSimplified.jar and adding it to your project's build path. If you don't know how check out this tutorial: http://goo.gl/ytURT6  

There are two ways to get the JGameSimplified.jar file.
1. Download the latest stable release from the <a href="https://github.com/Bevilacqua/JGameSimplified/releases">release page</a>
2. Build the project yourself. **Be careful the most recent commit may not be stable.**

###After you have the library added it's time to code:
The first thing we must do is create a new class and extend `Game` 

```Java
public class OurGame extends Game {

}
```

Next we need to add the unimplemented methods and constructor. If you are in eclipse hover over the name of your class and it will give you the option to auto generate these methods. It should look something like this:

```Java
public class OurGame extends Game {
  public OurGame(int screenWidth, int screenHeight, String title) {
    super(screenWidth , screenHeight , title);
  }
  
  public void update() {
  
  }
  
  public void render() {
  
  }
}
```

Now with all unimplemented methods added we must move on to the main method and starting the game loop. JGameSimplified handles all the dirty work of creating a JFrame, starting a Thread, and even creates and runs the game loop. All we have to do is start the loop. To do so we use the `start()` method. We will put the start method in the main method so that it is run at the beginning of the program. To access the start method we must first create a new instance of our game class. The constructor takes three paramaters:

1. The width of the window
2. The height of the window
3. The title of the window

```Java
public static void main(String args[]) {
  new OurGame(500,500,"Our Game").start();
}
```

Now that our main method is set up we can tap into the game loop to update and render to the screen. Rendering is easy with JGameSimplified. There is no need to create an image buffer, buffer strategy , or graphics object because it has all been done behind the scenes. Rendering is as easy as utilizing the Graphics object pre-named `g`. There are a ton of things we can use the graphics object to render such as circles and images. For this tutorial we will just be creating a rectangle but for a full list of all rendering methods found im the graphics object check out the javadocs: http://goo.gl/CK3rE2 We will use the `drawRect()` method to draw a rectangle. It takes four paramaters:
1. The x position of the rectangle
2. The y position of the rectangle
3. The width of the rectangle
4. The height of the rectangle

```Java
public void render() {
  g.drawRect(50,50,50,50);
}
```
Now that we have created our rectangle we can change the color using the `setColor()` method. 

```Java
public void render() {
  setColor(Color.red);
  g.drawRect(50,50,50,50);
}
```

##The tutorial is incomplete and does not yet cover
* The update method
* Input management

