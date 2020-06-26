
/**********************************************************************
 *  readme.txt template                                                   
 *  Guitar Hero: RingBuffer implementation with unit tests and exceptions
 **********************************************************************/

Name: Elick Coval



Hours to complete assignment: 5hrs

/**********************************************************************
 *  Briefly discuss the assignment itself and what you accomplished.
 **********************************************************************/
I was able to write a class that implements the given API.

  /**********************************************************************
 *  Discuss one or more key algorithms, data structures, or 
 *  OO designs that were central to the assignment.
 **********************************************************************/

Made sure class functions aligned with given API documentation.

Ringbuffer::Ringbuffer(int capacity) {
    if (capacity < 1) {
        throw invalid_argument("Error*: capacity must be greater than zero.");
        }
        ringbuffer.resize(capacity);
        rbCap = capacity;
        rbSize = 0;
        head = 0;
        tail = 0;
}

For the constructor we want to make sure the new capacity is greater 
than 1, if so, we adjust to the new size and reset relevant private
variables.

/**********************************************************************
 *  Briefly explain the workings of the features you implemented.
 *  Include code excerpts.
 **********************************************************************/

Most of the class functions are pretty straight forward. For instance,
the enqueue() function checks to see if the vector is empty, if not, use
the push_back function to push the type onto the vector. Otherwise,
throw an error.


/**********************************************************************
 *  Did you complete the whole assignment?
 *  Successfully or not? 
 *  Indicate which parts you think are working, and describe
 *    how you know that they're working.
 **********************************************************************/
I believe/hope I completed the whole assignment successfully. The class
functions with the test class as intended. Throws error when calling 
enqueue on full buffer and dequeue or peek on empty buffer


/**********************************************************************
 *  Does your RingBuffer implementation pass the unit tests?
 *  Indicate yes or no, and explain how you know that it does or does not.
 **********************************************************************/
Yes 


/**********************************************************************
 *  Explain the time and space performance of your RB implementation
**********************************************************************/
I used a vector to store types in the ring buffer, this is the closest
to the fastest type of ring buffer. Only thing that would make it
faster would be to have a fixed vector/ring buffer size.

/**********************************************************************
 *  List whatever help (if any) you received from lab TAs,
 *  classmates, or anyone else.
 **********************************************************************/
Help from lectures/given materials.


/**********************************************************************
 *  Describe any serious problems you encountered.                    
 **********************************************************************/
Couple minor issues with the test class but ironed those out.


/**********************************************************************
 *  List any other comments here.                                     
 **********************************************************************/

