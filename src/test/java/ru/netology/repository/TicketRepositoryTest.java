package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.NotFoundException;
import ru.netology.domain.Ticket;

import static org.junit.jupiter.api.Assertions.*;

class TicketRepositoryTest {

    private final TicketRepository repository = new TicketRepository();
    private final Ticket first = new Ticket(1, 1299, "LED", "KRR", 120);
    private final Ticket second = new Ticket(2, 2200, "SVO", "KRR", 180);
    private final Ticket third = new Ticket(3, 1299, "KRR", "SVO", 120);
    private final Ticket forth = new Ticket(4, 1299, "LED", "KRR", 160);
    private final Ticket fifth = new Ticket(5, 1299, "VKO", "KRR", 120);


    @Test
    public void shouldSaveOneTicket() {
        repository.save(first);

        Ticket[] expected = new Ticket[]{first};
        Ticket[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void add() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(forth);
        repository.save(fifth);

        Ticket[] expected = {first, second, third, forth, fifth};
        Ticket[] actual = repository.findAll();

        assertArrayEquals(expected, actual);

    }

    @Test
    public void add1() {
        repository.save(fifth);

        Ticket[] expected = {fifth};
        Ticket[] actual = repository.findAll();

        assertArrayEquals(expected, actual);

    }

    @Test
    public void findAll() {
        repository.save(first);
        repository.save(second);
        repository.save(forth);

        Ticket[] expected = {first, second, forth};
        Ticket[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    void removeById() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(forth);
        repository.save(fifth);

        repository.removeById(2);

        Ticket[] expected = {first, third, forth, fifth};
        Ticket[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    void removeById1() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(forth);
        repository.save(fifth);

        repository.removeById(2);
        repository.removeById(3);
        repository.removeById(4);
        repository.removeById(5);

        Ticket[] expected = {first};
        Ticket[] actual = repository.findAll();


        assertArrayEquals(expected, actual);
    }


    @Test
    public void notFoundException() {
        assertThrows(NotFoundException.class, () -> repository.removeById(7));
    }
}

