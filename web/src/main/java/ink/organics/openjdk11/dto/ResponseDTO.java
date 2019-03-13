package ink.organics.openjdk11.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.Instant;

/**
 * Created by 王汗超 on 2017/5/24.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDTO {

    private String message = "success";

    private String path;

    private int status = HttpStatus.OK.value();

    private long timestamp = Instant.now().toEpochMilli();

    public ResponseDTO(String message, int status) {
        this.message = message;
        this.status = status;
    }

    public ResponseDTO(int status) {
        this.status = status;
    }
}
