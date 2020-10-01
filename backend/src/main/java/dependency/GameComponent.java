package main.java.dependency;

import dagger.Component;
import main.java.gameplay.Game;

import javax.inject.Singleton;

@Singleton
@Component
public interface GameComponent {
    Game provideGame();
}
