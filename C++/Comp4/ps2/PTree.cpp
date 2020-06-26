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
	
	if (depth == -1)
	{
		return;
	}

	sf::Color newColor = sf::Color();
	newColor = parentSquare.getFillColor();
	if (newColor.r < 0)
		newColor.r = 255;
	else
		newColor.r -= 30;
	if (newColor.g > 255)
		newColor.g = 0;
	else
		newColor.g += 15;
	if (newColor.b > 255)
		newColor.b = 0;
	else
		newColor.b += 30;
	parentSquare.setFillColor(newColor);
	sf::RenderStates* renderStates = new RenderStates();
	draw(window, *renderStates);
	

	
	sf::Vector2f topLeft, topRight, coordDiff, midPoint;

	coordDiff.x = bottomRight.x - bottomLeft.x;
	coordDiff.y = bottomLeft.y - bottomRight.y;

	topLeft.x = bottomLeft.x - coordDiff.y;
	topLeft.y = bottomLeft.y - coordDiff.x;

	topRight.x = bottomRight.x - coordDiff.y;
	topRight.y = bottomRight.y - coordDiff.x;

	midPoint.x = topLeft.x + (coordDiff.x - coordDiff.y) / 2;
	midPoint.y = topLeft.y - (coordDiff.x + coordDiff.y) / 2;

	parentSquare.setPoint(0, bottomLeft);
	parentSquare.setPoint(1, bottomRight);
	parentSquare.setPoint(2, topRight);
	parentSquare.setPoint(3, topLeft);


	auto lChildSquare = parentSquare;
	PTree* lNode = new PTree(lChildSquare);
	lNode->depth = depth;
	lNode->bottomLeft = midPoint;
	lNode->bottomRight = topRight;
	lNode->pTreeRec(window);

	auto rChildSquare = parentSquare;
	PTree* rNode = new PTree(rChildSquare);
	rNode->depth = depth;
	rNode->bottomLeft = topLeft;
	rNode->bottomRight = midPoint;
	rNode->pTreeRec(window);
	
	
	return;
}

void PTree::draw(sf::RenderTarget& target, sf::RenderStates states) const
{
	target.draw(parentSquare, states);
	return;
}