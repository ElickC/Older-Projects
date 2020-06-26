#define _USE_MATH_DEFINES
#include <cmath>
#include "Body.hpp"

using namespace sf;
using namespace std;

Body::Body(float radiusUniverse, const sf::Vector2f& windowSize) : radiusUniverse(radiusUniverse), windowSize(windowSize) {}

istream& operator>>(istream& cin, Body& Body) {
	cin >> Body.xpos >> Body.ypos >> Body.xvel >> Body.yvel >> Body.mass >> Body.filename;
	return cin;
}

void Body::setSprite() {
	if (!(texture.loadFromFile(filename)))
		cerr << "Failed to load " << filename << " ." << endl;
	sprite.setTexture(texture);
}

void Body::setPosition() {
	float xScale = xpos / radiusUniverse;
	float yScale = ypos / radiusUniverse;

	sf::Vector2f position(xScale * (windowSize.x / 2) + windowSize.x / 2, -yScale * (windowSize.y / 2) + windowSize.y / 2);
	sf::Vector2f offset(sprite.getGlobalBounds().width / 2, sprite.getGlobalBounds().height / 2);
	sprite.setPosition(position - offset);
}

void Body::draw(sf::RenderTarget& target, sf::RenderStates states) const {
	target.draw(sprite);
}

void Body::step(double dT) {
	double xAccel = xForce / mass;
	double yAccel = yForce / mass;

	xvel += (xAccel * dT);
	yvel += (yAccel * dT);

	xpos += (xvel * dT);
	ypos += (yvel * dT);
}