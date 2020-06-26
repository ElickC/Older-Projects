#ifndef LFSR_HPP_
#define LFSR_HPP_

#include <iostream>
#include <string>



class LFSR {
 private:
	int length;
	int tap;
	string _data;
	
 public:

	LFSR(std::string seed, int t);
	int step(); 
	int generate(int k);
	friend ostream& operator << (ostream& out, LFSR& lfsr);
};

#endif
