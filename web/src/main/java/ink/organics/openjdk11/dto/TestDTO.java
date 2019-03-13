package ink.organics.openjdk11.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TestDTO extends PageRequestDTO {

    @NotBlank
    private String queryInfo;

}
