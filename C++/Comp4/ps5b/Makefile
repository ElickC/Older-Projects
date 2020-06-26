CC = g++
OFLAGS = -c -Wall -ansi -pedantic -Werror -ansi -g -lboost_unit_test_framework
CFLAGS = -Wall -ansi -pedantic -Werror -ansi -g -lboost_unit_test_framework
LFLAGS = -lsfml-window -lsfml-graphics -lsfml-system -lsfml-audio

all: GuitarHero

GuitarHero: GuitarHero.o RingBuffer.o GuitarString.o
	$(CC) GuitarString.o RingBuffer.o GuitarHero.o $(CFLAGS) $(LFLAGS) -o GuitarHero

GuitarHero.o: GuitarHero.cpp
	$(CC) $(OFLAGS) $(LFLAGSs) GuitarHero.cpp

RingBuffer.o: RingBuffer.cpp RingBuffer.hpp
	$(CC) $(OFLAGS) RingBuffer.cpp

GuitarString.o: GuitarString.cpp GuitarString.hpp 
	$(CC) $(OFLAGS) $(LFLAGS) GuitarString.cpp

clean:
	\rm -f *.o *~ RingBuffer test ps5b GuitarString GuitarHero