#ifndef PTREE_HPP_
#define PTREE_HPP_

#include <SFML/Graphics.hpp>
#include <SFML/Window.hpp>
#include <iostream>

using namespace sf;

class PTree : public sf::Drawable, sf::Transformable {
public:
	PTree(const ConvexShape& baseSquare);

	void pTreeRec(sf::RenderWindow &window);

	void draw(sf::RenderTarget& target, sf::RenderStates states) const;

	int depth;

	sf::ConvexShape parentSquare;
	sf::Vector2f bottomLeft;
	sf::Vector2f bottomRight;
};

#endif PTREE_HPP_