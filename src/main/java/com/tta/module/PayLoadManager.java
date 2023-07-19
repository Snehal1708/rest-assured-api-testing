package com.tta.module;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tta.payload.Booking;
import com.tta.payload.BookingDates;

public class PayLoadManager {

    // java to json
    // create a payload
    ObjectMapper objectMapper;

    public String createPayload() throws JsonProcessingException {

        objectMapper = new ObjectMapper();
        Booking booking = new Booking();
        booking.setFirstname("Snehal");
        booking.setLastname("Yadav");
        booking.setTotalprice(111);
        booking.setDepositpaid(true);
        booking.setAdditionalneeds("Breakfast");
        BookingDates bookingdates = new BookingDates();
        bookingdates.setCheckin("2023-01-01");
        bookingdates.setCheckout("2024-01-01");
        booking.setBookingdates(bookingdates);

        String payload = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(booking);
        return payload;


    }

    public String updatepayload() throws JsonProcessingException {

        objectMapper = new ObjectMapper();
        Booking booking = new Booking();
        booking.setFirstname("Is");
        booking.setLastname("Anand");
        booking.setTotalprice(111);
        booking.setDepositpaid(true);
        booking.setAdditionalneeds("Breakfast");
        BookingDates bookingdates = new BookingDates();
        bookingdates.setCheckin("2023-01-01");
        bookingdates.setCheckout("2024-01-01");
        booking.setBookingdates(bookingdates);

        String payload = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(booking);
        return payload;

    }


}
