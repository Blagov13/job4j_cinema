package ru.job4j.cinema.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.ui.ConcurrentModel;
import ru.job4j.cinema.model.Tickets;
import ru.job4j.cinema.service.TicketsService;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class TicketControllerTest {
    private TicketsService ticketsService;

    private TicketController ticketController;

    @BeforeEach
    public void initServices() {
        ticketsService = mock(TicketsService.class);
        ticketController = new TicketController(ticketsService);
    }

    @Test
    public void whenPostTicketThenSameDataAndReturnSuccessPage() throws Exception {
        var ticket = new Tickets(1, 1, 1, 1, 1);
        var ticketArgumentCaptor = ArgumentCaptor.forClass(Tickets.class);
        when(ticketsService.save(ticketArgumentCaptor.capture())).thenReturn(Optional.of(ticket));

        var model = new ConcurrentModel();
        var view = ticketController.create(ticket, model);
        var actualVacancy = ticketArgumentCaptor.getValue();

        assertThat(view).isEqualTo("tickets/success");
        assertThat(actualVacancy).isEqualTo(ticket);
    }

    @Test
    public void whenSomeExceptionThrownThenGetErrorPageWithMessage() {
        var expectedException = "Места заняты";
        when(ticketsService.save(any())).thenReturn(Optional.empty());

        var model = new ConcurrentModel();
        var ticket = new Tickets(1, 1, 1, 1, 1);
        var view = ticketController.create(ticket, model);
        var actualExceptionMessage = model.getAttribute("message");

        assertThat(view).isEqualTo("tickets/error");
        assertThat(actualExceptionMessage).isEqualTo(expectedException);
    }
}