package ru.netology.repository;

import ru.netology.domain.NotFoundException;
import ru.netology.domain.Ticket;

public class TicketRepository {
    private Ticket[] tickets = new Ticket[0];

    public void save(Ticket item) {
        int length = tickets.length + 1;
        Ticket[] tmp = new Ticket[length];
        System.arraycopy(tickets, 0, tmp, 0, tickets.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        tickets = tmp;
    }

    public Ticket[] findAll() {
        return tickets;
    }


    public Ticket findById(int id) {
        for (Ticket ticket : tickets) {
            if (ticket.getId() == id) {
                return ticket;
            }
        }
        return null;
    }

    public void removeById(int id) {
        if (findById(id) == null) {
            throw new NotFoundException("Element with id: " + id + " not found");
        } else {
            int length = tickets.length - 1;
            Ticket[] tmp = new Ticket[length];
            int index = 0;
            for (Ticket product : tickets) {
                if (product.getId() != id) {
                    tmp[index] = product;
                    index++;
                }
                tickets = tmp;
            }
        }
    }
}


