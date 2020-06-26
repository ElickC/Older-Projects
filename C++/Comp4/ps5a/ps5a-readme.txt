name: Sonny Chea
date: 10/26/16
program: ps5

purpose:

For this assignment we were tasked with writing a class named Ringbuffer that implements the following API:
public class RingBuffer
-------------------------------------------------------------------------------------------
        RingBuffer(int capacity)  // create an empty ring buffer, with given max capacity
int     size()                    // return number of items currently in the buffer
bool    isEmpty()                 // is the buffer empty (size equals zero)?
bool    isFull()                  // is the buffer full  (size equals capacity)?
void    enqueue(int16_t x)        // add item x to the end
int16_t dequeue()                 // delete and return item from the front
int16_t peek()                    // return (but do not delete) item from the front
------------------------------------------------------------------------------------------

We also had to include <stdint.h> into out head that allows us to define 16-bit integer type int16_t

Afterwards we had to include a testing case in which we were to test the functions/methods that we made for the assignment. 
