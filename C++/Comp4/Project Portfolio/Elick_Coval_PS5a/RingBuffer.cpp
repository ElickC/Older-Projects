// Copyright 2019 Elick Coval

#include <stdint.h>
#include <iostream>
#include <vector>
#include <stdexcept>
#include "RingBuffer.hpp"

// Default constructor
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

// Returns the size of the vector
int Ringbuffer::size() {
    return rbSize;
}

// Function to check to see if the vector is empty
bool Ringbuffer::isEmpty() {
    if (rbSize == 0)
        return 1;
    else
        return 0;
}
// Function to check to see if the vector is full
bool Ringbuffer::isFull() {
    int current;
    current = rbCap;
    if (size() == current)
        return 1;
    else
        return 0;
}

// Function which allows us to enqueue a type "double" onto the vector
void Ringbuffer::enqueue(int16_t x) {
    if (!isFull()) {
         ringbuffer[tail] = x;
         tail = (tail + 1) % rbCap;
         rbSize++;
    } else {
        throw runtime_error("Enqueue error*: Can't enqueue to a full ring");
}}

// Function which allows us to dequeue a type from the vector
int16_t Ringbuffer::dequeue() {
     if (rbSize == 0) {
        throw std::runtime_error("The ring buffer is empty!");
    }

    int temp = ringbuffer[head];
    head = (head + 1) % rbCap;
    rbSize--;
    return temp;
}

// Function which returns the first/next element from the vector
int16_t Ringbuffer::peek() {
    if (rbSize == 0) {
        throw std::runtime_error("The ring buffer is empty!");
    }
    return ringbuffer[head];
}
