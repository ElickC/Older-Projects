#ifndef BODY_HPP_
#define BODY_HPP_
#include <SFML/Graphics.hpp>
#include <SFML/Window.hpp>
#include <iostream>

using namespace sf;
using namespace std;

class Body : public sf::Drawable, sf::Transformable {
public:
	Body(float radiusUniverse, const sf::Vector2f& windowSize);
	friend istream& operator>>(istream& cin, Body& Body);

	const float radiusUniverse;
	const sf::Vector2f windowSize;

	float xpos;
	float ypos;
	float xvel;
	float yvel;
	float mass;
	float xForce;
	float yForce;
	std::string filename;
	sf::Texture texture;
	sf::Sprite sprite;

	void setSprite();
	void setPosition();
	void step(double dT);

private:
	void virtual draw(sf::RenderTarget& target, sf::RenderStates states) const;
};

#endif
