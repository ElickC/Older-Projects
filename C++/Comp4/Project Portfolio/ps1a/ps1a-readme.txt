
/**********************************************************************
 *  Linear Feedback Shift Register (part A) ps1a-readme.txt template
 **********************************************************************/

Name: Elick Coval
Hours to complete assignment: 15
/**********************************************************************
 *  Briefly discuss the assignment itself and what you accomplished.

 **********************************************************************/
I accomplished the ability to encrypt the image and then able to get back the same image using the correct parameters listed in the assignment



/**********************************************************************
 *  Explain the representation you used for the register bits 
 *  (how it works, and why you selected it)
 **********************************************************************/
I basically implemented it exactly how it works logically. XOR the first bit with the tap bit (tap would be the length minus the tap minus 1) store that string, I left shifted with the erase() function. and then concatenate the new bit to the end of the new string.

 
/**********************************************************************
 * Discuss what's being tested in your two additional Boost unit tests
  **********************************************************************/
 What's being tested by the Boost unit tests is a 32 bit seed with tap 0 and a 3 bit seed with tap 0.




/**********************************************************************
 *  List whatever help (if any) you received from the instructor,
 *  classmates, or anyone else.
 **********************************************************************/
Prof Wilkes showed us some examples in class

/**********************************************************************
 *  Describe any serious problems you encountered.                    
 **********************************************************************/
I was not able to get the image to go negative.

/**********************************************************************
 *  List any other comments here.                                     
 *****************************************************************
