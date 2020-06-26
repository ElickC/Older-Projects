name: Sonny Chea
date: 10/26/16
program: ps5b

purpose:
For this assignment we were tasked with writing a program to simulate plucking a guitar string using the Karplus-Strong algorithm. This algorithm played a seminal role in the emergence of physically modeled sound synthesis (where a physical description of a musical instrument is used to synthesize sound electronically). 

There are two parts of generating audio: (1) getting values out of the GuitarString object and into SFML audio playback object, and (2) playing the audio objects when key press events occur. 

In the sample code provided by Princeton, the stream of values from the GuitarString object is retrieved one value at a time and immediately given to an audio playback object.

This is an elegant solution and allows us to mix together signals from two (or more) GuitarStrings by averaging their values. (This is based on a similar superposition theorem that we used in the 2D physics simulation.)

For SFML, we have to have an existing sf::SoundBuffer that's created with a vector of sound samples. This SoundBuffer is created from a vector of sf::Int16s.

Then we create an sf::Sound object from the sf::SoundBuffer. The sf::Sound object can then be played. 
