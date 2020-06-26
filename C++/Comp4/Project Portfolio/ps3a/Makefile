CC = g++
CFLAGS = -std=c++11 -c -g -Og -Wall
OBJ = main.o Body.o
DEPS = 
LIBS = -lsfml-graphics -lsfml-window -lsfml-system -lsfml-audio
EXE = NBody

all: $(OBJ)
	$(CC) $(OBJ) -o $(EXE) $(LIBS)

main.o: main.cpp
	$(CC) $(CFLAGS) -c $<

Body.o: Body.cpp Body.hpp 
	$(CC) $(CFLAGS) -c $<

NBody: $(OBJ) 
	$(cc) $(OBJ) -o ps3a

clean:
	rm $(OBJ) $(EXE)