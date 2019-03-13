package ink.organics.openjdk11.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DemoSearchDTO extends PageRequestDTO {

    private String queryInfo;

}
