/**********************************************************************
 *  ps2-readme template                                                   
 *  Recursive Graphics (Pythagoras tree)                       
 **********************************************************************/

Your name: Yinghui Zhu

Operating system you're using (Linux, OS X, or Windows): Windows

If Windows, which solution?: Windows 10

Text editor or IDE you're using: Visual Studios 2017

Hours to complete assignment: 20 hours

/**********************************************************************
 *  Briefly discuss the assignment itself and what you accomplished.
 **********************************************************************/
The assignment was to create a program that would create a pythrogrean
tree recursively, given a size of the base square and a recursive depth.


 /**********************************************************************
 *  Discuss one or more key algorithms, data structures, or 
 *  OO designs that were central to the assignment.
 **********************************************************************/
The algorithm starts with a given base square, and then calculating the
top left and top right vertices of it, as well as a center point. It then
uses one of the vertices and the center point to generate a new base
square, and continues to do so until it hits the target depth. 


/**********************************************************************
 *  Briefly explain the workings of the features you implemented.
 *  Include code excerpts.
 **********************************************************************/
The program starts by creating a ConvexShape object based off of the
dimensions given as an argument. It uses that to create a PTree
object, which has a pTreeRec function. Inside each call of pTreeRec, the 
object's ConvexShape is drawn, and then it creates 2 new ConvexShape
objects based off of it's own, and creates 2 new PTree objects, which
calls their own pTreeRec functions.

	auto lChildSquare = parentSquare;
	PTree* lNode = new PTree(lChildSquare);
	lNode->depth = depth;
	lNode->bottomLeft = midPoint;
	lNode->bottomRight = topRight;
	lNode->pTreeRec(window);

	auto rChildSquare = parentSquare;
	PTree* rNode = new PTree(rChildSquare);
	rNode->depth = depth;
	rNode->bottomLeft = topLeft;
	rNode->bottomRight = midPoint;
	rNode->pTreeRec(window);


 /**********************************************************************
 *  Briefly explain what you learned in the assignment.
 **********************************************************************/
How to draw objects in SFML recursively.


/**********************************************************************
 *  List whatever help (if any) you received from the instructor,
 *  classmates, or anyone else.
 **********************************************************************/
SFML website, cplusplus.com, TA


/**********************************************************************
 *  Describe any serious problems you encountered.  
 *  If you didn't complete any part of any assignment, 
 *  the things that you didn't do, or didn't get working.                  
 **********************************************************************/
I ran into huge issues getting the recursive function to work properly.
I finally got it to work after going to the TA for help.


/**********************************************************************
 *  List any other comments here.                                     
 **********************************************************************/
Extra Credit: Each square is colored.