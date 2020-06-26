#include <SFML/Graphics.hpp>
#include <SFML/Window.hpp>
#include "PTree.hpp"

using namespace sf;

int main(int argc, char** argv) {

	int size = std::stoi(argv[1]);
	int depth = std::stoi(argv[2]);

	sf::RenderWindow window(sf::VideoMode(6 * size, 4 * size), "Pythagoras Tree");

	sf::ConvexShape square(4);
	square.setPoint(0, sf::Vector2f(0, 0));
	square.setPoint(1, sf::Vector2f(size, 0));
	square.setPoint(2, sf::Vector2f(size, size));
	square.setPoint(3, sf::Vector2f(0, size));
	square.setPosition(2.5 * size, 3 * size);

	sf::Vector2f origin = square.getOrigin();
	sf::Vector2f newOrigin = sf::Vector2f(size / 2, size / 2);
	sf::Vector2f offset = newOrigin - origin;
	square.setOrigin(newOrigin);
	square.move(offset);

	PTree* pTree = new PTree(square);
	pTree->bottomLeft = square.getPoint(3);
	pTree->bottomRight = square.getPoint(2);

	while (window.isOpen())
	{
		pTree->depth = depth;
		pTree->parentSquare.setFillColor(sf::Color::Red);
		
		// check all the window's events that were triggered since the last iteration of the loop
		sf::Event event;
		while (window.pollEvent(event))
		{
			// "close requested" event: we close the window
			if (event.type == sf::Event::Closed)
				window.close();
		}

		pTree->pTreeRec(window);
		window.display();
	}


	
	return 0;
}
