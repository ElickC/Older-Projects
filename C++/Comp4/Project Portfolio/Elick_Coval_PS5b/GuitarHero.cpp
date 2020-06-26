/*
  Copyright 2015 Fred Martin, fredm@cs.uml.edu
  Mon Mar 30 08:58:49 2015

  based on Princeton's GuitarHeroLite.java
  www.cs.princeton.edu/courses/archive/fall13/cos126/assignments/guitar.html

  build with
  g++ -Wall -c GuitarHeroLite.cpp -lsfml-system \
     -lsfml-audio -lsfml-graphics -lsfml-window
  g++ -Wall GuitarHeroLite.o RingBuffer.o GuitarString.o \
   -o GuitarHeroLite -lsfml-system -lsfml-audio -lsfml-graphics -lsfml-window
*/

#include <SFML/Graphics.hpp>
#include <SFML/System.hpp>
#include <SFML/Audio.hpp>
#include <SFML/Window.hpp>

#include <math.h>
#include <limits.h>

#include <iostream>
#include <string>
#include <exception>
#include <stdexcept>
#include <vector>

#include "RingBuffer.hpp"
#include "GuitarString.hpp"

#define CONCERT_A 440.0
#define SAMPLES_PER_SEC 44100

vector<sf::Int16> makeSamplesFromString(GuitarString *gs) {
  std::vector<sf::Int16> samples;

  gs->pluck();
  int duration = 8;  
  for (int i = 0; i < SAMPLES_PER_SEC * duration; i++) {
    gs->tic();
    samples.push_back(gs->sample());
  }

  return samples;
}

int main() {
  sf::RenderWindow window(sf::VideoMode(300, 200), "SFML Guitar Hero");
  sf::Event event;
  double freq;
  vector<sf::Int16> samples;

  // we're reusing the freq and samples vars, but
  // there are separate copies of GuitarString, SoundBuffer, and Sound
  //   for each note
  //
  // GuitarString is based on freq
  // samples are generated from GuitarString
  // SoundBuffer is loaded from samples
  // Sound is set to SoundBuffer

vector<std::vector <sf::Int16> > sampleVector;
	vector<sf::SoundBuffer> bufferVector;
	vector<sf::Sound> soundVector;

	for (int i = 0; i < 37; i++)
	{
		freq = CONCERT_A * pow(2, (i - 24.0) / 12.0);

		GuitarString gs = GuitarString(freq);
		sf::SoundBuffer& buffer = *new sf::SoundBuffer();
		sf::Sound& sound = *new sf::Sound();
		samples = makeSamplesFromString(&gs);
		sampleVector.push_back(samples);

		if (!buffer.loadFromSamples(&sampleVector[i][0], sampleVector[i].size(), 2, SAMPLES_PER_SEC))
			throw std::runtime_error("sf::SoundBuffer: load failure");

		sound.setBuffer(buffer);
		bufferVector.push_back(buffer);
		soundVector.push_back(sound);
	}


  while (window.isOpen()) {
		while (window.pollEvent(event)) {
			switch (event.type) {
			case sf::Event::Closed:
				window.close();
				break;
			case sf::Event::KeyPressed:
				switch (event.key.code) {
				case sf::Keyboard::Q:
					soundVector[0].play();
					break;
				case sf::Keyboard::Num2:
					soundVector[1].play();
					break;
				case sf::Keyboard::W:
					soundVector[2].play();
					break;
				case sf::Keyboard::E:
					soundVector[3].play();
					break;
				case sf::Keyboard::Num4:
					soundVector[4].play();
					break;
				case sf::Keyboard::R:
					soundVector[5].play();
					break;
				case sf::Keyboard::Num5:
					soundVector[6].play();
					break;
				case sf::Keyboard::T:
					soundVector[7].play();
					break;
				case sf::Keyboard::Y:
					soundVector[8].play();
					break;
				case sf::Keyboard::Num7:
					soundVector[9].play();
					break;
				case sf::Keyboard::U:
					soundVector[10].play();
					break;
				case sf::Keyboard::Num8:
					soundVector[11].play();
					break;
				case sf::Keyboard::I:
					soundVector[12].play();
					break;
				case sf::Keyboard::Num9:
					soundVector[13].play();
					break;
				case sf::Keyboard::O:
					soundVector[14].play();
					break;
				case sf::Keyboard::P:
					soundVector[15].play();
					break;
				case sf::Keyboard::Dash:
					soundVector[16].play();
					break;
				case sf::Keyboard::LBracket:
					soundVector[17].play();
					break;
				case sf::Keyboard::Equal:
					soundVector[18].play();
					break;
				case sf::Keyboard::Z:
					soundVector[19].play();
					break;
				case sf::Keyboard::X:
					soundVector[20].play();
					break;
				case sf::Keyboard::D:
					soundVector[21].play();
					break;
				case sf::Keyboard::C:
					soundVector[22].play();
					break;
				case sf::Keyboard::F:
					soundVector[23].play();
					break;
				case sf::Keyboard::V:
					soundVector[24].play();
					break;
				case sf::Keyboard::G:
					soundVector[25].play();
					break;
				case sf::Keyboard::B:
					soundVector[26].play();
					break;
				case sf::Keyboard::N:
					soundVector[27].play();
					break;
				case sf::Keyboard::J:
					soundVector[28].play();
					break;
				case sf::Keyboard::M:
					soundVector[29].play();
					break;
				case sf::Keyboard::K:
					soundVector[30].play();
					break;
				case sf::Keyboard::Comma:
					soundVector[31].play();
					break;
				case sf::Keyboard::Period:
					soundVector[32].play();
					break;
				case sf::Keyboard::SemiColon:
					soundVector[33].play();
					break;
				case sf::Keyboard::Slash:
					soundVector[34].play();
					break;
				case sf::Keyboard::Quote:
					soundVector[35].play();
					break;
				case sf::Keyboard::Space:
					soundVector[36].play();
					break;
				default:
					break;
				}
			default:
				break;
			}
			window.clear();
			window.display();
		}
	}

	return 0;
}