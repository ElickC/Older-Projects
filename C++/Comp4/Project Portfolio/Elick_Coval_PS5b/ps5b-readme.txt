/**********************************************************************
 *  readme.txt template                                                   
 *  Plucking a Guitar String
 **********************************************************************/

Name: Elick Coval
CS Login: ecoval

Hours to complete assignment: 8

/**********************************************************************
 *  Did you complete the whole assignment?
 *  Successfully or not? 
 *  Indicate which parts you think are working, and describe
 *    how you know that they're working.
 **********************************************************************/

I completed the whole assignment successfully. I was unclear of what 
was required before but now all 37 guitar strings are simulated from 
110Hz to 880Hz. 


/**********************************************************************
 *  Did you attempt the extra credit parts? Which one(s)?
 *  Successfully or not?  As a pair, or individually?
 *  If you completed the AutoGuitar, what does it play?
 **********************************************************************/

I didn't have enough time for this.


/**********************************************************************
 *  Does your GuitarString implementation pass the unit tests?
 *  Indicate yes or no, and explain how you know that it does or does not.
 **********************************************************************/

It does, both my files and GStest compile and run without errors.


/**********************************************************************
 *  List whatever help (if any) you received from lab TAs,
 *  classmates, or anyone else.
 **********************************************************************/

Help from lectures, slides, stackoverflow.com


/**********************************************************************
 *  Describe any serious problems you encountered.                    
 **********************************************************************/

Figuring out how to get the values out of the GuitarString object and into
SFML audio playback object. The rest was pretty straightforward.


/**********************************************************************
 *  List any other comments here.                                     
 **********************************************************************/

Time and space complexity for the ringbuffer implementation remained unchanged
from the last assignment, the same complexity as a Vector class. Exceptions 
come from the ringbuffer class to catch errors such as peeking on an empty 
ringbuffer. Tests were implemented using given GStest.

