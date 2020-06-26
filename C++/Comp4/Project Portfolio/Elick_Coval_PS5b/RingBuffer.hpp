// Copyright 2019 <Elick Coval>
#ifndef RB_HPP_
#define RB_HPP_

#include <stdint.h>
#include <iostream>
#include <vector>
#include <stdexcept>

using std::vector;
using std::invalid_argument;
using std::runtime_error;


class Ringbuffer {
 private:
    std::vector<int16_t> ringbuffer;
    int head;
    int tail;
    int rbCap;
    int rbSize;

 public:
     // Creates an empty ring buffer, with given max capacity
     explicit Ringbuffer(int capacity);
     // returns number of items currently in the buffer
     int size();
     // Is the buffer empty(size = zero?)
     bool isEmpty();
     // Is the buffer full(size = capacity)
     bool isFull();
     // Add item x to the end
     void enqueue(int16_t x);
     // Delete and return item from the front
     int16_t dequeue();
     // Return(doesn't delete) item from the front
     int16_t peek();
};
#endif  // RB_HPP_
