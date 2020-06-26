#ifndef PTREE_HPP_
#define PTREE_HPP_
#include <SFML/Graphics.hpp>
#include <SFML/Window.hpp>
#include <iostream>

using namespace sf;

class PTree : public sf::Drawable, sf::Transformable {
public:
	PTree(const ConvexShape& baseSquare);

	void draw(sf::RenderTarget& target, sf::RenderStates states) const;
	void pTreeRec(sf::RenderWindow &window);

	int depth;
	sf::ConvexShape parentSquare;
	sf::Vector2f btmLeft;
	sf::Vector2f btmRight;
};

#endif