package ru.netology;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PlayerTest {

    @Test
    public void shouldSumGenreIfOneGame() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");


        Player player = new Player("Petya");
        player.installGame(game);
        player.play(game, 3);

        int expected = 3;
        int actual = player.sumGenre(game.getGenre());
        assertEquals(expected, actual);
    }

    @Test
    public void shouldSumGenreIfTwoGame() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game1 = store.publishGame("Баттл", "Аркады");

        Player player = new Player("Petya");
        player.installGame(game);
        player.installGame(game1);
        player.play(game, 10);
        player.play(game1, 10);

        int expected = 20;
        int actual = player.sumGenre(game.getGenre());
        assertEquals(expected, actual);
    }

    @Test
    public void shouldSumGenreIfTwoGenre() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game1 = store.publishGame("Баттл", "Гонки");

        Player player = new Player("Petya");
        player.installGame(game);
        player.installGame(game1);
        player.play(game, 10);
        player.play(game1, 10);

        int expected = 10;
        int actual = player.sumGenre(game.getGenre());
        assertEquals(expected, actual);
    }

    @Test
    public void mostTimePlayerByGenre() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game1 = store.publishGame("Баттл", "Аркады");

        Player player = new Player("Petya");
        player.installGame(game);
        player.installGame(game1);
        player.play(game, 10);
        player.play(game1, 20);

        Game expected = game1;
        Game actual = player.mostPlayerByGenre("Аркады");
        assertEquals(expected, actual);
    }

    @Test
    public void mostTimePlayerByNotGenre() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game1 = store.publishGame("Баттл", "Аркады");

        Player player = new Player("Petya");
        player.installGame(game);
        player.installGame(game1);
        player.play(game, 10);
        player.play(game1, 20);

        Game expected = null;
        Game actual = player.mostPlayerByGenre("Гонки");
        assertEquals(expected, actual);
    }

    @Test
    public void installGame() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game1 = store.publishGame("Баттл", "Аркады");

        Player player = new Player("Petya");
        player.installGame(game);
        player.play(game, 1);
        player.installGame(game);

        int expected = 1;
        int actual = player.sumGenre(game.getGenre());
        assertEquals(expected, actual);
    }

    @Test
    public void negativeTime() {

        GameStore store = new GameStore();
        Game game = store.publishGame("Баттл", "Аркады");

        Player player = new Player("Petya");

        player.installGame(game);

        Assertions.assertThrows(RuntimeException.class, () -> {
            player.play(game, -1);
        });
    }

    @Test
    public void notInstalledGame() {

        GameStore store = new GameStore();
        Game game = store.publishGame("Баттл", "Аркады");

        Player player = new Player("Petya");


        Assertions.assertThrows(RuntimeException.class, () -> {
            player.play(game, 3);
        });
    }

    // другие ваши тесты
}