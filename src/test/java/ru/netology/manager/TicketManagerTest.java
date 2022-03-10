package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;
import ru.netology.repository.TicketRepository;

import static org.junit.jupiter.api.Assertions.*;

class TicketManagerTest {

    private final TicketRepository repository = new TicketRepository();
    TicketManager managers = new TicketManager(repository);
    private final Ticket first = new Ticket(1, 1299, "LED", "KRR", 120);
    private final Ticket second = new Ticket(2, 2200, "SVO", "KRR", 180);
    private final Ticket third = new Ticket(3, 1299, "KRR", "SVO", 120);
    private final Ticket forth = new Ticket(4, 1299, "LED", "KRR", 160);
    private final Ticket fifth = new Ticket(5, 2200, "VKO", "KRR", 120);

    @Test
    public void add() {
        managers.add(first);
        managers.add(second);
        managers.add(fifth);

        Ticket[] expected = {first, second, fifth};
        Ticket[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void add1() {
        managers.add(forth);

        Ticket[] expected = {forth};
        Ticket[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchByLedKrr() {
        managers.add(first);
        managers.add(forth);

        Ticket[] expected = new Ticket[]{first, forth};
        Ticket[] actual = managers.searchBy("LED", "KRR");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchBySvoKrr() {
        managers.add(second);

        Ticket[] expected = new Ticket[]{second};
        Ticket[] actual = managers.searchBy("SVO", "KRR");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchByKrrSvo() {
        managers.add(third);

        Ticket[] expected = new Ticket[]{third};
        Ticket[] actual = managers.searchBy("KRR", "SVO");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchByVkoKrr() {
        managers.add(fifth);

        Ticket[] expected = new Ticket[]{fifth};
        Ticket[] actual = managers.searchBy("VKO", "KRR");

        assertArrayEquals(expected, actual);
    }
}

