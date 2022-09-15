package ru.netology;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameStoreTest {

    @Test
    public void shouldAddGame() {

        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        assertTrue(store.containsGame(game));
    }

    @Test
    public void shouldReturnFalseAddGames() {

        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = new Game("Цивилизация", "Стратегия", store);

        assertFalse(store.containsGame(game2));
    }

    @Test
    public void shouldReturnFalseContainsGame() {

        GameStore store = new GameStore();

        Game game2 = new Game("Цивилизация", "Стратегия", store);

        assertFalse(store.containsGame(game2));
    }

    @Test
    public void shouldGetMostPlayer() {

        GameStore store = new GameStore();

        store.addPlayTime("Kirill", 2);
        store.addPlayTime("Anna", 7);
        store.addPlayTime("Petr", 4);


        String actual = store.getMostPlayer();
        String expected = "Anna";
        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetMostPlayerEqualsZero() {

        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        store.addPlayTime("Kirill", 0);

        String actual = store.getMostPlayer();
        String expected = "Kirill";
        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetMostPlayerReturnNull() {

        GameStore store = new GameStore();

        String actual = store.getMostPlayer();
        String expected = null;
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnNullGetMostPlayerNegativeValue() {

        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        store.addPlayTime("Kirill", -1);

        String actual = store.getMostPlayer();
        String expected = null;
        assertEquals(expected, actual);
    }

    @Test
    public void shouldRegisteredAddPlayTime() {

        GameStore store = new GameStore();

        store.addPlayTime("Kirill", 0);
        store.addPlayTime("Kirill", 2);


        String actual = store.getMostPlayer();
        String expected = "Kirill";
        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetMostPlayerEquallyOne() {

        GameStore store = new GameStore();

        store.addPlayTime("Kirill", 1);

        String actual = store.getMostPlayer();
        String expected = "Kirill";
        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetSumPlayedTime() {

        GameStore store = new GameStore();

        store.addPlayTime("Kirill", 1);
        store.addPlayTime("Anna", 5);
        store.addPlayTime("Petr", 3);

        int actual = store.getSumPlayedTime();
        int expected = 9;
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnZeroGetSumPlayedTime() {

        GameStore store = new GameStore();

        int actual = store.getSumPlayedTime();
        int expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetSumZeroPlayedTime() {

        GameStore store = new GameStore();

        store.addPlayTime("Kirill", 0);
        store.addPlayTime("Anna", 0);
        store.addPlayTime("Petr", 0);

        int actual = store.getSumPlayedTime();
        int expected = 0;
        assertEquals(expected, actual);

    }

    @Test
    public void shouldGetSumOnePlayedTime() {

        GameStore store = new GameStore();

        store.addPlayTime("Kirill", 0);
        store.addPlayTime("Anna", 0);
        store.addPlayTime("Petr", 1);

        int actual = store.getSumPlayedTime();
        int expected = 1;
        assertEquals(expected, actual);

    }
}
