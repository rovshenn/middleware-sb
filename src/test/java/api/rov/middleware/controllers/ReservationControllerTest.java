package api.rov.middleware.controllers;

import api.rov.middleware.business.domain.RoomReseravation;
import api.rov.middleware.business.service.ReservationService;
import api.rov.middleware.utils.DateUtils;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.Date;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.mockito.Mockito.when;

//@WebMvcTest
@RunWith(SpringRunner.class)
@WebFluxTest(ReservationController.class)
public class ReservationControllerTest {

    @MockBean
    private ReservationService reservationService;

    @Autowired
    private WebTestClient webTestClient;

    @Test
    public void getReservation() throws Exception {
        String dateStr = "2020-01-01";
        Date date = DateUtils.createDateString(dateStr);
        RoomReseravation roomReseravation = new RoomReseravation();
        when(reservationService.getRoomReservationForDate(date)).thenReturn(Lists.list(roomReseravation));

        this.webTestClient.get()
                .uri("/reservations?date=" + dateStr)
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBody(List.class)
                .value(roomRes -> roomRes.size(), equalTo(1)
        );
    }
}
