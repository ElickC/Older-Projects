CC = g++
CFLAGS = -std=c++11 -c -g -Og -Wall -pedantic -lz
OBJ = RingBuffer.o GuitarString.o GuitarHero.o GStest.o
DEPS = 
LIBS = -lsfml-audio -lsfml-graphics -lsfml-window -lsfml-system -lboost_unit_test_framework
EXE = GuitarHero GStest

%.o: %.cpp $(DEPS)
	$(CC) $(CFLAGS) -o $@ $<

GuitarHero: $(OBJ)
	$(CC) RingBuffer.o GuitarString.o GuitarHero.o -o GuitarHero $(LIBS)
	
GStest: $(OBJ)
	$(CC) RingBuffer.o GuitarString.o GStest.o -o GStest $(LIBS)
	
all: $(OBJ)
	$(CC) $(OBJ) -o $(EXE) $(LIBS)

clean:
	rm $(OBJ) $(EXE)

