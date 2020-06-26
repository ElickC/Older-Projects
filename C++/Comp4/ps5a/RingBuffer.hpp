#ifndef RB_HPP_
#define RB_HPP_

#include <stdint.h>
#include <iostream>
#include <vector>
#include <stdexcept>

using namespace std;

class Ringbuffer
{
	private:
		//I decided to use a data struct of vectors for the enqueue/dequeue
		std::vector<int16_t> ringbuffer;

	public:
		//creates an empty ring buffer, with given max capacity
		explicit Ringbuffer(int capacity); 
		// returns number of items currently in the buffer
		int size();
		//is the buffer empty(size = zero?)
		bool isEmpty();		
		//is the buffer full(size = capacity)
		bool isFull();
		//add item x to the end
		void enqueue(int16_t x);
		//delete and return item from the front
		int16_t dequeue(); 
		 //return(doesn't delete) item from the front
		int16_t peek();
};

#endif