CC = g++
CFLAGS = -std=c++11 -c -g -Og -Wall -pedantic
OBJ = PTree.o main.o
DEPS = 
LIBS = -lsfml-graphics -lsfml-window -lsfml-system
EXE = PTree

all: $(OBJ)
	$(CC) $(OBJ) -o $(EXE) $(LIBS)

Main.o: main.cpp 
	$(CC) $(CFLAGS) -c $<

PTree.o: PTree.cpp PTree.hpp 
	$(CC) $(CFLAGS) -c $<

PTree: $(OBJ) 
	$(cc) $(OBJ) -o ps1a

clean:
	rm $(OBJ) $(EXE)
