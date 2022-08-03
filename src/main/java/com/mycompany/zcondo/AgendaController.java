package com.mycompany.zcondo;

import com.calendarfx.model.Calendar;
import com.calendarfx.model.CalendarSource;
import com.calendarfx.model.Entry;
import com.calendarfx.view.CalendarView;
import static java.lang.Thread.sleep;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class AgendaController implements Initializable {
    
    @FXML 
    AnchorPane pane;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        CalendarView calendarView = new CalendarView();
//        calendarView.setEntryFactory(factory);
        

        Calendar calendarioPiscina = new Calendar("Piscina");
        calendarioPiscina.setStyle(Calendar.Style.STYLE6);
        Entry<String> eventos = new Entry<>("Festa na piscina");
        calendarioPiscina.addEntry(eventos);
        
         /////////// Adicionando eventos para o mesmo dia 
        calendarioPiscina.addEventHandler(calendarEvent -> {
            
            if (calendarEvent.isDayChange()) {
                //Dispara quando muda algum evento
                String nomeEvento = calendarEvent.getEntry().getTitle();
                String localEvento = calendarEvent.getEntry().getLocation();
                String dataEvento = calendarEvent.getEntry().getStartDate().toString();
                String horaEvento = calendarEvent.getEntry().getStartTime().toString();
                String duracaoEvento = calendarEvent.getEntry().getDuration().toString();

                Evento novoEvento = new Evento(nomeEvento, localEvento, dataEvento, horaEvento, duracaoEvento);

                EventoDAO eventoDao = new EventoDAO();
                eventoDao.update(novoEvento); //Salvando o evento no banco

                
             
                
            } else if (calendarEvent.isEntryAdded()) {
                // Dispara quando adiciona um item
                String nomeEvento = calendarEvent.getEntry().getTitle();
                String localEvento = calendarEvent.getEntry().getLocation();
                String dataEvento = calendarEvent.getEntry().getStartDate().toString();
                String horaEvento = calendarEvent.getEntry().getStartTime().toString();
                String duracaoEvento = calendarEvent.getEntry().getDuration().toString();

                Evento novoEvento = new Evento(nomeEvento, localEvento, dataEvento, horaEvento, duracaoEvento);

                EventoDAO eventoDao = new EventoDAO();
                eventoDao.save(novoEvento); //Salvando o evento no banco

            } else if (calendarEvent.isEntryRemoved()) {
                // Dispara quando remove um item
            }
        });

        CalendarSource myCalendarSource = new CalendarSource("My Calendars");
        myCalendarSource.getCalendars().addAll(calendarioPiscina);

        calendarView.getCalendarSources().addAll(myCalendarSource);

        calendarView.setRequestedTime(LocalTime.now());

        Thread updateTimeThread = new Thread("Calendar: Update Time Thread") {

            @Override
            public void run() {
                while (true) {
                    Platform.runLater(() -> {
                        calendarView.setToday(LocalDate.now());    //Configura data e hora
                        calendarView.setTime(LocalTime.now());
                    });

                    try {
                        // update every 10 seconds
                        sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        };

        updateTimeThread.setPriority(Thread.MIN_PRIORITY);
        updateTimeThread.setDaemon(true);
        updateTimeThread.start();

        Scene scene = new Scene(calendarView);
        
        
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();

        stage.setTitle("Condomínio");
        stage.setScene(scene);
        stage.setWidth(700);
        stage.setHeight(500);
        stage.centerOnScreen();
        stage.show();
    }

}
