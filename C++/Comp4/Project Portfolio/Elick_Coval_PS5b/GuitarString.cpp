#include "GuitarString.hpp"
#include <stdint.h>
#include <math.h>
#include <SFML/Audio.hpp>
#include <vector>
#include <iostream>
#include "RingBuffer.hpp"

GuitarString::GuitarString(double frequency) 
{
	count = 0;
	N = ceil(44100 /frequency);
	ptrRB = new Ringbuffer(N);
	while ((*ptrRB).isEmpty())
	(*ptrRB).enqueue(0);
}

GuitarString::GuitarString(std::vector<sf::Int16> init) 
{
	count = 0;
	N = init.size();
	ptrRB = new Ringbuffer(N);
	for (std::vector<sf::Int16>::
	iterator it = init.begin(); it != init.end(); ++it)
	(*ptrRB).enqueue(*it);
}

GuitarString::~GuitarString() 
{
	delete ptrRB;
}

void GuitarString::pluck() 
{
	while (!(*ptrRB).isEmpty())
	(*ptrRB).dequeue();
		while (!(*ptrRB).isFull())
		(*ptrRB).enqueue((sf::Int16)(rand() & 0xffff));
}

void GuitarString::tic() 
{
	int16_t front = (*ptrRB).dequeue();
	int16_t frontNext = (*ptrRB).peek();
	float result = ((front + frontNext)/2) * 0.996;
	(*ptrRB).enqueue(result);
}

sf::Int16 GuitarString::sample() 
{
	return (*ptrRB).peek();
}

int GuitarString::time() 
{
	return count++;
}