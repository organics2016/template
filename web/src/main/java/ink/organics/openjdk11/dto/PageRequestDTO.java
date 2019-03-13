package ink.organics.openjdk11.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by 王汗超 on 2017/6/2.
 * <p>
 * 分页请求Dto
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageRequestDTO {

    private int page = 0;

    private int size = 10;
}
