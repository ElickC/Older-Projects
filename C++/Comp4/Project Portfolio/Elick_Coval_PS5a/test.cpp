#define BOOST_TEST_DYN_LINK
#define BOOST_TEST_MODULE Main
#include <boost/test/unit_test.hpp>

#include <stdint.h>
#include <iostream>
#include <string>
#include <exception>
#include <stdexcept>

#include "RingBuffer.hpp"

BOOST_AUTO_TEST_CASE(RBconstructor) {
	// normal constructor
	Ringbuffer RB(100);
	BOOST_REQUIRE_NO_THROW(RB);

	// this should fail
//	BOOST_REQUIRE_THROW(RB(0), std::exception);
//	BOOST_REQUIRE_THROW(RB(0), std::invalid_argument);
}

BOOST_AUTO_TEST_CASE(RBenque_dequeue) {
	Ringbuffer rb(100);

	rb.enqueue(2);
	rb.enqueue(1);
	rb.enqueue(0);

	BOOST_REQUIRE(rb.dequeue() == 2);
	BOOST_REQUIRE(rb.dequeue() == 1);
	BOOST_REQUIRE(rb.dequeue() == 0);

	BOOST_REQUIRE_THROW(rb.dequeue(), std::runtime_error);
}

BOOST_AUTO_TEST_CASE(RBpeek){
	Ringbuffer rb(100);
	BOOST_REQUIRE_THROW(rb.peek(), std::runtime_error);
	rb.enqueue(0);

	//should fail
//	BOOST_REQUIRE(rb.peek() == 1);
}

BOOST_AUTO_TEST_CASE(RBfull_empty){
	Ringbuffer rb(3);
	BOOST_REQUIRE(rb.isEmpty() == true);
	BOOST_REQUIRE(rb.size() == 0);

	rb.enqueue(2);
	BOOST_REQUIRE(rb.size() == 1);
	rb.enqueue(1);
	BOOST_REQUIRE(rb.size() == 2);
	rb.enqueue(0);
	BOOST_REQUIRE(rb.size() == 3);
	BOOST_REQUIRE(rb.isFull() == true);
	BOOST_REQUIRE_THROW(rb.enqueue(-1), std::runtime_error);

	BOOST_REQUIRE(rb.dequeue() == 2);
	BOOST_REQUIRE(rb.size() == 2);
	BOOST_REQUIRE(rb.dequeue() == 1);
	BOOST_REQUIRE(rb.size() == 1);
	BOOST_REQUIRE(rb.dequeue() == 0);
	BOOST_REQUIRE(rb.size() == 0);
}