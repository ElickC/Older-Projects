/**********************************************************************
 *  ps2-readme template                                                   
 *  Recursive Graphics (Pythagoras tree)                       
 **********************************************************************/

Your name: Elick Coval

Operating system you're using (Linux, OS X, or Windows): Linux

If Windows, which solution?:

Text editor or IDE you're using: VS Code

Hours to complete assignment: 18

/**********************************************************************
 *  Briefly discuss the assignment itself and what you accomplished.
 **********************************************************************/
The assignment was to create a pythrogrean tree recursively, given a 
size of the base square and a depth for the recursion.

 /**********************************************************************
 *  Discuss one or more key algorithms, data structures, or 
 *  OO designs that were central to the assignment.
 **********************************************************************/
It starts with a given base square based on input. Then calculates the
left and right vertices and center point. Then, it uses one of the new
vertices and the center point to generate a new child square which 
becomes the parent of the next pair of child squares. It continues until
it reaches the target depth.


/**********************************************************************
 *  Briefly explain the workings of the features you implemented.
 *  Include code excerpts.
 **********************************************************************/
It begins by creating a ConvexShape object from the dimensions given as 
an argment. The object uses the dimensions to create a PTree object which
has a pTreeRec function. Inside each of these, the object's ConvexShape is
drawn, which creates 2 new ConvexShape objects and creates new PTree
objects, it continues recursively.

auto leftChild = parentSquare;
PTree* leftNode = new PTree(leftChild);
leftNode->depth = depth;
leftNode->btmLeft = midPoint;
leftNode->btmRight = topRight;
leftNode->pTreeRec(window);


 /**********************************************************************
 *  Briefly explain what you learned in the assignment.
 **********************************************************************/
How to get SFML objects to be displayed in a window.


/**********************************************************************
 *  List whatever help (if any) you received from the instructor,
 *  classmates, or anyone else.
 **********************************************************************/
Used code provided by the professor, stackexchange.com, TA


/**********************************************************************
 *  Describe any serious problems you encountered.  
 *  If you didn't complete any part of any assignment, 
 *  the things that you didn't do, or didn't get working.                  
 **********************************************************************/
I ran into issues getting the recursion to work, displaying the SFML object.

/**********************************************************************
 *  List any other comments here.                                     
 ********************************
Extra Credit: Each square's color is randomized, creating a cool effect
that doesn't show up in the screen capture.
