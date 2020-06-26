#ifndef GS_HPP_
#define GS_HPP_

#include <vector>
#include <SFML/Audio.hpp>
#include <stdint.h>
#include "RingBuffer.hpp"

class GuitarString{
    private:
    Ringbuffer *ptrRB;
    int N;

    public:
    explicit GuitarString(double frequency);
    explicit GuitarString(std::vector<sf::Int16> init);
    ~GuitarString();
    void pluck();
    void tic();
    sf::Int16 sample();
    int time();
    int count;

};
#endif