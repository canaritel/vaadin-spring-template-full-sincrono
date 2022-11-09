package es.televoip.backend.exception;

import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response {

    //Atributes for control error exceptions
    private Timestamp timestamp;
    private String data;
    private int respondeCode;
    private String status;
}
