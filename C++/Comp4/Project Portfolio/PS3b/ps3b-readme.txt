/**********************************************************************
 *  N-Body Simulation ps3b-readme.txt template
 **********************************************************************/

Name:Elick Coval
OS:Linux
Text editor: VSCode
Hours to complete assignment:6

/**********************************************************************
 *  Briefly discuss the assignment itself and what you accomplished.
 **********************************************************************/

For this assignment we had to add new functionality to ps3a so that it would
display the celestial bodies moving around the sun. All of the needed data
was given in the planets.txt file. We had to use Newton's Laws of motion
and gravitation to make it work.


  /**********************************************************************
 *  Discuss one or more key algorithms, data structures, or 
 *  OO designs that were central to the assignment.
 **********************************************************************/

The calculation for the force of one body on another was from Newton's
Law of Universal Gravitation. The result would ten be used to calculate
how much the affected body would move on the screen

	float calculateForce(float massA, float massB, float radius) {
		return (gravity * massA * massB) / pow(radius, 2);
	}

/**********************************************************************
 *  Briefly explain the workings of the features you implemented.
 *  Include code excerpts.
 **********************************************************************/

Here I initialized the font:

	sf::Font font;
	if (!font.loadFromFile("Walkway_Bold.ttf")) {
		cerr << "Failed to load Font File" << endl;
	}
	
	sf::Text time;
	time.setFont(font);
	time.setString(to_string(currentT));
	time.setCharacterSize(28);
	time.setFillColor(sf::Color::White);

Later on in the event loop the time is updated with the current elapsed time and draws it on the screen. 

		window.draw(time);
		currentT = currentT + dT;
		time.setString(to_string(currentT));
		

/**********************************************************************
 *  List whatever help (if any) you received from the instructor,
 *  classmates, or anyone else.
 **********************************************************************/

lecture, stackoverflow

/**********************************************************************
 *  Describe any serious problems you encountered.                    
 **********************************************************************/

None other than events outside of school interfering with my ability to
get this done.

/**********************************************************************
 *  List any other comments here.                                     
 **********************************************************************/

I was able to complete the extra credit of displaying the elapsed time
and play a sound file.
