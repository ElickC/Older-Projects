#include <SFML/Graphics.hpp>
#include <SFML/Window.hpp>
#include <SFML/Audio.hpp>
#include <memory>
#include <cmath>
#include <fstream>
#include "Body.hpp"

using namespace std;
using namespace sf;

float findRadius(float dX, float dY);
float calculateForce(float massA, float massB, float radius);

const double gravity = 6.67 * 1e-11;

int main(int argc, char** argv) {
	float T = atoi(argv[1]);
	float dT = atoi(argv[2]);
	int currentT = 0;

	int numBodies;
	float radiusUniverse;
	cin >> numBodies >> radiusUniverse;


	sf::Vector2f windowSize(500, 500);
	sf::RenderWindow window(sf::VideoMode(windowSize.x, windowSize.y), "Universe Simulation");


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

	sf::Font font;
	if (!font.loadFromFile("Arialn.ttf"))
	{
		cerr << "Failed to load Font File Arialn.ttf" << endl;
	}
	
	sf::Text time;
	time.setFont(font);
	time.setString(to_string(currentT));
	time.setCharacterSize(24);
	time.setFillColor(sf::Color::Red);

	sf::Music music;
	if (music.openFromFile("2001.wav")) {
		music.play();
	} music.play();

	while (window.isOpen())
	{
		sf::Event event;
		while (window.pollEvent(event))
		{
			if (event.type == sf::Event::Closed)
				window.close();
		}

		double radius = 0;
		double force = 0;
		double netXForce = 0;
		double netYForce = 0;
		double dX = 0;
		double dY = 0;

		if (currentT < T) {
			for (int i = 0; i < numBodies; i++) {
				for (int j = 0; j < numBodies; j++) {
					if (i != j) {
						dX = bodies[j]->xpos - bodies[i]->xpos;
						dY = bodies[j]->ypos - bodies[i]->ypos;
						radius = findRadius(dX, dY);
						force = calculateForce(bodies[i]->mass, bodies[j]->mass, radius);
						netXForce += force * (dX / radius);
						netYForce += force * (dY / radius);
						bodies[i]->xForce = netXForce;
					        bodies[i]->yForce = netYForce;
					}
				}
				netXForce = 0;
				netYForce = 0;
			}

			for (int i = 0; i < numBodies; i++) {
				bodies[i]->step(dT);
			}

		       	for (int i = 0; i < numBodies; i++) {
				bodies[i]->setPosition();
			}

			window.clear();
			window.draw(spriteBackground);
			for (int i = 0; i < numBodies; i++)
			{
				window.draw(*bodies[i]);
			}
			window.draw(time);
			window.display();
			currentT = currentT + dT;
			time.setString(to_string(currentT));
		}
	}

	std::ofstream out("output.txt");
	out.precision(4);
	out << numBodies << endl;
	out << radiusUniverse << endl;
	for (int i = 0; i < numBodies; i++)
	{
		out << std::scientific << " " << bodies[i]->xpos << "  " << bodies[i]->ypos << "  " << bodies[i]->xvel << "  " << bodies[i]->yvel << "  " << bodies[i]->mass << "  " << bodies[i]->filename << endl;
	}
	return 0;
}

float findRadius(float dX, float dY) {
	return sqrt(pow(dX, 2) + pow(dY, 2));
}

float calculateForce(float massA, float massB, float radius) {
	return (gravity * massA * massB) / pow(radius, 2);
}
