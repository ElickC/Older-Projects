/**********************************************************************
 *  N-Body Simulation ps3a-readme.txt template
 **********************************************************************/

Name: Elick Coval
OS: Linux
Text editor: VSCode
Hours to complete assignment: 6

/**********************************************************************
 *  Briefly discuss the assignment itself and what you accomplished.
 **********************************************************************/

The assignment had us overload the >> operator to read data from a text
file and use that data to display the celestial bodies correctly. I 
was able to complete this assignment 100% after some time.

  /**********************************************************************
 *  Discuss one or more key algorithms, data structures, or 
 *  OO designs that were central to the assignment.
 **********************************************************************/

The overload of the >> operator looked like this:

istream& operator>>(istream& cin, Body& Body) {
	cin >> Body.xpos >> Body.ypos >> Body.xvel >> Body.yvel >> Body.mass >> Body.filename;
	return cin;
}

This allows for the extraction of all the data we need to display the
bodies correctly.

/**********************************************************************
 *  Briefly explain the workings of the features you implemented.
 *  Include code excerpts.
 **********************************************************************/

This is the code that takes in information about each body using a smart pointer:

	vector<shared_ptr<Body>> bodies(numBodies);
	for (int i = 0; i < numBodies; i++) {
		bodies[i] = make_shared<Body>(Body(radiusUniverse, windowSize));
		cin >> *bodies[i];
	}
	for (int i = 0; i < numBodies; i++) {
		bodies[i]->setSprite();
	}
	for (int i = 0; i < numBodies; i++) {
		bodies[i]->setPosition();
	}

Once we have this information, we can go about displaying the bodies

		while (window.isOpen())
	{
		sf::Event event;
		while (window.pollEvent(event))
		{
			if (event.type == sf::Event::Closed)
				window.close();
		}

		for (int i = 0; i < numBodies; i++)
		{
			window.draw(*bodies[i]);
		}
			window.display();
	}

/**********************************************************************
 *  List whatever help (if any) you received from the instructor,
 *  classmates, or anyone else.
 **********************************************************************/
Stackoverflow.com, lecture, TA

/**********************************************************************
 *  Describe any serious problems you encountered.                    
 **********************************************************************/
Figuring out how to get the positions correct was a challenge

/**********************************************************************
 *  List any other comments here.                                     
 **********************************************************************/

I was able to complete the Extra Credit of displaying a background image.
