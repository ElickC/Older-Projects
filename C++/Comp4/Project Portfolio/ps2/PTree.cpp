#define _USE_MATH_DEFINES
#include <iostream>
#include <cmath>
#include "PTree.hpp"

using namespace sf;

PTree::PTree(const ConvexShape& baseSquare) {
	parentSquare = baseSquare;
}

void PTree::pTreeRec(sf::RenderWindow &window) {
	depth--;
	
	if (depth == -1){
		return;
	}

	sf::Color newColor = sf::Color();
	newColor = parentSquare.getFillColor();

	newColor.r = rand();
	newColor.b = rand();
	newColor.g = rand();
	
	parentSquare.setFillColor(newColor);
	sf::RenderStates* renderStates = new RenderStates();
	draw(window, *renderStates);
	
	sf::Vector2f topLeft, topRight, coordDiff, midPoint;

	coordDiff.x = btmRight.x - btmLeft.x;
	coordDiff.y = btmLeft.y - btmRight.y;

	topLeft.x = btmLeft.x - coordDiff.y;
	topLeft.y = btmLeft.y - coordDiff.x;

	topRight.x = btmRight.x - coordDiff.y;
	topRight.y = btmRight.y - coordDiff.x;

	midPoint.x = topLeft.x + (coordDiff.x - coordDiff.y) / 2;
	midPoint.y = topLeft.y - (coordDiff.x + coordDiff.y) / 2;

	parentSquare.setPoint(0, btmLeft);
	parentSquare.setPoint(1, btmRight);
	parentSquare.setPoint(2, topRight);
	parentSquare.setPoint(3, topLeft);

	auto leftChild = parentSquare;
	PTree* leftNode = new PTree(leftChild);
	leftNode->depth = depth;
	leftNode->btmLeft = midPoint;
	leftNode->btmRight = topRight;
	leftNode->pTreeRec(window);

	auto rChildSquare = parentSquare;
	PTree* rightNode = new PTree(rChildSquare);
	rightNode->depth = depth;
	rightNode->btmLeft = topLeft;
	rightNode->btmRight = midPoint;
	rightNode->pTreeRec(window);
	
	return;
}

void PTree::draw(sf::RenderTarget& target, sf::RenderStates states) const
{
	target.draw(parentSquare, states);
	return;
}