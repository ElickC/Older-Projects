CC = g++
OFLAGS = -c -Wall -ansi -pedantic -Werror -std=c++0x -lboost_unit_test_framework
CFLAGS = -Wall -ansi -pedantic -Werror -std=c++0x -lboost_unit_test_framework

all: ps1a

ps1a: LFSR.o test.o
	$(CC) LFSR.o test.o $(CFLAGS) $(LFLAGS)  -o ps1a

LFSR.o: LFSR.cpp LFSR.hpp
	$(CC) $(OFLAGS) LFSR.cpp

test.o: test.cpp
	$(CC) $(OFLAGS) test.cpp

clean:
	\rm -f *.o  *~ ps1a LFSR test