/*
Elick Coval
1/28/2019
SFML Hello-world
*/

#include <SFML/Graphics.hpp>

int main()
{
    sf::RenderWindow window(sf::VideoMode(400, 400), "Voila!");
    sf::CircleShape shape(200.f);
    shape.setFillColor(sf::Color::Green);
    
    sf::Texture texture;
    if (!texture.loadFromFile("sprite.png"))
    	return EXIT_FAILURE;
    sf::Sprite sprite(texture);
    int spriteX = -75, spriteY = -100;
    sprite.setOrigin(spriteX, spriteY);

    while (window.isOpen())
    {
        sf::Event event;
        
        while (window.pollEvent(event))
        {
            if (event.type == sf::Event::Closed)
                window.close();
        }
        if (sf::Keyboard::isKeyPressed(sf::Keyboard::Up)) 
        	sprite.move(0,-.25);
  
  		if (sf::Keyboard::isKeyPressed(sf::Keyboard::Down)) 
        	sprite.move(0, .25);
        	
        if (sf::Keyboard::isKeyPressed(sf::Keyboard::Left)) 
        	sprite.move(-0.25, 0);
        	
        if (sf::Keyboard::isKeyPressed(sf::Keyboard::Right)) 
        	sprite.move(0.25, 0);
        	
        if (sf::Keyboard::isKeyPressed(sf::Keyboard::Space)) 
        	sprite.rotate(.5);
        	
        	

        window.clear();
        window.draw(shape);
        window.draw(sprite);
        window.display();
    }

    return 0;
}
