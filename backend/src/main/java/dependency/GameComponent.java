package dependency;

import dagger.Component;
import gameplay.Game;

import javax.inject.Singleton;

@Singleton
@Component
public interface GameComponent {
    Game provideGame();
}
