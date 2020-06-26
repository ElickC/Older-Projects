/**********************************************************************
 *  N-Body Simulation ps3b-readme.txt template
 **********************************************************************/

Name:Yinghui Zhu
OS:Ubuntu 
Text editor: Notepad++
Hours to complete assignment:3

/**********************************************************************
 *  Briefly discuss the assignment itself and what you accomplished.
 **********************************************************************/
This assignment had us implement new functionality to the program we made
in ps3a, so that it would display the bodies moving around the sun, as if
they were actual planets. Each body's trajectory was calculated from the
initial data given about each object from the input file, and using
Newton's Laws of gravitation and motion.

  /**********************************************************************
 *  Discuss one or more key algorithms, data structures, or 
 *  OO designs that were central to the assignment.
 **********************************************************************/
The calculation of force of one body on another was handled by the 
following code:

	float calculateForce(float massA, float massB, float radius) {
		return (gravity * massA * massB) / pow(radius, 2);
	}

This is essentially an implementation of Newton's Law of universal 
gravitation. The result of this function was then used to find how much
that force would move the affected body in terms of the screen size.


/**********************************************************************
 *  Briefly explain the workings of the features you implemented.
 *  Include code excerpts.
 **********************************************************************/
display elapsed time

	sf::Font font;
	if (!font.loadFromFile("Arialn.ttf"))
	{
		cerr << "Failed to load Arialn.ttf" << endl;
	}
	sf::Text time;
	time.setFont(font);
	time.setString(to_string(currentT));
	time.setCharacterSize(24);
	time.setFillColor(sf::Color::Red);

Using the above code I implemented a way to display the time elapsed in the program.
It loads a font file I got from the internet, and set's it's initial values. In the event loop
it calls 

		window.draw(time);
		currentT = currentT + dT;
		time.setString(to_string(currentT));
		
each loop, so that the time is updated with the current elapsed time and draws it on the screen. 

play sound file:

	sf::Music music;
	if (music.openFromFile("2001.wav")) {
		music.play();
	} music.play();
	
Using sfml's Music class and the 2001.wav file that was given, I implemented
a way to play music while the program ran. 

Prints the state of the universe at the end of the simulation

	std::ofstream out("output.txt");
	out.precision(4);
	out << numBodies << endl;
	out << radiusUniverse << endl;
	for (int i = 0; i < numBodies; i++)
	{
		out << std::scientific << " " << bodies[i]->xpos << "  " << bodies[i]->ypos << "  " << bodies[i]->xvel << "  " << bodies[i]->yvel << "  " << bodies[i]->mass << "  " << bodies[i]->filename << endl;
	}
	
Using the above code I added functionality to print out the final state of the current NBody simulation. It simply outputs
the final values of each body in the same format as the input file. 


/**********************************************************************
 *  List whatever help (if any) you received from the instructor,
 *  classmates, or anyone else.
 **********************************************************************/
Cplusplus.com, stackoverflow

/**********************************************************************
 *  Describe any serious problems you encountered.                    
 **********************************************************************/
Trying to include <SFML/Audio.hpp> caused a "The code execution cannot 
proceed because OpenAL32.dll was not found. Reinstalling the program 
may fix this problem." error on my Visual Studios 2017. The error persisted
even after removing the include statement and any references to it's contents.
I had to switch to using linux development enviornment. 

/**********************************************************************
 *  List any other comments here.                                     
 **********************************************************************/
Extra Credit: Display elapsed time, plays sound file