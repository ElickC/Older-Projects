#include <SFML/Graphics.hpp>
#include <SFML/Window.hpp>
#include <memory>
#include <cmath>
#include <fstream>
#include "Body.hpp"

using namespace std;
using namespace sf;

int main(int argc, char** argv) {

	int numBodies;
	float radiusUniverse;
	cin >> numBodies >> radiusUniverse;

	sf::Vector2f windowSize(500, 500);
	sf::RenderWindow window(sf::VideoMode(windowSize.x, windowSize.y), "Solar System Simulation");

	vector<shared_ptr<Body>> bodies(numBodies);
	for (int i = 0; i < numBodies; i++) {
		bodies[i] = make_shared<Body>(Body(radiusUniverse, windowSize));
		cin >> *bodies[i];
	}
	for (int i = 0; i < numBodies; i++) {
		bodies[i]->setSprite();
	}
	for (int i = 0; i < numBodies; i++) {
		bodies[i]->setPosition();
	}

	sf::Texture textureBackground;
	textureBackground.loadFromFile("starfield.jpg");
	sf::Sprite spriteBackground(textureBackground);
	
	while (window.isOpen())
	{
		sf::Event event;
		while (window.pollEvent(event))
		{
			if (event.type == sf::Event::Closed)
				window.close();
		}
		window.draw(spriteBackground);
		for (int i = 0; i < numBodies; i++)
		{
			window.draw(*bodies[i]);
		}

			window.display();
	}
}